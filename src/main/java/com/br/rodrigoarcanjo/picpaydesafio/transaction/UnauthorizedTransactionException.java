package com.br.rodrigoarcanjo.picpaydesafio.transaction;

public class UnauthorizedTransactionException extends RuntimeException {
    public UnauthorizedTransactionException(String message) {
      super(message);
    }
  }