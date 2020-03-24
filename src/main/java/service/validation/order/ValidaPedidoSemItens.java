package service.validation.order;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Pedido;

public class ValidaPedidoSemItens implements ValidaPedidoService {

    private ValidaPedidoService proxima;

    @Override
    public Pedido validaPedido(Pedido pedido) throws CadastroInvalidoException {
        if (pedido.getItemPedidoList().size() == 0) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.PEDIDO_SEM_ITENS);
        } else {
            return proxima.validaPedido(pedido);
        }
    }

    @Override
    public void setProximaValidacao(ValidaPedidoService proxima) {
        this.proxima = proxima;
    }
}
