package Entity;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Usuario usuario;
    private List<ItemPedido> itemPedidoList = new ArrayList<>();

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
}
