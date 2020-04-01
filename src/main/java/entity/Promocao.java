package entity;

public class Promocao {

    private Double desconto;

    public Promocao() {
        this.desconto = 0.0;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto += desconto;
    }

}