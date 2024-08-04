import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface Persistencia, realizando a escrita e leitura no arquivo instrutor.txt.
 * Recebe o caminho do arquivo como parâmetro no construtor.
 */
public class PersisteInstrutor implements Persistencia<Instrutor, Void>{
    private final String path;

    /**
     * Cria um novo objeto PersisteInstrutor que realiza as operação para o caminho especificado.
     * @param path Caminha para o arquivo.
     */
    public PersisteInstrutor(String path){
        this.path = path;
    }

    /**
     * Carrega os dados contidos no arquivo instrutor.txt, retornando um ArrayList com os dados dos objetos Instrutor.
     * @param v Parâmetro nulo.
     * @return Retorna um ArrayList com os instrutores persistidos no arquivo instrutor.txt.
     */
    @Override
    public ArrayList<Instrutor> carregaDados(List<Void> v){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();

        try(BufferedReader leitor = new BufferedReader(new FileReader(this.path))){
            String linha;
            String[] dados;

            while ((linha = leitor.readLine()) != null) {
                dados = linha.split(";");
                instrutores.add(new Instrutor(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4]));
            }
        } catch(IOException e){
            instrutores = null;
            e.printStackTrace();
        }

        return instrutores;
    }

    /**
     * Atualiza o arquivo instrutor.txt conforme são criados novos instrutores.
     * @param instrutor Objeto instrutor que será persistido no aruqivo instrutor.txt.
     */
    @Override
    public void persisteDados(Instrutor instrutor){
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(this.path, true))){
            escritor.write(instrutor.toPersistencia());
            escritor.newLine();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
