import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class client {

	String Questions[] = {"Como te llamas",
	"Cual es tu color favorito",
	"Cuantos anos tienes",
	"Cual es tu comida favorita",
	"Cual es tu lugar favorito",
	"Cual es tu musica favorita",
	"Tienes hermanos",
	"Como se llama tu papa",
	"Como se llama tu mama",
	"Que te gusta hacer"},
	Response;

	Socket socket;
	DataOutputStream outputStream;
	DataInputStream inputStream;

	public client(){
		for (int i=0; i<Questions.length; i++) {
			System.out.println("\n"+ (i+1) + "." + Questions[i] + "?");
		}
		Scanner scanner = new Scanner(System.in);
		Response = scanner.nextLine();
	}

	public void connectClient(){
		try{
			socket = new Socket("localhost", 5000);

			outputStream = new DataOutputStream(socket.getOutputStream());
			outputStream.writeUTF(Response);
			inputStream = new DataInputStream(socket.getInputStream());
			
			System.out.println("Server says: " + inputStream.readUTF());

			socket.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		do{
			new client().connectClient();
		} while(true);
	}
}