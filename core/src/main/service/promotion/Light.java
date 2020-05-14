package main.service.promotion;

import main.entity.Pedido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Light implements Desconto {

    @Override
    public BigDecimal getDesconto(Pedido pedido) {
        BigDecimal percentualDesconto = new BigDecimal(0.10);

        return pedido.getTotalPedido().multiply(percentualDesconto).setScale(2, RoundingMode.HALF_EVEN);
    }
}