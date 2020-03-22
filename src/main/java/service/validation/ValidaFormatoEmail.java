package service.validation;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Usuario;

public class ValidaFormatoEmail implements ValidaUsuarioService {

    private ValidaUsuarioService proxima;

    @Override
    public Usuario validaUsuario(Usuario usuario) throws CadastroInvalidoException {

        if (usuario.getEmail().contains("@email.com")) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.FORMATO_EMAIL_USUARIO_INCORRETO);
        } else {
            return proxima.validaUsuario(usuario);
        }

    }

    @Override
    public void setProximaValidacao(ValidaUsuarioService proxima) {
        this.proxima = proxima;
    }
}
