package service.validation.orderItem;

import cadastroexception.CadastroInvalidoException;
import entity.ItemPedido;
import service.validation.ValidaCadastrosService;

public class ValidacaoItemPedidoService {

    public void validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException {

        ValidaCadastrosService quantidadeNula = new ValidaItemPedidoQuantidadeNula();
        ValidaCadastrosService quantidadeIncorreta = new ValidaItemPedidoQuantidadeIncorreta();
        ValidaCadastrosService produtoNulo = new ValidaItemPedidoProdutoNulo();
        ValidaCadastrosService itemPedidoValido = new ItemPedidoValido();

        quantidadeNula.setProximaValidacao(quantidadeIncorreta);
        quantidadeIncorreta.setProximaValidacao(produtoNulo);
        produtoNulo.setProximaValidacao(itemPedidoValido);
        quantidadeNula.validaCadastros(itemPedido);
    }
}
