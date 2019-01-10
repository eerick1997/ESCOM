package Chess.chess;

import Chess.forAutomaton.Automaton;
import Chess.forAutomaton.Path;
import Chess.forFiles.MyFiles;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Chess {

    public static void main() {

        boolean flag = true;
        final String FILE_ACCEPTED = "Chess/accepted_combinations.txt",
                FILE_TRANSITIONS = "transitions.txt";

        MyFiles acceptedPath = new MyFiles(FILE_ACCEPTED);
        MyFiles transitions = new MyFiles(FILE_TRANSITIONS);
        while (flag) {
            Scanner scanner = new Scanner(System.in);

            Path path = new Path();
            path.addMove("q1");

            System.out.println("\nAjedrez");
            System.out.println("\nElige alguna opción");
            System.out.println("1.Entrada estandar");
            System.out.println("2.Leer un archivo");
            System.out.println("3.Combinación aleatoria");
            System.out.println("4.Salir");
            switch (scanner.nextInt()) {
                case 1:
                    scanner.nextLine();
                    acceptedPath = new MyFiles(FILE_ACCEPTED);
                    transitions = new MyFiles(FILE_TRANSITIONS);
                    System.out.println("Digita una combinación que contenga los caracteres r o b");
                    new Automaton(path, "q1", acceptedPath, transitions, scanner.nextLine(), 0);
                    acceptedPath.closeFile();
                    transitions.closeFile();
                    readFile(FILE_ACCEPTED);
                    break;
                case 2:
                    acceptedPath = new MyFiles(FILE_ACCEPTED);
                    transitions = new MyFiles(FILE_TRANSITIONS);
                    System.out.println("Ingresa la ruta del archivo a leer");
                    scanner.nextLine();
                    String strr = readFileCombinations(scanner.nextLine()).trim();
                    System.out.println("El sistema eligió: " + strr);
                    new Automaton(path, "q1", acceptedPath, transitions, strr, 0);
                    acceptedPath.closeFile();
                    transitions.closeFile();
                    
                    readFile(FILE_ACCEPTED);
                    break;
                case 3:
                    String str = generateString();
                    System.out.println("El sistema selecciono la cadena: " + str);
                    acceptedPath = new MyFiles(FILE_ACCEPTED);
                    transitions = new MyFiles(FILE_TRANSITIONS);
                    new Automaton(path, "q1", acceptedPath, transitions, str, 0);
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    private static String generateString() {
        String str = "";
        for (int i = 0; i < Math.random() * 1000; i++) {
            if (Math.rint(Math.random()) == 0)//Concat b
            {
                str += "b";
            } else //Concat r
            {
                str += "r";
            }
        }
        return str;
    }

    private static void readFile(String path) {
        Path toChessBoard = new Path();
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
        toChessBoard.copyPath("Combinación seleccionada: " + (list.get((int) (Math.random() * list.size()))));
        new ChessBoard(toChessBoard);
    }
    
        private static String readFileCombinations(String path) {
        ArrayList<String> list = new ArrayList<>();
        String str = "";
        try {
            FileReader fileReader = new FileReader(path);
            int character = fileReader.read();

            while (character != -1) {
                if (character == '\n') {
                    if(!str.isEmpty())
                        list.add(str);
                    str = "";
                } else {
                    str += (char)character;
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
        return list.get((int)(Math.random()*list.size()));
    }
}
