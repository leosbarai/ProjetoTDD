package service.validation.user;

import cadastroexception.CadastroInvalidoException;
import entity.Usuario;
import service.validation.ValidaCadastrosService;

public class ValidacaoUsuarioService {

    public void validaUsuario(Usuario usuario) throws CadastroInvalidoException {

        ValidaCadastrosService usuarioNulo = new ValidaUsuarioNulo();
        ValidaCadastrosService emailNulo = new ValidaUsuarioEmailNulo();
        ValidaCadastrosService formatoEmail = new ValidaUsuarioFormatoEmail();
        ValidaCadastrosService emailExistente = new ValidaUsuarioEmailExistente();
        ValidaCadastrosService usuarioValido = new UsuarioValido();

        usuarioNulo.setProximaValidacao(emailNulo);
        emailNulo.setProximaValidacao(formatoEmail);
        formatoEmail.setProximaValidacao(emailExistente);
        emailExistente.setProximaValidacao(usuarioValido);
        usuarioNulo.validaCadastros(usuario);
    }

}
