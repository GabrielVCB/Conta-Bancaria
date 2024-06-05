# Projeto Banco

Este projeto simula operações bancárias básicas, incluindo a criação de contas, depósito, saque, transferência e exibição de saldo. O projeto foi desenvolvido em Java e está estruturado em várias classes para representar clientes, contas e operações bancárias.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- `Banco`: Classe principal que agrupa as classes `Cliente`, `Conta`, `ContaPoupanca`, `ContaCorrente` e `TesteOperacoes`.
- `Cliente`: Classe que representa um cliente do banco.
- `Conta`: Classe abstrata que representa uma conta bancária.
- `ContaPoupanca`: Classe que herda de `Conta` e representa uma conta poupança.
- `ContaCorrente`: Classe que herda de `Conta` e representa uma conta corrente.
- `TesteOperacoes`: Classe responsável por realizar operações bancárias e interagir com o usuário.
- `Main`: Classe principal que inicia a aplicação e apresenta o menu de operações.

# Classes
## Banco:
- Atua como a base do codigo que agrupa instâncias de outras classes, ou seja, ela é usada para organizar as outras classes.

## Cliente: 
### Princípio da Responsabilidade Única (SRP): A classe `Cliente` é responsável por manter e exibir os dados do cliente:
- Atua como uma classe cadastro de informações cliente.
1. Os **atributos** são os tópicos de armazenamento das informações do usuário.
   - nome: Armazena o nome do cliente.
   - endereco: Armazena o endereço do cliente
   - profissao:Armazena a profissão do cliente.
2. O **construtor** é responsavel por inicializar  os **atributos** 
3. Os **métodos**: São as formas de utilidade dadas aos **atributos**.
   - void exibirAtributos():É um metodo utilizado para exibir os **atributos**.
   - Getters e Setters:É um método de acesso e modificador dos **atributos**(que podem ser usados em outras **Classe**).

## Conta:
-Atua como uma classe cadastro de informações da conta.
### Princípio da Responsabilidade Única (SRP):A classe `Conta` é responsável pela manipulação das operações bancárias (depósito, saque, transferência)
-Os **atributos** são os tópicos de armazenamento das informações da conta:
numeroAgencia: Armazena o número da agência da conta;
numeroConta: Armazena o número da conta;
saldo: Armazena o saldo atual da conta;
cliente: Instância da classe Cliente que representa o dono da conta.
- O **construtor** é responsavel por inicializar  os **atributos**(O saldo é definido inicialmente como 0.0)
- Os **métodos**:
- void deposito(double quantia): É um método que adiciona um valor especifico ao saldo.
- void saque(double quantia): Deduz uma quantia especifica do saldo(caso o saldo seja maior que o saque, caso não, ele exibirá a mensagem "Saldo insuficiente").
- void transferencia(Conta destino, double quantia):Transfere a quantia especificada da conta atual para a conta de destino(caso o saldo seja maior que o saque, caso não, ele exibirá a mensagem "Saldo insuficiente")
- void exibirSaldo(): Exibe o saldo atual da conta.
- Getters e Setters: Métodos para acessar e modificar os atributos.

## ContaCorrente:
### Princípio da Responsabilidade Única (SRP):A classe `ContaCorrente` é responsável pela manipulação das operações bancárias (depósito, saque, transferência)
-É  uma classe que herda(**extends**) e acrescenta funções espécificas para a classe `ContaCorrente`.
-Os **atributos** são tanto os da classe `Conta` quanto o especifico dela própria.
- super(int numeroAgencia, int numeroConta, Cliente cliente);
- taxaManutencao: Taxa fixa de manutenção mensal (50.0);
- O **construtor** é responsável chamar o construtor da superclasse Conta para inicializar
- Os **métodos**:
- void simularOperacao(int meses): Calcula o saldo após deduzir a taxa de manutenção por um número especificado de meses e exibe o saldo final.
  

