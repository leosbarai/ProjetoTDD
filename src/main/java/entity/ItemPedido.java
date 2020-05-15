package entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class ItemPedido {

    private Integer quantidade;
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getTotalItem(){
        return this.produto.getPrecoUnitario().multiply(BigDecimal.valueOf(this.quantidade)).setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return produto.equals(that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto);
    }
}
