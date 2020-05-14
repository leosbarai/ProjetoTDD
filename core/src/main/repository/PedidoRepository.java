package main.repository;

import main.entity.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {

    private List<Pedido> pedidoList = new ArrayList<>();

    public Pedido addPedido(Pedido pedido) {
        pedidoList.add(pedido);
        return pedido;
    }

    public void removePedido(Pedido pedido) {
        if (pedidoList.contains(pedido)) {
            pedidoList.remove(pedido);
        }
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }
}
