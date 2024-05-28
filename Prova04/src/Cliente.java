package Prova04.src;

public class Cliente {
    private String nome;
    private String endereco;
    private String profissao;
    
    public Cliente(String nome, String endereco, String profissao) {
        this.nome = nome;
        this.endereco = endereco;
        this.profissao = profissao;
    }

    void exibirAtributos() {
        System.out.println("Nome: " + nome);
        System.out.println("Endereco: " + endereco);
        System.out.println("Profissao: " + profissao);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
