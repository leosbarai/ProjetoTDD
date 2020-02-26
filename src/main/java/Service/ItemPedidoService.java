package Service;

import Entity.ItemPedido;
import Repository.ItemPedidoRepository;
import Exception.CadastroInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class ItemPedidoService {

    private ItemPedidoRepository itemPedidoRepository = new ItemPedidoRepository();

    public List<ItemPedido> itemPedidoList() {
        List<ItemPedido> itemPedidoList = new ArrayList<>();
        itemPedidoList.addAll(itemPedidoRepository.getListaItens());
        return itemPedidoList;
    }

    public void validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException {
        if (itemPedido.getQuantidade() == null) {
            throw new CadastroInvalidoException("Quantidade não pode ser nula!");
        } else if (itemPedido.getQuantidade() <= 0) {
            throw new CadastroInvalidoException("Quantidade incorreta!");
        } else if (itemPedido.getProduto() == null) {
            throw new CadastroInvalidoException("Produto não pode ser nulo!");
        }
    }

    public void addItemPedidoSvc(ItemPedido itemPedido) throws CadastroInvalidoException {
        validaItemPedido(itemPedido);
        itemPedidoRepository.addItemPedido(itemPedido);
    }

    public void removeItemPedido(ItemPedido itemPedido) {
        itemPedidoRepository.removeItem(itemPedido);
    }
}
