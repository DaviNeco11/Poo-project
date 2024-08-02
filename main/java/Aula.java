public class Aula {
    private String tipo;
    private String horario;
    private Instrutor responsavel;

    Aula(String tipo, String horario, Instrutor responsavel){
        this.tipo = tipo;
        this.horario = horario;
        this.responsavel = responsavel;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setHorario(String horario){
        this.horario = horario;
    }

    public void setResponsavel(Instrutor responsavel){
        this.responsavel = responsavel;
    }

    public String getTipo(){
        return tipo;
    }

    public String getHorario(){
        return horario;
    }

    public Instrutor getResponsavel(){
        return responsavel;
    }

    public String toString(){
        return "Tipo da aula: " + tipo + ", Horário da Aula: " + horario + ", Instrutor Responsável - \n" + responsavel;
    }

    
}

