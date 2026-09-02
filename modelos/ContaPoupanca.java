package modelos;
public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String titular, double saldo) {
        super(titular, saldo);
        this.taxaRendimento = 0.005;
    }

    @Override
    public void sacar(double valor) {
        
    }
}
