package PDA.pushdownautomata;

import PDA.UI.UI;
import PDA.forFiles.MyFiles;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PushDownAutomata {

    public static void main() {
        myMain();
    }
    
    public static void myMain(){
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while(flag){
            System.out.println("\nAutomata de pila:");
            System.out.println("Elige una opción");
            System.out.println("1.Entrada manual");
            System.out.println("2.Lectura de un archivo");
            System.out.println("3.Salir");
            switch(scanner.nextInt()){
                case 1:
                    scanner.nextLine();
                    System.out.println("Escribe una expresión binaria");
                    new UI(scanner.nextLine(), new MyFiles("PushDown/expression.txt")).setVisible(true);
                    break;
                case 2:
                    scanner.nextLine();
                    readFile(scanner.nextLine());
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Esta opción no existe");
                    break;
            }
        }
    }
    
    private static void readFile(String path) {
        ArrayList<String> list = new ArrayList<>();
        String str = "";
        try {
            FileReader fileReader = new FileReader(path);
            int character = fileReader.read();

            while (character != -1) {
                if (character == '\n') {
                    list.add(str);
                    str = "";
                } else {
                    str += (char) character;
                }
                character = fileReader.read();
            }

            character = fileReader.read();
            if (character == '\n') {
                list.add(str);
                str = "";
            } else {
                str += character;
            }
            fileReader.close();
        } catch (Exception e) {
            System.err.println("Error reading file: " + path);
            System.err.println(e);
        }
        new UI(list.get((int)(Math.random()*list.size())), new MyFiles("PushDown/expression.txt")).setVisible(true);
    }
    
}
