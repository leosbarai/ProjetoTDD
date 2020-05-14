package main.service.promotion;

import main.entity.Pedido;

import java.math.BigDecimal;

public class SemDesconto implements Desconto{

    @Override
    public BigDecimal getDesconto(Pedido pedido) {
        return BigDecimal.valueOf(0);
    }
}
