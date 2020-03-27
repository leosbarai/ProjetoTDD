package service.validation.order;

import entity.Pedido;
import service.validation.ValidaCadastrosService;

public class PedidoValido implements ValidaCadastrosService<Pedido> {

    @Override
    public Pedido validaCadastros(Pedido pedido) {
        return pedido;
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<Pedido> proximaValidacao) {

    }
}
