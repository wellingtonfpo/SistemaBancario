package modelos;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nomeDoBanco;
    private List<Conta> contas;

    public Banco(String nomeBanco) {
        this.nomeDoBanco = nomeBanco;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
        System.out.printf("Conta criada com sucesso!");
        System.out.printf(" Número: %s%n", conta.getNumeroConta());
        System.out.printf(" Titular: %s%n", conta.getTitular());
    }

    public Conta buscarConta(String numeroDaConta) {
        
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numeroDaConta)) {
                return conta;
            }
        }
        return null;
    }

    public void ListarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhum conta cadastrada!");
            return ;
        }

        System.out.println("\n" + "=".repeat(100));
        System.out.printf("CONTAS CADASTRADAS - %s", this.nomeDoBanco);
        System.out.println("\n" + "=".repeat(100));

        for (Conta conta : contas) {
            System.out.printf("%s | Numero: %s | Titular: %-20s | Saldo: %.2f%n",
                conta.getClass().getSimpleName(),
                conta.getNumeroConta(),
                conta.getTitular(),
                conta.getSaldo());
        }
        System.out.printf("%nTotal de Contas: %d", this.getTotalContas());
        System.out.println("\n" + "=".repeat(100));
    }

    public int getTotalContas() {
        return contas.size();
    }

    public List<Conta> getContas() {
        return contas;
    }
}
