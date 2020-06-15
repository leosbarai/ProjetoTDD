package service.promotion;

import entity.Pedido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Bruto implements Desconto {

    public static final BigDecimal percentualDesconto = new BigDecimal("0.05");

    @Override
    public BigDecimal getDesconto(Pedido pedido) {
        return pedido.getTotalPedido()
                .multiply(percentualDesconto)
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public Boolean validate(Pedido pedido) {
        return pedido.getItemPedidoList().size() >= 10;
    }


}
