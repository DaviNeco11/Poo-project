import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersisteInstrutor implements Persistencia<Instrutor, Void>{
    private final String path;

    public PersisteInstrutor(String path){
        this.path = path;
    }

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
