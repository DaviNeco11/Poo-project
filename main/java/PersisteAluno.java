import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersisteAluno implements Persistencia<Aluno, Void> {
    private final String path;

    public PersisteAluno(String path){this.path = path;}

    @Override
    public ArrayList<Aluno> carregaDados(List<Void> v){
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        try(BufferedReader leitor = new BufferedReader(new FileReader(this.path))){
            String linha;
            String[] dados;

            while ((linha = leitor.readLine()) != null) {
                dados = linha.split(";");
                alunos.add(new Aluno(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], new PlanoDeTreino(dados[5])));
            }
        } catch(IOException e){
            alunos = null;
            e.printStackTrace();
        }

        return alunos;
    }

    @Override
    public void persisteDados(Aluno aluno){
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(this.path, true))){
            escritor.write(aluno.toPersistencia());
            escritor.newLine();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
