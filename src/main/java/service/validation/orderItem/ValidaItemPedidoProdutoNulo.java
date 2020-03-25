package service.validation.orderItem;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.ItemPedido;

public class ValidaItemPedidoProdutoNulo implements ValidaItemPedidoService {

    private ValidaItemPedidoService proxima;

    @Override
    public ItemPedido validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException {

        if (itemPedido.getProduto() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_ITEMPEDIDO_NULO);
        } else {
            return proxima.validaItemPedido(itemPedido);
        }
    }

    @Override
    public void setProximaValidacao(ValidaItemPedidoService proxima) {
        this.proxima = proxima;
    }
}
