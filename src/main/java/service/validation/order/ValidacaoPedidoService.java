package service.validation.order;

import cadastroexception.CadastroInvalidoException;
import entity.Pedido;

public class ValidacaoPedidoService {

    public void validaPedido(Pedido pedido) throws CadastroInvalidoException {

        ValidaPedidoService pedidoSemItens = new ValidaPedidoSemItens();
        ValidaPedidoService pedidoUsuarioNulo = new ValidaPedidoUsuarioNulo();
        ValidaPedidoService pedidoValido = new PedidoValido();

        pedidoUsuarioNulo.setProximaValidacao(pedidoSemItens);
        pedidoSemItens.setProximaValidacao(pedidoValido);
        pedidoUsuarioNulo.validaPedido(pedido);
    }
}
