package pkg01practica;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    @Override
    public void run() {
        try{
            int port = 5533, n = 0, porcentaje = 0;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Starting servic... waiting files");
            for(;;){
                Socket socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String name = dataInputStream.readUTF();
                long tam = dataInputStream.readLong();
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(name));
                System.out.println("Preparing to reveive " + name + " from: " + socket.getInetAddress() + " size " + tam + " bytes");
                long recibidos = 0;
                while(recibidos < tam){
                    byte[] b = new byte[1500];
                    n = dataInputStream.read(b);
                    recibidos += n;
                    dataOutputStream.write(b,0,n);
                    dataOutputStream.flush();
                    porcentaje = (int)((recibidos * 100) / tam);
                }
                System.out.println("Received");
                dataOutputStream.close();
                dataInputStream.close();
                socket.close();
                        
            }
        } catch (Exception e){
            System.err.println(e);
        }
    }
    
    
}
