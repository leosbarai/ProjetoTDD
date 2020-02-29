package Service;

import Entity.Produto;
import Exception.CadastroInvalidoException;
import Repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private ProdutoRepository produtoRepository = new ProdutoRepository();

    public List<Produto> mockList() {
        Produto alface = new Produto("001", "Alface", 0.40);
        Produto bacon = new Produto("002", "Bacon", 2.00);
        Produto hamburguer = new Produto("003", "Hamburguer de carne", 3.00);
        Produto ovo = new Produto("004", "Ovo", 0.80);
        Produto queijo = new Produto("005", "Queijo", 1.50);
        Produto pao = new Produto("006", "Pão", 1.00);
        Produto maionese = new Produto("007", "Maionese", 0.50);
        Produto mostarda = new Produto("008", "Mostarda", 0.50);
        Produto catchup = new Produto("009", "Catchup", 0.50);
        Produto azeitona = new Produto("010", "Azeitona", 0.50);

        List<Produto> produtoList = new ArrayList<>();
        produtoList.add(alface);
        produtoList.add(bacon);
        produtoList.add(hamburguer);
        produtoList.add(ovo);
        produtoList.add(queijo);
        produtoList.add(pao);
        produtoList.add(maionese);
        produtoList.add(mostarda);
        produtoList.add(catchup);
        produtoList.add(azeitona);

        return produtoList;
    }

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
