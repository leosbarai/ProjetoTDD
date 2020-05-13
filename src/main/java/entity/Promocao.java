package entity;

import java.math.BigDecimal;

public class Promocao {

    private BigDecimal desconto;

    public Promocao() {
        this.desconto = BigDecimal.ZERO;
    }

    public Boolean isLight(Pedido pedido) {
        if (pedido.getItemPedidoList().stream().anyMatch(itemPedido -> itemPedido.getProduto().getDescricao().equals("Alface"))) {
            if (pedido.getItemPedidoList().stream().anyMatch(itemPedido -> itemPedido.getProduto().getDescricao().equals("Bacon"))) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean isMuitaCarne(Pedido pedido) {
        for (ItemPedido itemPedido : pedido.getItemPedidoList()) {
            if (itemPedido.getProduto().getDescricao().equals("Hamburguer de carne") &&
                    itemPedido.getQuantidade() >= 3) {
                return true;
            }
        }

        return false;
    }

    public Boolean isMuitoQueijo(Pedido pedido) {
        for (ItemPedido itemPedido : pedido.getItemPedidoList()) {
            if (itemPedido.getProduto().getDescricao().equals("Queijo") &&
                    itemPedido.getQuantidade() >= 3) {
                return true;
            }
        }

        return false;
    }

    public Boolean isBruto(Pedido pedido) {
        return pedido.getItemPedidoList().size() >= 10;
    }

    public Boolean isGordao(Pedido pedido) {
        return pedido.getItemPedidoList().stream().anyMatch(itemPedido -> itemPedido.getQuantidade() >= 5);
    }
}