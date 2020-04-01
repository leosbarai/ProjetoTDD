package service.promotion;

import entity.Pedido;
import entity.Promocao;

public interface Desconto {

    Pedido aplicaDesconto(Pedido pedido, Promocao promocao);

    void setProximoDesconto(Desconto proxima);
}
