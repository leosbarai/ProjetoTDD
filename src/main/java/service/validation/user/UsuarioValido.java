package service.validation.user;

import entity.Usuario;
import service.validation.ValidaCadastrosService;

public class UsuarioValido implements ValidaCadastrosService<Usuario> {

    @Override
    public Usuario validaCadastros(Usuario usuario) {
        return usuario;
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<Usuario> proxima) {

    }
}
