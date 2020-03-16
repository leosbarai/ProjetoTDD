package service;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Produto;
import repository.ProdutoRepository;

import java.util.ArrayList;
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
        List<Produto> produtoList = new ArrayList<>();
        produtoList.addAll(produtoRepository.getListaProdutos());
        return produtoList;
    }

    public void validaProduto(Produto produto) throws CadastroInvalidoException {
        if (produto.getCodigo() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.CODIGO_PRODUTO_NULO);
        } else if (produto.getDescricao() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.DESCRICAO_PRODUTO_NULA);
        } else if (produto.getPrecoUnitario() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_SEM_PRECO);
        } else {
            for (Produto produtoLista : produtoList()) {
                if (produto.getCodigo() == produtoLista.getCodigo()) {
                    throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_EXISTENTE);
                }
            }
        }
    }

    public void addProdutoSvc(Produto produto) throws CadastroInvalidoException {
        validaProduto(produto);
        produtoRepository.addProdutos(produto);
    }

    public void removeProdutosSvc(Produto produto) {
        produtoRepository.removeProdutos(produto);
    }


}
