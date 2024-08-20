package com.br.rodrigoarcanjo.picpaydesafio.wallet;

public enum WalletType {
    COMUM(1), LOGISTA(2);

    private int value;

    private WalletType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
