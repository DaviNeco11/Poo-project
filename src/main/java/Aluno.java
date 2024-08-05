/**
 * Representa um aluno, que é uma pessoa com matrícula e um plano de treino.
 */
public class Aluno extends Pessoa {
    
    private int numMatricula;
    protected static int contador = 1;
    private PlanoDeTreino planoDeTreino;

    /**
     * Cria um aluno com nome, idade, CPF, telefone e plano de treino especificados.
     * O número de matrícula é gerado automaticamente.
     * @param nome Nome do aluno
     * @param idade Idade do aluno
     * @param cpf CPF do aluno
     * @param telefone Telefone do aluno
     * @param planoDeTreino Plano de treino do aluno
     */
    public Aluno(String nome, int idade, String cpf, String telefone, PlanoDeTreino planoDeTreino){
        super(nome, idade, cpf, telefone);
        this.numMatricula = contador;
        contador++;
        this.planoDeTreino = planoDeTreino;
    }

    /**
     * Define o número de matrícula do aluno.
     * @param numMatricula O novo número de matrícula do aluno.
     */
    public void setNumMatricula(int numMatricula){
        this.numMatricula = numMatricula;
    }

    /**
     * Define o plano de treino do aluno.
     * @param planoDeTreino O novo plano de treino do aluno.
     */
    public void setPlanoDeTreino(PlanoDeTreino planoDeTreino){
        this.planoDeTreino = planoDeTreino;
    }

    /**
     * Obtém o número de matrícula do aluno.
     * @return O número de matrícula do aluno.
     */
    public int getMatricula(){
        return numMatricula;
    }

    /**
     * Obtém o plano de treino do aluno.
     * @return O plano de treino do aluno.
     */
    public PlanoDeTreino getPlanoDeTreino(){
        planoDeTreino.toString();
        return planoDeTreino;
    }

    /**
     * Retorna uma string pronta para ser persistida no arquivo aluno.txt.
     * A String descreve os atributos da classe instanciada.
     */
    public String toPersistencia(){
        return this.getNome() + ";"
                + this.getIdade() + ";"
                + this.getCpf() + ";"
                + this.getTelefone() + ";"
                + this.numMatricula + ";"
                + this.planoDeTreino.getDificuldade();
    }
}
