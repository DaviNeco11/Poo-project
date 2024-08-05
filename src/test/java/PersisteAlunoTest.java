import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersisteAlunoTest {

    @Test
    void persisteDados() {
        PlanoDeTreino plano = new PlanoDeTreino("Superiores");
        Aluno aluno = new Aluno("João", 25, "02752229978", "62999448822", plano);
        PersisteAluno persisteAluno = new PersisteAluno("testeAlunoEscrita.txt");

        persisteAluno.persisteDados(aluno);

        try(BufferedReader leitor = new BufferedReader(new FileReader("testeAlunoEscrita.txt"))){
            String linha;
            String[] dados;

            linha = leitor.readLine();
            dados = linha.split(";");
            Aluno alunoTeste = new Aluno(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], new PlanoDeTreino(dados[5]));
            assertEquals(aluno.toString(), alunoTeste.toString());
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Test
    void carregaDados() {
        List<Aluno> listAluno = new ArrayList<Aluno>();
        List<Aluno> listCarregada = new ArrayList<Aluno>();

        PlanoDeTreino plano = new PlanoDeTreino("Superiores");

        Aluno aluno1 = new Aluno("João", 25, "02752229978", "62999448822", plano);
        Aluno aluno2 = new Aluno("Jose", 30, "02752448878", "62999448820", plano);
        Aluno aluno3 = new Aluno("Amanda", 19, "01234229978", "62998446622", plano);

        PersisteAluno persisteAluno = new PersisteAluno("testeAluno.txt");
        listCarregada = persisteAluno.carregaDados(null);
        int cont = 0;

        for(Aluno a : listAluno){
            a.toString().equals(listCarregada.get(cont).toString());
            cont++;
        }
    }
}