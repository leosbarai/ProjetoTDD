package Service;

import Entity.ItemPedido;
import Entity.Pedido;
import Repository.PedidoRepository;
import Exception.CadastroInvalidoException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {

    private PedidoRepository pedidoRepository = new PedidoRepository();

    public List<Pedido> pedidoList() {
        List<Pedido> pedidoList = new ArrayList<>();
        pedidoList.addAll(pedidoRepository.getPedidoList());
        return pedidoList;
    }

    public void validaPedido(Pedido pedido) throws CadastroInvalidoException {
        if (pedido.getUsuario() == null) {
            throw new CadastroInvalidoException("Usuário não pode ser nulo!");
        } else if (pedido.getItemPedidoList() == null) {
            throw new CadastroInvalidoException("Pedido sem itens!");
        }
    }

    public void adicionaPedido(Pedido pedido) throws CadastroInvalidoException {
        validaPedido(pedido);
        pedidoRepository.addPedido(pedido);
    }

    public void removeItemPedido(Pedido pedido) {
        pedidoRepository.removePedido(pedido);
    }

    public Double totalPedido(Pedido pedido) {
        Double valorTotal = 0.0;
        for (ItemPedido x : pedido.getItemPedidoList()) {
            if (pedido.getItemPedidoList().size() >= 10 && x.getQuantidade() < 5) {
                valorTotal += x.getTotalItem() - (x.getTotalItem() * 0.05);
            } else if (x.getQuantidade() >= 5) {
                valorTotal += x.getTotalItem() - (x.getTotalItem() * 0.10);
            } else {
                valorTotal += x.getTotalItem();
            }
        }

        BigDecimal total = new BigDecimal(valorTotal).setScale(2, RoundingMode.HALF_EVEN);
        return total.doubleValue();
    }

}
