package service.promotion;

import entity.Pedido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Gordao implements Desconto {

    private static final BigDecimal percentualDesconto = new BigDecimal("0.10");

    @Override
    public BigDecimal getDesconto(Pedido pedido) {
        return pedido.getTotalPedido()
                .multiply(percentualDesconto)
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public Boolean validate(Pedido pedido) {
        return pedido.getItemPedidoList().stream().anyMatch(itemPedido -> itemPedido.getQuantidade() >= 5);
    }

}
