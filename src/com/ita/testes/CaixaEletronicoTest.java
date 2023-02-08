package com.ita.testes;

import com.ita.caixaeletronico.CaixaEletronico;
import com.ita.caixaeletronico.ContaCorrente;
import com.ita.caixaeletronico.MockHardware;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaixaEletronicoTest {

    private final CaixaEletronico caixaEletronico = new CaixaEletronico();
    private final MockHardware mockHardware = new MockHardware();
    private final ContaCorrente contaCorrente = new ContaCorrente();

    @BeforeEach
    public void caixaEletronico() {
        assertNotNull(caixaEletronico);
        assertNotNull(mockHardware);
        assertNotNull(mockHardware);
    }

    @Test
    public void loginFalha() {
        contaCorrente.recuperarConta();
        String respostaLogin = caixaEletronico.login(mockHardware.pegarNumeroDaContaCartao(false));
        assertEquals("Não foi possível autenticar o usuário", respostaLogin);
    }

    @Test
    public void loginSucesso() {
        contaCorrente.recuperarConta();
        String respostaLogin = caixaEletronico.login(mockHardware.pegarNumeroDaContaCartao(true));
        assertEquals("Usuário Autenticado", respostaLogin);
    }

    @Test
    public void saldo() {
        String respostaSaldo = caixaEletronico.saldo();
        assertEquals("O saldo é R$50,00" , respostaSaldo);
    }

    @Test
    public void sacarSucesso() {
        Double valor = 50.0;
        String respostaSaque = caixaEletronico.sacar(valor);
        assertEquals("Retire seu dinheiro", respostaSaque);
        contaCorrente.persistirConta();
        mockHardware.entregarDinheiro();
    }

    @Test
    public void sacarFalha() {
        Double valor = 200.0;
        String respostaSaque = caixaEletronico.sacar(valor);
        assertEquals("Saldo insuficiente", respostaSaque);
    }

    @Test
    public void depositarSucesso() {
        Double valor = 300.0;
        String respostaDeposito = caixaEletronico.depositar(valor);
        assertEquals("Depósito recebido com sucesso", respostaDeposito);
        contaCorrente.persistirConta();
        mockHardware.lerEnvelope();
    }
}