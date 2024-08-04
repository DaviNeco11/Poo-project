import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersisteAula implements Persistencia<Aula, Instrutor>{
    private final String path;

    public PersisteAula(String path){this.path = path;}

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
