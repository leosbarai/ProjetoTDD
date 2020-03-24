package service.validation;

import cadastroexception.CadastroInvalidoException;
import entity.Usuario;

public class ValidacaoUsuarioService {

    public void validaUsuario(Usuario usuario) throws CadastroInvalidoException {

        ValidaUsuarioService usuarioNulo = new ValidaUsuarioNulo();
        ValidaUsuarioService emailNulo = new ValidaUsuarioEmailNulo();
        ValidaUsuarioService formatoEmail = new ValidaUsuarioFormatoEmail();
        ValidaUsuarioService emailExistente = new ValidaUsuarioEmailExistente();
        ValidaUsuarioService usuarioValido = new UsuarioValido();

        usuarioNulo.setProximaValidacao(emailNulo);
        emailNulo.setProximaValidacao(formatoEmail);
        formatoEmail.setProximaValidacao(emailExistente);
        emailExistente.setProximaValidacao(usuarioValido);
        usuarioNulo.validaUsuario(usuario);
    }

}
