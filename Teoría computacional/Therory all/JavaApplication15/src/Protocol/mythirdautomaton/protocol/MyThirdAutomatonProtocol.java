package Protocol.mythirdautomaton.protocol;

import Protocol.Automaton.Protocol;
import java.util.Scanner;

public class MyThirdAutomatonProtocol {

    public static void main() {
        boolean flag = true;
        while (flag) {

            Scanner scanner = new Scanner(System.in);
            Protocol protocol;

            System.out.println("-------------------------------------");
            System.out.println("Menu");
            System.out.println("Elige una opcion");
            System.out.println("1.Por teclado");
            System.out.println("2.Por archivo");
            System.out.println("3.Salir");
            switch (scanner.nextInt()) {
                case 1:
                    protocol = new Protocol();
                    scanner.nextLine(); // Cleaning buffer
                    System.out.println("Ingresa la cadena a evaluar");
                    protocol.readByKeyboard(scanner.nextLine());
                    protocol.getHistoryProtocol().closeFile();
                    break;
                case 2:
                    protocol = new Protocol();
                    scanner.nextLine(); // Cleaning buffer
                    System.out.println("Ingresa la ruta del fichero");
                    protocol.readByFile(scanner.nextLine());
                    protocol.getHistoryProtocol().closeFile();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Esa opción no existe");
                    break;
            }
        }
    }
}
