package service.validation;

import cadastroexception.CadastroInvalidoException;
import entity.Produto;

public interface ValidaProdutoService {

    Produto validaProduto(Produto produto) throws CadastroInvalidoException;

    void setProximaValidacao(ValidaProdutoService proxima);
}
