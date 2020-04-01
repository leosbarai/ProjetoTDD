package service.promotion;


import entity.ItemPedido;
import entity.Pedido;
import entity.Promocao;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DescontoMaiorIgualDezItens implements Desconto {

    private Desconto desconto;

    @Override
    public Pedido aplicaDesconto(Pedido pedido, Promocao promocao) {
        Double totalItem = 0.0;

        if (pedido.getItemPedidoList().size() >= 10) {
            totalItem = pedido.getItemPedidoList().stream().mapToDouble(ItemPedido::getTotalItem).sum();
        }

        BigDecimal desconto = new BigDecimal(totalItem * 0.05).setScale(2, RoundingMode.HALF_EVEN);
        promocao.setDesconto(desconto.doubleValue());

        return this.desconto.aplicaDesconto(pedido, promocao);
    }

    @Override
    public void setProximoDesconto(Desconto proxima) {
        this.desconto = proxima;
    }
}
