package com.franca.desafiodesignpattern.exceptions;

public class DepositoMinimoException extends RuntimeException{
    public DepositoMinimoException(String mensagem){
        super(mensagem);
    }
}
