package service.promotion;

import entity.Pedido;
import entity.Promocao;

public class PromocaoFactory {

    public static Desconto desconto(Pedido pedido) {

        Promocao promocao = new Promocao();

        if (promocao.isLight(pedido)) {
            return new Light();
        }

        if (promocao.isMuitaCarne(pedido)) {
            return new MuitaCarne();
        }

        if (promocao.isMuitoQueijo(pedido)) {
            return new MuitoQueijo();
        }

        if (promocao.isBruto(pedido)) {
            return new Bruto();
        }

        if (promocao.isGordao(pedido)) {
            return new Gordao();
        }

        return new SemDesconto();
    }
}
