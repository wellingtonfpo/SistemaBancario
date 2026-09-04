package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Conta {
    protected String numeroConta;
    protected String titular;
    protected double saldo;
    protected List<Transacao> historico;

    public Conta(String titular, double saldo) {
        this.numeroConta = this.gerarNumeroConta();
        this.titular = titular;
        this.saldo = saldo;
        this.historico = new ArrayList<>();
    }

    private String gerarNumeroConta() {
        return UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor deve ser positivo");
            return;
        }
        this.saldo += valor;
        this.registrarTransacao("DEPÓSITO", valor, null);
        System.out.printf("DEPÓSITO de R$ %.2f realizado com sucesso!", valor);
    }

    protected void registrarTransacao(String tipo, double valor, String contaRelacionada) {
        Transacao transacao = new Transacao(tipo, valor, contaRelacionada, this.saldo);
        this.historico.add(transacao);
    }

    public void extrato() {
        System.out.println("\n" + "=".repeat(100));
        System.out.printf("EXTRATO = %s%n", this.getClass().getSimpleName());
        System.out.println("=".repeat(100));
        System.out.printf("Titular: %s%n", this.titular);
        System.out.printf("Número da Conta: %s%n", this.numeroConta);
        System.out.printf("Saldo Atual: %.2f%n", this.saldo);
        System.out.println("-".repeat(100));

        if (historico.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            for (Transacao t : historico) {
                System.out.println(t);
            }
        }
        System.out.println("\n" + "=".repeat(100));
    }

    public List<Transacao> exibirHistorico() {
        return this.historico;
    }

    public void transferenciaPix(Conta contaDestino, double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor da transferencia deve ser maior que zero!");
            return;
        }

        if (valor > this.saldo) {
            System.out.println("Erro: Saldo insuficiente!");
            return;
        }

        this.saldo -= valor;
        registrarTransacao("PIX ENVIADO", -valor, contaDestino.numeroConta);

        contaDestino.saldo += valor;
        contaDestino.registrarTransacao("PIX RECEBIDO", valor, this.numeroConta);

        System.out.printf(
            "Transferencia Pix de R$ %.2f para %s realizado com sucesso!%n", 
                valor, contaDestino.numeroConta);
    }

    public void exibirInformacoes() {
        System.out.printf("%s - Titular: %s | Conta: %s | Saldo: %.2f%n",
            this.getClass().getSimpleName(), this.titular, this.numeroConta, this.saldo);
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    abstract public void sacar(double valor);
}
