import cadastroexception.CadastroInvalidoException;
import entity.ItemPedido;
import entity.Produto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ItemPedidoService;
import service.ProdutoService;

public class TestItemPedidoService {

    private ProdutoService produtoService;
    private ItemPedidoService itemPedidoService;

    @Before
    public void setup() {
        produtoService = new ProdutoService();
        itemPedidoService = new ItemPedidoService();
    }

    private ItemPedido itemPedido(int quantidade, Produto produto) {
        return new ItemPedido(quantidade, produto);
    }

    @Test
    public void adicionarItensPedido() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.pao()));

        Assert.assertEquals(1, itemPedidoService.itemPedidoList().size());
    }

    @Test
    public void removerItensPedido() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.pao()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.hamburguer()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.queijo()));

        itemPedidoService.removeItemPedidoSvc(itemPedidoService.itemPedidoList().get(0));

        Assert.assertEquals(2, itemPedidoService.itemPedidoList().size());
    }

    @Test
    public void adicionarQuantidade() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.hamburguer()));
        itemPedidoService.addQuantidade(itemPedidoService.itemPedidoList().get(0), 4);

        Assert.assertEquals((Integer) 5, itemPedidoService.itemPedidoList().get(0).getQuantidade());
    }

    @Test
    public void removerQuantidade() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(5, produtoService.hamburguer()));
        itemPedidoService.removeQuantidade(itemPedidoService.itemPedidoList().get(0), 4);

        Assert.assertEquals((Integer) 1, itemPedidoService.itemPedidoList().get(0).getQuantidade());
    }

    @Test
    public void totalItem() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(5, produtoService.bacon()));

        Assert.assertEquals((Double) 10.0, itemPedidoService.getTotalItemSvc());
    }

}
