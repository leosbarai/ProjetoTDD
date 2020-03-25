package service.validation.user;

import cadastroexception.CadastroInvalidoException;
import entity.Usuario;

public interface ValidaUsuarioService {

    Usuario validaUsuario(Usuario usuario) throws CadastroInvalidoException;

    void setProximaValidacao(ValidaUsuarioService proxima);
}
