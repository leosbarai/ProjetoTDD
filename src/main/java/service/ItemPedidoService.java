package service;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.ItemPedido;
import repository.ItemPedidoRepository;
import service.validation.orderItem.ValidacaoItemPedidoService;

import java.util.List;

public class ItemPedidoService {

    private ItemPedidoRepository itemPedidoRepository = new ItemPedidoRepository();

    public List<ItemPedido> itemPedidoList() {
        return itemPedidoRepository.getListaItens();
    }

    public void addItemPedidoSvc(ItemPedido itemPedido) throws CadastroInvalidoException {
        ValidacaoItemPedidoService validaCadastro = new ValidacaoItemPedidoService();
        validaCadastro.validaItemPedido(itemPedido);
        itemPedidoRepository.addItemPedido(itemPedido);
    }

    public void removeItemPedidoSvc(ItemPedido itemPedido) {
        itemPedidoRepository.removeItem(itemPedido);
    }

    public void addQuantidade(ItemPedido itemPedido, Integer qtd) {
        itemPedidoRepository.getListaItens().stream().filter(x -> x.getProduto().equals(itemPedido.getProduto())).forEach(x -> x.setQuantidade(x.getQuantidade() + qtd));
    }

    public void removeQuantidade(ItemPedido itemPedido, Integer qtd) throws CadastroInvalidoException {
        for (ItemPedido itemPedidoList : itemPedidoRepository.getListaItens()) {
            if (itemPedidoList.getProduto().equals(itemPedido.getProduto())) {
                if (itemPedidoList.getQuantidade() > qtd) {
                    itemPedidoList.setQuantidade(itemPedidoList.getQuantidade() - qtd);
                } else {
                    throw new CadastroInvalidoException(MotivoCadastroInvalido.REMOCAO_QUANTIDADE_INCORRETA_ITEMPEDIDO);
                }
            }
        }
    }

    public Double getTotalItemSvc() {
        return itemPedidoRepository.getListaItens().stream().mapToDouble(ItemPedido::getTotalItem).sum();
    }
}
