package service.validation.user;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Usuario;

public class ValidaUsuarioNulo implements ValidaUsuarioService {

    private ValidaUsuarioService proxima;

    @Override
    public Usuario validaUsuario(Usuario usuario) throws CadastroInvalidoException {

        if (usuario.getNome() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.USUARIO_NULO);
        } else {
            return proxima.validaUsuario(usuario);
        }
    }

    @Override
    public void setProximaValidacao(ValidaUsuarioService proxima) {
        this.proxima = proxima;
    }
}
