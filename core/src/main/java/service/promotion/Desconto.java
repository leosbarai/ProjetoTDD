package service.promotion;

import entity.Pedido;

import java.math.BigDecimal;

public interface Desconto {
    BigDecimal getDesconto(Pedido pedido);
    Boolean validate(Pedido pedido);
}
