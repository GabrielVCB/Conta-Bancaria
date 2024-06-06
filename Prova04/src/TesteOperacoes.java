package Prova04.src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteOperacoes {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Conta> contas = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void criarConta() {
        try {
            System.out.println("Informe o nome:");
            String nome = sc.nextLine();
            System.out.println("Informe o endereço:");
            String endereco = sc.nextLine();
            System.out.println("Informe a profissão:");
            String profissao = sc.nextLine();
    
            Cliente cliente = new Cliente(nome, endereco, profissao);
    
            System.out.println("Informe o tipo de conta: (poupanca ou corrente)");
            String tipoConta = sc.nextLine();
    
            if (tipoConta.equalsIgnoreCase("poupanca") || tipoConta.equalsIgnoreCase("corrente")) {
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
                    sc.nextLine();
                    return;
                }
    
                sc.nextLine();
    
                if (tipoConta.equalsIgnoreCase("poupanca")) {
                    ContaPoupanca contaPoupanca = new ContaPoupanca(numAgencia, numConta, cliente);
                    contaPoupanca.deposito(saldo);
                    contas.add(contaPoupanca);
                    System.out.printf("Conta poupança criada:\n\tAgência: %d\n\tConta: %d\n", numAgencia, numConta);
                } else if (tipoConta.equalsIgnoreCase("corrente")) {
                    ContaCorrente contaCorrente = new ContaCorrente(numAgencia, numConta, cliente);
                    contaCorrente.deposito(saldo);
                    contas.add(contaCorrente);
                    System.out.printf("Conta corrente criada:\n\tAgência: %d\n\tConta: %d\n", numAgencia, numConta);
                }
                System.out.println("Conta criada com sucesso.");
            } else {
                System.out.println("Erro: Tipo de conta inválido.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida.");
            sc.nextLine();
        }
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
            System.out.printf("Novo saldo da conta de origem (Agência: %d, Conta: %d): R$ %.2f\n", origem.getNumeroAgencia(), origem.getNumeroConta(), origem.getSaldo());
            System.out.printf("Novo saldo da conta de destino (Agência: %d, Conta: %d): R$ %.2f\n", destino.getNumeroAgencia(), destino.getNumeroConta(), destino.getSaldo());
        } else {
            System.out.println("Conta de origem ou destino não encontrada.");
        }
    }

    public void exibirSaldo(int numeroAgencia, int numeroConta) {
        try {
            Conta conta = null;
            for (Conta c : contas) {
                if (c.getNumeroAgencia() == numeroAgencia && c.getNumeroConta() == numeroConta) {
                    conta = c;
                    break;
                }
            }
            if (conta != null) {
                System.out.printf("Saldo atual da conta (Agência: %d, Conta: %d): R$ %.2f\n", conta.getNumeroAgencia(), conta.getNumeroConta(), conta.getSaldo());

                System.out.println("Deseja simular o saldo após alguns meses? (s/n)");
                String resposta = sc.nextLine();
                if (resposta.equalsIgnoreCase("s")) {
                    System.out.println("Informe a quantidade de meses para simulação:");
                    int meses = sc.nextInt();
                    sc.nextLine();
                    if (conta instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta).simularOperacao(meses);
                    } else if (conta instanceof ContaCorrente) {
                        ((ContaCorrente) conta).simularOperacao(meses);
                    }
                }
            } else {
                System.out.println("Conta não encontrada.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida.");
            sc.nextLine();
        }
    }

    public void apresentarMenu() {
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Criar conta");
                System.out.println("2 - Realizar transferência");
                System.out.println("3 - Exibir saldo");
                System.out.println("4 - Exibir atributos do cliente");
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
                    case 4:
                        System.out.println("Informe a agência:");
                        int agencia = sc.nextInt();
                        System.out.println("Informe a conta:");
                        int conta = sc.nextInt();
                        sc.nextLine();
                        Conta contaEncontrada = null;
                        for (Conta c : contas) {
                            if (c.getNumeroAgencia() == agencia && c.getNumeroConta() == conta) {
                                contaEncontrada = c;
                                break;
                            }
                        }
                        if (contaEncontrada != null) {
                            contaEncontrada.getCliente().exibirAtributos();
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
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
                    if (resposta.equalsIgnoreCase("n") || !resposta.equalsIgnoreCase("s")) {
                        continuar = false;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida.");
                sc.nextLine();
                continuar = false;
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
