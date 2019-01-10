package mysecondautomaton;

import MyAutomaton.Automaton;
import MyAutomaton.Graph;
import java.util.Scanner;


public class MySecondAutomaton {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
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
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
