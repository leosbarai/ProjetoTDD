package service.validation.product;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Produto;
import service.ProdutoService;
import service.validation.ValidaCadastrosService;

public class ValidacaoProdutoService {

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

    public class ValidaProdutoDescricaoNula implements ValidaCadastrosService<Produto> {

        private ValidaCadastrosService<Produto> proxima;

        @Override
        public Produto validaCadastros(Produto produto) throws CadastroInvalidoException {
            if (produto.getDescricao() == null) {
                throw new CadastroInvalidoException(MotivoCadastroInvalido.DESCRICAO_PRODUTO_NULA);
            } else {
                return proxima.validaCadastros(produto);
            }
        }

        @Override
        public void setProximaValidacao(ValidaCadastrosService<Produto> proxima) {
            this.proxima = proxima;
        }
    }

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

    public class ProdutoValido implements ValidaCadastrosService<Produto> {

        @Override
        public Produto validaCadastros(Produto produto) {
            return produto;
        }

        @Override
        public void setProximaValidacao(ValidaCadastrosService<Produto> proxima) {

        }
    }

    public void validaProduto(Produto produto) throws CadastroInvalidoException {

        ValidaCadastrosService codigoNulo = new ValidaProdutoCodigoNulo();
        ValidaCadastrosService descricaoNula = new ValidaProdutoDescricaoNula();
        ValidaCadastrosService precoNulo = new ValidaProdutoSemPreco();
        ValidaCadastrosService produtoExistente = new ValidaProdutoExistente();
        ValidaCadastrosService produtoValido = new ProdutoValido();

        codigoNulo.setProximaValidacao(descricaoNula);
        descricaoNula.setProximaValidacao(precoNulo);
        precoNulo.setProximaValidacao(produtoExistente);
        produtoExistente.setProximaValidacao(produtoValido);
        codigoNulo.validaCadastros(produto);
    }
}
