package Prova04.src;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class TesteOperacoes {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Conta> contas = new ArrayList<Conta>();
    Scanner sc = new Scanner(System.in); 

    public void criarConta() {
        System.out.println("Informe o nome:");
        String nome = sc.nextLine();
        System.out.println("Informe o endereço:");
        String endereco = sc.nextLine();
        System.out.println("Informe a profissão:");
        String profissao = sc.nextLine();

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
            sc.nextLine();  

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida.");
            sc.nextLine();  
        }
        if (tipoConta.equalsIgnoreCase("poupança")) {
            ContaPoupanca contaPoupanca = new ContaPoupanca(numAgencia, numConta, cliente);
            contaPoupanca.setCliente(cliente);
            contaPoupanca.deposito(saldo);
            contas.add(contaPoupanca);

        } else if (tipoConta.equalsIgnoreCase("corrente")) {
            ContaCorrente contaCorrente = new ContaCorrente(numAgencia, numConta, cliente);
            contaCorrente.setCliente(cliente);
            contaCorrente.deposito(saldo);
            contas.add(contaCorrente);
        }
        System.out.println("Conta criada com sucesso.");
    }

    public void realizarOperacoes(int agenciaOrigem, int contaOrigem, int agenciaDestino, int contaDestino, double quantia) {
        Conta contaOrigemObj = null;
        Conta contaDestinoObj = null;

        for (Conta conta : contas) {
            if (conta.getNumeroAgencia() == agenciaOrigem && conta.getNumeroConta() == contaOrigem) {
                contaOrigemObj = conta;
            }
            if (conta.getNumeroAgencia() == agenciaDestino && conta.getNumeroConta() == contaDestino) {
                contaDestinoObj = conta;
            }
        }

        if (contaOrigemObj != null && contaDestinoObj != null) {
            contaOrigemObj.transferencia(contaDestinoObj, quantia);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Conta origem ou destino não encontrada.");
        }
    }

    public void exibirSaldo(int numeroAgencia, int numeroConta) {
        Conta contaEncontrada = null;

        for (Conta conta : contas) {
            if (conta.getNumeroAgencia() == numeroAgencia && conta.getNumeroConta() == numeroConta) {
                contaEncontrada = conta;
                break;
            }
        }
        if (contaEncontrada != null) {
            System.out.println("Informe a quantidade de meses para simular operações:");
            int meses = sc.nextInt();
            sc.nextLine();  

            if (contaEncontrada instanceof ContaCorrente) {
                ((ContaCorrente) contaEncontrada).simularOperacao(meses);
            } 
            else if (contaEncontrada instanceof ContaPoupanca) {
                ((ContaPoupanca) contaEncontrada).simularOperacao(meses);
            }
            contaEncontrada.exibirSaldo();
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void apresentarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Realizar operações");
            System.out.println("3 - Exibir saldo");
            System.out.println("0 - Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    System.out.println("Informe a agência de origem:");
                    int agenciaOrigem = sc.nextInt();
                    System.out.println("Informe a conta de origem:");
                    int contaOrigem = sc.nextInt();
                    System.out.println("Informe a agência de destino:");
                    int agenciaDestino = sc.nextInt();
                    System.out.println("Informe a conta de destino:");
                    int contaDestino = sc.nextInt();
                    System.out.println("Informe a quantia a ser transferida:");
                    double quantia = sc.nextDouble();
                    sc.nextLine();  
                    realizarOperacoes(agenciaOrigem, contaOrigem, agenciaDestino, contaDestino, quantia);
                    break;
                case 3:
                    System.out.println("Informe a agência:");
                    int numeroAgencia = sc.nextInt();
                    System.out.println("Informe a conta:");
                    int numeroConta = sc.nextInt();
                    sc.nextLine();  
                    exibirSaldo(numeroAgencia, numeroConta);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            if (continuar) {
                System.out.println("Deseja realizar outra operação? (s/n)");
                String resposta = sc.nextLine();
                if (resposta.equalsIgnoreCase("n")) {
                    continuar = false;
                }
            }
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
