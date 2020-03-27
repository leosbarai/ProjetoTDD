package service.validation.product;

import entity.Produto;
import service.validation.ValidaCadastrosService;

public class ProdutoValido implements ValidaCadastrosService<Produto> {

    @Override
    public Produto validaCadastros(Produto produto) {
        return produto;
    }

    @Override
    public void setProximaValidacao(ValidaCadastrosService<Produto> proxima) {

    }
}
