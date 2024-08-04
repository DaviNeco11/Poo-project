import java.util.ArrayList;

/**
 * Representa um instrutor, que é uma pessoa com especialidade, identificador e horários de aulas.
 */
public class Instrutor extends Pessoa {
    
    private String especialidade;
    private int id;
    protected static int contadorInstrutor = 0;
    private ArrayList<String> horarios;

    /**
     * Cria um novo instrutor com nome, idade, CPF, telefone e especialidade especificados.
     * O identificador do instrutor é gerado automaticamente.
     * @param nome Nome do instrutor
     * @param idade Idade do instrutor
     * @param cpf CPF do instrutor
     * @param telefone Telefone do instrutor
     * @param especialidade Especialidade do instrutor
     */
    public Instrutor(String nome, int idade, String cpf, String telefone, String especialidade){
        super(nome, idade, cpf, telefone);
        this.especialidade = especialidade;
        this.id = contadorInstrutor;
        contadorInstrutor++;
        horarios = new ArrayList<>();
        }

    /**
     * Define a especialidade do instrutor.
     * @param especialidade A nova especialidade do instrutor.
     */
    public void setEspecialide(String especialidade){
        this.especialidade = especialidade;
    }

    /**
     * Obtém a especialidade do instrutor.
     * @return A especialidade do instrutor.
     */
    public String getEspecialidade(){
        return especialidade;
    }

    /**
     * Adiciona um horário de aula à lista de horários do instrutor.
     * @param horario O novo horário de aula do instrutor.
     */
    public void setHorario(String horario){
        horarios.add(horario);
    }

    /**
     * Imprime todos os horários de aula do instrutor.
     */
    public void getHorarios(){
        System.out.println("Horários de Aula desse instrutor:");
        for(String horario: horarios){
            System.out.println(horario);
        }
        System.out.println();
    }

    /**
     * Obtém o identificador do instrutor.
     * @return O identificador do instrutor.
     */
    public int getId(){
        return this.id;
    }

    /**
     * Retorna uma string pronta para ser persistida no arquivo instrutor.txt.
     * A String descreve os atributos da classe instanciada.
     */
    public String toPersistencia(){
        return this.getNome() + ";"
                + this.getIdade() + ";"
                + this.getCpf() + ";"
                + this.getTelefone() + ";"
                + this.especialidade + ";"
                + this.id;
    }
}
