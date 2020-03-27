package service.validation.orderItem;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.ItemPedido;
import service.validation.ValidaCadastrosService;

public class ValidaItemPedidoQuantidadeNula implements ValidaCadastrosService<ItemPedido> {

    private ValidaCadastrosService<ItemPedido> proxima;

    @Override
    public ItemPedido validaCadastros(ItemPedido itemPedido) throws CadastroInvalidoException {

        if (itemPedido.getQuantidade() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.QUANTIDADE_ITEMPEDIDO_NULA);
        } else {
            return proxima.validaCadastros(itemPedido);
        }
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<ItemPedido> proxima) {
        this.proxima = proxima;
    }
}
