package Prova04.src;

public class ContaCorrente extends Conta {
    private double taxaManutencao = 50.0;

    public ContaCorrente(int numeroAgencia, int numeroConta, Cliente cliente) {
        super(numeroAgencia, numeroConta, cliente);
    }
    
    public void simularOperacao(int meses) {
        double custo = taxaManutencao * meses;
        double saldoFinal = this.getSaldo() - custo;
        System.out.printf("Saldo apos manuntecoes em %d meses: R$ %.2f", meses, saldoFinal);
    } 
}
