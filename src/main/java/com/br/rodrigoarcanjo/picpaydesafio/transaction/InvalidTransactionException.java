package com.br.rodrigoarcanjo.picpaydesafio.exception;

public class InvalidTransactionException extends RuntimeException{
    
    public InvalidTransactionException(String message) {
        super(message);
    }
}
