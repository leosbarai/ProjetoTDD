package Repository;

import Entity.ItemPedido;

import java.util.ArrayList;
import java.util.List;

public class ItemPedidoRepository {

    private List<ItemPedido> itemPedidoList = new ArrayList<>();

    public ItemPedido addItemPedido(ItemPedido itemPedido) {
        itemPedidoList.add(itemPedido);
        return itemPedido;
    }

    public void removeItem(ItemPedido itemPedido) {
        if (itemPedidoList.contains(itemPedido)) {
            itemPedidoList.remove(itemPedido);
        } else {
            System.out.println("Item não está na lista!");
        }
    }

    public List<ItemPedido> getListaItens() {
        return itemPedidoList;
    }
}
