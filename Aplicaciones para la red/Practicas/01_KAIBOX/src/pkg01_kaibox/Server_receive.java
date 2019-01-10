package pkg01_kaibox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class Server_receive implements Runnable{
    
    private Socket socket;
    private static final String path = "C:\\Users\\Erick\\Documents\\ESCOM\\Aplicaciones para la red\\Practicas\\01_KAIBOX\\KaiBox";
    
    public Server_receive(Socket socket){
        System.out.println("pkg01_kaibox.Server_receive.<init>()");
        this.socket = socket;
        Thread thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run(){
        System.out.println("pkg01_kaibox.Server_receive.run()");
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        
        try{
           dataInputStream = new DataInputStream(socket.getInputStream());
           String name_file = dataInputStream.readUTF();
           long size = dataInputStream.readLong();
           
           dataOutputStream = new DataOutputStream(new FileOutputStream(path+"\\"+name_file));
           System.out.println("Preparing to receive " + name_file + " from " + socket.getInetAddress() + " size " + size + " bytes");
           long received = 0;
           byte[] bytes = new byte[1500];
           int n = 0;
           while((n = dataInputStream.read(bytes)) > 0){
               dataOutputStream.write(bytes,0,n);
               received += n;
               dataOutputStream.flush();
               System.out.println("\r" + ((received*100)/size) + "% received " + received + " total size " + size + "bytes readed " + n + "bytes");
           }
            System.out.println("Received");
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch(Exception e){
            System.err.println("An error has occurred in Server_receive class :C");
            e.printStackTrace();
        }
    }
}
