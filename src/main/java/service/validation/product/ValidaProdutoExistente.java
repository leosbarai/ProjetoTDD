package service.validation.product;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Produto;
import service.ProdutoService;
import service.validation.ValidaCadastrosService;

public class ValidaProdutoExistente implements ValidaCadastrosService<Produto> {

    private ValidaCadastrosService<Produto> proxima;

    @Override
    public Produto validaCadastros(Produto produto) throws CadastroInvalidoException {

        ProdutoService produtoService = new ProdutoService();

        for (Produto produtoLista : produtoService.produtoList()) {
            if (produto.getCodigo().equals(produtoLista.getCodigo())) {
                throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_EXISTENTE);
            }
        }

        return proxima.validaCadastros(produto);
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<Produto> proxima) {
        this.proxima = proxima;
    }
}
