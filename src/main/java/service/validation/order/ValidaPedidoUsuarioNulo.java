package service.validation.order;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Pedido;
import service.validation.ValidaCadastrosService;

public class ValidaPedidoUsuarioNulo implements ValidaCadastrosService<Pedido> {

    private ValidaCadastrosService<Pedido> proxima;

    @Override
    public Pedido validaCadastros(Pedido pedido) throws CadastroInvalidoException {
        if (pedido.getUsuario() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.USUARIO_NULO_PEDIDO);
        } else {
            return proxima.validaCadastros(pedido);
        }
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<Pedido> proximaValidacao) {
        this.proxima = proximaValidacao;
    }
}
