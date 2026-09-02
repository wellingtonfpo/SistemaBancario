package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao extends Object {
    private String tipo;
    private double valor;
    private String contaRelacionada;
    private double saldoAposTransacao;
    private LocalDateTime dataHora;

    // Método construtor
    public Transacao(
        String tipo, double valor, String contaRelacionada, double saldoAposTransacao) {
            this.tipo = tipo;
            this.valor = valor;
            this.contaRelacionada = contaRelacionada;
            this.saldoAposTransacao = saldoAposTransacao;
            this.dataHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       String linha = String.format("%s | %-20s | Valor: R$ %.2f | Saldo R$ %.2f", 
            dataHora.format(formatter), this.tipo, this.valor, this.saldoAposTransacao);

        if (contaRelacionada != null) {
            linha += " | Conta: " + this.contaRelacionada;
        }
       
       return linha;
    }
}
