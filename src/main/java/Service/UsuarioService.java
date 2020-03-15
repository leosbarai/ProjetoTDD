package Service;

import Entity.Usuario;
import cadastroexception.CadastroInvalidoException;
import Repository.UsuarioRepository;

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
            throw new CadastroInvalidoException("Nome do usuário não pode ser nulo!");
        } else if (usuario.getEmail() == null) {
            throw new CadastroInvalidoException("E-mail do usuário não pode ser nulo!");
        } else if (usuario.getEmail().contains("@email.com")) {
            throw new CadastroInvalidoException("Formato de e-mail incorreto!");
        } else {
            for (Usuario x : getUsuarios()) {
                if (usuario.getEmail() == x.getEmail()) {
                    throw new CadastroInvalidoException("E-mail já cadastrado para outro usuário!");
                }
            }
        }
    }

}
