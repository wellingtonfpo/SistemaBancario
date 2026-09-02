package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Conta {
    protected String numero;
    protected String titular;
    protected double saldo;
    protected List<Transacao> historico; 
    
    public Conta(String titular, double saldo) {
        this.numero = this.gerarNumeroConta();
        this.titular = titular;
        this.saldo = saldo;
        this.historico = new ArrayList<>();
    }

    public String gerarNumeroConta() {
        return UUID.randomUUID()
            .toString()
            .substring(0, 8)
            .toUpperCase();
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor deve ser positivo");
            return;
        }
        this.saldo += valor;
        System.out.printf("DEPÓSITO de R$ %.2f realizado com sucesso!");
    }

    protected void registrarTransacao(String tipo, double valor, String contaRelacionada) {
        Transacao transacao = new Transacao(tipo, valor, contaRelacionada, this.saldo);
        this.historico.add(transacao);
    }

    public void extrato() {
        System.out.println("\n" + "=".repeat(70));
        System.out.printf("EXTRATO = %s%n", this.getClass().getSimpleName());
        System.out.println("=".repeat(70));
        System.out.printf("Titular: %s%n ", this.titular);
        System.out.printf("Número da Conta: %s%n ", this.numero);
        System.out.printf("Saldo Atual: %.2f%n ", this.saldo);
        System.out.println("-".repeat(70));

        if (historico.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            for (Transacao t : historico) {
                System.out.println(t);
            }
        }
        System.out.println("\n" + "=".repeat(70));
    }

    public List<Transacao> exibirHistorico() {
        return this.historico;
    }

    abstract public void sacar(double valor);
}