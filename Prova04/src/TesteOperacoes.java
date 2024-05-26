package Prova04.src;
import Prova04.src.Cliente;
import Prova04.src.Conta;
import Prova04.src.ContaCorrente;
import Prova04.src.ContaPoupanca;
import Prova04.src.TesteOperacoes;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class TesteOperacoes {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Conta> contas = new ArrayList<Conta>();

    public void criarConta(String nome, String endereco, String profissao) {
        Scanner sc = new Scanner(System.in);

        Cliente cliente = new Cliente(nome, endereco, profissao);
        clientes.add(cliente);
        System.out.println("Informe o tipo de conta: (poupança ou corrente)");
        String tipoConta = sc.nextLine();
        int numAgencia = 0;
        int numConta = 0;
        double saldo = 0.0;
        try {
            System.out.println("Informe o número da agência:");
            numAgencia = sc.nextInt();
            System.out.println("Informe o número da conta:");
            numConta = sc.nextInt();
            System.out.println("Informe o saldo inicial:");
            saldo = sc.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida.");
        }
        if (tipoConta == "poupança") {
            ContaPoupanca contaPoupanca = new ContaPoupanca(numAgencia, numConta, cliente);
            contaPoupanca.setCliente(cliente);
            contaPoupanca.deposito(saldo);
            contas.add(contaPoupanca);
        } else if (tipoConta == "corrente") {
            ContaCorrente contaCorrente = new ContaCorrente(numAgencia, numConta, cliente);
            contaCorrente.setCliente(cliente);
            contaCorrente.deposito(saldo);
            contas.add(contaCorrente);
            
        }
        sc.close();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
}
