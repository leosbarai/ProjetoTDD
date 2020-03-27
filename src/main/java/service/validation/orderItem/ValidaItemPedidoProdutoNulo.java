package service.validation.orderItem;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.ItemPedido;
import service.validation.ValidaCadastrosService;

public class ValidaItemPedidoProdutoNulo implements ValidaCadastrosService<ItemPedido> {

    private ValidaCadastrosService<ItemPedido> proxima;

    @Override
    public ItemPedido validaCadastros(ItemPedido itemPedido) throws CadastroInvalidoException {

        if (itemPedido.getProduto() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_ITEMPEDIDO_NULO);
        } else {
            return proxima.validaCadastros(itemPedido);
        }
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<ItemPedido> proxima) {
        this.proxima = proxima;
    }
}
