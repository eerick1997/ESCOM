package pkg01practica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Client {

    private static final String default_path = "c:\\Users\\Erick\\Documentos";
    private File folder = new File(default_path);
    private String name = "", extension  = "";
    public Client(String name, String extension){
        this.name = name;
        this.extension = extension;
    }
    

    public void Upload() {
        /**To upload to server**/
        int port = 5533, porcentaje = 0, n = 0;
        String host = "localhost";
        if(!folderExists())
            folder.mkdir();
        try {
            Socket socket = null;
            DataOutputStream dataOutputStream = null;
            DataInputStream dataInputStream = null;
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.requestFocus();
            jFileChooser.setMultiSelectionEnabled(true);
            int r = jFileChooser.showOpenDialog(null);
            if(r == JFileChooser.APPROVE_OPTION){
                File f[] = jFileChooser.getSelectedFiles();
                for(int i = 0; i < f.length; i++){
                    String name = f[i].getName();
                    long tam = f[i].length();
                    String path = f[i].getAbsolutePath();
                    int enviados = 0;
                    socket = new Socket(host, port);
                    System.out.println("Connected with server, uploading file " + path);
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataInputStream = new DataInputStream(new FileInputStream(path));
                    dataOutputStream.writeUTF(name);
                    dataOutputStream.flush();
                    byte[] b = new byte[1500];
                    while(enviados<tam){
                        n = dataInputStream.read(b);
                        enviados += n;
                        dataOutputStream.write(b, 0, n);
                        dataOutputStream.flush();
                        porcentaje = (int)((enviados * 100) / tam);
                        System.out.println("\rProgress: " + porcentaje + "% ");
                    }
                    System.out.println("File transmited");
                }
                dataOutputStream.close();
                dataInputStream.close();
                socket.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al conectar con el servidor...", "Error", JOptionPane.ERROR);
            System.err.println("Error in class client: " + e);
        }
        
    }
    
    public void Download(){
        
    }
    
    public boolean folderExists(){
        return folder.exists() && folder.isDirectory();
    }

}
