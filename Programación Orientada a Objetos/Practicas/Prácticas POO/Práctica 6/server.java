import java.net.*;
import java.io.*;
import java.awt.*;

public class server {

	public static void main(String args[]) {
		Socket client;
		DataOutputStream outputSream;
		DataInputStream inputStream;
		ServerSocket serverSocket;

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

		Answers[] = {"Erick Efrain",
		"Negro", "19", "Los tacos", "Mi habitacion", 
		"Rock", "Si", "Efrain", "Mireya",
		"En mi tiempo libre suelo dormir"};

		try{
			serverSocket = new ServerSocket(5000);
			System.out.println("Waiting for a connection");

			while(true){
				client = serverSocket.accept();
				System.out.println("Client connected");
				outputSream = new DataOutputStream(client.getOutputStream());
				inputStream = new DataInputStream(client.getInputStream());
				String request = inputStream.readUTF();

				for (int i=0; i<Questions.length; i++) {
					if (request.equals(Questions[i])) 
						outputSream.writeUTF(Answers[i]);
				}

				System.out.println("Closing connection");
				client.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}