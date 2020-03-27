package service.validation.product;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Produto;
import service.validation.ValidaCadastrosService;

public class ValidaProdutoCodigoNulo implements ValidaCadastrosService<Produto> {

    private ValidaCadastrosService<Produto> proxima;

    @Override
    public Produto validaCadastros(Produto produto) throws CadastroInvalidoException {
        if (produto.getCodigo() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.CODIGO_PRODUTO_NULO);
        } else {
            return proxima.validaCadastros(produto);
        }
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<Produto> proxima) {
        this.proxima = proxima;
    }
}
