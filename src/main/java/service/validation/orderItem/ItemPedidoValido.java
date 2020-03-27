package service.validation.orderItem;

import entity.ItemPedido;
import service.validation.ValidaCadastrosService;

public class ItemPedidoValido implements ValidaCadastrosService<ItemPedido> {

    @Override
    public ItemPedido validaCadastros(ItemPedido itemPedido) {
        return itemPedido;
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<ItemPedido> proxima) {

    }
}
