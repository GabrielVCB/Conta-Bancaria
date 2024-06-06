# Prova 04

Este projeto simula operações bancárias básicas, incluindo a criação de contas, depósito, saque, transferência e exibição de saldo. O projeto foi desenvolvido em Java e está estruturado em várias classes para representar clientes, contas e operações bancárias.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- `Banco`: Classe principal que agrupa as classes `Cliente`, `Conta`, `ContaPoupanca`, `ContaCorrente` e `TesteOperacoes`.
- `Cliente`: Classe que representa um cliente do banco.
- `Conta`: Classe que representa uma conta bancária.
- `ContaPoupanca`: Classe que herda de `Conta` e representa uma conta poupança.
- `ContaCorrente`: Classe que herda de `Conta` e representa uma conta corrente.
- `TesteOperacoes`: Classe responsável por realizar operações bancárias e interagir com o usuário.
- `Main`: Classe principal que inicia a aplicação e apresenta o menu de operações.

# Classes
## Banco:
- Atua como a base do codigo que agrupa instâncias de outras classes, ou seja, é um pacote usado para organizar as outras classes.

## Cliente: 
### Princípio da Responsabilidade Única (SRP): A classe `Cliente` é responsável por manter e exibir os dados do cliente:
- Atua como uma classe cadastro de informações cliente.
1. **Atributos** são os tópicos de armazenamento das informações do usuário.
   - nome: Armazena o nome do cliente.
   - endereco: Armazena o endereço do cliente.
   - profissao: Armazena a profissão do cliente.
2. **Construtor**: Responsavel por inicializar  os **atributos** 
3. **Métodos**: 
   - void exibirAtributos():É um metodo utilizado para exibir os **atributos**.
   - Getters e Setters:É um método de acesso e modificador dos **atributos**(que podem ser usados em outras **Classe**).

## Conta:
- Atua como uma classe cadastro de informações da conta.
### Princípio da Responsabilidade Única (SRP):A classe `Conta` é responsável pela manipulação das operações bancárias (depósito, saque, transferência)
1. **Atributos**: 
   - numeroAgencia: Armazena o número da agência da conta.
   - numeroConta: Armazena o número da conta.
   - saldo: Armazena o saldo atual da conta.
   - cliente: Instância da classe Cliente que representa o dono da conta.
2. **Construtor**: Responsavel por inicializar  os **atributos**(O saldo é definido inicialmente como 0.0).
3. **Métodos**:
   - void deposito(double quantia): É um método que adiciona um valor especifico ao saldo.
   - void saque(double quantia): Deduz uma quantia especifica do saldo(caso o saldo seja maior que o saque, caso não, ele exibirá a mensagem "Saldo insuficiente").
   - void transferencia(Conta destino, double quantia):Transfere a quantia especificada da conta atual para a conta de destino(caso o saldo seja maior que o saque, caso não, ele exibirá a mensagem "Saldo insuficiente").
   - void exibirSaldo(): Exibe o saldo atual da conta.
   - Getters e Setters: Métodos para acessar e modificar os atributos.

## ContaCorrente:
### Princípio da Responsabilidade Única (SRP):A classe `ContaCorrente` é responsável pela simulação do custo das operações da conta corrente após n meses.
-É  uma classe que herda(**extends**) e acrescenta funções espécificas para a classe `ContaCorrente`.
1. **Atributos**: 
   - super(int numeroAgencia, int numeroConta, Cliente cliente).
   - taxaManutencao: Taxa fixa de manutenção mensal (50.0).
2. **Construtor**: Responsável chamar o construtor da superclasse Conta para inicializar.
3. **Métodos**:
   - void simularOperacao(int meses): Calcula o saldo após deduzir a taxa de manutenção por um número especificado de meses e exibe o saldo final.
  
## ContaPoupanca:
### Princípio da Responsabilidade Única (SRP): A classe ContaPoupanca é responsável pela simulação de rendimento do saldo após n meses.
- É uma classe que herda (**extends**) da classe Conta e acrescenta funcionalidades específicas para a classe `ContaPoupanca`.
1. **Atributos**: 
   - super(int numeroAgencia, int numeroConta, Cliente cliente).
   - taxaRendimento: Taxa de rendimento mensal (5% ou 0.05).
2. **Construtor**: O construtor chama o construtor da superclasse Conta para inicializar os atributos comuns.
3. **Métodos**:
   - void simularOperacao(int meses): Calcula o rendimento do saldo após um número especificado de meses aplicando a taxa de rendimento e exibe o saldo final.

## TesteOperacoes:
### Princípio da Responsabilidade Única (SRP): A classe TesteOperacoes é responsável por realizar operações bancárias interativas e gerenciar a interação com o usuário.
- A classe TesteOperacoes utiliza as outras classes (Cliente, Conta, ContaPoupanca, ContaCorrente) para gerenciar contas e realizar operações.
1. **Atributos**:
   - ArrayList<Cliente> clientes: Lista de clientes cadastrados.
   - ArrayList<Conta> contas: Lista de contas cadastradas.
2. **Métodos**:
   - void criarConta(): Cria uma nova conta (poupança ou corrente) com os dados fornecidos pelo usuário.
   - void realizarOperacoes(int agenciaOrigem, int contaOrigem, int agenciaDestino, int contaDestino, double quantia): Realiza a transferência de uma conta de origem para uma conta de destino.
   - void exibirSaldo(int numeroAgencia, int numeroConta): Exibe o saldo de uma conta e permite simular o saldo após um número especificado de meses.
   - void apresentarMenu(): Apresenta um menu interativo para o usuário selecionar e realizar operações bancárias.

## Main:
### Princípio da Responsabilidade Única (SRP): A classe Main é responsável por iniciar a aplicação e apresentar o menu de operações ao usuário.
- A classe `Main` contém o método main que inicia a execução do programa.
1. **Método**:
   - public static void main(String[] args): Instancia a classe TesteOperacoes e chama o método apresentarMenu para iniciar a interação com o usuário.
2. **Funcionamento do Programa**:
   - Iniciar a Aplicação: O método main da classe Main inicia a aplicação e apresenta o menu de operações ao usuário.
3. **Menu de Operações**: 
- O usuário pode escolher entre as seguintes opções:

   - Criar conta
   - Realizar transferência
   - Exibir saldo
   - Exibir atributos do cliente
   - Sair

- Criar Conta: O usuário fornece os dados do cliente e da conta (poupança ou corrente) e a conta é criada e armazenada na lista de contas.
- Realizar Transferência: O usuário fornece os dados das contas de origem e destino e a quantia a ser transferida. A transferência é realizada se houver saldo suficiente.
- Exibir Saldo: O usuário fornece os dados da conta e o saldo é exibido. O usuário pode optar por simular o saldo após um número especificado de meses.
- Exibir Atributos do Cliente: O usuário fornece os dados da conta e os atributos do cliente associado são exibidos.


