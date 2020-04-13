package service.promotion;

import entity.Pedido;
import entity.Promocao;

import java.math.BigDecimal;

public class SemDesconto implements Desconto {

    @Override
    public Pedido aplicaDesconto(Pedido pedido, Promocao promocao) {
        BigDecimal totalItem = BigDecimal.ZERO;
        promocao.setDesconto(totalItem);
        return pedido;
    }

    @Override
    public void setProximoDesconto(Desconto proxima) {

    }
}
