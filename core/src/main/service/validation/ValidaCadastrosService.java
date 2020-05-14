package main.service.validation;

import main.cadastroexception.CadastroInvalidoException;

public interface ValidaCadastrosService<T> {

    T validaCadastros(T objeto) throws CadastroInvalidoException;

    void setProximaValidacao(ValidaCadastrosService<T> proximaValidacao);
}
