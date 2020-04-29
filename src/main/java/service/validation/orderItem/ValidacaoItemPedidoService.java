package service.validation.orderItem;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.ItemPedido;
import service.validation.ValidaCadastrosService;

public class ValidacaoItemPedidoService {

    public class ValidaItemPedidoProdutoNulo implements ValidaCadastrosService<ItemPedido> {

        private ValidaCadastrosService<ItemPedido> proxima;

        @Override
        public ItemPedido validaCadastros(ItemPedido itemPedido) throws CadastroInvalidoException {

            if (itemPedido.getProduto() == null) {
                throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_ITEMPEDIDO_NULO);
            } else {
                return proxima.validaCadastros(itemPedido);
            }
        }

        @Override
        public void setProximaValidacao(ValidaCadastrosService<ItemPedido> proxima) {
            this.proxima = proxima;
        }
    }

    public class ValidaItemPedidoQuantidadeIncorreta implements ValidaCadastrosService<ItemPedido> {

        private ValidaCadastrosService<ItemPedido> proxima;

        @Override
        public ItemPedido validaCadastros(ItemPedido itemPedido) throws CadastroInvalidoException {

            if (itemPedido.getQuantidade() <= 0) {
                throw new CadastroInvalidoException(MotivoCadastroInvalido.QUANTIDADE_ITEMPEDIDO_INCORRETA);
            } else {
                return proxima.validaCadastros(itemPedido);
            }
        }

        @Override
        public void setProximaValidacao(ValidaCadastrosService<ItemPedido> proxima) {
            this.proxima = proxima;
        }
    }

    public class ValidaItemPedidoQuantidadeNula implements ValidaCadastrosService<ItemPedido> {

        private ValidaCadastrosService<ItemPedido> proxima;

        @Override
        public ItemPedido validaCadastros(ItemPedido itemPedido) throws CadastroInvalidoException {

            if (itemPedido.getQuantidade() == null) {
                throw new CadastroInvalidoException(MotivoCadastroInvalido.QUANTIDADE_ITEMPEDIDO_NULA);
            } else {
                return proxima.validaCadastros(itemPedido);
            }
        }

        @Override
        public void setProximaValidacao(ValidaCadastrosService<ItemPedido> proxima) {
            this.proxima = proxima;
        }
    }

    public class ItemPedidoValido implements ValidaCadastrosService<ItemPedido> {

        @Override
        public ItemPedido validaCadastros(ItemPedido itemPedido) {
            return itemPedido;
        }

        @Override
        public void setProximaValidacao(ValidaCadastrosService<ItemPedido> proxima) {

        }
    }

    public void validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException {

        ValidaCadastrosService quantidadeNula = new ValidaItemPedidoQuantidadeNula();
        ValidaCadastrosService quantidadeIncorreta = new ValidaItemPedidoQuantidadeIncorreta();
        ValidaCadastrosService produtoNulo = new ValidaItemPedidoProdutoNulo();
        ValidaCadastrosService itemPedidoValido = new ItemPedidoValido();

        quantidadeNula.setProximaValidacao(quantidadeIncorreta);
        quantidadeIncorreta.setProximaValidacao(produtoNulo);
        produtoNulo.setProximaValidacao(itemPedidoValido);
        quantidadeNula.validaCadastros(itemPedido);
    }
}
