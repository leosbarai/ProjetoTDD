package service.validation.order;

import cadastroexception.CadastroInvalidoException;
import entity.Pedido;
import service.validation.ValidaCadastrosService;

public class ValidacaoPedidoService {

    public void validaPedido(Pedido pedido) throws CadastroInvalidoException {

        ValidaCadastrosService pedidoSemItens = new ValidaPedidoSemItens();
        ValidaCadastrosService pedidoUsuarioNulo = new ValidaPedidoUsuarioNulo();
        ValidaCadastrosService pedidoValido = new PedidoValido();

        pedidoUsuarioNulo.setProximaValidacao(pedidoSemItens);
        pedidoSemItens.setProximaValidacao(pedidoValido);
        pedidoUsuarioNulo.validaCadastros(pedido);
    }
}
