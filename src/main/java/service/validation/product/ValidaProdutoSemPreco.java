package service.validation.product;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Produto;
import service.validation.ValidaCadastrosService;

public class ValidaProdutoSemPreco implements ValidaCadastrosService<Produto> {

    private ValidaCadastrosService<Produto> proxima;

    @Override
    public Produto validaCadastros(Produto produto) throws CadastroInvalidoException {
        if (produto.getPrecoUnitario() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_SEM_PRECO);
        } else {
            return proxima.validaCadastros(produto);
        }
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<Produto> proxima) {
        this.proxima = proxima;
    }
}
