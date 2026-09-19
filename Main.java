import java.util.Locale;
import java.util.Scanner;

import modelos.Banco;
import modelos.ContaCorrente;
import modelos.ContaPoupanca;

private static boolean ativo;
private static Scanner input;
private static Banco banco;
void main() {
    Locale.setDefault(Locale.US);
    
    banco = new Banco("FPO Bank");
    input = new Scanner(System.in);
    ativo = true;
    menuPrincipal();
    input.close();
}

private static void menuPrincipal() {
    while(ativo) {
        int opcao;

        System.out.println("\n" + "=".repeat(80));
        System.out.println("MENU PRINCIPAL - BANCO XPTO");
        System.out.println("=".repeat(80));
        System.out.println("1 - Abrir Conta");
        System.out.println("2 - Listar Contas");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
        opcao = input.nextInt();
        
        switch (opcao) {
            case 1:
                abrirConta();
                break;
            case 2:
                banco.ListarContas();
                break;
            case 3:
                System.out.println("Sair do Sistema");
                ativo = false;
                break;
            default:
                System.out.println("Opção inválida!!!");
        }
    }
}

private static void abrirConta() {
    System.out.println("\n" + "=".repeat(80));
    System.out.println("    ABRIR CONTA");
    System.out.println("=".repeat(80));

    System.out.print("Digite Saldo inicial (R$): ");
    double saldoInicial = input.nextDouble();

    if (saldoInicial < 0) {
        saldoInicial = 0.0;
    }

    input.nextLine();
    
    System.out.print("Digite o nome do titular: ");
    String titular = input.nextLine();

    if (titular.trim().isEmpty() || titular.length() < 3) {
        System.out.println(
            "Titular não pode ser vazio e deve ter mais que 2 caracteres");
        return;
    }

    System.out.println("\nTipo de Conta:");
    System.out.println("1 - Conta Poupança");
    System.out.println("2 - Conta Corrente");
    System.out.print("Escolha: ");
    int tipoConta = input.nextInt();

    switch (tipoConta) {
        case 1:
            ContaPoupanca cp = new ContaPoupanca(titular, saldoInicial);
            banco.adicionarConta(cp);
            break;
        case 2:
            ContaCorrente cc = new ContaCorrente(titular, saldoInicial);
            banco.adicionarConta(cc);
            break;
        default:
            System.out.println("Tipo de Conta Inválida!");
    }
}