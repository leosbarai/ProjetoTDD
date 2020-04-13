package entity;

import java.math.BigDecimal;

public class Promocao {

    private BigDecimal desconto;

    public Promocao() {
        this.desconto = BigDecimal.ZERO;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = this.desconto.add(desconto);
    }

}