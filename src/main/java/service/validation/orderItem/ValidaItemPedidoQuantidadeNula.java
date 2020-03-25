package service.validation.orderItem;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.ItemPedido;

public class ValidaItemPedidoQuantidadeNula implements ValidaItemPedidoService {

    private ValidaItemPedidoService proxima;

    @Override
    public ItemPedido validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException {

        if (itemPedido.getQuantidade() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.QUANTIDADE_ITEMPEDIDO_NULA);
        } else {
            return proxima.validaItemPedido(itemPedido);
        }
    }

    @Override
    public void setProximaValidacao(ValidaItemPedidoService proxima) {
        this.proxima = proxima;
    }
}
