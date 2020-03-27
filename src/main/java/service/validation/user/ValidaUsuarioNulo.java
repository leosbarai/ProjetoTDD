package service.validation.user;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Usuario;
import service.validation.ValidaCadastrosService;

public class ValidaUsuarioNulo implements ValidaCadastrosService<Usuario> {

    private ValidaCadastrosService<Usuario> proxima;

    @Override
    public Usuario validaCadastros(Usuario usuario) throws CadastroInvalidoException {

        if (usuario.getNome() == null) {
            throw new CadastroInvalidoException(MotivoCadastroInvalido.USUARIO_NULO);
        } else {
            return proxima.validaCadastros(usuario);
        }
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<Usuario> proxima) {
        this.proxima = proxima;
    }
}
