package service.validation.order;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Pedido;
import service.validation.RegisterValidation;

public class ValidaPedidoDecorator {

    public static class ValidaPedidoDecoratorUsuarioNulo extends RegisterValidation<Pedido> {

        public ValidaPedidoDecoratorUsuarioNulo(RegisterValidation<Pedido> outraValidacao) {
            super(outraValidacao);
        }

        @Override
        public Pedido validaCadastros(Pedido pedido) throws CadastroInvalidoException {
            if (pedido.getUsuario() == null)
                throw new CadastroInvalidoException(MotivoCadastroInvalido.USUARIO_NULO_PEDIDO);

            return pedido;
        }
    }

    public static class ValidaPedidoDecoratorSemItem extends RegisterValidation<Pedido> {

        public ValidaPedidoDecoratorSemItem(RegisterValidation<Pedido> outraValidacao) {
            super(outraValidacao);
        }

        @Override
        public Pedido validaCadastros(Pedido pedido) throws CadastroInvalidoException {
            if (pedido.getItemPedidoList().isEmpty())
                throw new CadastroInvalidoException(MotivoCadastroInvalido.PEDIDO_SEM_ITENS);

            return pedido;
        }
    }

    public static class PedidoDecoratorValido extends RegisterValidation<Pedido> {

        @Override
        public Pedido validaCadastros(Pedido pedido) throws CadastroInvalidoException {
            return pedido;
        }
    }

    public static Pedido validaPedido(Pedido pedido) throws CadastroInvalidoException {
        RegisterValidation<Pedido> pedidoRegisterValidation = new ValidaPedidoDecoratorUsuarioNulo(
                new ValidaPedidoDecoratorSemItem(new PedidoDecoratorValido()));

        return pedidoRegisterValidation.validaCadastros(pedido);
    }

}
