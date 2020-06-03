package service.promotion;

import entity.Pedido;

import java.util.Arrays;
import java.util.List;

public class PromocaoFactory {

    private static final List<Desconto> promocoes = Arrays.asList(new Light(), new MuitaCarne()
            , new MuitoQueijo(), new Bruto(), new Gordao());

    public static Desconto desconto(Pedido pedido) {
        for (Desconto desconto : promocoes) {
            if (desconto.validate(pedido)) {
                return desconto;
            }
        }

        return new SemDesconto();
    }
}
