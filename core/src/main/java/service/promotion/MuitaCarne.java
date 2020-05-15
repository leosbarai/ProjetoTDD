package service.promotion;

import entity.ItemPedido;
import entity.Pedido;

import java.math.BigDecimal;

public class MuitaCarne implements Desconto {

    @Override
    public BigDecimal getDesconto(Pedido pedido) {
        int quantidade = 0;

        for (ItemPedido itemPedido : pedido.getItemPedidoList()) {
            if (itemPedido.getProduto().getDescricao().equals("Hamburguer de carne")) {
                quantidade = itemPedido.getQuantidade() / 3;
            }

            if (quantidade > 0) {
                return itemPedido.getProduto().getPrecoUnitario().multiply(BigDecimal.valueOf(quantidade));
            }
        }

        return BigDecimal.valueOf(quantidade);
    }
}
