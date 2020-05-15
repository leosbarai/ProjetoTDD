package repository;

import entity.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private List<Produto> produtoList = new ArrayList<>();

    public Produto addProdutos(Produto produto) {
        produtoList.add(produto);
        return produto;
    }

    public void removeProdutos(Produto produto) {
        if (produtoList.contains(produto)) {
            produtoList.remove(produto);
        } else {
            System.out.println("Produto não consta na lista!");
        }
    }

    public List<Produto> getListaProdutos() {
        return produtoList;
    }
}
