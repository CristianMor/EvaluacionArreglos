import java.util.Scanner;
import java.util.Stack;

public class AlgoritPosfijo{
    public static void main(String args[]){
        
        System.out.println("Escribe una expresion algebraica: ");
        Scanner leer = new Scanner(System.in);

        //Depurar la expresion algebraica
        String expr= depurar(leer.nextLine());
        /*Mediante el metodo Split podemos romper una cadena basada en algunos atributos. En su mayoria este sera un separador o un elemento comun con elque desea dividir la cadena.*/
        String[] arrayInfix = expr.split(" ");

        Stack < String > E = new Stack < String > (); //Pila entrada
        Stack < String > P = new Stack < String > (); //Pila temporal
        Stack < String > S = new Stack < String > ();
        //Anadir el arreglo a la pila de entrada (pilaEntrada)
        for(int i= arrayInfix.length - 1; i>= 0; i--){
            System.out.println("Push valor: "+arrayInfix[i]);
            E.push(arrayInfix[i]);
        }
        
        try{
            System.out.println("Algoritmo Infijo a Posfijo");
            //isEmpty comprueba si la pila esta vacia
            while(!E.isEmpty()){
                System.out.println("Consulta pila vacia: "+ E.isEmpty());
                //peek consulta el primer elemento de la cima de la pila.
                //teclado.readLine();
                for(String pila : E){
                    System.out.println(pila);
                }
                System.out.println("Valor preferencia: "+ pref(E.peek()));
                switch(pref(E.peek())){
                    case 1:
                        //PUSH introduce un elemento en la pila, POP saca un elemento de la pila
                        P.push(E.pop());
                        break;
                    case 3:
                    case 4:
                        while(pref(P.peek()) >= pref(E.peek())){
                            S.push(P.pop());
                        }
                        P.push(E.pop());
                        break;
                    case 2:
                        //equals devuelve true si dos objetos son del mismo tipo y tienen los mismos datos.
                        while(!P.peek().equals("(")){
                            S.push(P.pop());
                        }
                        P.pop();
                        E.pop();
                        break;
                    default:
                        S.push(E.pop());
                }
            }

            //Eliminacion de impurezas en la expresiones algebraicas
            String infix= expr.replace(" ", ""); 
            //replace Devuelve una nueva cadena resultante de reemplazar cada aparicion de caracteres con un nuevo caracter.
            String postfix= S.toString().replaceAll("[\\]\\[,]", "");

            //Muestra resultados:
            System.out.println("Expresion infija: "+infix);
            System.out.println("Expresion posfija: "+postfix);

        }catch(Exception e){
            System.out.println("Error en la expresion algebraica");
            System.err.println(e);
        }
    }

    private static String depurar(String s){
        s= s.replaceAll("\\s+", ""); //Elimina espacios en blanco
        /*El metodo replaceAll() devuelve una cadena que reemplaza toda la secuencia de caracteres que coinciden con la expresion regular y la cadena de reemplazo*/
        s= "(" + s + ")";
        String simbolos= "+-*/()";
        String str="";

        //Deja espacios entre operadores
        for(int i=0; i< s.length(); i++){
            //Contains verifica si String contiene otra subcadena o no. Devuelve un valo booleano.
            if(simbolos.contains("" + s.charAt(i))){
                str += " " + s.charAt(i) + " ";
            }else str += s.charAt(i);
        }
        //.trim() Quita los espacios en blanco en ambos lados de una cadena.
        return str.replaceAll("\\s+", " ").trim();
    }

    private static int pref(String op){
        int prf = 99;
        if(op.equals("^")) prf= 5;
        if(op.equals("*") || op.equals("/")) prf= 4;
        if(op.equals("+") || op.equals("-")) prf= 3;
        if(op.equals(")")) prf= 2;
        if(op.equals("(")) prf= 1;
        return prf;
    }
}
