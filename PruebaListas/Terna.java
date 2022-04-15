package PruebaListas;
public class Terna<E> {
    private E elemento;
    private int numVeces1, numVeces2;

    public Terna(E e, int n1, int n2) {
        elemento = e;
        numVeces1 = n1;
        numVeces2 = n2;
    }

    public E getElemento() {
        return elemento;
    }

    public String toString() {
        return "< " + elemento + " , " + numVeces1 + " , " + numVeces2 + " >";
    }
}