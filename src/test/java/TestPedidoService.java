import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.ItemPedido;
import entity.Pedido;
import entity.Produto;
import entity.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ItemPedidoService;
import service.PedidoService;
import service.ProdutoService;

public class TestPedidoService {

    private ProdutoService produtoService;
    private ItemPedidoService itemPedidoService;
    private PedidoService pedidoService;
    private Usuario usuario;
    private Pedido pedido;

    @Before
    public void setup() {
        produtoService = new ProdutoService();
        itemPedidoService = new ItemPedidoService();
        pedidoService = new PedidoService();
        usuario = new Usuario("João", "joao@gmail.com");
        pedido = new Pedido(usuario);
    }

    private ItemPedido itemPedido(int quantidade, Produto produto) {
        return new ItemPedido(quantidade, produto);
    }

    @Test
    public void adicionaPedidoComUsuarioNulo() throws CadastroInvalidoException {
        Pedido pedido1 = new Pedido();

        try {
            pedidoService.adicionaPedido(pedido1);
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.USUARIO_NULO_PEDIDO, e.getMotivo());
        }

    }

    @Test
    public void adicionaPedidoSemItens() throws CadastroInvalidoException {

        try {
            pedidoService.adicionaPedido(pedido);
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.PEDIDO_SEM_ITENS, e.getMotivo());
        }

    }

    @Test
    public void adicionaPedido() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.pao()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.hamburguer()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.queijo()));
        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());
        pedidoService.adicionaPedido(pedido);

        Assert.assertEquals(1, pedidoService.pedidoList().size());
    }

    @Test
    public void calculaPrecoTotalItens() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.pao()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.hamburguer()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.queijo()));
        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());

        Assert.assertEquals(Double.valueOf(5.5), pedidoService.totalPedido(pedido));
    }

    @Test
    public void calculaDescontoPorQuantidadeDoItem() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.pao()));
        itemPedidoService.addItemPedidoSvc(itemPedido(5, produtoService.hamburguer()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.queijo()));
        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());

        Assert.assertEquals((Double) 16.0, pedidoService.totalPedido(pedido));
    }

    @Test
    public void calculaDescontoPorUnidades() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.pao()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.hamburguer()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.queijo()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.alface()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.bacon()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.ovo()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.maionese()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.mostarda()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.catchup()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.azeitona()));

        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());

        Assert.assertEquals((Double) 10.16, pedidoService.totalPedido(pedido));
    }


    @Test
    public void calculaDescontoPorQuantidadesEUnidades() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.pao()));
        itemPedidoService.addItemPedidoSvc(itemPedido(6, produtoService.hamburguer()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.queijo()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.alface()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.bacon()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.ovo()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.maionese()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.mostarda()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.catchup()));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, produtoService.azeitona()));

        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());

        Assert.assertEquals((Double) 23.52, pedidoService.totalPedido(pedido));
    }

}
