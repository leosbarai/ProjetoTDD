package Service;

import Entity.ItemPedido;
import cadastroexception.CadastroInvalidoException;
import Repository.ItemPedidoRepository;

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

    public void removeItemPedidoSvc(ItemPedido itemPedido) {
        itemPedidoRepository.removeItem(itemPedido);
    }

    public void addQuantidade(ItemPedido itemPedido, Integer qtd) {
        for (ItemPedido x : itemPedidoRepository.getListaItens()) {
            if (x.getProduto() == itemPedido.getProduto()) {
                x.setQuantidade(x.getQuantidade() + qtd);
            }
        }
    }

    public void removeQuantidade(ItemPedido itemPedido, Integer qtd) throws CadastroInvalidoException {
        for (ItemPedido x : itemPedidoRepository.getListaItens()) {
            if (x.getProduto() == itemPedido.getProduto()) {
                if (x.getQuantidade() > qtd) {
                    x.setQuantidade(x.getQuantidade() - qtd);
                } else {
                    throw new CadastroInvalidoException("Quantidade não pode ser removida em sua totalidade!");
                }
            }
        }
    }

    public Double getTotalItemSvc() {
        Double total = 0.0;
        for (ItemPedido x : itemPedidoRepository.getListaItens()) {
            total += x.getTotalItem();
        }
        return total;
    }
}
