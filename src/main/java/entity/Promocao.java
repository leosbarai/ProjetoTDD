package entity;

import java.math.BigDecimal;

public class Promocao {

    private BigDecimal desconto;

    public Promocao() {
        this.desconto = BigDecimal.ZERO;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = this.desconto.add(desconto);
    }

    public Boolean isLight(Pedido pedido) {
        for (ItemPedido itemPedidoAlface : pedido.getItemPedidoList()) {
            if (itemPedidoAlface.getProduto().getDescricao().equals("Alface")) {
                for (ItemPedido itemPedidoBacon : pedido.getItemPedidoList()) {
                    if (itemPedidoBacon.getProduto().getDescricao().equals("Bacon")) {
                        return false;
                    }
                }

                return true;
            }
        }
        return false;
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
        for (ItemPedido itemPedido : pedido.getItemPedidoList()) {
            if (itemPedido.getQuantidade() >= 5) {
                return true;
            }
        }

        return false;
    }
}