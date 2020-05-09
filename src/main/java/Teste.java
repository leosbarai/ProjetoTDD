import cadastroexception.CadastroInvalidoException;
import entity.*;
import service.ItemPedidoService;
import service.PedidoService;

import java.math.BigDecimal;

public class Teste {

    public static ItemPedido itemPedido(int quantidade, Produto produto) {
        return new ItemPedido(quantidade, produto);
    }

    public static void main(String[] args) throws CadastroInvalidoException {

        ItemPedidoService itemPedidoService;
        PedidoService pedidoService;
        Usuario usuario;
        Pedido pedido;

        itemPedidoService = new ItemPedidoService();
        pedidoService = new PedidoService();
        usuario = new Usuario("João", "joao@gmail.com");
        pedido = new Pedido(usuario);

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

        for (ItemPedido itemPedido: itemPedidoService.itemPedidoList()) {
            if(itemPedido.getProduto().getDescricao().equals("Alface")){
                //System.out.println("ACHOU!");
            }
        }

        Promocao promocao = new Promocao();

        System.out.println(promocao.isGordao(pedido));

    }
}
