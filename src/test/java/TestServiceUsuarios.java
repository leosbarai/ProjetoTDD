import Entity.Usuario;
import Exception.CadastroInvalidoException;
import Service.UsuarioService;
import org.junit.Assert;
import org.junit.Test;

public class TestServiceUsuarios {

    @Test
    public void insercaoUsuariosSemRestricao() {
        Usuario usuario = new Usuario("Leonardo", "leonardo@gmail.com");
        UsuarioService usuarioService = new UsuarioService();
        usuarioService.adicionaUsuarioSvc(usuario);

        Assert.assertEquals(usuario.toString(), usuarioService.retornaListaUsuariosSvc());
    }

    @Test(expected = CadastroInvalidoException.class)
    public void usuarioComNomeNulo() {
        Usuario usuario = new Usuario();
        UsuarioService usuarioService = new UsuarioService();

        usuarioService.adicionaUsuarioSvc(usuario);
    }

    @Test(expected = CadastroInvalidoException.class)
    public void usuarioComEmailNulo() {
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        UsuarioService usuarioService = new UsuarioService();

        usuarioService.adicionaUsuarioSvc(usuario);
    }

    @Test(expected = CadastroInvalidoException.class)
    public void usuarioComEmailRepetido() {
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setEmail("joao@email.com");
        UsuarioService usuarioService = new UsuarioService();

        usuarioService.adicionaUsuarioSvc(usuario);
    }

    @Test
    public void remocaoUsuarios() {
        Usuario usuario1 = new Usuario("Leonardo", "leonardo@gmail.com");
        Usuario usuario2 = new Usuario("João", "joao@gmail.com");
        UsuarioService usuarioService = new UsuarioService();

        usuarioService.adicionaUsuarioSvc(usuario1);
        usuarioService.adicionaUsuarioSvc(usuario2);
        usuarioService.removeUsuarioSvc(usuario1);

        Assert.assertEquals(1, usuarioService.retonaTamanhoListaSvc().intValue());
        Assert.assertEquals(usuario2.toString(), usuarioService.retornaListaUsuariosSvc());
    }
}
