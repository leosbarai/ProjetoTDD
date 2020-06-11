package service;

import entity.Pedido;
import service.promotion.Desconto;
import service.promotion.PromocaoFactory;

import java.math.BigDecimal;

public class PromocaoService {

    public static  BigDecimal aplicaDesconto(Pedido pedido) {
        Desconto valorDesconto = PromocaoFactory.desconto(pedido);
        return valorDesconto.getDesconto(pedido);
    }
}
