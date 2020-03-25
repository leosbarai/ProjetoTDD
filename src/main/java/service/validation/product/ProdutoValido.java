package service.validation.product;

import cadastroexception.CadastroInvalidoException;
import entity.Produto;
import service.validation.product.ValidaProdutoService;

public class ProdutoValido implements ValidaProdutoService {

    @Override
    public Produto validaProduto(Produto produto) throws CadastroInvalidoException {
        return produto;
    }

    @Override
    public void setProximaValidacao(ValidaProdutoService proxima) {

    }
}
