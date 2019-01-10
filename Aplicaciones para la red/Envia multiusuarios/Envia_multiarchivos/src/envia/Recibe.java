package envia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Recibe {
    
    public static void main(String[] args){
        try{
            int pto = 1234, n = 0, porcentaje = 0;
            
            ServerSocket s = new ServerSocket(pto);
            System.out.println("Servicio iniciado... esperando archivos");
            for(;;){
                Socket cl = s.accept();
                DataInputStream dis = new DataInputStream(cl.getInputStream());
                String nombre = dis.readUTF();
                long tam = dis.readLong();
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombre));
                System.out.println("Preparando para recibir el archivo: " + nombre + " desde: " + cl.getInetAddress() + " con " + tam + "bytes de datos");
                long recibidos = 0;
                while(recibidos<tam){
                    byte[] b = new byte[1500];
                    n = dis.read(b);
                    recibidos += n;
                    dos.write(b,0,n);
                    dos.flush();
                    porcentaje = (int)((recibidos*100)/(tam));
                }
                System.out.println("Archivo recibido");
                dos.close();
                dis.close();
                cl.close();
            }
            //cl.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

/**Si queremos mandar múltiples archivos
 jf.setMultiSelectionEnabled(true)
 * int r = jf.showOpenDialog(null);
 * if(r == JFileChooser.APPROVE_OPTION){
 *  File[] f = jf.getSelectedFiles();
 *  String nombre = f[i].getName();
 * }
 **/