package service;

import cadastroexception.CadastroInvalidoException;
import entity.Produto;
import repository.ProdutoRepository;
import service.validation.ValidacaoProdutoService;

import java.util.List;

public class ProdutoService {

    private ProdutoRepository produtoRepository = new ProdutoRepository();

    public Produto alface() {
        return new Produto("001", "Alface", 0.40);
    }

    public Produto bacon() {
        return new Produto("002", "Bacon", 2.00);
    }

    public Produto hamburguer() {
        return new Produto("003", "Hamburguer de carne", 3.00);
    }

    public Produto ovo() {
        return new Produto("004", "Ovo", 0.80);
    }

    public Produto queijo() {
        return new Produto("005", "Queijo", 1.50);
    }

    public Produto pao() {
        return new Produto("006", "Pão", 1.00);
    }

    public Produto maionese() {
        return new Produto("007", "Maionese", 0.50);
    }

    public Produto mostarda() {
        return new Produto("008", "Mostarda", 0.50);
    }

    public Produto catchup() {
        return new Produto("009", "Catchup", 0.50);
    }

    public Produto azeitona() {
        return new Produto("010", "Azeitona", 0.50);
    }

    public List<Produto> produtoList() {
        return produtoRepository.getListaProdutos();
    }

    public void addProdutoSvc(Produto produto) throws CadastroInvalidoException {
        ValidacaoProdutoService validaCadastro = new ValidacaoProdutoService();
        validaCadastro.validaProduto(produto);
        produtoRepository.addProdutos(produto);
    }

    public void removeProdutosSvc(Produto produto) {
        produtoRepository.removeProdutos(produto);
    }


}
