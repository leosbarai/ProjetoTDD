package service;

import cadastroexception.CadastroInvalidoException;
import entity.ItemPedido;
import entity.Pedido;
import repository.PedidoRepository;
import service.validation.order.ValidacaoPedidoService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PedidoService {

    private PedidoRepository pedidoRepository = new PedidoRepository();

    public List<Pedido> pedidoList() {
        return pedidoRepository.getPedidoList();
    }

    public void adicionaPedido(Pedido pedido) throws CadastroInvalidoException {
        ValidacaoPedidoService validaCadastro = new ValidacaoPedidoService();
        validaCadastro.validaPedido(pedido);
        pedidoRepository.addPedido(pedido);
    }

    public void removeItemPedido(Pedido pedido) {
        pedidoRepository.removePedido(pedido);
    }

    public Double totalPedido(Pedido pedido) {
        Double valorTotal = 0.0;
        
        for (ItemPedido itemPedidoList : pedido.getItemPedidoList()) {
            if (pedido.getItemPedidoList().size() >= 10 && itemPedidoList.getQuantidade() < 5) {
                valorTotal += itemPedidoList.getTotalItem() - (itemPedidoList.getTotalItem() * 0.05);
            } else if (itemPedidoList.getQuantidade() >= 5) {
                valorTotal += itemPedidoList.getTotalItem() - (itemPedidoList.getTotalItem() * 0.10);
            } else {
                valorTotal += itemPedidoList.getTotalItem();
            }
        }

        BigDecimal total = new BigDecimal(valorTotal).setScale(2, RoundingMode.HALF_EVEN);
        return total.doubleValue();
    }

}
