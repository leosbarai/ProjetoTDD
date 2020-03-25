package service.validation.orderItem;

import cadastroexception.CadastroInvalidoException;
import entity.ItemPedido;

public class ValidacaoItemPedidoService {

    public void validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException {

        ValidaItemPedidoService quantidadeNula = new ValidaItemPedidoQuantidadeNula();
        ValidaItemPedidoService quantidadeIncorreta = new ValidaItemPedidoQuantidadeIncorreta();
        ValidaItemPedidoService produtoNulo = new ValidaItemPedidoProdutoNulo();
        ValidaItemPedidoService itemPedidoValido = new ItemPedidoValido();

        quantidadeNula.setProximaValidacao(quantidadeIncorreta);
        quantidadeIncorreta.setProximaValidacao(produtoNulo);
        produtoNulo.setProximaValidacao(itemPedidoValido);
        quantidadeNula.validaItemPedido(itemPedido);
    }
}
