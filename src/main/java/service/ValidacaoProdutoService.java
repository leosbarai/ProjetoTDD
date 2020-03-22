package service;

import cadastroexception.CadastroInvalidoException;
import entity.Produto;
import service.validation.*;

public class ValidacaoProdutoService {

    public void validaProduto(Produto produto) throws CadastroInvalidoException {

        ValidaProdutoService codigoNulo = new ValidaProdutoCodigoNulo();
        ValidaProdutoService descricaoNula = new ValidaProdutoDescricaoNula();
        ValidaProdutoService precoNulo = new ValidaProdutoSemPreco();
        ValidaProdutoService produtoExistente = new ValidaProdutoExistente();
        ValidaProdutoService produtoValido = new ProdutoValido();

        codigoNulo.setProximaValidacao(descricaoNula);
        descricaoNula.setProximaValidacao(precoNulo);
        precoNulo.setProximaValidacao(produtoExistente);
        produtoExistente.setProximaValidacao(produtoValido);
        codigoNulo.validaProduto(produto);
    }
}
