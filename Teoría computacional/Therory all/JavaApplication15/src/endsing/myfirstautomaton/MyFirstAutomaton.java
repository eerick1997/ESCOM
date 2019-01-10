package endsing.myfirstautomaton;

import endsing.Automaton.Graph;
import java.util.Scanner;

public class MyFirstAutomaton {

    public static void main() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while(flag){
            System.out.println("------------------------------------------------");
            System.out.println("Menu");
            System.out.println("Elige una opcion");
            System.out.println("1.Por teclado");
            System.out.println("2.Por archivo");
            System.out.println("3.Salir");
            
            switch(scanner.nextInt()){
                case 1:
                    scanner.nextLine();//Limpiamos el buffer
                    System.out.println("Ingresa la cadena a evaluar");
                    new endsing.Automaton.Automaton().readByKeyboard(scanner.nextLine());
                    new Graph().graph();
                    break;
                case 2:
                    scanner.nextLine();//Limpiamos el buffer
                    System.out.println("Ingresa la ruta del fichero");
                    new endsing.Automaton.Automaton().readByFile(scanner.nextLine());
                    new Graph().graph();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.err.println("Esa opción no existe");
                    break;
            }
        }
    }
}
