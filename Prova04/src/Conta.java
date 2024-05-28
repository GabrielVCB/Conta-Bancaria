package Prova04.src;

public class Conta {
    private int numeroAgencia;
    private int numeroConta;
    private double saldo;
    private Cliente cliente;

    public Conta(int numeroAgencia, int numeroConta, Cliente cliente) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
        this.cliente = cliente;
    }

    public void deposito(double quantia) {
        this.saldo += quantia;
    }

    public void saque(double quantia) {
        if(this.saldo >= quantia) {
            this.saldo -= quantia;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transferencia(Conta destino, double quantia) {
        if(this.saldo >= quantia) {
            this.saque(quantia);
            destino.deposito(quantia);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    void exibirSaldo() {
        System.err.printf("Usuário: %s\nSaldo: %.2f\n", this.cliente.getNome(), this.saldo);
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }
    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }
    public int getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
