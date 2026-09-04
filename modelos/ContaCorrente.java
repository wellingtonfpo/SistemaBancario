package modelos;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String titular, double saldo) {
        super(titular, saldo);
        this.limite = 1000.0;
    }

    public void sacar(double valor) {
        if (this.saldo < 0) {
            System.out.println("ERROR: Saldo insuficiente!");
            return;
        }

        double saldoComLimite = this.saldo + this.limite;

        if (valor > saldoComLimite) {
            System.out.println("ERROR: Saldo insuficiente!");
            return;
        }

        this.saldo -= valor;
        this.registrarTransacao("SAQUE", -valor, null);
        System.out.printf("Saque de R$ %.2f realizado com sucesso!", valor);
    }
}
