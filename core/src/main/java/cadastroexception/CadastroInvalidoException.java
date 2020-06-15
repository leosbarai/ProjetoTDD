package cadastroexception;

public class CadastroInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

    private MotivoCadastroInvalido motivo;

    public CadastroInvalidoException(MotivoCadastroInvalido motivoCadastroInvalido) {
        super(motivoCadastroInvalido.getMensagem());
        this.motivo = motivoCadastroInvalido;
    }

    public MotivoCadastroInvalido getMotivo() {
        return this.motivo;
    }
}
