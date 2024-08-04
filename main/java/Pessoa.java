/**
 * Superclasse que define os atributos de uma pessoa.
 * Essa classe mantém o nome, idade, cpf e telefone de uma pessoa.
 */
public class Pessoa {
    
    private String nome;
    private int idade;
    private String cpf;
    private String telefone;

    /**
     * Cria uma nova pessoa com nome, idade, cpf e telefone especificados
     * @param nome Nome da pessoa
     * @param idade Idade da pessoa
     * @param cpf Cpf da pessoa
     * @param telefone Telefone da pessoa
     */
    public Pessoa(String nome, int idade, String cpf, String telefone){
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        this.cpf = cpf;
    }

    /**
     * Define o nome da pessoa.
     * @param nome O novo nome da pessoa.
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Define a idade da pessoa.
     * @param idade A nova idade da pessoa.
     */
    public void setIdade(int idade){
        this.idade = idade;
    }

    /**
     * Define o CPF da pessoa.
     * @param cpf O novo CPF da pessoa.
     */
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    /**
     * Define o telefone da pessoa.
     * @param telefone O novo telefone da pessoa.
     */
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    /**
     * Retorna uma representação em string da pessoa.
     * @return Uma string representando a pessoa.
     */
    public String toString(){
        return "Nome: " + nome + ", Idade: " + idade + ", CPF: " + cpf + ", telefone: " + telefone;
    }

    /**
     * Obtém o nome da pessoa.
     * @return O nome da pessoa.
     */
    public String getNome(){
        return nome;
    }

    /**
     * Obtém o telefone da pessoa.
     * @return O telefone da pessoa.
     */
    public String getTelefone(){
        return telefone;
    }

    /**
     * Obtém a idade da pessoa.
     * @return A idade da pessoa.
     */
    public int getIdade(){
        return idade;
    }

    /**
     * Obtém o CPF da pessoa.
     * @return O CPF da pessoa.
     */
    public String getCpf(){
        return cpf;
    }
}