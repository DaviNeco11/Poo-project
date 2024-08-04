/**
 * Representa uma aula com tipo, horário e responsável.
 */
public class Aula {
    private String tipo;
    private String horario;
    private Instrutor responsavel;

    /**
     * Cria uma nova aula com tipo, horário e instrutor responsável especificados.
     * @param tipo O tipo da aula
     * @param horario O horário da aula
     * @param responsavel O instrutor responsável pela aula
     */
    Aula(String tipo, String horario, Instrutor responsavel){
        this.tipo = tipo;
        this.horario = horario;
        this.responsavel = responsavel;
    }

    /**
     * Define o tipo da aula.
     * @param tipo O novo tipo da aula.
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    /**
     * Define o horário da aula.
     * @param horario O novo horário da aula.
     */
    public void setHorario(String horario){
        this.horario = horario;
    }

    /**
     * Define o instrutor responsável pela aula.
     * @param responsavel O novo instrutor responsável pela aula.
     */
    public void setResponsavel(Instrutor responsavel){
        this.responsavel = responsavel;
    }

    /**
     * Obtém o tipo da aula.
     * @return O tipo da aula.
     */
    public String getTipo(){
        return tipo;
    }

    /**
     * Obtém o horário da aula.
     * @return O horário da aula.
     */
    public String getHorario(){
        return horario;
    }

    /**
     * Obtém o instrutor responsável pela aula.
     * @return O instrutor responsável pela aula.
     */
    public Instrutor getResponsavel(){
        return responsavel;
    }

    /**
     * Retorna uma representação em string da aula.
     * @return Uma string representando a aula.
     */
    public String toString(){
        return "Tipo da aula: " + tipo + ", Horário da Aula: " + horario + ", Instrutor Responsável - \n" + responsavel;
    }

    /**
     * Retorna uma string pronta para ser persistida no arquivo aula.txt.
     * A String descreve os atributos da classe instanciada.
     */
    public String toPersistencia(){
        return this.tipo + ";"
                + this.horario + ";"
                + this.responsavel.getNome();
    }
}

