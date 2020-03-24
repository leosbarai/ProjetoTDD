package service.validation.product;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Produto;

public class ValidaProdutoSemPreco implements ValidaProdutoService {

    private ValidaProdutoService proxima;

    @Override
    public Produto validaProduto(Produto produto) throws CadastroInvalidoException {
        if (produto.getPrecoUnitario() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_SEM_PRECO);
        } else {
            return proxima.validaProduto(produto);
        }
    }

    @Override
    public void setProximaValidacao(ValidaProdutoService proxima) {
        this.proxima = proxima;
    }
}
