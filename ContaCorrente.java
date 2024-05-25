public class ContaCorrente extends Conta {
    private double taxaManutencao = 50.0;

    public ContaCorrente() {
        this.taxaManutencao = taxaManutencao;
    }

    public void simularOperacao(int meses) {
        double manuntencao = (this.getSaldo() - (taxaManutencao * meses));
        System.out.printf("Saldo apos manuntecoes em %d meses: %.2f", meses, manuntencao);
    } 
}
