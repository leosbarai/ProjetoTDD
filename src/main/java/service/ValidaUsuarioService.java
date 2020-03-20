package service;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Usuario;

public class ValidaUsuarioService {

    public void validaUsuarioNulo(Usuario usuario) throws CadastroInvalidoException {
        if (usuario.getNome() == null)
            throw new CadastroInvalidoException(MotivoCadastroInvalido.USUARIO_NULO);

    }

    public void validaEmailUsuarioNulo(Usuario usuario) throws CadastroInvalidoException {
        if (usuario.getEmail() == null)
            throw new CadastroInvalidoException(MotivoCadastroInvalido.EMAIL_USUARIO_NULO);
    }

    public void validaFormatoEmail(Usuario usuario) throws CadastroInvalidoException {
        if (usuario.getEmail().contains("@email.com"))
            throw new CadastroInvalidoException(MotivoCadastroInvalido.FORMATO_EMAIL_USUARIO_INCORRETO);
    }

    public void validaEmailExistente(Usuario usuario) throws CadastroInvalidoException {
        UsuarioService usuarioService = new UsuarioService();
        for (Usuario usuariosList : usuarioService.getUsuarios()) {
            if (usuario.getEmail() == usuariosList.getEmail())
                throw new CadastroInvalidoException(MotivoCadastroInvalido.EMAIL_USUARIO_EXISTENTE);
        }
    }

    public void validaCadastroUsuario(Usuario usuario) throws CadastroInvalidoException {
        validaUsuarioNulo(usuario);
        validaEmailUsuarioNulo(usuario);
        validaFormatoEmail(usuario);
        validaEmailExistente(usuario);
    }

}
