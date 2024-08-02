import java.util.ArrayList;


public class Instrutor extends Pessoa {
    
    private String especialidade;
    protected static int contadorInstrutor = 0;
    private ArrayList<String> horarios;
    
    public Instrutor(String nome, int idade, String cpf, String telefone, String especialidade){
        super(nome, idade, cpf, telefone);
        this.especialidade = especialidade;
        contadorInstrutor ++;
        horarios = new ArrayList<>();
        }

    public void setEspecialide(String especialidade){
        this.especialidade = especialidade;
    }

    public String getEspecialidade(){
        return especialidade;
    }

    public void setHorario(String horario){
        horarios.add(horario);
    }

    public void getHorarios(){
        System.out.println("Horários de Aula desse instrutor:");
        for(String horario: horarios){
            System.out.println(horario);
        }
        System.out.println();
    }

}
