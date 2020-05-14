package main.service.validation.user;

import main.cadastroexception.CadastroInvalidoException;
import main.cadastroexception.MotivoCadastroInvalido;
import main.entity.Usuario;
import main.service.UsuarioService;
import main.service.validation.ValidaCadastrosService;

public class ValidacaoUsuarioService {

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

    public class ValidaUsuarioEmailNulo implements ValidaCadastrosService<Usuario> {

        private ValidaCadastrosService<Usuario> proxima;

        @Override
        public Usuario validaCadastros(Usuario usuario) throws CadastroInvalidoException {

            if (usuario.getEmail() == null) {
                throw new CadastroInvalidoException(MotivoCadastroInvalido.EMAIL_USUARIO_NULO);
            } else {
                return proxima.validaCadastros(usuario);
            }
        }

        @Override
        public void setProximaValidacao(ValidaCadastrosService<Usuario> proxima) {
            this.proxima = proxima;
        }
    }

    public class ValidaUsuarioFormatoEmail implements ValidaCadastrosService<Usuario> {

        private ValidaCadastrosService<Usuario> proxima;

        @Override
        public Usuario validaCadastros(Usuario usuario) throws CadastroInvalidoException {

            if (usuario.getEmail().contains("@email.com")) {
                throw new CadastroInvalidoException(MotivoCadastroInvalido.FORMATO_EMAIL_USUARIO_INCORRETO);
            } else {
                return proxima.validaCadastros(usuario);
            }

        }

        @Override
        public void setProximaValidacao(ValidaCadastrosService<Usuario> proxima) {
            this.proxima = proxima;
        }
    }

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

    public class UsuarioValido implements ValidaCadastrosService<Usuario> {

        @Override
        public Usuario validaCadastros(Usuario usuario) {
            return usuario;
        }

        @Override
        public void setProximaValidacao(ValidaCadastrosService<Usuario> proxima) {

        }
    }

    public void validaUsuario(Usuario usuario) throws CadastroInvalidoException {

        ValidaCadastrosService usuarioNulo = new ValidaUsuarioNulo();
        ValidaCadastrosService emailNulo = new ValidaUsuarioEmailNulo();
        ValidaCadastrosService formatoEmail = new ValidaUsuarioFormatoEmail();
        ValidaCadastrosService emailExistente = new ValidaUsuarioEmailExistente();
        ValidaCadastrosService usuarioValido = new UsuarioValido();

        usuarioNulo.setProximaValidacao(emailNulo);
        emailNulo.setProximaValidacao(formatoEmail);
        formatoEmail.setProximaValidacao(emailExistente);
        emailExistente.setProximaValidacao(usuarioValido);
        usuarioNulo.validaCadastros(usuario);
    }

}
