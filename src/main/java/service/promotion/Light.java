package service.promotion;

import entity.ItemPedido;
import entity.Pedido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Light {

    public BigDecimal getDesconto(Pedido pedido) {
        BigDecimal totalDesconto = BigDecimal.ZERO;
        BigDecimal percentualDesconto = new BigDecimal(0.10);

        if (pedido.getItemPedidoList().stream().map(ItemPedido::getProduto).equals("Alface") &&
                !pedido.getItemPedidoList().stream().map(ItemPedido::getProduto).equals("Bacon")) {
            return totalDesconto.multiply(percentualDesconto).setScale(2, RoundingMode.HALF_EVEN);
        } else {
            return totalDesconto;
        }
    }
}
