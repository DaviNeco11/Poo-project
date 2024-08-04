import java.util.ArrayList;

public class PlanoDeTreino {
    private int id;
    protected static int contador = 1;
    private String dificuldade;
    private ArrayList<String> exercicios;

    PlanoDeTreino(String dificuldade){
        this.id = contador;
        contador++;
        this.dificuldade = dificuldade;
        exercicios = new ArrayList<>();
    }

    public void setDificuldade(String dificuldade){
        this.dificuldade = dificuldade;
    }

    public String getDificuldade(){
        return dificuldade;
    }

    public void setExercicios(String exercicio){
        exercicios.add(exercicio);
    }

    public void getExercicios(){
        for(String exercicio : exercicios){
            System.out.println(exercicio);
        }
    }

    public int getId(){return this.id;}

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nível de dificuldade: ").append(dificuldade).append(", Lista de exercícios:\n");
        for (String exercicio : exercicios) {
            sb.append("- ").append(exercicio).append("\n");
        }
        return sb.toString();
    }
}
