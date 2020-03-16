import entity.Usuario;
import cadastroexception.CadastroInvalidoException;
import org.junit.Before;
import service.UsuarioService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestServiceUsuarios {

    private UsuarioService usuarioService;
    private Usuario usuario;

    @Before
    public void setup(){
        usuarioService = new UsuarioService();
        usuario = new Usuario();
    }

    private Usuario addUsuario(String nome, String email){
        return new Usuario(nome, email);
    }

    @Test
    public void insercaoUsuariosSemRestricao() throws CadastroInvalidoException {
        usuario = addUsuario("Leonardo", "leonardo@gmail.com");
        usuarioService.adicionaUsuarioSvc(usuario);

        Assert.assertEquals(usuario, usuarioService.getUsuarios().get(0));
    }

    @Test(expected = CadastroInvalidoException.class)
    public void usuarioComNomeNulo() throws CadastroInvalidoException {
        usuarioService.adicionaUsuarioSvc(usuario);
    }

    @Test(expected = CadastroInvalidoException.class)
    public void usuarioComEmailNulo() throws CadastroInvalidoException {
        usuario.setNome("João");
        usuarioService.adicionaUsuarioSvc(usuario);
    }

    @Test(expected = CadastroInvalidoException.class)
    public void usuarioComEmailRepetido() throws CadastroInvalidoException {
        usuario.setNome("João");
        usuario.setEmail("joao@email.com");

        usuarioService.adicionaUsuarioSvc(usuario);
    }

    @Test
    public void remocaoUsuarios() throws CadastroInvalidoException {
        Usuario usuario1 = addUsuario("Leonardo", "leonardo@gmail.com");
        Usuario usuario2 = addUsuario("João", "joao@gmail.com");

        usuarioService.adicionaUsuarioSvc(usuario1);
        usuarioService.adicionaUsuarioSvc(usuario2);
        usuarioService.removeUsuarioSvc(usuario1);

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario2);

        Assert.assertEquals(1, usuarioService.retonaTamanhoListaSvc().intValue());
        Assert.assertEquals(usuarios, usuarioService.getUsuarios());
    }
}
