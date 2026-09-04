import modelos.ContaPoupanca;

void main() {
    ContaPoupanca cp = new ContaPoupanca("Pereira", 1500.0);
    cp.aplicarRendimento();
    cp.depositar(500.0);
    cp.sacar(100.0);
    cp.aplicarRendimento();
    cp.extrato();   
}
