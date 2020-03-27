package service.validation.user;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Usuario;
import service.UsuarioService;
import service.validation.ValidaCadastrosService;

public class ValidaUsuarioEmailExistente implements ValidaCadastrosService<Usuario> {

    private ValidaCadastrosService<Usuario> proxima;

    @Override
    public Usuario validaCadastros(Usuario usuario) throws CadastroInvalidoException {

        UsuarioService usuarioService = new UsuarioService();

        for (Usuario usuariosList : usuarioService.getUsuarios()) {
            if (usuario.getEmail().equals(usuariosList.getEmail()))
                throw new CadastroInvalidoException(MotivoCadastroInvalido.EMAIL_USUARIO_EXISTENTE);
        }

        return proxima.validaCadastros(usuario);
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<Usuario> proxima) {
        this.proxima = proxima;
    }
}
