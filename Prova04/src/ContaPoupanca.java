package Prova04.src;

public class ContaPoupanca extends Conta{
    private double taxaRendimento = 0.05;

    public ContaPoupanca(int numeroAgencia, int numeroConta, Cliente cliente) {
        super(numeroAgencia, numeroConta, cliente);
    }

    public void simularOperacao(int meses) {
        double rendimento = (this.getSaldo() * Math.pow((1 + taxaRendimento), meses));
        System.out.printf("Rendimento após %d meses: %.2f", meses, rendimento);

    }
}
