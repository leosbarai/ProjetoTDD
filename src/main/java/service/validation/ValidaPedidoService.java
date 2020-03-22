package service.validation;

import cadastroexception.CadastroInvalidoException;
import entity.Pedido;

public interface ValidaPedidoService {

    Pedido validaPedido(Pedido pedido) throws CadastroInvalidoException;

    void setProximaValidacao(ValidaPedidoService proxima);
}
