package envia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFileChooser;

public class Envia {

    public static void main(String[] args) {
        try {
            DataOutputStream dos = null;
            DataInputStream dis = null;
            Socket cl = null;
            int pto = 1234, n = 0, porcentaje = 0;
            String host = "127.0.0.1";
            JFileChooser jf = new JFileChooser();
            jf.requestFocus();//Obtenemos el foco, mandamos a primer plano el JfileChooser
            jf.setMultiSelectionEnabled(true);
            int r = jf.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                File f[] = jf.getSelectedFiles();
                for(int i = 0; i < f.length; i++){
                    String nombre = f[i].getName();
                    long tam = f[i].length();
                    String path = f[i].getAbsolutePath();
                    int enviados = 0;
                    cl = new Socket(host, pto);
                    System.out.println("Conexión establecida, inicia transferencia del archivo" + path);
                    dos = new DataOutputStream(cl.getOutputStream());
                    dis = new DataInputStream(new FileInputStream(path));
                    dos.writeUTF(nombre);
                    dos.flush();
                    byte[] b = new byte[1500];
                    while (enviados < tam) {
                        n = dis.read(b);
                        enviados += n;
                        dos.write(b, 0, n);
                        dos.flush();
                        porcentaje = (int) ((enviados * 100) / tam);
                        System.out.println("\rx Transmitido el " + porcentaje + "% del archivo");
                    }
                    System.out.println("Archivo transmitido");
                }
                dis.close();
                dos.close();
                cl.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}