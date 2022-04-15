package PruebaPilas;

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
}
