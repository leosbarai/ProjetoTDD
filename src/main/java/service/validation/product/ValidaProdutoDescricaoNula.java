package service.validation.product;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Produto;

public class ValidaProdutoDescricaoNula implements ValidaProdutoService {

    private ValidaProdutoService proxima;

    @Override
    public Produto validaProduto(Produto produto) throws CadastroInvalidoException {
        if (produto.getDescricao() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.DESCRICAO_PRODUTO_NULA);
        } else {
            return proxima.validaProduto(produto);
        }
    }

    @Override
    public void setProximaValidacao(ValidaProdutoService proxima) {
        this.proxima = proxima;
    }
}
