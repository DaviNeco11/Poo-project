public class Aluno extends Pessoa {
    
    private int numMatricula;
    protected static int contador = 1;
    private PlanoDeTreino planoDeTreino;
    
    public Aluno(String nome, int idade, String cpf, String telefone, PlanoDeTreino planoDeTreino){
        super(nome, idade, cpf, telefone);
        this.numMatricula = contador;
        contador++;
        this.planoDeTreino = planoDeTreino;
    }

    public void setNumMatricula(int numMatricula){
        this.numMatricula = numMatricula;
    }

    public void setPlanoDeTreino(PlanoDeTreino planoDeTreino){
        this.planoDeTreino = planoDeTreino;
    }

    public int getMatricula(){
        return numMatricula;
    }

    public PlanoDeTreino getPlanoDeTreino(){
        planoDeTreino.toString();
        return planoDeTreino;
    }

    public String toPersistencia(){
        return this.getNome() + ";"
                + this.getIdade() + ";"
                + this.getCpf() + ";"
                + this.getTelefone() + ";"
                + this.numMatricula + ";"
                + this.planoDeTreino.getDificuldade();
    }

}
