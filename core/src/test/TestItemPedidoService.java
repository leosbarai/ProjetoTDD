package test;

import main.cadastroexception.CadastroInvalidoException;
import main.entity.ItemPedido;
import main.entity.Produto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import main.service.ItemPedidoService;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestItemPedidoService {

    private ItemPedidoService itemPedidoService;

    @Before
    public void setup() {
        itemPedidoService = new ItemPedidoService();
    }

    private ItemPedido itemPedido(int quantidade, Produto produto) {
        return new ItemPedido(quantidade, produto);
    }

    @Test
    public void adicionarItensPedido() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1,
                new Produto("006", "Pão", new BigDecimal(1.0))));

        Assert.assertEquals(1, itemPedidoService.itemPedidoList().size());
    }

    @Test
    public void removerItensPedido() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("006", "Pão", new BigDecimal(1.0))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("003", "Hamburguer de carne", new BigDecimal(3.00))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("005", "Queijo", new BigDecimal(1.50))));

        itemPedidoService.removeItemPedidoSvc(itemPedidoService.itemPedidoList().get(0));

        Assert.assertEquals(2, itemPedidoService.itemPedidoList().size());
    }

    @Test
    public void adicionarQuantidade() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("003", "Hamburguer de carne", new BigDecimal(3.00))));
        itemPedidoService.addQuantidade(itemPedidoService.itemPedidoList().get(0), 4);

        Assert.assertEquals((Integer) 5, itemPedidoService.itemPedidoList().get(0).getQuantidade());
    }

    @Test
    public void removerQuantidade() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(5, new Produto("003", "Hamburguer de carne", new BigDecimal(3.00))));
        itemPedidoService.removeQuantidade(itemPedidoService.itemPedidoList().get(0), 4);

        Assert.assertEquals((Integer) 1, itemPedidoService.itemPedidoList().get(0).getQuantidade());
    }

    @Test
    public void totalItem() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(5, new Produto("002", "Bacon", new BigDecimal(2.00))));

        Assert.assertEquals(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_EVEN), itemPedidoService.getTotalItemSvc());

    }

}
