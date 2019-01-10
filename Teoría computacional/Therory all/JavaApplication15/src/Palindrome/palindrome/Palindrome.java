package Palindrome.palindrome;

import Palindrome.forFiles.MyFiles;
import java.util.Random;
import java.util.Scanner;

public class Palindrome {

    /**
     *
     */
    public static final String rules[] = {"0P0", "1P1"};

    public static void main() {
        
            myMain();
    }

    public static final void myMain() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("\nMenú palíndromo");
            System.out.println("Elige una opción");
            System.out.println("1.Modo manual");
            System.out.println("2.Modo automático");
            System.out.println("3.Salir");
            switch (scanner.nextInt()) {
                case 1:
                    manualMode();
                    break;
                case 2:
                    automaticMode();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Esa opción no existe.");
                    break;
            }
        }
    }

    public static final void manualMode() {
        MyFiles file = new MyFiles("palindrome/palindrome.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngresa la dimensión del palíndromo");
        int dimen = scanner.nextInt();
        if (dimen == 0) {
            file.writeSth("e");
        } else if (dimen == 1) {
            System.out.println(rules[0]);
        } else if (dimen == 2) {
            System.out.println(rules[1]);
        } else if (dimen >= 3)
            createPalindrome(dimen);
        file.closeFile();
    }

    public static final void automaticMode() {
        MyFiles file = new MyFiles("palindrome/palindrome.txt");
        int dimen = (int) (Math.random() * 1000);
        System.out.println("El valor elegido es: " + dimen);
        if (dimen == 0) {
            file.writeSth("e");
        } else if (dimen == 1) {
            System.out.println(rules[0]);
        } else if (dimen == 2) {
            System.out.println(rules[1]);
        } else if (dimen >= 3)
            createPalindrome(dimen);
        file.closeFile();
    }

    public static final void createPalindrome(int dimen) {
        MyFiles file = new MyFiles("palindrome/palindrome.txt");
        String str = "P";
        //If the module of half of dimen is not 0 is an odd number
        if (((dimen / 2) % 2) != 0) {
            dimen++;//I add 1 in the dimen variable
        }
        for (int i = 0; i < dimen / 2; i++) {
            str = (i == ((dimen) / 2) - 1) ? str.replace("P", ((int) Math.rint(Math.random()) + "")) : str.replace("P", rules[(int) Math.rint(Math.random())]);
            file.writeSth(str);
        }
        file.closeFile();
    }

}
