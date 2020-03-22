package service.validation;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Produto;

public class ValidaProdutoCodigoNulo implements ValidaProdutoService {

    ValidaProdutoService proxima;

    @Override
    public Produto validaProduto(Produto produto) throws CadastroInvalidoException {
        if (produto.getCodigo() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.CODIGO_PRODUTO_NULO);
        } else {
            return proxima.validaProduto(produto);
        }
    }

    @Override
    public void setProximaValidacao(ValidaProdutoService proxima) {
        this.proxima = proxima;
    }
}
