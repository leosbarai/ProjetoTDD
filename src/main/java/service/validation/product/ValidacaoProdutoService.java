package service.validation.product;

import cadastroexception.CadastroInvalidoException;
import entity.Produto;

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
