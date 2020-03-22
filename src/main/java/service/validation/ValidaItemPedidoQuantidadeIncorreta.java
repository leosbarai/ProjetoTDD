package service.validation;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.ItemPedido;

public class ValidaItemPedidoQuantidadeIncorreta implements ValidaItemPedidoService {

    private ValidaItemPedidoService proxima;

    @Override
    public ItemPedido validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException {

        if (itemPedido.getQuantidade() <= 0) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.QUANTIDADE_ITEMPEDIDO_INCORRETA);
        } else {
            return proxima.validaItemPedido(itemPedido);
        }
    }

    @Override
    public void setProximaValidacao(ValidaItemPedidoService proxima) {
        this.proxima = proxima;
    }
}
