package service.validation;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Pedido;

public class ValidaPedidoUsuarioNulo implements ValidaPedidoService {

    private ValidaPedidoService proxima;

    @Override
    public Pedido validaPedido(Pedido pedido) throws CadastroInvalidoException {
        if (pedido.getUsuario() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.USUARIO_NULO_PEDIDO);
        } else {
            return proxima.validaPedido(pedido);
        }
    }

    @Override
    public void setProximaValidacao(ValidaPedidoService proxima) {
        this.proxima = proxima;
    }
}
