package service.promotion;

import entity.Pedido;
import entity.Promocao;

public class ValidaDesconto {

    public void aplicaDesconto(Pedido pedido, Promocao promocao) {
        Desconto descontoQuantidadeMaiorIgualACincoCinco = new DescontoQuantidadeMaiorIgualACinco();
        Desconto descontoMaiorIgualDez = new DescontoMaiorIgualDezItens();
        Desconto semDesconto = new SemDesconto();

        descontoQuantidadeMaiorIgualACincoCinco.setProximoDesconto(descontoMaiorIgualDez);
        descontoMaiorIgualDez.setProximoDesconto(semDesconto);
        descontoQuantidadeMaiorIgualACincoCinco.aplicaDesconto(pedido, promocao);
    }
}
