package service;

import cadastroexception.CadastroInvalidoException;
import entity.Pedido;
import repository.PedidoRepository;
import service.promotion.Desconto;
import service.promotion.PromocaoFactory;
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

    public BigDecimal aplicaDesconto(Pedido pedido) {
        Desconto valorDesconto = PromocaoFactory.desconto(pedido);
        return valorDesconto.getDesconto(pedido);
    }

    public void removeItemPedido(Pedido pedido) {
        pedidoRepository.removePedido(pedido);
    }

    public BigDecimal totalPedido(Pedido pedido) {
        pedido.calculaTotal();
        return pedido.getTotalPedido().subtract(aplicaDesconto(pedido)).setScale(2, RoundingMode.HALF_EVEN);
    }

}
