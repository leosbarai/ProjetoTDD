package service;

import cadastroexception.CadastroInvalidoException;
import entity.Usuario;
import repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    UsuarioRepository usuarioRepository = new UsuarioRepository();

    public void adicionaUsuarioSvc(Usuario usuario) throws CadastroInvalidoException {
        ValidaUsuarioService validaCadastro = new ValidaUsuarioService();
        validaCadastro.validaCadastroUsuario(usuario);
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
        return usuarioRepository.getListaUsuario();
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
