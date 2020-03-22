package service.validation;

import cadastroexception.CadastroInvalidoException;
import entity.Usuario;

public interface ValidaUsuarioService {

    Usuario validaUsuario(Usuario usuario) throws CadastroInvalidoException;

    void setProximaValidacao(ValidaUsuarioService proxima);
}
