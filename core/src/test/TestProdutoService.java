package test;

import main.cadastroexception.CadastroInvalidoException;
import main.cadastroexception.MotivoCadastroInvalido;
import main.entity.Produto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import main.service.ProdutoService;

import java.math.BigDecimal;

public class TestProdutoService {

    private ProdutoService produtoService;
    private Produto produto;

    @Before
    public void setup() {
        produtoService = new ProdutoService();
        produto = new Produto();
    }

    private Produto produto(String codigo, String descricao, BigDecimal preco) {
        return new Produto(codigo, descricao, preco);
    }

    @Test
    public void adicionaProdutos() throws CadastroInvalidoException {

        produtoService.addProdutoSvc(produto("001", "Bacon", new BigDecimal(1.50)));

        Assert.assertEquals(produtoService.produtoList().get(0).getDescricao(), new Produto("002", "Bacon", new BigDecimal(2.00)).getDescricao());
    }

    @Test
    public void produtoComCodigoNulo() throws CadastroInvalidoException {

        produto.setDescricao("Bacon");

        try {
            produtoService.addProdutoSvc(produto);
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.CODIGO_PRODUTO_NULO, e.getMotivo());
        }
    }

    @Test
    public void produtoComDescricaoNula() {

        produto.setCodigo("001");

        try {
            produtoService.addProdutoSvc(produto);
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.DESCRICAO_PRODUTO_NULA, e.getMotivo());
        }

    }

    @Test
    public void produtoSemPreco() {

        produto.setCodigo("001");
        produto.setDescricao("Bacon");

        try {
            produtoService.addProdutoSvc(produto);
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.PRODUTO_SEM_PRECO, e.getMotivo());
        }

    }

    @Test
    public void produtoComCodigoRepetido() {

        try {
            produtoService.addProdutoSvc(produto("001", "Bacon", new BigDecimal(1.50)));
            produtoService.addProdutoSvc(produto("001", "Alface", new BigDecimal(1.00)));
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.PRODUTO_EXISTENTE, e.getMotivo());
        }
    }
}
