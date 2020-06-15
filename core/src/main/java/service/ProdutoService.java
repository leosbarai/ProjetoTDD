package service;

import cadastroexception.CadastroInvalidoException;
import entity.Produto;
import repository.ProdutoRepository;
import service.validation.product.ValidaProdutoDecorator;

import java.util.List;

public class ProdutoService {

    private ProdutoRepository produtoRepository = new ProdutoRepository();

    public List<Produto> produtoList() {
        return produtoRepository.findAll();
    }

    public void addProdutoSvc(Produto produto) throws CadastroInvalidoException {
        produtoRepository.add(ValidaProdutoDecorator.validaProduto(produto));
    }

    public void removeProdutosSvc(Produto produto) {
        produtoRepository.remove(produto);
    }

}
