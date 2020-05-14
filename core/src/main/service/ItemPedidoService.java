package main.service;

import main.cadastroexception.CadastroInvalidoException;
import main.cadastroexception.MotivoCadastroInvalido;
import main.entity.ItemPedido;
import main.repository.ItemPedidoRepository;
import main.service.validation.orderItem.ValidacaoItemPedidoService;

import java.math.BigDecimal;
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

    public BigDecimal getTotalItemSvc() {
        return itemPedidoRepository.getListaItens().stream().map(ItemPedido::getTotalItem).reduce(BigDecimal::add).get();
    }
}
