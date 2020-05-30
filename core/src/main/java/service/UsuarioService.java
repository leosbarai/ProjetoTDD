package service;

import cadastroexception.CadastroInvalidoException;
import entity.Usuario;
import repository.UsuarioRepository;
import service.validation.user.ValidacaoUsuarioService;

import java.util.List;

public class UsuarioService {

    UsuarioRepository usuarioRepository = new UsuarioRepository();

    public void adicionaUsuarioSvc(Usuario usuario) throws CadastroInvalidoException {
        ValidacaoUsuarioService validaCadastro = new ValidacaoUsuarioService();
        validaCadastro.validaUsuario(usuario);
        usuarioRepository.add(usuario);
    }

    public Integer retornaTamanhoListaSvc() {
        if (usuarioRepository.size() > 0) {
            return usuarioRepository.size();
        } else {
            return 0;
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public String retornaListaUsuariosSvc() {
        if (usuarioRepository.size() > 0) {
            return usuarioRepository.retornaListaUsuarios();
        } else {
            return "Lista vazia!";
        }
    }

    public void removeUsuarioSvc(Usuario usuario) {
        usuarioRepository.remove(usuario);
    }

}
