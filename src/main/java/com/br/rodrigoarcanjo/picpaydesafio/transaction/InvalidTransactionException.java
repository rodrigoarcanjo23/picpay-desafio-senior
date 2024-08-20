package com.br.rodrigoarcanjo.picpaydesafio.transaction;

public class InvalidTransactionException extends RuntimeException {

    public InvalidTransactionException(String message) {
      super(message);
    }
  
  }