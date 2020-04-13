package service.promotion;

import entity.ItemPedido;
import entity.Pedido;
import entity.Promocao;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DescontoQuantidadeMaiorIgualACinco implements Desconto {

    private Desconto desconto;

    @Override
    public Pedido aplicaDesconto(Pedido pedido, Promocao promocao) {
        BigDecimal totalItem;
        BigDecimal percentualDesconto = new BigDecimal(0.10).setScale(2, RoundingMode.HALF_EVEN);

        totalItem = pedido.getItemPedidoList().stream().filter(itemPedido -> itemPedido.getQuantidade() >= 5).map(ItemPedido::getTotalItem).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal desconto = totalItem.multiply(percentualDesconto).setScale(2, RoundingMode.HALF_EVEN);
        promocao.setDesconto(desconto);

        return this.desconto.aplicaDesconto(pedido, promocao);
    }

    @Override
    public void setProximoDesconto(Desconto proxima) {
        this.desconto = proxima;
    }
}
