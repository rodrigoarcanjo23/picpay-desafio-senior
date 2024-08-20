package com.br.rodrigoarcanjo.picpaydesafio.wallet;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public record Wallet(
        @Id Long id,
        String fullName,
        Long cpf,
        String email,
        String password,
        int type,
        BigDecimal balance) {

    public Wallet debit(BigDecimal value) {
        return new Wallet(id, fullName, cpf, email, password, type, balance.subtract(value));
    }

}
