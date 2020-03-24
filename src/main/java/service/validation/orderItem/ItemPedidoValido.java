package service.validation.orderItem;

import cadastroexception.CadastroInvalidoException;
import entity.ItemPedido;

public class ItemPedidoValido implements ValidaItemPedidoService{

    @Override
    public ItemPedido validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException {
        return itemPedido;
    }

    @Override
    public void setProximaValidacao(ValidaItemPedidoService proxima) {

    }
}
