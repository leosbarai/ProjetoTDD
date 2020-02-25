package Service;

import Entity.Produto;
import Exception.CadastroInvalidoException;
import Repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private ProdutoRepository produtoRepository = new ProdutoRepository();

    public List<Produto> produtoList() {
        List<Produto> produtoList = new ArrayList<>();
        produtoList.addAll(produtoRepository.getListaProdutos());
        return produtoList;
    }

    public void validaProduto(Produto produto) throws CadastroInvalidoException {
        if (produto.getCodigo() == null) {
            throw new CadastroInvalidoException("Código do produto não pode ser nulo!");
        } else if (produto.getDescricao() == null) {
            throw new CadastroInvalidoException("Descrição do produto não pode ser nula!");
        } else if (produto.getPrecoUnitario() == null) {
            throw new CadastroInvalidoException("Preço do produto é obrigatório");
        } else {
            for (Produto x : produtoList()) {
                if (produto.getCodigo() == x.getCodigo()) {
                    throw new CadastroInvalidoException("Produto já existe na lista");
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
