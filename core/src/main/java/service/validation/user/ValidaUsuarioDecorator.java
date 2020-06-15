package service.validation.user;

import cadastroexception.CadastroInvalidoException;
import cadastroexception.MotivoCadastroInvalido;
import entity.Usuario;
import service.UsuarioService;
import service.validation.RegisterValidation;

public class ValidaUsuarioDecorator {

    public static class ValidaUsuarioDecoratorNulo extends RegisterValidation<Usuario> {

        public ValidaUsuarioDecoratorNulo(RegisterValidation<Usuario> outraValidacao) {
            super(outraValidacao);
        }

        @Override
        public Usuario validaCadastros(Usuario usuario) throws CadastroInvalidoException {
            if (usuario.getNome() == null)
                throw new CadastroInvalidoException(MotivoCadastroInvalido.USUARIO_NULO);

            return usuario;
        }
    }

    public static class ValidaUsuarioDecoratorEmailNulo extends RegisterValidation<Usuario> {

        public ValidaUsuarioDecoratorEmailNulo(RegisterValidation<Usuario> outraValidacao) {
            super(outraValidacao);
        }

        @Override
        public Usuario validaCadastros(Usuario usuario) throws CadastroInvalidoException {
            if (usuario.getEmail() == null)
                throw new CadastroInvalidoException(MotivoCadastroInvalido.EMAIL_USUARIO_NULO);

            return usuario;
        }
    }

    public static class ValidaUsuarioDecoratorFormatoEmail extends RegisterValidation<Usuario> {

        public ValidaUsuarioDecoratorFormatoEmail(RegisterValidation<Usuario> outraValidacao) {
            super(outraValidacao);
        }

        @Override
        public Usuario validaCadastros(Usuario usuario) throws CadastroInvalidoException {
            if (usuario.getEmail().contains("@email.com"))
                throw new CadastroInvalidoException(MotivoCadastroInvalido.FORMATO_EMAIL_USUARIO_INCORRETO);

            return usuario;
        }
    }

    public static class ValidaUsuarioDecoratorEmailExistente extends RegisterValidation<Usuario> {

        public ValidaUsuarioDecoratorEmailExistente(RegisterValidation<Usuario> outraValidacao) {
            super(outraValidacao);
        }

        @Override
        public Usuario validaCadastros(Usuario usuario) throws CadastroInvalidoException {
            UsuarioService usuarioService = new UsuarioService();

            for (Usuario usuariosList : usuarioService.getUsuarios()) {
                if (usuario.getEmail().equals(usuariosList.getEmail()))
                    throw new CadastroInvalidoException(MotivoCadastroInvalido.EMAIL_USUARIO_EXISTENTE);
            }

            return usuario;
        }
    }

    public static class UsuarioDecoratorValido extends RegisterValidation<Usuario> {

        @Override
        public Usuario validaCadastros(Usuario usuario) {
            return usuario;
        }
    }

    public static Usuario validaUsuario(Usuario usuario) throws CadastroInvalidoException {
        RegisterValidation<Usuario> usuarioRegisterValidation = new ValidaUsuarioDecoratorNulo(
                new ValidaUsuarioDecoratorEmailNulo(
                        new ValidaUsuarioDecoratorFormatoEmail(
                                new ValidaUsuarioDecoratorEmailExistente(new UsuarioDecoratorValido()))));

        return usuarioRegisterValidation.validaCadastros(usuario);
    }
}
