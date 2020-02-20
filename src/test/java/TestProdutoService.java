import org.junit.Test;
import Exception.CadastroInvalidoException;

public class TestProdutoService {

    @Test
    public void adicionaProdutos() {
    }

    @Test(expected = CadastroInvalidoException.class)
    public void produtoComCodigoNulo() throws CadastroInvalidoException {

    }

    @Test(expected = CadastroInvalidoException.class)
    public void produtoComDescricaoNula() throws CadastroInvalidoException {

    }

    @Test(expected = CadastroInvalidoException.class)
    public void produtoSemPreco() throws CadastroInvalidoException {

    }

    @Test(expected = CadastroInvalidoException.class)
    public void produtoComCodigoRepetido() throws CadastroInvalidoException {

    }
}
