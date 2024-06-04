package Prova04.src;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class TesteOperacoes {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Conta> contas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void criarConta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o nome:");
        String nome = sc.nextLine();
        System.out.println("Informe o endereço:");
        String endereco = sc.nextLine();
        System.out.println("Informe a profissão:");
        String profissao = sc.nextLine();
    
        Cliente cliente = new Cliente(nome, endereco, profissao);
    
        System.out.println("Informe o tipo de conta: (poupanca ou corrente)");
        String tipoConta = sc.nextLine();
        int numAgencia;
        int numConta;
        double saldo;
    
        try {
            System.out.println("Informe o número da agência:");
            numAgencia = sc.nextInt();
            System.out.println("Informe o número da conta:");
            numConta = sc.nextInt();
            System.out.println("Informe o saldo inicial:");
            saldo = sc.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida.");
            return;
        }
    
        sc.nextLine();
    
        if (tipoConta.equalsIgnoreCase("poupanca")) {
            ContaPoupanca contaPoupanca = new ContaPoupanca(numAgencia, numConta, cliente);
            contaPoupanca.deposito(saldo);
            contas.add(contaPoupanca);
            System.out.println("Conta poupança criada: Agência " + numAgencia + " Conta " + numConta);
        } else if (tipoConta.equalsIgnoreCase("corrente")) {
            ContaCorrente contaCorrente = new ContaCorrente(numAgencia, numConta, cliente);
            contaCorrente.deposito(saldo);
            contas.add(contaCorrente);
            System.out.println("Conta corrente criada: Agência " + numAgencia + " Conta " + numConta);
        }
        System.out.println("Conta criada com sucesso.");
    }
    public void realizarOperacoes(int agenciaOrigem, int contaOrigem, int agenciaDestino, int contaDestino, double quantia) {
        Conta origem = null;
        Conta destino = null;
        for (Conta conta : contas) {
            if (conta.getNumeroAgencia() == agenciaOrigem && conta.getNumeroConta() == contaOrigem) {
                origem = conta;
            }
            if (conta.getNumeroAgencia() == agenciaDestino && conta.getNumeroConta() == contaDestino) {
                destino = conta;
            }
        }
    
        if (origem != null && destino != null) {
            origem.transferencia(destino, quantia);
        } else {
            System.out.println("Conta de origem ou destino não encontrada.");
        }
    }
    public void exibirSaldo(int numeroAgencia, int numeroConta) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a quantidade de meses para simulação:");
        int meses = sc.nextInt();
    
        Conta conta = null;
        for (Conta c : contas) {
            if (c.getNumeroAgencia() == numeroAgencia && c.getNumeroConta() == numeroConta) {
                conta = c;
                break;
            }
        }
    
        if (conta != null) {
            if (conta instanceof ContaPoupanca) {
                ((ContaPoupanca) conta).simularOperacao(meses);
            } else if (conta instanceof ContaCorrente) {
                ((ContaCorrente) conta).simularOperacao(meses);
            }
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

    public static void main(String[] args) {
        TesteOperacoes teste = new TesteOperacoes();
        teste.apresentarMenu();
    }
}
