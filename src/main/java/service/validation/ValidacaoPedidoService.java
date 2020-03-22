package service.validation;

import cadastroexception.CadastroInvalidoException;
import entity.Pedido;

public class ValidacaoPedidoService {

    public void validaPedido(Pedido pedido) throws CadastroInvalidoException {

        ValidaPedidoService pedidoSemItens = new ValidaPedidoSemItens();
        ValidaPedidoService pedidoUsuarioNulo = new ValidaPedidoUsuarioNulo();
        ValidaPedidoService pedidoValido = new PedidoValido();

        pedidoSemItens.setProximaValidacao(pedidoUsuarioNulo);
        pedidoUsuarioNulo.setProximaValidacao(pedidoValido);
        pedidoSemItens.validaPedido(pedido);
    }
}
