import Entity.Produto;
import Repository.ProdutoRepository;
import Service.ProdutoService;
import org.junit.Assert;
import org.junit.Test;
import Exception.CadastroInvalidoException;

public class TestProdutoService {

    @Test
    public void adicionaProdutos() throws CadastroInvalidoException {
        Produto produto = new Produto("001", "Bacon", 1.50);
        ProdutoService produtoService = new ProdutoService();

        produtoService.addProdutoSvc(produto);

        Assert.assertEquals(produto, produtoService.produtoList().get(0));
    }

    @Test(expected = CadastroInvalidoException.class)
    public void produtoComCodigoNulo() throws CadastroInvalidoException {
        Produto produto = new Produto();
        produto.setDescricao("Bacon");

        ProdutoService produtoService = new ProdutoService();
        produtoService.addProdutoSvc(produto);
    }

    @Test(expected = CadastroInvalidoException.class)
    public void produtoComDescricaoNula() throws CadastroInvalidoException {
        Produto produto = new Produto();
        produto.setCodigo("001");

        ProdutoService produtoService = new ProdutoService();
        produtoService.addProdutoSvc(produto);
    }

    @Test(expected = CadastroInvalidoException.class)
    public void produtoSemPreco() throws CadastroInvalidoException {
        Produto produto = new Produto();
        produto.setCodigo("001");
        produto.setDescricao("Bacon");

        ProdutoService produtoService = new ProdutoService();
        produtoService.addProdutoSvc(produto);
    }

    @Test(expected = CadastroInvalidoException.class)
    public void produtoComCodigoRepetido() throws CadastroInvalidoException {
        Produto produto1 = new Produto("001", "Bacon", 1.50);
        ProdutoService produtoService = new ProdutoService();
        produtoService.addProdutoSvc(produto1);

        Produto produto2 = new Produto("001", "Alface", 1.00);
        produtoService.addProdutoSvc(produto2);
    }
}
