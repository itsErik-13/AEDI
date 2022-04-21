package PruebaPilas;

import pila.*;
import java.util.Stack;

public class PruebaPilas {
    public static void main(String[] args) {
        
    }
    public static String codificar (String mensaje){
        String toRet = "";
        Stack<Character> aux = new Stack<>();
        Character examine;
        for (int i = 0; i < mensaje.length(); i++) {
            examine = mensaje.charAt(i);
            switch(examine){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                while(!aux.isEmpty()){
                    toRet += aux.pop();
                }
                toRet += examine;
                break;
                default:
                aux.push(examine);
                break;
            }
        }
        while(!aux.isEmpty()){
            toRet+=aux.pop();
        }
        return toRet;
    }

    public static String codificarAEDI(String mensaje){
        String toRet = "";
        Pila<Character> aux = new EnlazadaPila<>();
        Character examine;
        for (int i = 0; i < mensaje.length(); i++) {
            examine = mensaje.charAt(i);
            switch(examine){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                while(!aux.esVacio()){
                    toRet += aux.pop();
                }
                toRet += examine;
                break;
                default:
                aux.push(examine);
                break;
            }
        }
        while(!aux.esVacio()){
            toRet+=aux.pop();
        }
        return toRet;
    }

    public static <E> E desapilarElemento (Stack<E> p, int n) throws IllegalArgumentException{
        E toRet;
        if(n < 0||n >= p.size()) throw new IllegalArgumentException();
        Stack<E> aux = new Stack<>();
        for (int i = 0; i < n ; i++) {
            aux.add(p.pop());
        }
        toRet = p.pop();
        while(!aux.isEmpty()){
            p.add(aux.pop());
        }
        return toRet;
    }

    public static <E> E desapilarElementoAEDI (Pila<E> p, int n) throws IllegalArgumentException{
        E toRet;
        if(n < 0||n >= p.tamaño()) throw new IllegalArgumentException();
        Pila<E> aux = new EnlazadaPila<>();
        for (int i = 0; i < n ; i++) {
            aux.push(p.pop());
        }
        toRet = p.pop();
        while(!aux.esVacio()){
            p.push(aux.pop());
        }
        return toRet;
    }

    public static String convertir (int numero){
        String toRet = "";
        Stack<Integer> p = new Stack<>();
        while(numero/2 >= 1){
            p.add(numero%2);
            numero = numero/2;
        }
        p.add(numero);
        while(!p.isEmpty()){
            toRet+=p.pop();
        }
        return toRet;
    }

    public static String convertirAEDI (int numero){
        String toRet = "";
        Pila<Integer> p = new EnlazadaPila<>();
        while(numero/2 >= 1){
            p.push(numero%2);
            numero = numero/2;
        }
        p.push(numero);
        while(!p.esVacio()){
            toRet+=p.pop();
        }
        return toRet;
    }

    public static boolean esCorrecto(String exp){
        boolean toRet = true;
        final String OPENING_DICC = "[{(" ;
        final String CLOSING_DICC = "]})";
        Stack<Character> aux = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            for (int j = 0; j < OPENING_DICC.length(); j++) {
                if(exp.charAt(i) == OPENING_DICC.charAt(j)){
                    aux.push(OPENING_DICC.charAt(j));
                }
                if(exp.charAt(i) == CLOSING_DICC.charAt(j)){
                    if(aux.isEmpty()|| aux.pop()!=OPENING_DICC.charAt(j))
                        toRet=false;
                }
            }
        }
        return toRet && aux.isEmpty();
    }

    public static boolean esCorrectoAEDI(String exp){
        boolean toRet = true;
        final String OPENING_DICC = "[{(" ;
        final String CLOSING_DICC = "]})";
        Pila<Character> aux = new EnlazadaPila<>();
        for (int i = 0; i < exp.length(); i++) {
            for (int j = 0; j < OPENING_DICC.length(); j++) {
                if(exp.charAt(i) == OPENING_DICC.charAt(j)){
                    aux.push(OPENING_DICC.charAt(j));
                }
                if(exp.charAt(i) == CLOSING_DICC.charAt(j)){
                    if(aux.esVacio()|| aux.pop()!=OPENING_DICC.charAt(j))
                        toRet=false;
                }
            }
        }
        return toRet && aux.esVacio();
    }
}
