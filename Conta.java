public class Conta {
    private int numeroAgencia;
    private int numeroConta;
    private double saldo;
    private Cliente cliente;

    public Conta(int numeroAgencia, int numeroConta, double saldo, Cliente cliente) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }
    public void deposito(double quantia) {
        this.saldo += quantia;
    }
    public void saque(double quantia) {
        this.saldo -= quantia;
    }
    public void transferencia(Conta destino, double quantia) {
        if(this.saldo < quantia) {
            System.out.println("Saldo insuficiente");
            return;
        } else {
            this.saque(quantia);
            destino.deposito(quantia);
            System.out.println("Transferência realizada com sucesso");
        }
    }
    void exibirSaldo() {
        System.err.printf("Usuário: %s\nSaldo: %.2f", this.cliente.getNome(), this.saldo);
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
