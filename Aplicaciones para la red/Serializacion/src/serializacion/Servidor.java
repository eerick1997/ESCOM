package serializacion;

import java.net.*;
import java.io.*;

public class Servidor {
    
    public static void main(String[] args){
    
        try{
            int pto = 8888;
            ServerSocket s= new ServerSocket(pto);
            System.out.println("Servidor iniciado... esperando clientes....");
            for(;;){   
                Socket cl = s.accept();
                System.out.println("Cliente conectado desde " + cl.getInetAddress() + ":" + cl.getPort());
                ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
                Dato d1 = (Dato)ois.readObject();
                System.out.println("Objeto recibido con los datos: = Nombre: " + d1.getNombre() + " Edad: " + d1.getEdad() + " Telefono: " + d1.getTelefono() + " Sueldo: " 
                    + d1.getSueldo());
                Dato d2 = new Dato("Pepe", 25, "53333333", 10.8f);
                oos.writeObject(d2);
                oos.flush();
                System.out.println("Objeto enviado");
                ois.close();
                oos.close();
                cl.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
}
