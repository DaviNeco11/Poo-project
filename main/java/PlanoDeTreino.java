import java.util.ArrayList;

/**
 * Representa um plano de treino com um identificador, uma dificuldade e uma lista de exercícios
 */
public class PlanoDeTreino {
    private int id;
    protected static int contador = 1;
    private String dificuldade;
    private ArrayList<String> exercicios;

    /**
     * Cria um novo plano de treino com a dificuldade especificada.
     * O identificador do plano de treino é gerado automaticamente.
     * @param dificuldade Nível de dificuldade do plano de treino.
     */
    PlanoDeTreino(String dificuldade){
        this.id = contador;
        contador++;
        this.dificuldade = dificuldade;
        exercicios = new ArrayList<>();
    }

    /**
     * Define o nível de dificuldade do plano de treino.
     * @param dificuldade O novo nível de dificuldade do plano de treino.
     */
    public void setDificuldade(String dificuldade){
        this.dificuldade = dificuldade;
    }

    /**
     * Obtém o nível de dificuldade do plano de treino.
     * @return O nível de dificuldade do plano de treino.
     */
    public String getDificuldade(){
        return dificuldade;
    }

    /**
     * Adiciona um exercício à lista de exercícios do plano de treino.
     * @param exercicio O novo exercício do plano de treino.
     */
    public void setExercicios(String exercicio){
        exercicios.add(exercicio);
    }

    /**
     * Imprime todos os exercícios do plano de treino.
     */
    public void getExercicios(){
        for(String exercicio : exercicios){
            System.out.println(exercicio);
        }
    }

    /**
     * Obtém o identificador do plano de treino.
     * @return O identificador do plano de treino.
     */
    public int getId(){return this.id;}

    /**
     * Retorna uma representação em string do plano de treino.
     * @return Uma string representando o plano de treino.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nível de dificuldade: ").append(dificuldade).append(", Lista de exercícios:\n");
        for (String exercicio : exercicios) {
            sb.append("- ").append(exercicio).append("\n");
        }
        return sb.toString();
    }
}
