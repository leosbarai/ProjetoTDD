package service.validation;

import cadastroexception.CadastroInvalidoException;
import entity.Usuario;

public interface ValidaItemPedidoService {

    Usuario validaUsuario(Usuario usuario) throws CadastroInvalidoException;

    void setProximaValidacao(ValidaItemPedidoService proxima);
}
