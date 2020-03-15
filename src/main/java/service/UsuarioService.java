package service;

import cadastroexception.MotivoCadastroInvalido;
import entity.Usuario;
import cadastroexception.CadastroInvalidoException;
import repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    UsuarioRepository usuarioRepository = new UsuarioRepository();

    public void adicionaUsuarioSvc(Usuario usuario) throws CadastroInvalidoException {
        validaCadastroUsuario(usuario);
        usuarioRepository.addUsuario(usuario);
    }

    public Integer retonaTamanhoListaSvc() {
        if (usuarioRepository.retonaTamanhoLista() > 0) {
            return usuarioRepository.retonaTamanhoLista();
        } else {
            return 0;
        }
    }

    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(usuarioRepository.getListaUsuario());
        return usuarios;
    }

    public String retornaListaUsuariosSvc() {
        if (usuarioRepository.retonaTamanhoLista() > 0) {
            return usuarioRepository.retornaListaUsuarios();
        } else {
            return "Lista vazia!";
        }
    }

    public void removeUsuarioSvc(Usuario usuario) {
        usuarioRepository.removeUsuario(usuario);
    }

    public void validaCadastroUsuario(Usuario usuario) throws CadastroInvalidoException {
        if (usuario.getNome() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.USUARIO_NULO);
        } else if (usuario.getEmail() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.EMAIL_USUARIO_NULO);
        } else if (usuario.getEmail().contains("@email.com")) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.FORMATO_EMAIL_USUARIO_INCORRETO);
        } else {
            for (Usuario usuariosList : getUsuarios()) {
                if (usuario.getEmail() == usuariosList.getEmail()) {
                    throw new CadastroInvalidoException(MotivoCadastroInvalido.EMAIL_USUARIO_EXISTENTE);
                }
            }
        }
    }

}
