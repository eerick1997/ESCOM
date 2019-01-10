package webay;

import webay.Files.MyFile;
import webay.Graph.GraphWebay;
import java.util.Scanner;
import webay.Automata.Automata;

public class webay_main {
    public static void main() {
        boolean flag = true;
        Automata automata;

        final String FILE_TRANS = "webay/transitions.txt", FILE_WORDS = "webay/words.txt";

        while (flag) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nWeb - ebay");
            System.out.println("\nElige una opción");
            System.out.println("\n1. Entrada estandar");
            System.out.println("\n2. Cargar archivo");
            System.out.println("\n3. Salir");
            switch (scanner.nextInt()) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Digita alguna o algunas palabras");
                    automata = new Automata(new MyFile(FILE_TRANS), new MyFile(FILE_WORDS));
                    automata.standardInput(scanner.nextLine());
                    new GraphWebay().graph();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Digita la ruta del archivo de texto");
                    automata = new Automata(new MyFile(FILE_TRANS), new MyFile(FILE_WORDS));
                    automata.readFile(scanner.nextLine());
                    new GraphWebay().graph();
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
