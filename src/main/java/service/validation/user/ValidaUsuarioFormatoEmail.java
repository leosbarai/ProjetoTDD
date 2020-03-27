package service.validation.user;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Usuario;
import service.validation.ValidaCadastrosService;

public class ValidaUsuarioFormatoEmail implements ValidaCadastrosService<Usuario> {

    private ValidaCadastrosService<Usuario> proxima;

    @Override
    public Usuario validaCadastros(Usuario usuario) throws CadastroInvalidoException {

        if (usuario.getEmail().contains("@email.com")) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.FORMATO_EMAIL_USUARIO_INCORRETO);
        } else {
            return proxima.validaCadastros(usuario);
        }

    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<Usuario> proxima) {
        this.proxima = proxima;
    }
}
