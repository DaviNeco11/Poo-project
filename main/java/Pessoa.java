public class Pessoa {
    
    private String nome;
    private int idade;
    private String cpf;
    private String telefone;

    public Pessoa(String nome, int idade, String cpf, String telefone){
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        this.cpf = cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String toString(){
        return "Nome: " + nome + ", Idade: " + idade + ", CPF: " + cpf + ", telefone: " + telefone;
    }
    
    public String getNome(){
        return nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public int getIdade(){
        return idade;
    }

    public String getCpf(){
        return cpf;
    }
}