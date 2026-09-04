import modelos.Banco;
import modelos.ContaCorrente;
import modelos.ContaPoupanca;

void main() {
    ContaPoupanca cp = new ContaPoupanca("Pereira", 1500.0);
    ContaCorrente cc = new ContaCorrente("Pietro", 2000.0);
    Banco b1 = new Banco("Banco FPO");
    b1.adicionarConta(cp);
    b1.adicionarConta(cc);
    b1.ListarContas();
}
