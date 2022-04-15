package PruebaColas;

import java.util.ArrayDeque;
import java.util.Queue;

public class PruebaColas {
    public static void main(String[] args) {
    }

    public static <E> void concatenar(Queue<E> q1, Queue<E> q2) {
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    public static <E> Queue<E> barajar(Queue<E> q1, Queue<E> q2) {
        Queue<E> toRet = new ArrayDeque<>();
        while (!(q1.isEmpty() && q2.isEmpty())) {
            if (!q1.isEmpty())
                toRet.add(q1.remove());
            if (!q2.isEmpty())
                toRet.add(q2.remove());
        }
        return toRet;
    }

    public static <E> Queue<E> copiar(Queue<E> q) {
        Queue<E> toRet = new ArrayDeque<>();
        for (int i = 0; i < q.size(); i++) {
            E toCopy = q.remove();
            toRet.add(toCopy);
            q.add(toCopy);
        }
        return toRet;
    }

    public static Queue<Integer> mezcla(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> toRet = new ArrayDeque<>();
        Queue<Integer> aux1 = new ArrayDeque<>();
        Queue<Integer> aux2 = new ArrayDeque<>();
        int aux;
        aux1.addAll(q1);
        aux2.addAll(q2);
        while (!(aux1.isEmpty() && aux2.isEmpty())) {
            if (aux1.isEmpty() || !aux2.isEmpty() && aux1.peek() > aux2.peek()) {
                aux = aux2.remove();
                toRet.add(aux);
            } else if (aux2.isEmpty() || !aux1.isEmpty() && aux1.peek() < aux2.peek()) {
                aux = aux1.remove();
                toRet.add(aux);
            } else {

                aux = aux1.remove();
                aux2.remove();
                toRet.add(aux);

            }
        }
        return toRet;
    }

    public static <E> boolean iguales(Queue<E> q) {
        boolean toRet = true;
        E aux = q.peek();
        for (int i = 0; i < q.size(); i++) {
            if (!q.peek().equals(aux)) {
                toRet = false;
            }
            q.add(q.remove());
        }
        return toRet;
    }
}
