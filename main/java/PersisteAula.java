import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface Persistencia, realizando a escrita e leitura no arquivo aula.txt.
 * Recebe o caminho do arquivo como parâmetro no construtor.
 */
public class PersisteAula implements Persistencia<Aula, Instrutor>{
    private final String path;

    /**
     * Cria um novo objeto PersisteAula que realiza as operação para o caminho especificado
     * @param path Caminha para o arquivo
     */
    public PersisteAula(String path){this.path = path;}

    /**
     * Carrega os dados contidos no arquivo aula.txt, retornando um ArrayList com os dados dos objetos Aula.
     * @param instrutores Lista de instrutores para buscar o instrutor responsável pela aula
     * @return Retorna um ArrayList com as aulas persistidas no arquivo aula.txt
     */
    @Override
    public ArrayList<Aula> carregaDados(List<Instrutor> instrutores){
        ArrayList<Aula> aulas = new ArrayList<Aula>();

        try(BufferedReader leitor = new BufferedReader(new FileReader(this.path))){
            String linha;
            String[] dados;
            Instrutor i = null;

            while ((linha = leitor.readLine()) != null) {
                dados = linha.split(";");

                for(Instrutor inst : instrutores){
                    if(inst.getNome().equals(dados[2])){
                        i = inst;
                        break;
                    }
                }

                aulas.add(new Aula(dados[0], dados[1], i));
            }
        } catch(IOException e){
            aulas = null;
            e.printStackTrace();
        }

        return aulas;
    }

    /**
     * Atualiza o arquivo aula.txt conforme são criadas novas aulas.
     * @param aula Objeto aula que será persistido no arquivo aula.txt.
     */
    @Override
    public void persisteDados(Aula aula){
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(this.path, true))){
            escritor.write(aula.toPersistencia());
            escritor.newLine();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
