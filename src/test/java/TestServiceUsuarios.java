import entity.Usuario;
import cadastroexception.CadastroInvalidoException;
import service.UsuarioService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestServiceUsuarios {

    @Test
    public void insercaoUsuariosSemRestricao() throws CadastroInvalidoException {
        Usuario usuario = new Usuario("Leonardo", "leonardo@gmail.com");
        UsuarioService usuarioService = new UsuarioService();
        usuarioService.adicionaUsuarioSvc(usuario);

        Assert.assertEquals(usuario, usuarioService.getUsuarios().get(0));
    }

    @Test(expected = CadastroInvalidoException.class)
    public void usuarioComNomeNulo() throws CadastroInvalidoException {
        Usuario usuario = new Usuario();
        UsuarioService usuarioService = new UsuarioService();

        usuarioService.adicionaUsuarioSvc(usuario);
    }

    @Test(expected = CadastroInvalidoException.class)
    public void usuarioComEmailNulo() throws CadastroInvalidoException {
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        UsuarioService usuarioService = new UsuarioService();

        usuarioService.adicionaUsuarioSvc(usuario);
    }

    @Test(expected = CadastroInvalidoException.class)
    public void usuarioComEmailRepetido() throws CadastroInvalidoException {
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setEmail("joao@email.com");
        UsuarioService usuarioService = new UsuarioService();

        usuarioService.adicionaUsuarioSvc(usuario);
    }

    @Test
    public void remocaoUsuarios() throws CadastroInvalidoException {
        Usuario usuario1 = new Usuario("Leonardo", "leonardo@gmail.com");
        Usuario usuario2 = new Usuario("João", "joao@gmail.com");
        UsuarioService usuarioService = new UsuarioService();

        usuarioService.adicionaUsuarioSvc(usuario1);
        usuarioService.adicionaUsuarioSvc(usuario2);
        usuarioService.removeUsuarioSvc(usuario1);

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario2);

        Assert.assertEquals(1, usuarioService.retonaTamanhoListaSvc().intValue());
        Assert.assertEquals(usuarios, usuarioService.getUsuarios());
    }
}
