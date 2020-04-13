package service;

import cadastroexception.CadastroInvalidoException;
import entity.Pedido;
import entity.Promocao;
import repository.PedidoRepository;
import service.promotion.ValidaDesconto;
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
        Promocao promocao = new Promocao();
        ValidaDesconto desconto = new ValidaDesconto();
        desconto.aplicaDesconto(pedido, promocao);
        return promocao.getDesconto();
    }

    public void removeItemPedido(Pedido pedido) {
        pedidoRepository.removePedido(pedido);
    }

    public BigDecimal totalPedido(Pedido pedido) {
        BigDecimal valorTotal, desconto;
        pedido.calculaTotal();
        valorTotal = pedido.getTotalPedido().subtract(aplicaDesconto(pedido));
        return valorTotal.setScale(2, RoundingMode.HALF_EVEN);
    }

}
