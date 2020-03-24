package service.validation;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Produto;
import service.ProdutoService;

public class ValidaProdutoExistente implements ValidaProdutoService {

    private ValidaProdutoService proxima;

    @Override
    public Produto validaProduto(Produto produto) throws CadastroInvalidoException {

        ProdutoService produtoService = new ProdutoService();

        for (Produto produtoLista : produtoService.produtoList()) {
            if (produto.getCodigo() == produtoLista.getCodigo()) {
                throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_EXISTENTE);
            }
        }

        return proxima.validaProduto(produto);
    }

    @Override
    public void setProximaValidacao(ValidaProdutoService proxima) {
        this.proxima = proxima;
    }
}
