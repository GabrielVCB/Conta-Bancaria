public class ContaPoupanca extends Conta{
    private double taxaRendimento = 0.05;

    public ContaPoupanca() {
        this.taxaRendimento = taxaRendimento;
    }

    public void simularOperacao(int meses) {
        double rendimento = (this.getSaldo() + (taxaRendimento * this.getSaldo())) * meses;
        System.out.printf("Rendimento após %d meses: %.2f", meses, rendimento);

    }
}
