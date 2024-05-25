import java.util.ArrayList;
import java.util.Scanner;
public class TesteOperacoes {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Conta> contas = new ArrayList<Conta>();

    public void criarConta(String nome, String endereco, String profissao) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEndereco(endereco);
        cliente.setProfissao(profissao);
        clientes.add(cliente);
        Conta conta = new Conta();
        conta.setCliente(cliente);
        contas.add(conta);
        System.out.println("Informe o tipo de conta: (poupança ou corrente)");
        String tipoConta = sc.nextLine();
        if (tipoConta == "poupança") {
            ContaPoupanca contaPoupanca = new ContaPoupanca();
            contaPoupanca.setCliente(cliente);
            contas.add(contaPoupanca);
            int num
        } else if (tipoConta == "corrente") {
            ContaCorrente contaCorrente = new ContaCorrente();
            contaCorrente.setCliente(cliente);
            contas.add(contaCorrente);
        }
    }

}
