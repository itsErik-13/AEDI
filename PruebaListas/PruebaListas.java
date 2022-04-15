package PruebaListas;

import java.util.LinkedList;
import java.util.List;


public class PruebaListas {
    public static void main(String[] args) {
        List<Integer> lista1 = new LinkedList<>();
        List<Integer> lista2 = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            lista1.add(i);
            lista2.add(i);
        }
        System.out.println(generarListaResumen(lista1, lista2));
    }

    public static List<Integer> mayores(List<Integer> lista, int num) {
        List<Integer> toRet = new LinkedList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) > num) {
                toRet.add(lista.get(i));
            }
        }
        return toRet;
    }

    public static <E> List<E> inversa(List<E> lista) {
        List<E> toRet = new LinkedList<>();
        for (int i = 0; i < lista.size(); i++) {
            toRet.add(lista.get(lista.size() - i - 1));
        }
        return toRet;
    }

    public static <E> boolean igualNumVeces(List<E> lista) {
        boolean toRet = true;
        int numVeces = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(lista.get(0)))
                numVeces += 1;
        }
        for (int i = 0; i < lista.size() && toRet; i++) {
            int max = 0;
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(i).equals(lista.get(j))) {
                    max += 1;
                }
                toRet = max == numVeces;
            }
        }
        return toRet;
    }

    public static boolean ordenAscendente(List<Integer> lista) {
        boolean toRet = true;
        for (int i = 0; i < lista.size() - 1 && toRet; i++) {
            if (lista.get(i) > lista.get(i + 1)) {
                toRet = false;
            }
        }
        return toRet;
    }

    public static <E> List<E> valoresRepetidos(List<E> lista) {
        List<E> toRet = new LinkedList<>();
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i) == lista.get(j) && !toRet.contains(lista.get(i)))
                    toRet.add(lista.get(i));
            }
        }
        return toRet;
    }

    public static <E> List<Terna<E>> generarListaResumen(List<E> l1, List<E> l2) {
        List<Terna<E>> toRet = new LinkedList<>();
        List<E> aux = new LinkedList<>();
        aux.addAll(l1);
        aux.addAll(l2);
        boolean add;
        int numVeces1;
        int numVeces2;
        for (E elemento : aux) {
            add = true;
            for (int i = 0; i < toRet.size(); i++) {
                if (toRet.get(i).getElemento().equals(elemento))
                    add = false;
            }
            if(add){
                numVeces1 = 0;
                numVeces2 = 0;
                for (int i = 0; i < l1.size(); i++) {
                    if(elemento == l1.get(i))
                    numVeces1++;
                }
                for (int i = 0; i < l2.size(); i++) {
                    if(elemento == l2.get(i))
                    numVeces2++;
                }
                toRet.add(new Terna<E>(elemento, numVeces1, numVeces2));
            }
        }

        return toRet;
    }
}
    

