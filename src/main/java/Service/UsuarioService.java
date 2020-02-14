package Service;

import Entity.Usuario;
import Repository.UsuarioRepository;

public class UsuarioService {

    UsuarioRepository usuarioRepository = new UsuarioRepository();

    public void adicionaUsuarioSvc(Usuario usuario) {
        if (usuario.getNome() == null) {
            System.out.println("Nome nulo");
        } else if (usuario.getEmail() == null) {
            System.out.println("Email nulo");
        } else {
            usuarioRepository.addUsuario(usuario);
        }
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

}
