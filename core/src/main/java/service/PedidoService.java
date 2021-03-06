package service;

import cadastroexception.CadastroInvalidoException;
import entity.Pedido;
import repository.PedidoRepository;
import service.validation.order.ValidaPedidoDecorator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PedidoService {

    private PedidoRepository pedidoRepository = new PedidoRepository();

    public List<Pedido> pedidoList() {
        return pedidoRepository.findAll();
    }

    public void adicionaPedido(Pedido pedido) throws CadastroInvalidoException {
        pedidoRepository.add(ValidaPedidoDecorator.validaPedido(pedido));
    }

    public void removeItemPedido(Pedido pedido) {
        pedidoRepository.remove(pedido);
    }

    public BigDecimal totalPedido(Pedido pedido) {
        return pedido.getTotalPedido().subtract(PromocaoService.aplicaDesconto(pedido)).setScale(2, RoundingMode.HALF_EVEN);
    }

}
