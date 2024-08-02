public class App {
    public static void main(String[] args) {
        // Testando a classe PlanoDeTreino
        System.out.println("Testando a classe PlanoDeTreino - ");
        PlanoDeTreino plano = new PlanoDeTreino("Intermediário");
        plano.setExercicios("Flexões");
        plano.setExercicios("Abdominais");
        plano.setExercicios("Agachamentos");

        System.out.println(plano);

        // Testando a classe Instrutor
        System.out.println("Testando a classe Instrutor - ");
        Instrutor instrutor1 = new Instrutor("matheus", 19, "138293218", "301923021", "nenhumakk");
        instrutor1.setHorario("15:00");
        instrutor1.setHorario("19:00");
        System.out.println(instrutor1);
        instrutor1.getHorarios();

        // Testando a classe Aluno:
        System.out.println("Testando a classe Aluno - ");
        Aluno aluno1 = new Aluno("davi", 19, "3219832", "31298382901", 891, plano);
        System.out.println(aluno1);
        System.out.println(aluno1.getPlanoDeTreino());

        // Testando a classe Aula:
        System.out.println("Testando a classe Aula - ");
        Aula aula1 = new Aula("dança", "19:00", instrutor1);
        System.out.println(aula1);
    }
}

