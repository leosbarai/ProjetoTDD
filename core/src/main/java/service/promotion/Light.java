package service.promotion;

import entity.Pedido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Light implements Desconto {

    private static final BigDecimal percentualDesconto = new BigDecimal("0.10");

    @Override
    public BigDecimal getDesconto(Pedido pedido) {
        return pedido.getTotalPedido()
                .multiply(percentualDesconto)
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public Boolean validate(Pedido pedido) {
        if (pedido.getItemPedidoList().stream().anyMatch(itemPedido -> itemPedido.getProduto().getDescricao().equals("Alface"))) {
            return pedido.getItemPedidoList().stream().noneMatch(itemPedido -> itemPedido.getProduto().getDescricao().equals("Bacon"));
        }

        return false;
    }
}
