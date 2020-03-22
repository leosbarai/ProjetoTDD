package service.validation;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Usuario;
import service.UsuarioService;

public class ValidaEmailExistente implements ValidaUsuarioService {

    private ValidaUsuarioService proxima;

    @Override
    public Usuario validaUsuario(Usuario usuario) throws CadastroInvalidoException {

        UsuarioService usuarioService = new UsuarioService();

        for (Usuario usuariosList : usuarioService.getUsuarios()) {
            if (usuario.getEmail() == usuariosList.getEmail())
                throw new CadastroInvalidoException(MotivoCadastroInvalido.EMAIL_USUARIO_EXISTENTE);
        }

        return proxima.validaUsuario(usuario);
    }

    @Override
    public void setProximaValidacao(ValidaUsuarioService proxima) {
        this.proxima = proxima;
    }
}
