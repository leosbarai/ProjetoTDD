package Service;

import Entity.Usuario;
import Repository.UsuarioRepository;

public class UsuarioService {

    UsuarioRepository usuarioRepository = new UsuarioRepository();

    public void adicionaUsuarioSvc(Usuario usuario) {
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

    public void validaCadastroUsuario(Usuario usuario) {
        if (usuario.getNome() == null) {
            throw new IllegalArgumentException("Nome do usuário não pode ser nulo!");
        } else if (usuario.getEmail() == null) {
            throw new IllegalArgumentException("E-mail do usuário não pode ser nulo!");
        } else if (usuario.getEmail().contains("@email.com")) {
            throw new IllegalArgumentException("Formato de e-mail incorreto!");
        }
    }
}
