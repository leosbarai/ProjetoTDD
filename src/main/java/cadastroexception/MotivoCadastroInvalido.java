package cadastroexception;

public class MotivoCadastroInvalido {

    public static final MotivoCadastroInvalido CODIGO_PRODUTO_NULO = new MotivoCadastroInvalido(1, "Código do produto não pode ser nulo.");
    public static final MotivoCadastroInvalido DESCRICAO_PRODUTO_NULA = new MotivoCadastroInvalido(2, "Descrição do produto não pode ser nula.");
    public static final MotivoCadastroInvalido PRODUTO_SEM_PRECO = new MotivoCadastroInvalido(3, "Produto sem preço.");
    public static final MotivoCadastroInvalido PRODUTO_EXISTENTE = new MotivoCadastroInvalido(4, "Produto já existe na lista.");

    public static final MotivoCadastroInvalido USUARIO_NULO = new MotivoCadastroInvalido(5, "Nome do usuário não pode ser nulo.");
    public static final MotivoCadastroInvalido EMAIL_USUARIO_NULO = new MotivoCadastroInvalido(6, "E-mail do usuário não pode ser nulo.");
    public static final MotivoCadastroInvalido FORMATO_EMAIL_USUARIO_INCORRETO = new MotivoCadastroInvalido(7, "Formato de e-mail incorreto.");
    public static final MotivoCadastroInvalido EMAIL_USUARIO_EXISTENTE = new MotivoCadastroInvalido(8, "E-mail já cadastrado para outro usuário.");

    public static final MotivoCadastroInvalido QUANTIDADE_ITEMPEDIDO_NULA = new MotivoCadastroInvalido(9, "Quantidade não pode ser nula.");
    public static final MotivoCadastroInvalido QUANTIDADE_ITEMPEDIDO_INCORRETA = new MotivoCadastroInvalido(10, "Quantidade incorreta.");
    public static final MotivoCadastroInvalido PRODUTO_ITEMPEDIDO_NULO = new MotivoCadastroInvalido(11, "Produto não pode ser nulo.");
    public static final MotivoCadastroInvalido REMOCAO_QUANTIDADE_INCORRETA_ITEMPEDIDO = new MotivoCadastroInvalido(12, "Quantidade não pode ser removida em sua totalidade.");

    public static final MotivoCadastroInvalido USUARIO_NULO_PEDIDO = new MotivoCadastroInvalido(13, "Usuário não pode ser nulo.");
    public static final MotivoCadastroInvalido PEDIDO_SEM_ITENS = new MotivoCadastroInvalido(14, "Pedido sem itens.");

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
