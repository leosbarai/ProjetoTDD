package service.validation.orderItem;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.ItemPedido;
import service.validation.ValidaCadastrosService;

public class ValidaItemPedidoQuantidadeIncorreta implements ValidaCadastrosService<ItemPedido> {

    private ValidaCadastrosService<ItemPedido> proxima;

    @Override
    public ItemPedido validaCadastros(ItemPedido itemPedido) throws CadastroInvalidoException {

        if (itemPedido.getQuantidade() <= 0) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.QUANTIDADE_ITEMPEDIDO_INCORRETA);
        } else {
            return proxima.validaCadastros(itemPedido);
        }
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<ItemPedido> proxima) {
        this.proxima = proxima;
    }
}
