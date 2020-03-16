import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.UsuarioService;

public class TestServiceUsuarios {

    private UsuarioService usuarioService;
    private Usuario usuario;

    @Before
    public void setup() {
        usuarioService = new UsuarioService();
        usuario = new Usuario();
    }

    private Usuario addUsuario(String nome, String email) {
        return new Usuario(nome, email);
    }

    @Test
    public void insercaoUsuariosSemRestricao() throws CadastroInvalidoException {
        usuario = addUsuario("Leonardo", "leonardo@gmail.com");
        usuarioService.adicionaUsuarioSvc(usuario);

        Assert.assertEquals(usuario, usuarioService.getUsuarios().get(0));
    }

    @Test
    public void usuarioComNomeNulo() throws CadastroInvalidoException {

        try {
            usuarioService.adicionaUsuarioSvc(usuario);
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.USUARIO_NULO, e.getMotivo());
        }
    }

    @Test
    public void usuarioComEmailNulo() throws CadastroInvalidoException {
        usuario.setNome("João");

        try {
            usuarioService.adicionaUsuarioSvc(usuario);
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.EMAIL_USUARIO_NULO, e.getMotivo());
        }
    }

    @Test
    public void usuarioComEmailRepetido() throws CadastroInvalidoException {
        usuario.setNome("Leonardo");
        usuario.setEmail("leonardo@gmail.com");

        try {
            usuarioService.adicionaUsuarioSvc(usuario);
        } catch (CadastroInvalidoException e) {
            Assert.assertEquals(MotivoCadastroInvalido.EMAIL_USUARIO_EXISTENTE, e.getMotivo());
        }

    }

    @Test
    public void remocaoUsuarios() throws CadastroInvalidoException {

        usuarioService.adicionaUsuarioSvc(addUsuario("Leonardo", "leonardo@gmail.com"));
        usuarioService.adicionaUsuarioSvc(addUsuario("João", "joao@gmail.com"));
        usuarioService.removeUsuarioSvc(usuarioService.getUsuarios().get(1));

        Assert.assertEquals(1, usuarioService.retonaTamanhoListaSvc().intValue());
    }
}
