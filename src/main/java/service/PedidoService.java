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

    public Double aplicaDesconto(Pedido pedido) {
        Promocao promocao = new Promocao();
        ValidaDesconto desconto = new ValidaDesconto();
        desconto.aplicaDesconto(pedido, promocao);
        return promocao.getDesconto();
    }

    public void removeItemPedido(Pedido pedido) {
        pedidoRepository.removePedido(pedido);
    }

    public Double totalPedido(Pedido pedido) {
        pedido.calculaTotal();
        BigDecimal totalComDesconto = new BigDecimal(pedido.getTotalPedido() - aplicaDesconto(pedido)).setScale(2, RoundingMode.HALF_EVEN);
        return totalComDesconto.doubleValue();
    }

}
