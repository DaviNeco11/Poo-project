import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *Interface que determina as operações de persistência dos dados.
 */
public interface Persistencia<E, T> {
    /**
     * Carrega dados armazenados nos respectivos arquivos feitos para persistência dos dados.
     * @param t List genérica para a passagem de uma lista para objetos associados
     * @return Retorna uma ArrayList com os objetos persistidos
     */
    public ArrayList<E> carregaDados(List<T> t);

    /**
     * Insere os novos dados criados nos respectivos arquivos feitos para persistência dos dados.
     * @param e Objeto genérico para passagem de um objeto a ser persistido
     */
    public void persisteDados(E e);

}
