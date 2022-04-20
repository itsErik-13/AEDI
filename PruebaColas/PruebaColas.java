package PruebaColas;

import cola.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class PruebaColas {
    public static void main(String[] args) {
        Cola<Integer> q1 = new EnlazadaCola<>();
        Cola<Integer> q2 = new EnlazadaCola<>();
        for (int i = 0; i < 10; i++) {
            q1.insertar(i);
        }
        //System.out.println(igualesAEDI(q1));
        Cola<Integer> result = mezcla2AEDI(q2, q1);
        while(!result.esVacio()){
            System.out.print(result.suprimir() + " ");
        }

    }

    public static <E> void concatenar(Queue<E> q1, Queue<E> q2) {
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }
    public static <E> void concatenarAEDI(Cola<E> q1, Cola<E> q2) {
        while (!q2.esVacio()) {
            q1.insertar(q2.suprimir());
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

    public static <E> Cola<E> barajarAEDI(Cola<E> q1 , Cola<E> q2){
        Cola<E> toRet = new EnlazadaCola<>();
        while(!(q1.esVacio() && q2.esVacio())){
            if(!q1.esVacio()){
                toRet.insertar(q1.suprimir());
            }
            if(!q2.esVacio()){
                toRet.insertar(q2.suprimir());
            }
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

    public static <E> Cola<E> copiarAEDI(Cola<E> q){
        Cola<E> toRet = new EnlazadaCola<>();
        int tam = q.tamaño();
        for (int i = 0; i < tam; i++) {
            E toCopy = q.suprimir();
            toRet.insertar(toCopy);
            q.insertar(toCopy);
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

    public static Cola<Integer> mezclaAEDI(Cola<Integer> q1, Cola<Integer> q2) {
        Cola<Integer> toRet = new EnlazadaCola<>();
        Cola<Integer> aux1 = new EnlazadaCola<>();
        Cola<Integer> aux2 = new EnlazadaCola<>();
        int aux;
        for (int i = 0; i < q1.tamaño(); i++) {
            Integer toCopy = q1.suprimir();
            aux1.insertar(toCopy);
            q1.insertar(toCopy);
        }
        for (int i = 0; i < q2.tamaño(); i++) {
            Integer toCopy = q2.suprimir();
            aux2.insertar(toCopy);
            q2.insertar(toCopy);
        }
        while (!(aux1.esVacio() && aux2.esVacio())) {
            if (aux1.esVacio() || !aux2.esVacio() && aux1.primero() > aux2.primero()) {
                aux = aux2.suprimir();
                toRet.insertar(aux);
            } else if (aux2.esVacio() || !aux1.esVacio() && aux1.primero() < aux2.primero()) {
                aux = aux1.suprimir();
                toRet.insertar(aux);
            } else {
                aux = aux1.suprimir();
                aux2.suprimir();
                toRet.insertar(aux);
            }
        }
        return toRet;
    }

    public static Queue<Integer> mezcla2(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> toRet = new ArrayDeque<>();
        int aux = Integer.MIN_VALUE;
        while (aux < q1.peek() || aux < q2.peek()) {
            if (aux > q1.peek() ||(aux < q2.peek() && q2.peek() < q1.peek())) {
                aux = q2.remove();
                toRet.add(aux);
                q2.add(aux);
            } else if (aux > q2.peek() || (aux < q1.peek() && q1.peek() < q2.peek())) {
                aux = q1.remove();
                toRet.add(aux);
                q1.add(aux);
            } else {
                aux = q2.remove();
                q1.remove();
                toRet.add(aux);
                q2.add(aux);
                q1.add(aux);
            }
        }
        return toRet;
    }

    public static Cola<Integer> mezcla2AEDI(Cola<Integer> q1, Cola<Integer> q2) {
        Cola<Integer> toRet;
        int aux = Integer.MIN_VALUE;
        if(q1.esVacio() && q2.esVacio()){
            toRet = new EnlazadaCola<>();
        }else if(q1.esVacio()){
            toRet = copiarAEDI(q2);
        }else if(q2.esVacio()){
            toRet = copiarAEDI(q1);
        }else{
            toRet = new EnlazadaCola<>();
            while (aux < q1.primero() || aux < q2.primero()) {
                if (aux > q1.primero() || (aux < q2.primero() && q2.primero() < q1.primero())) {
                    aux = q2.suprimir();
                    toRet.insertar(aux);
                    q2.insertar(aux);
                } else if (aux > q2.primero() || (aux < q1.primero() && q1.primero() < q2.primero())) {
                    aux = q1.suprimir();
                    toRet.insertar(aux);
                    q1.insertar(aux);
                } else {
                    aux = q2.suprimir();
                    q1.suprimir();
                    toRet.insertar(aux);
                    q2.insertar(aux);
                    q1.insertar(aux);
                }
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

    public static <E> boolean igualesAEDI(Cola<E> q){
        boolean toRet = true;
        int tam = q.tamaño();
        E aux = q.primero();
        for(int i = 0; i < tam && toRet; i++){
            if(q.primero() != aux)
                toRet = false;
            q.insertar(q.suprimir());
        }
        return toRet;
    }
}
