package com.ita.caixaeletronico;

public class MockHardware implements Hardware {
    public MockHardware() {
    }

    public String pegarNumeroDaContaCartao(boolean cartaoCorreto) {
        if (cartaoCorreto) return "1234";
        return "123456789";
    }

    public void entregarDinheiro() {
    }

    public void lerEnvelope() {
    }
}
