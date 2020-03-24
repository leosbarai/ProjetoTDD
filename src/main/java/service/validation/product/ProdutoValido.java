package service.validation;

import cadastroexception.CadastroInvalidoException;
import entity.Produto;

public class ProdutoValido implements ValidaProdutoService {

    @Override
    public Produto validaProduto(Produto produto) throws CadastroInvalidoException {
        return produto;
    }

    @Override
    public void setProximaValidacao(ValidaProdutoService proxima) {

    }
}
