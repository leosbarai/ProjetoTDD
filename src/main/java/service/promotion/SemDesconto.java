package service.promotion;

import entity.Pedido;
import entity.Promocao;

public class SemDesconto implements Desconto {

    @Override
    public Pedido aplicaDesconto(Pedido pedido, Promocao promocao) {
        promocao.setDesconto(0.0);
        return pedido;
    }

    @Override
    public void setProximoDesconto(Desconto proxima) {

    }
}
