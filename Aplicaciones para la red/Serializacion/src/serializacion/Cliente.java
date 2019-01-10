package serializacion;

import java.net.*;
import java.io.*;

public class Cliente {
    
    public static void main(String[] args){
        try{
            int pto = 8888;
            String dst = "127.0.0.1";
            Socket cl = new Socket(dst, pto);
            System.out.println("Conexión establecida... produciendo objeto...");
            Dato d1 = new Dato("Juan", 20, "555555555", 20.5f);
            System.out.println("Se enviará objeto con los datos");
            System.out.println("Nombre: " + d1.getNombre() + " Edad: " + d1.getEdad() + " Telefono: " + d1.getTelefono() + " Sueldo: " 
                    + d1.getSueldo());
            ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
            oos.writeObject(d1);
            Dato d2 = (Dato)ois.readObject();
            System.out.println("Objeto recibido con los datos: = Nombre: " + d1.getNombre() + " Edad: " + d1.getEdad() + " Telefono: " + d1.getTelefono() + " Sueldo: " 
                    + d1.getSueldo());
            ois.close();
            oos.close();
            cl.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

//Si se quiere evitar el envio de un dato en particular solo ponemos transient por ejemplo si lo queremos en el sueldo
//transent float sueldo
/**Si nos envian muchos objetos diferentes usamos la palabra reservada instanceof ejemplo
 Object o = ois.readObject();
 of(o instanceOf Dato1)**/