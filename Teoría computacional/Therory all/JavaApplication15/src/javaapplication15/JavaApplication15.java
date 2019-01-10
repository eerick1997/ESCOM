package javaapplication15;

import RE.generatestrings.GenerateStrings;
import PDA.pushdownautomata.*;
import java.util.Scanner;
import webay.webay_main;

public class JavaApplication15 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\n\nMenú principal");
            System.out.println("Elige un opción");
            System.out.println("1.Web-Ebay");
            System.out.println("2.Ajedrez");
            System.out.println("3.Expresiones regulares");
            System.out.println("4.Palíndromo");
            System.out.println("5.Autómata de pila");
            System.out.println("6.Universo");
            System.out.println("7.Números primos");
            System.out.println("8.Paridad");
            System.out.println("9.Protocolo");
            System.out.println("10.Termina01");
            System.out.println("11.Termina ING");
            System.out.println("12.Lenguajes no ambiguos");
            System.out.println("13.Máquina de turing");
            System.out.println("14.Salir");
            System.out.println("Digita la opción a elegir");
            switch(scanner.nextInt()){
                case 1:
                    new webay_main().main();
                    break;
                case 2:
                    new Chess.chess.Chess().main();
                    break;
                case 3:
                    new GenerateStrings().main();
                    break;
                case 4:
                    new Palindrome.palindrome.Palindrome().main();
                    break;
                case 5:
                    new PushDownAutomata().main();
                    break;
                case 6:
                    new Universe.universe.Universe().main();
                    break;
                case 7:
                    new primeNumbers.prime.numbers.MyMain().display();
                    break;
                case 8:
                    new parity.mysecondautomaton.MySecondAutomaton().main();
                    break;
                case 9:
                    new Protocol.mythirdautomaton.protocol.MyThirdAutomatonProtocol().main();
                    break;
                case 10:
                    new ends01.myfourthautomaton.pkg01.MyFourthAutomaton01().main();
                    break;
                case 11:
                    new endsing.myfirstautomaton.MyFirstAutomaton().main();
                    break;
                case 12:
                    new cgf.CGF().main();
                    break;
                case 13:
                    new turingmachine.TuringMachine().main();
                    break;
                case 14:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Esa opción no existe");
                    break;
            }
        }
    }
}
