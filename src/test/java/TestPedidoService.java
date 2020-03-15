import Entity.ItemPedido;
import Entity.Pedido;
import Entity.Produto;
import Entity.Usuario;
import cadastroexception.CadastroInvalidoException;
import Service.ItemPedidoService;
import Service.PedidoService;
import Service.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPedidoService {

    private ProdutoService produtoService;

    @Before
    public void setup() {
        produtoService = new ProdutoService();
    }

    @Test
    public void calculaPrecoTotalItens() throws CadastroInvalidoException {
        Usuario usuario = new Usuario("João", "joao@gmail.com");
        PedidoService pedidoService = new PedidoService();

        ItemPedidoService itemPedidoService = new ItemPedidoService();
        ItemPedido pao = new ItemPedido(1, produtoService.alface());
        itemPedidoService.addItemPedidoSvc(pao);

        ItemPedido hamburguer = new ItemPedido(1, produtoService.mockList().get(2));
        itemPedidoService.addItemPedidoSvc(hamburguer);

        ItemPedido queijo = new ItemPedido(1, produtoService.mockList().get(4));
        itemPedidoService.addItemPedidoSvc(queijo);

        Pedido pedido = new Pedido(usuario);
        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());

        Assert.assertEquals(Double.valueOf(5.5), pedidoService.totalPedido(pedido));
    }

    @Test
    public void calculaDescontoPorQuantidadeDoItem() throws CadastroInvalidoException {
        Usuario usuario = new Usuario("João", "joao@gmail.com");
        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService();

        ItemPedidoService itemPedidoService = new ItemPedidoService();
        ItemPedido pao = new ItemPedido(1, produtoService.mockList().get(5));
        itemPedidoService.addItemPedidoSvc(pao);

        ItemPedido hamburguer = new ItemPedido(5, produtoService.mockList().get(2));
        itemPedidoService.addItemPedidoSvc(hamburguer);

        ItemPedido queijo = new ItemPedido(1, produtoService.mockList().get(4));
        itemPedidoService.addItemPedidoSvc(queijo);

        Pedido pedido = new Pedido(usuario);
        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());

        Assert.assertEquals((Object) 16.0, pedidoService.totalPedido(pedido));
    }

    @Test
    public void calculaDescontoPorUnidades() throws CadastroInvalidoException {
        Usuario usuario = new Usuario("João", "joao@gmail.com");
        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService();

        ItemPedidoService itemPedidoService = new ItemPedidoService();
        ItemPedido pao = new ItemPedido(1, produtoService.mockList().get(5));
        itemPedidoService.addItemPedidoSvc(pao);

        ItemPedido hamburguer = new ItemPedido(1, produtoService.mockList().get(2));
        itemPedidoService.addItemPedidoSvc(hamburguer);

        ItemPedido queijo = new ItemPedido(1, produtoService.mockList().get(4));
        itemPedidoService.addItemPedidoSvc(queijo);

        ItemPedido alface = new ItemPedido(1, produtoService.mockList().get(0));
        itemPedidoService.addItemPedidoSvc(alface);

        ItemPedido bacon = new ItemPedido(1, produtoService.mockList().get(1));
        itemPedidoService.addItemPedidoSvc(bacon);

        ItemPedido ovo = new ItemPedido(1, produtoService.mockList().get(3));
        itemPedidoService.addItemPedidoSvc(ovo);

        ItemPedido maionese = new ItemPedido(1, produtoService.mockList().get(6));
        itemPedidoService.addItemPedidoSvc(maionese);

        ItemPedido mostarda = new ItemPedido(1, produtoService.mockList().get(7));
        itemPedidoService.addItemPedidoSvc(mostarda);

        ItemPedido catchup = new ItemPedido(1, produtoService.mockList().get(8));
        itemPedidoService.addItemPedidoSvc(catchup);

        ItemPedido azeitona = pedido(1, produtoService.alface());
        itemPedidoService.addItemPedidoSvc(azeitona);

        Pedido pedido = new Pedido(usuario);
        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());

        Assert.assertEquals((Object) 10.16, pedidoService.totalPedido(pedido));
    }

    private ItemPedido pedido(int quantidade, Produto produto) {
        return new ItemPedido(quantidade, produto);
    }

    @Test
    public void calculaDescontoPorQuantidadesEUnidades() throws CadastroInvalidoException {
        Usuario usuario = new Usuario("João", "joao@gmail.com");
        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService();

        ItemPedidoService itemPedidoService = new ItemPedidoService();
        ItemPedido pao = new ItemPedido(1, produtoService.mockList().get(5));
        itemPedidoService.addItemPedidoSvc(pao);

        ItemPedido hamburguer = new ItemPedido(6, produtoService.mockList().get(2));
        itemPedidoService.addItemPedidoSvc(hamburguer);

        ItemPedido queijo = new ItemPedido(1, produtoService.mockList().get(4));
        itemPedidoService.addItemPedidoSvc(queijo);

        ItemPedido alface = new ItemPedido(1, produtoService.mockList().get(0));
        itemPedidoService.addItemPedidoSvc(alface);

        ItemPedido bacon = new ItemPedido(1, produtoService.mockList().get(1));
        itemPedidoService.addItemPedidoSvc(bacon);

        ItemPedido ovo = new ItemPedido(1, produtoService.mockList().get(3));
        itemPedidoService.addItemPedidoSvc(ovo);

        ItemPedido maionese = new ItemPedido(1, produtoService.mockList().get(6));
        itemPedidoService.addItemPedidoSvc(maionese);

        ItemPedido mostarda = new ItemPedido(1, produtoService.mockList().get(7));
        itemPedidoService.addItemPedidoSvc(mostarda);

        ItemPedido catchup = new ItemPedido(1, produtoService.mockList().get(8));
        itemPedidoService.addItemPedidoSvc(catchup);

        ItemPedido azeitona = new ItemPedido(1, produtoService.mockList().get(9));
        itemPedidoService.addItemPedidoSvc(azeitona);

        Pedido pedido = new Pedido(usuario);
        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());

        Assert.assertEquals((Object) 23.52, pedidoService.totalPedido(pedido));
    }

}
