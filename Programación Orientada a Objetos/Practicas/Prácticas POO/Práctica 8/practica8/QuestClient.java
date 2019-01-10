import java.rmi.*;
import java.util.*;

  public class QuestClient{
   
    static Scanner entrada= new Scanner(System.in);
   
	public static void main(String s[]){
	System.setSecurityManager(new RMISecurityManager());
	try{
	    Answer a= (Answer)Naming.lookup("resp");
		String pregunta = a.sayAnswer(entrada.nextLine());
		System.out.println("Respuesta desde el servidor: " + pregunta);
	}catch (Exception e){}
   }
 }