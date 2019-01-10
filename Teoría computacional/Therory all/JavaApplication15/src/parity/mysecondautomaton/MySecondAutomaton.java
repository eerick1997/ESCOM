package parity.mysecondautomaton;

import parity.MyAutomaton.Automaton;
import parity.MyAutomaton.Graph;
import java.util.Scanner;


public class MySecondAutomaton {

    public static void main() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while(flag){
            System.out.println("-------------------------------------");
            System.out.println("Menu");
            System.out.println("Elige una opcion");
            System.out.println("1.Por teclado");
            System.out.println("2.Por archivo");
            System.out.println("3.Generar una cadena aleatoria");
            System.out.println("4.Salir");
            switch(scanner.nextInt()){
                case 1:
                    scanner.nextLine();//Limpiamos el buffer
                    System.out.println("Ingresa la cadena a evaluar");
                    new Automaton().readByKeyboard(scanner.nextLine());
                    new Graph().graph();
                    break;
                case 2:
                    scanner.nextLine(); //Limpiamos el buffer
                    System.out.println("Ingresa la ruta del fichero");
                    new Automaton().readByFile(scanner.nextLine());
                    new Graph().graph();
                    break;
                case 3:
                    new Automaton().readByKeyboard(new Automaton().generateBinaryString());
                    new Graph().graph();
                    break;
                case 4:
                    flag  = false;
                    break;
                default:
                    System.out.println("Esa opción no existe");
                    break;
            }
        }
    }
}
