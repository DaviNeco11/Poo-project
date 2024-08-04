import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface Persistencia<E, T> {
    public ArrayList<E> carregaDados(List<T> t);
    public void persisteDados(E e);

}
