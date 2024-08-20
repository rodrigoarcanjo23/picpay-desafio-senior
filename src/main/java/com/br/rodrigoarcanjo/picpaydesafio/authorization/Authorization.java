package com.br.rodrigoarcanjo.picpaydesafio.authorization;

public record Authorization(
    String message
) {
    public boolean isAuthorized() {
        return message.equals("Autorizado");
    }
}
