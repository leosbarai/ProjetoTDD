package service.validation.product;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Produto;
import service.ProdutoService;
import service.validation.RegisterValidation;

public class ValidaProdutoDecorator {

    public static class ValidaProdutoDecoratorCodigoNulo extends RegisterValidation<Produto> {

        public ValidaProdutoDecoratorCodigoNulo(RegisterValidation<Produto> outraValidacao) {
            super(outraValidacao);
        }

        @Override
        public Produto validaCadastros(Produto produto) throws CadastroInvalidoException {
            if (produto.getCodigo() == null)
                throw new CadastroInvalidoException(MotivoCadastroInvalido.CODIGO_PRODUTO_NULO);

            return produto;
        }
    }

    public static class ValidaProdutoDecoratorDescricaoNula extends RegisterValidation<Produto> {

        public ValidaProdutoDecoratorDescricaoNula(RegisterValidation<Produto> outraValidacao) {
            super(outraValidacao);
        }

        @Override
        public Produto validaCadastros(Produto produto) throws CadastroInvalidoException {
            if (produto.getDescricao() == null)
                throw new CadastroInvalidoException(MotivoCadastroInvalido.DESCRICAO_PRODUTO_NULA);

            return produto;
        }
    }

    public static class ValidaProdutoDecoratorExistente extends RegisterValidation<Produto> {

        public ValidaProdutoDecoratorExistente(RegisterValidation<Produto> outraValidacao) {
            super(outraValidacao);
        }

        @Override
        public Produto validaCadastros(Produto produto) throws CadastroInvalidoException {
            ProdutoService produtoService = new ProdutoService();

            for (Produto produtoLista : produtoService.produtoList()) {
                if (produto.getCodigo().equals(produtoLista.getCodigo())) {
                    throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_EXISTENTE);
                }
            }
            return produto;
        }
    }

    public static class ValidaProdutoDecoratorSemPreco extends RegisterValidation<Produto> {

        public ValidaProdutoDecoratorSemPreco(RegisterValidation<Produto> outraValicacao) {
            super(outraValicacao);
        }

        @Override
        public Produto validaCadastros(Produto produto) throws CadastroInvalidoException {
            if (produto.getPrecoUnitario() == null)
                throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_SEM_PRECO);

            return produto;
        }
    }

    public static class ProdutoDecoratorValido extends RegisterValidation<Produto> {

        @Override
        public Produto validaCadastros(Produto produto) throws CadastroInvalidoException {
            return produto;
        }
    }

    public static Produto validaProduto(Produto produto) throws CadastroInvalidoException {
        RegisterValidation<Produto> produtoRegisterValidation = new ValidaProdutoDecoratorCodigoNulo(
                new ValidaProdutoDecoratorDescricaoNula(
                        new ValidaProdutoDecoratorExistente(
                                new ValidaProdutoDecoratorSemPreco(new ProdutoDecoratorValido()))));

        return produtoRegisterValidation.validaCadastros(produto);
    }

}
