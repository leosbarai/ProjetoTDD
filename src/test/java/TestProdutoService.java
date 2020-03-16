import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Produto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ProdutoService;

public class TestProdutoService {

    private ProdutoService produtoService;
    private Produto produto;

    @Before
    public void setup() {
        produtoService = new ProdutoService();
        produto = new Produto();
    }

    private Produto produto(String codigo, String descricao, Double preco) {
        return new Produto(codigo, descricao, preco);
    }

    @Test
    public void adicionaProdutos() throws CadastroInvalidoException {

        produtoService.addProdutoSvc(produto("001", "Bacon", 1.50));

        Assert.assertEquals(produtoService.produtoList().get(0).getDescricao(), produtoService.bacon().getDescricao());
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
    public void produtoComDescricaoNula() throws CadastroInvalidoException {

        produto.setCodigo("001");

        try {
            produtoService.addProdutoSvc(produto);
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.DESCRICAO_PRODUTO_NULA, e.getMotivo());
        }

    }

    @Test
    public void produtoSemPreco() throws CadastroInvalidoException {

        produto.setCodigo("001");
        produto.setDescricao("Bacon");

        try {
            produtoService.addProdutoSvc(produto);
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.PRODUTO_SEM_PRECO, e.getMotivo());
        }

    }

    @Test
    public void produtoComCodigoRepetido() throws CadastroInvalidoException {

        try {
            produtoService.addProdutoSvc(produto("001", "Bacon", 1.50));
            produtoService.addProdutoSvc(produto("001", "Alface", 1.00));
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.PRODUTO_EXISTENTE, e.getMotivo());
        }
    }
}
