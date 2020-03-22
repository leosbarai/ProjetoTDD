package service;

import cadastroexception.CadastroInvalidoException;
import entity.ItemPedido;
import service.validation.*;

public class ValidacaoItemPedido {

    public void validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException {

        ValidaItemPedidoService quantidadeNula = new ValidaItemPedidoQuantidadeNula();
        ValidaItemPedidoService quantidadeIncorreta = new ValidaItemPedidoQuantidadeIncorreta();
        ValidaItemPedidoService produtoNulo = new ValidaItemPedidoProdutoNulo();
        ValidaItemPedidoService itemPedidoValido = new ItemPedidoValidado();

        quantidadeNula.setProximaValidacao(quantidadeIncorreta);
        quantidadeIncorreta.setProximaValidacao(produtoNulo);
        produtoNulo.setProximaValidacao(itemPedidoValido);
        quantidadeNula.validaItemPedido(itemPedido);
    }
}
