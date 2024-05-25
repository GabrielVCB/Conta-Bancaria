package ;
public class Banco {
    Cliente cliente;
    Conta conta;
    ContaPoupanca contaPoupanca;
    ContaCorrente contaCorrente;
    TesteOperacoes testeOperacoes;

    void exibirAtributos() {
        System.out.println("Cliente: " + cliente);
        System.out.println("Conta: " + conta);
        System.out.println("Conta Poupança: " + contaPoupanca);
        System.out.println("Conta Corrente: " + contaCorrente);
    }
}