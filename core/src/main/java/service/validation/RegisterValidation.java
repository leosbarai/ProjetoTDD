package service.validation;

import cadastroexception.CadastroInvalidoException;

public abstract class RegisterValidation<T> {

    protected RegisterValidation<T> registerValidation;

    public RegisterValidation(){}

    public RegisterValidation(RegisterValidation<T> outraValidacao){
        this.registerValidation = outraValidacao;
    }

    public abstract T validaCadastros(T objeto) throws CadastroInvalidoException;
}
