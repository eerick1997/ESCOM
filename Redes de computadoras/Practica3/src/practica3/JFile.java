/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author ANDRES
 */
public class JFile {

String pathO="";
String pathD="";

 byte[] readFile() throws IOException{
    InputStream is = null;
    int i=0;

    byte[] buf; 
      
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
                        String path = selectedFile.getAbsolutePath();
                        pathO = selectedFile.getName();
                        long tamanio = selectedFile.length();
                try { 
                        // new input stream created
                        is = new FileInputStream(path);
                        buf= new byte[(int)tamanio];
                        long env=0;
                        // reads till the end of the stream
                        while(env <tamanio) {
                            i = is.read(buf); //copia al arreglo el contenido del archivo.
                            env++;
                        }
                        for (int j=0;j<buf.length;j++){
                            System.out.print((char)buf[j]);
                        }                       
                        return buf;

                    } catch(Exception e) {

                         // if any I/O error occurs
                         e.printStackTrace();
                      } finally {

                         // releases system resources associated with this stream
                         if(is!=null)
                            is.close();
                   }
		}
                return null;
}
 
 byte[] writeFile(byte[] s) throws IOException{
                         OutputStream dos = new FileOutputStream("resultado.pdf");
                    try {                         
                        dos.write(s,0,s.length); //copia al arreglo el contenido del archivo.
                        dos.flush();
                        dos.close();
                    } catch(Exception e) {
                         // if any I/O error occurs
                         e.printStackTrace();
                    }
                return null;
}

void readPDF() throws FileNotFoundException, IOException{
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
                        String path = selectedFile.getAbsolutePath();

        OutputStream oos = new FileOutputStream("test.pdf");

        byte[] buf = new byte[8192];

        InputStream is = new FileInputStream(path);

        int c = 0;
        while ((c = is.read(buf, 0, buf.length)) > 0) {
            oos.write(buf, 0, c);
            oos.flush();
        }
        oos.close();
        System.out.println("stop");
        is.close();
                }
} 
 
String getOriginPath(){
    String aux="";
    int i=0;
    while(pathO.charAt(i)!='.'){
        aux=aux+pathO.charAt(i);
        i++;
    }
    return aux;
}
String getDestinyPath(){
    String aux="";
    int i=0;
    while(pathD.charAt(i)!='.'){
        aux=aux+pathD.charAt(i);
        i++;
    }
    return aux;
}

public static void main(String[] args) throws IOException{
    JFile jf=new JFile();
    //jf.readPDF();
    byte[]result=jf.readFile();
    jf.writeFile(result);
    System.out.println(jf.getOriginPath());
}
}