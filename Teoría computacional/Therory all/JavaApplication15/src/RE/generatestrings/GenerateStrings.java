package RE.generatestrings;

import RE.String.TypeOne;
import RE.String.TypeTwo;
import java.util.Scanner;

public class GenerateStrings {

    public static void main() {
        boolean flag = true; 
       while(flag){
           Scanner scanner = new Scanner(System.in);
           System.out.println("Generar cadenas");
           System.out.println("Elige una opción");
           System.out.println("1.(0+10)*(e+1)");
           System.out.println("2.[(10)*0 + 1(01)*1] [0(01)*(1+00) + 1(10)*(0+11)]*");
           System.out.println("3.Salir");
           switch(scanner.nextInt()){
               case 1:
                   new TypeOne();
                   break;
               case 2:
                   new TypeTwo();
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
