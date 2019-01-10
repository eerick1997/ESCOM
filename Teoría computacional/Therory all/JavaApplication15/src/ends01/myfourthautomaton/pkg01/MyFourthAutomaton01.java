package ends01.myfourthautomaton.pkg01;

import ends01.Automaton.Automaton;
import ends01.Automaton.Graph;
import java.util.Scanner;

public class MyFourthAutomaton01 {

    public static void main() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        Automaton automaton;
        while (flag) {
            System.out.println("------------------------------------------------");
            System.out.println("Menu");
            System.out.println("Elige una opcion");
            System.out.println("1.Por teclado");
            System.out.println("2.Por archivo");
            System.out.println("3.Salir");

            switch (scanner.nextInt()) {
                case 1:
                    automaton = new Automaton();
                    scanner.nextLine();//Limpiamos el buffer
                    System.out.println("Ingresa la cadena a evaluar");
                    automaton.readByKeyboard(scanner.nextLine());
                    new Graph().graph();
                    automaton.getFileMatrix().closeFile();
                    break;
                case 2:
                    automaton = new Automaton();
                    scanner.nextLine();//Limpiamos el buffer
                    System.out.println("Ingresa la ruta del fichero");
                    automaton.readByFile(scanner.nextLine());
                    new Graph().graph();
                    automaton.getFileMatrix().closeFile();
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
