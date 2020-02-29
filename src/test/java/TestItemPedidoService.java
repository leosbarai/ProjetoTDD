import Entity.ItemPedido;
import Exception.CadastroInvalidoException;
import Service.ItemPedidoService;
import Service.ProdutoService;
import org.junit.Assert;
import org.junit.Test;

public class TestItemPedidoService {

    @Test
    public void adicionarItensPedido() throws CadastroInvalidoException {
        ProdutoService produtoService = new ProdutoService();
        ItemPedido itemPedido = new ItemPedido(1, produtoService.mockList().get(0));

        ItemPedidoService itemPedidoService = new ItemPedidoService();
        itemPedidoService.addItemPedidoSvc(itemPedido);

        Assert.assertEquals(1, itemPedidoService.itemPedidoList().size());
    }

    @Test
    public void removerItensPedido() throws CadastroInvalidoException {
        ProdutoService produtoService = new ProdutoService();
        ItemPedido itemPedido1 = new ItemPedido(1, produtoService.mockList().get(0));
        ItemPedido itemPedido2 = new ItemPedido(1, produtoService.mockList().get(1));
        ItemPedido itemPedido3 = new ItemPedido(1, produtoService.mockList().get(2));

        ItemPedidoService itemPedidoService = new ItemPedidoService();
        itemPedidoService.addItemPedidoSvc(itemPedido1);
        itemPedidoService.addItemPedidoSvc(itemPedido2);
        itemPedidoService.addItemPedidoSvc(itemPedido3);

        itemPedidoService.removeItemPedidoSvc(itemPedido2);

        Assert.assertEquals(2, itemPedidoService.itemPedidoList().size());
    }

    @Test
    public void adicionarQuantidade() throws CadastroInvalidoException {
        ProdutoService produtoService = new ProdutoService();
        ItemPedido itemPedido = new ItemPedido(1, produtoService.mockList().get(1));

        ItemPedidoService itemPedidoService = new ItemPedidoService();
        itemPedidoService.addItemPedidoSvc(itemPedido);

        itemPedidoService.addQuantidade(itemPedido, 4);

        Assert.assertEquals((Object) 5, itemPedidoService.itemPedidoList().get(0).getQuantidade());
    }

    @Test
    public void removerQuantidade() throws CadastroInvalidoException {
        ProdutoService produtoService = new ProdutoService();
        ItemPedido itemPedido = new ItemPedido(5, produtoService.mockList().get(1));

        ItemPedidoService itemPedidoService = new ItemPedidoService();
        itemPedidoService.addItemPedidoSvc(itemPedido);

        itemPedidoService.removeQuantidade(itemPedido, 4);

        Assert.assertEquals((Object) 1, itemPedidoService.itemPedidoList().get(0).getQuantidade());
    }

    @Test
    public void totalItem() throws CadastroInvalidoException {
        ProdutoService produtoService = new ProdutoService();
        ItemPedido itemPedido = new ItemPedido(5, produtoService.mockList().get(1));

        ItemPedidoService itemPedidoService = new ItemPedidoService();
        itemPedidoService.addItemPedidoSvc(itemPedido);

        Assert.assertEquals((Object) 10.0, itemPedidoService.getTotalItemSvc());
    }

}
