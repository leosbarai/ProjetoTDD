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

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestPedidoService {

    private ItemPedidoService itemPedidoService;
    private PedidoService pedidoService;
    private Usuario usuario;
    private Pedido pedido;

    @Before
    public void setup() {
        itemPedidoService = new ItemPedidoService();
        pedidoService = new PedidoService();
        usuario = new Usuario("João", "joao@gmail.com");
        pedido = new Pedido(usuario);
    }

    private ItemPedido itemPedido(int quantidade, Produto produto) {
        return new ItemPedido(quantidade, produto);
    }

    @Test
    public void adicionaPedidoComUsuarioNulo() {
        Pedido pedido1 = new Pedido();

        try {
            pedidoService.adicionaPedido(pedido1);
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.USUARIO_NULO_PEDIDO, e.getMotivo());
        }

    }

    @Test
    public void adicionaPedidoSemItens() {

        try {
            pedidoService.adicionaPedido(pedido);
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.PEDIDO_SEM_ITENS, e.getMotivo());
        }

    }

    @Test
    public void adicionaPedido() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("006", "Pão", new BigDecimal(1.0))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("003", "Hamburguer de carne", new BigDecimal(3.00))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("005", "Queijo", new BigDecimal(1.50))));
        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());
        pedidoService.adicionaPedido(pedido);

        Assert.assertEquals(1, pedidoService.pedidoList().size());
    }

    @Test
    public void calculaPrecoTotalItens() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("006", "Pão", new BigDecimal(1.0))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("003", "Hamburguer de carne", new BigDecimal(3.00))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("005", "Queijo", new BigDecimal(1.50))));
        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());

        Assert.assertEquals(new BigDecimal(5.5).setScale(2, RoundingMode.HALF_EVEN), pedidoService.totalPedido(pedido));
    }

    @Test
    public void calculaDescontoPorQuantidadeDoItem() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("006", "Pão", new BigDecimal(1.0))));
        itemPedidoService.addItemPedidoSvc(itemPedido(5, new Produto("003", "Hamburguer de carne", new BigDecimal(3.00))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("005", "Queijo", new BigDecimal(1.50))));
        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());

        Assert.assertEquals(new BigDecimal(16.00).setScale(2, RoundingMode.HALF_EVEN), pedidoService.totalPedido(pedido));
    }

    @Test
    public void calculaDescontoPorUnidades() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("006", "Pão", new BigDecimal(1.0))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("003", "Hamburguer de carne", new BigDecimal(3.00))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("005", "Queijo", new BigDecimal(1.50))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("001", "Alface", new BigDecimal(0.40))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("002", "Bacon", new BigDecimal(2.00))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("004", "Ovo", new BigDecimal(0.80))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("007", "Maionese", new BigDecimal(0.50))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("008", "Mostarda", new BigDecimal(0.50))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("009", "Catchup", new BigDecimal(0.50))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("010", "Azeitona", new BigDecimal(0.50))));

        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());

        Assert.assertEquals(new BigDecimal(10.16).setScale(2, RoundingMode.HALF_EVEN), pedidoService.totalPedido(pedido));
    }


    @Test
    public void calculaDescontoPorQuantidadesEUnidades() throws CadastroInvalidoException {

        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("006", "Pão", new BigDecimal(1.0))));
        itemPedidoService.addItemPedidoSvc(itemPedido(6, new Produto("003", "Hamburguer de carne", new BigDecimal(3.00))));
        itemPedidoService.addItemPedidoSvc(itemPedido(2, new Produto("005", "Queijo", new BigDecimal(1.50))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("001", "Alface", new BigDecimal(0.40))));
        itemPedidoService.addItemPedidoSvc(itemPedido(2, new Produto("002", "Bacon", new BigDecimal(2.00))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("004", "Ovo", new BigDecimal(0.80))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("007", "Maionese", new BigDecimal(0.50))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("008", "Mostarda", new BigDecimal(0.50))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("009", "Catchup", new BigDecimal(0.50))));
        itemPedidoService.addItemPedidoSvc(itemPedido(1, new Produto("010", "Azeitona", new BigDecimal(0.50))));

        pedido.setItemPedidoList(itemPedidoService.itemPedidoList());

        Assert.assertEquals(new BigDecimal(25.94).setScale(2, RoundingMode.HALF_EVEN), pedidoService.totalPedido(pedido));
    }

}
