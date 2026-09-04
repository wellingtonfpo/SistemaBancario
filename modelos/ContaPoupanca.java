package modelos;
public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String titular, double saldo) {
        super(titular, saldo);
        this.taxaRendimento = 0.005;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Error: O valor do saque deve ser maior que zero!");
            return;
        }

        if (valor > this.saldo) {
            System.out.println("Error: Saldo insuficiente!");
            return;
        }

        this.saldo -= valor;
        this.registrarTransacao("SAQUE", -valor, null);
        System.out.printf("Saque de R$ %.2f realizado com sucesso!", valor);
    }

    public void aplicarRendimento() {
        double rendimento = this.saldo * taxaRendimento;
        this.saldo += rendimento;
        this.registrarTransacao("RENDIMENTO", rendimento, null);
    }
}
