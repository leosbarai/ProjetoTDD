package service.validation;

import cadastroexception.CadastroInvalidoException;
import entity.ItemPedido;

public interface ValidaItemPedidoService {

    ItemPedido validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException;

    void setProximaValidacao(ValidaItemPedidoService proxima);
}
