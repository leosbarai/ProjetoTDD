package service.validation.orderItem;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.ItemPedido;
import service.validation.RegisterValidation;

public class ValidaItemPedidoDecorator {

    public static class ValidaItemPedidoDecoratorProdutoNulo extends RegisterValidation<ItemPedido> {

        public ValidaItemPedidoDecoratorProdutoNulo(RegisterValidation<ItemPedido> outraValidacao) {
            super(outraValidacao);
        }

        @Override
        public ItemPedido validaCadastros(ItemPedido itemPedido) throws CadastroInvalidoException {
            if (itemPedido.getProduto() == null)
                throw new CadastroInvalidoException(MotivoCadastroInvalido.PRODUTO_ITEMPEDIDO_NULO);

            return itemPedido;
        }
    }

    public static class ValidaItemPedidoDecoratorQuantidadeIncorreta extends RegisterValidation<ItemPedido> {

        public ValidaItemPedidoDecoratorQuantidadeIncorreta(RegisterValidation<ItemPedido> outraValidacao) {
            super(outraValidacao);
        }

        @Override
        public ItemPedido validaCadastros(ItemPedido itemPedido) throws CadastroInvalidoException {
            if (itemPedido.getQuantidade() <= 0)
                throw new CadastroInvalidoException(MotivoCadastroInvalido.QUANTIDADE_ITEMPEDIDO_INCORRETA);

            return itemPedido;
        }
    }

    public static class ValidaItemPedidoDecoratorQuantidadeNula extends RegisterValidation<ItemPedido> {

        public ValidaItemPedidoDecoratorQuantidadeNula(RegisterValidation<ItemPedido> outraValidacao) {
            super(outraValidacao);
        }

        @Override
        public ItemPedido validaCadastros(ItemPedido itemPedido) throws CadastroInvalidoException {
            if (itemPedido.getQuantidade() == null)
                throw new CadastroInvalidoException(MotivoCadastroInvalido.QUANTIDADE_ITEMPEDIDO_NULA);

            return itemPedido;
        }
    }

    public static class ItemPedidoDecoratorValido extends RegisterValidation<ItemPedido> {

        @Override
        public ItemPedido validaCadastros(ItemPedido itemPedido) throws CadastroInvalidoException {
            return itemPedido;
        }
    }

    public static ItemPedido validaItemPedido(ItemPedido itemPedido) throws CadastroInvalidoException {
        RegisterValidation<ItemPedido> itemPedidoRegisterValidation = new ValidaItemPedidoDecoratorProdutoNulo(
                new ValidaItemPedidoDecoratorQuantidadeIncorreta(
                        new ValidaItemPedidoDecoratorQuantidadeNula(
                                new ItemPedidoDecoratorValido())));

        return itemPedidoRegisterValidation.validaCadastros(itemPedido);
    }
}
