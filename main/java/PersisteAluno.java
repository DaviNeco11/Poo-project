import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface Persistencia, realizando a escrita e leitura no arquivo aluno.txt.
 * Recebe o caminho do arquivo como parâmetro no construtor.
 */
public class PersisteAluno implements Persistencia<Aluno, Void> {
    private final String path;

    /**
     * Cria um novo objeto PersisteAluno que realiza as operação para o caminho especificado
     * @param path Caminha para o arquivo
     */
    public PersisteAluno(String path){this.path = path;}

    /**
     * Carrega os dados contidos no arquivo aluno.txt, retornando um ArrayList com os dados dos objetos Aluno.
     * @param v Parâmetro nulo.
     * @return Retorna um ArrayList com os alunos persistidos no arquivo aluno.txt.
     */
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

    /**
     * Atualiza o arquivo aluno.txt conforme são criados novos alunos.
     * @param aluno Objeto aluno que será persistido no arquivo aluno.txt.
     */
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
