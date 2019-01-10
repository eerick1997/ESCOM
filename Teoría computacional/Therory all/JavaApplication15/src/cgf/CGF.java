package cgf;

import java.util.Scanner;

public class CGF {

    public static final int constant = 1000;
    
    public static void main() {
        boolean flag = true;
        while(flag){
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n\n\nMenú CGF");
            System.out.println("Elige una opción");
            System.out.println("1.Modo manual");
            System.out.println("2.Generar cadena aleatoria");
            System.out.println("3.Lectura de un archivo");
            System.out.println("4.Salir");
            switch(scanner.nextInt()){
                case 1:
                    scanner.nextLine();
                    System.out.println("Escribe solo paréntesis");
                    new expression().evaluateExpression(scanner.nextLine(), 0);
                    break;
                case 2:
                    new expression().evaluateExpression(randomString(), 0);
                    break;
                case 3:
                    scanner.nextLine();
                    new expression().readByFile(scanner.nextLine());
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Esa opción no existe");
                    break;
            }
            
        }
    }
    
    private static String randomString(){
        int random = (int)(Math.random()*constant);
        String str = "";
        System.out.println("Se generará una cadena de longitud: " + random);
        for(int i = 0; i < random; i++){
            if(Math.rint(Math.random()) == 0){
                str += "(";
            } else {
                str += ")";
            }
        }
        System.out.println("La cadena generada es: " + str);
        return str;
    }
}
