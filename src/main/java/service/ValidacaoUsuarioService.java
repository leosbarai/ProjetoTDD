package service;

import cadastroexception.CadastroInvalidoException;
import entity.Usuario;
import service.validation.ValidaUsuarioService;
import service.validation.*;

public class ValidacaoUsuarioService {

    public void validaUsuario(Usuario usuario) throws CadastroInvalidoException {

        ValidaUsuarioService usuarioNulo = new ValidaUsuarioNulo();
        ValidaUsuarioService emailNulo = new ValidaUsuarioEmailNulo();
        ValidaUsuarioService formatoEmail = new ValidaFormatoEmail();
        ValidaUsuarioService emailExistente = new ValidaUsuarioEmailExistente();
        ValidaUsuarioService usuarioValido = new UsuarioValidado();

        usuarioNulo.setProximaValidacao(emailNulo);
        emailNulo.setProximaValidacao(formatoEmail);
        formatoEmail.setProximaValidacao(emailExistente);
        emailExistente.setProximaValidacao(usuarioValido);
        usuarioNulo.validaUsuario(usuario);
    }

}
