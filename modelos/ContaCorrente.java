package modelos;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String titular, double saldo) {
        super(titular, saldo);
        this.limite = 1000.0;
    }

    public void sacar(double valor) {
        if (getSaldo() < 0) {
            System.out.println("Saldo insuficiente!");
            return;
        }

        double saldoDisponivel = getSaldo() + this.limite;

        if (valor > saldoDisponivel) {
            System.out.println("Saldo insuficiente!");
            return;
        }

        this.saldo -= valor;   
    }
}
