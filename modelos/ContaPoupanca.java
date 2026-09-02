package modelos;
public class ContaPoupanca extends Conta {
    private static final double TAXA_RENDIMENTO = 0.05;

    public ContaPoupanca(String titular, double saldo) {
            super(titular, saldo);
    }

    public double getTaxaRendimento() {
        return TAXA_RENDIMENTO;
    }

    public void sacar(double valor) {
        if (getSaldo() < 0 || valor > getSaldo()) {
            System.out.println("Saldo insuficiente!");
            return;
        }
        this.saldo -= valor;   
    }

    public void aplicarRendimento() {
        double rendimento = this.saldo * TAXA_RENDIMENTO;
        this.saldo += rendimento;
        System.out.println("Rendimento: " + rendimento);
        System.out.println();
    }
}
