package service.validation.product;

import cadastroexception.CadastroInvalidoException;
import entity.Produto;
import service.validation.ValidaCadastrosService;

public class ValidacaoProdutoService {

    public void validaProduto(Produto produto) throws CadastroInvalidoException {

        ValidaCadastrosService codigoNulo = new ValidaProdutoCodigoNulo();
        ValidaCadastrosService descricaoNula = new ValidaProdutoDescricaoNula();
        ValidaCadastrosService precoNulo = new ValidaProdutoSemPreco();
        ValidaCadastrosService produtoExistente = new ValidaProdutoExistente();
        ValidaCadastrosService produtoValido = new ProdutoValido();

        codigoNulo.setProximaValidacao(descricaoNula);
        descricaoNula.setProximaValidacao(precoNulo);
        precoNulo.setProximaValidacao(produtoExistente);
        produtoExistente.setProximaValidacao(produtoValido);
        codigoNulo.validaCadastros(produto);
    }
}
