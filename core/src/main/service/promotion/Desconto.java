package main.service.promotion;

import main.entity.Pedido;

import java.math.BigDecimal;

public interface Desconto {
    BigDecimal getDesconto(Pedido pedido);
}
