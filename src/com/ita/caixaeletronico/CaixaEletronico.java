package com.ita.caixaeletronico;

import java.text.DecimalFormat;

public class CaixaEletronico {

    private Double saldo = 50.0;

    public String login(String conta) {
        if (conta.equals("1234")) return "Usuário Autenticado";
        return "Não foi possível autenticar o usuário";
    }

    public String sacar(Double valor) {
        if (valor <= saldo) return "Retire seu dinheiro";
        return "Saldo insuficiente";
    }

    public String saldo() {
        String stringSaldo = new DecimalFormat("#.00#").format(saldo);
        return "O saldo é R$" + stringSaldo;
    }

    public String depositar(Double valor) {
        saldo = saldo + valor;
        return "Depósito recebido com sucesso";
    }
}
