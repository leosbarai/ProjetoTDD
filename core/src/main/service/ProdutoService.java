package main.service;

import main.cadastroexception.CadastroInvalidoException;
import main.entity.Produto;
import main.repository.ProdutoRepository;
import main.service.validation.product.ValidacaoProdutoService;

import java.util.List;

public class ProdutoService {

    private ProdutoRepository produtoRepository = new ProdutoRepository();

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
