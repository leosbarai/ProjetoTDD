package service.validation.user;

import cadastroexception.CadastroInvalidoException;
import entity.Usuario;

public class UsuarioValido implements ValidaUsuarioService {

    @Override
    public Usuario validaUsuario(Usuario usuario) throws CadastroInvalidoException {
        return usuario;
    }

    @Override
    public void setProximaValidacao(ValidaUsuarioService proxima) {
        // Fim da cadeia
    }
}
