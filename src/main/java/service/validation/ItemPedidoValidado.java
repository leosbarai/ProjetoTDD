package service.validation;

import cadastroexception.CadastroInvalidoException;
import entity.ItemPedido;

public class ItemPedidoValidado implements ValidaItemPedidoService{

    @Override
    public ItemPedido validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException {
        return itemPedido;
    }

    @Override
    public void setProximaValidacao(ValidaItemPedidoService proxima) {

    }
}
