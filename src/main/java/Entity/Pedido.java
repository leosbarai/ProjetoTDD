package Entity;

public class Pedido {

    private Usuario usuario;

    public Pedido() {
    }

    public Pedido(Integer quantidade, Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
