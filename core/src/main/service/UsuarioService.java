package main.service;

import main.cadastroexception.CadastroInvalidoException;
import main.entity.Usuario;
import main.repository.UsuarioRepository;
import main.service.validation.user.ValidacaoUsuarioService;

import java.util.List;

public class UsuarioService {

    UsuarioRepository usuarioRepository = new UsuarioRepository();

    public void adicionaUsuarioSvc(Usuario usuario) throws CadastroInvalidoException {
        ValidacaoUsuarioService validaCadastro = new ValidacaoUsuarioService();
        validaCadastro.validaUsuario(usuario);
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