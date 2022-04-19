package PruebaListas;

import lista.*;
import java.util.LinkedList;
import java.util.List;

public class PruebaListas {
    public static void main(String[] args) {
        Lista<Integer> l = new ListaEnlazada<>();
        Lista<Integer> l2 = new ListaEnlazada<>();
        for (int i = 0; i < 5; i++) {
            l.insertarFinal(i);
            l2.insertarFinal(i+2);
        }
        l.insertarFinal(4);
        l.insertarFinal(3);
        Lista<Integer> result = valoresRepetidosAEDI(l);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
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

    public static Lista<Integer> mayoresAEDI(Lista<Integer> lista, int num) {
        Lista<Integer> toRet = new ListaEnlazada<>();
        for (Integer elemento : lista) {
            if (elemento > num) {
                toRet.insertarFinal(elemento);
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

    public static <E> Lista<E> inversaAEDI(Lista<E> lista) {
        Lista<E> toRet = new ListaEnlazada<>();
        for (E e : lista) {
            toRet.insertarPrincipio(e);
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

    public static <E> boolean igualNumVecesAEDI(Lista<E> lista) {
        boolean toRet = true;
        int numVeces = numVecesAEDI(lista, lista.recuperar());
        for (E e : lista) {
            if (numVecesAEDI(lista, e) != numVeces)
                toRet = false;
        }
        return toRet;
    }

    public static <E> int numVecesAEDI(Lista<E> lista, E elem) {
        int toRet = 0;
        for (E e : lista) {
            if (e.equals(elem)) {
                toRet += 1;
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

    public static <E> boolean ordenAscendenteAEDI(Lista<Integer> lista) {
        boolean toRet = true;
        IteradorLista<Integer> it = lista.iteradorLista();
        Integer anterior = it.next();
        while (it.hasNext() && toRet) {
            Integer toComp = it.next();
            if (toComp < anterior) {
                toRet = false;
            }
            anterior = toComp;
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

    public static <E> Lista<E> valoresRepetidosAEDI(Lista<E> lista) {
        Lista<E> toRet = new ListaEnlazada<>();
        for (E e : lista) {
            if(!toRet.contiene(e)){
                /*
                IteradorLista<E> it = lista.iteradorLista();
                int cont = 0;
                while(it.hasNext()){
                    if(e.equals(it.next())){
                        cont++;
                    }
                }
                if(cont > 1){
                    toRet.insertarFinal(e);
                }*/
                if(numVecesAEDI(lista, e) > 1){
                    toRet.insertarFinal(e);
                }
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
            if (add) {
                numVeces1 = 0;
                numVeces2 = 0;
                for (int i = 0; i < l1.size(); i++) {
                    if (elemento == l1.get(i))
                        numVeces1++;
                }
                for (int i = 0; i < l2.size(); i++) {
                    if (elemento == l2.get(i))
                        numVeces2++;
                }
                toRet.add(new Terna<E>(elemento, numVeces1, numVeces2));
            }
        }

        return toRet;
    }

    public static <E> Lista<Terna<E>> generarListaResumenAEDI(Lista<E> l1, Lista<E> l2) {
        Lista<Terna<E>> toRet = new ListaEnlazada<>();
        Lista<E> aux = new ListaEnlazada<>();
        for (E e : l1) {
            aux.insertarFinal(e);
        }
        for (E e : l2) {
            aux.insertarFinal(e);
        }
        boolean add;
        int numVeces1;
        int numVeces2;
        for (E elemento : aux) {
            add = true;
            for (Terna<E> e : toRet) {
                if(e.getElemento().equals(e)){
                    add = false;
                }
            }
            if(add){
                numVeces1 = numVecesAEDI(l1, elemento);
                numVeces2 = numVecesAEDI(l2, elemento);
                toRet.insertarFinal(new Terna<E>(elemento, numVeces1, numVeces2));
            }
        }
        return toRet;
    }
}
