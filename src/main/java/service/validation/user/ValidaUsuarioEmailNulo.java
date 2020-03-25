package service.validation.user;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Usuario;

public class ValidaUsuarioEmailNulo implements ValidaUsuarioService {

    private ValidaUsuarioService proxima;

    @Override
    public Usuario validaUsuario(Usuario usuario) throws CadastroInvalidoException {

        if (usuario.getEmail() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.EMAIL_USUARIO_NULO);
        } else {
            return proxima.validaUsuario(usuario);
        }
    }

    @Override
    public void setProximaValidacao(ValidaUsuarioService proxima) {
        this.proxima = proxima;
    }
}
