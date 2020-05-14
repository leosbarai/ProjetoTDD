package main.cadastroexception;

public enum MotivoCadastroInvalido {

    CODIGO_PRODUTO_NULO(1, "Código do produto não pode ser nulo."),
    DESCRICAO_PRODUTO_NULA(2, "Descrição do produto não pode ser nula."),
    PRODUTO_SEM_PRECO(3, "Produto sem preço."),
    PRODUTO_EXISTENTE(4, "Produto já existe na lista."),

    USUARIO_NULO(5, "Nome do usuário não pode ser nulo."),
    EMAIL_USUARIO_NULO(6, "E-mail do usuário não pode ser nulo."),
    FORMATO_EMAIL_USUARIO_INCORRETO(7, "Formato de e-mail incorreto."),
    EMAIL_USUARIO_EXISTENTE(8, "E-mail já cadastrado para outro usuário."),

    QUANTIDADE_ITEMPEDIDO_NULA(9, "Quantidade não pode ser nula."),
    QUANTIDADE_ITEMPEDIDO_INCORRETA(10, "Quantidade incorreta."),
    PRODUTO_ITEMPEDIDO_NULO(11, "Produto não pode ser nulo."),
    REMOCAO_QUANTIDADE_INCORRETA_ITEMPEDIDO(12, "Quantidade não pode ser removida em sua totalidade."),

    USUARIO_NULO_PEDIDO(13, "Usuário não pode ser nulo."),
    PEDIDO_SEM_ITENS(14, "Pedido sem itens.");

    private Integer codigo;
    private String mensagem;

    MotivoCadastroInvalido(Integer codigo, String mensagem) {
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
