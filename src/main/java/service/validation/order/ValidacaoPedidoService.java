package service.validation.order;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Pedido;
import service.validation.ValidaCadastrosService;

public class ValidacaoPedidoService {

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

    public class ValidaPedidoSemItens implements ValidaCadastrosService<Pedido> {

        private ValidaCadastrosService<Pedido> proxima;

        @Override
        public Pedido validaCadastros(Pedido pedido) throws CadastroInvalidoException {
            if (pedido.getItemPedidoList().isEmpty()) {
                throw new CadastroInvalidoException(MotivoCadastroInvalido.PEDIDO_SEM_ITENS);
            } else {
                return proxima.validaCadastros(pedido);
            }
        }

        @Override
        public void setProximaValidacao(ValidaCadastrosService<Pedido> proximaValidacao) {
            this.proxima = proximaValidacao;
        }
    }

    public class PedidoValido implements ValidaCadastrosService<Pedido> {

        @Override
        public Pedido validaCadastros(Pedido pedido) {
            return pedido;
        }

        @Override
        public void setProximaValidacao(ValidaCadastrosService<Pedido> proximaValidacao) {

        }
    }

    public void validaPedido(Pedido pedido) throws CadastroInvalidoException {

        ValidaCadastrosService pedidoSemItens = new ValidaPedidoSemItens();
        ValidaCadastrosService pedidoUsuarioNulo = new ValidaPedidoUsuarioNulo();
        ValidaCadastrosService pedidoValido = new PedidoValido();

        pedidoUsuarioNulo.setProximaValidacao(pedidoSemItens);
        pedidoSemItens.setProximaValidacao(pedidoValido);
        pedidoUsuarioNulo.validaCadastros(pedido);
    }
}
