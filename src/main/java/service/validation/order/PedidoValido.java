package service.validation.order;

import cadastroexception.CadastroInvalidoException;
import entity.Pedido;

public class PedidoValido implements ValidaPedidoService {

    @Override
    public Pedido validaPedido(Pedido pedido) throws CadastroInvalidoException {
        return pedido;
    }

    @Override
    public void setProximaValidacao(ValidaPedidoService proxima) {

    }
}
