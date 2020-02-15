import org.junit.Test;
import Exception.CadastroInvalidoException;

public class TestServiceUsuarios {


    public void insercaoUsuariosSemRestricao() {

    }

    @Test(expected = CadastroInvalidoException.class)
    public void usuarioComNomeNulo() {

    }

    @Test(expected = CadastroInvalidoException.class)
    public void usuarioComEmailNulo() {

    }

    @Test(expected = CadastroInvalidoException.class)
    public void usuarioComEmailRepetido() {

    }

    @Test
    public void remocaoUsuarios() {
        
    }
}
