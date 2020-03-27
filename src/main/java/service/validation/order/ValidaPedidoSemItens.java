package service.validation.order;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Pedido;
import service.validation.ValidaCadastrosService;

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
