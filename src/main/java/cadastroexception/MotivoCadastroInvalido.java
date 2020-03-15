package cadastroexception;

public class MotivoCadastroInvalido {

    public static final MotivoCadastroInvalido PRODUTO_SEM_PRECO = new MotivoCadastroInvalido(1, "Produto sem preço");

    private Integer codigo;
    private String mensagem;

    public MotivoCadastroInvalido(Integer codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
