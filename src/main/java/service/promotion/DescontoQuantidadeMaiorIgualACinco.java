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
        Double totalItem = 0.0;

        totalItem = pedido.getItemPedidoList().stream().filter(x -> x.getQuantidade() >= 5).mapToDouble(ItemPedido::getTotalItem).sum();

        BigDecimal desconto = new BigDecimal(totalItem * 0.1).setScale(2, RoundingMode.HALF_EVEN);
        promocao.setDesconto(desconto.doubleValue());

        return this.desconto.aplicaDesconto(pedido, promocao);
    }

    @Override
    public void setProximoDesconto(Desconto proxima) {
        this.desconto = proxima;
    }
}
