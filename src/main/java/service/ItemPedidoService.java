package service;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.ItemPedido;
import repository.ItemPedidoRepository;

import java.util.List;

public class ItemPedidoService {

    private ItemPedidoRepository itemPedidoRepository = new ItemPedidoRepository();

    public List<ItemPedido> itemPedidoList() {
        return itemPedidoRepository.getListaItens();
    }

    public void validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException {
        if (itemPedido.getQuantidade() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.QUANTIDADE_ITEMPEDIDO_NULA);
        } else if (itemPedido.getQuantidade() <= 0) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.QUANTIDADE_ITEMPEDIDO_INCORRETA);
        } else if (itemPedido.getProduto() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_ITEMPEDIDO_NULO);
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
        for (ItemPedido itemPedidoList : itemPedidoRepository.getListaItens()) {
            if (itemPedidoList.getProduto() == itemPedido.getProduto()) {
                if (itemPedidoList.getQuantidade() > qtd) {
                    itemPedidoList.setQuantidade(itemPedidoList.getQuantidade() - qtd);
                } else {
                    throw new CadastroInvalidoException(MotivoCadastroInvalido.REMOCAO_QUANTIDADE_INCORRETA_ITEMPEDIDO);
                }
            }
        }
    }

    public Double getTotalItemSvc() {
        Double total = 0.0;
        for (ItemPedido itemPedidoList : itemPedidoRepository.getListaItens()) {
            total += itemPedidoList.getTotalItem();
        }
        return total;
    }
}
