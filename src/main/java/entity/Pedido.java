package entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Usuario usuario;
    private List<ItemPedido> itemPedidoList = new ArrayList<>();
    private BigDecimal totalPedido = BigDecimal.ZERO;

    public Pedido() {
    }

    public Pedido(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
        this.itemPedidoList = itemPedidoList;
    }

    public void calculaTotal() {
        this.totalPedido  = itemPedidoList.stream()
                .map(ItemPedido::getTotalItem).reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_EVEN);
    }

}
