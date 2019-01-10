package datagramsockets;

import java.io.*;
import java.net.*;

public class CHMD {
    public static void main(String[] args){
        try{
            DatagramSocket cl = new DatagramSocket(1234);
            System.out.println("Cliente iniciado, escuchando anuncios");
            for(;;){
                //Tamaño máximo de un datagrama es de 65535 bytes
                DatagramPacket p = new DatagramPacket(new byte[65535],65535);
                cl.receive(p);
                //0 es la posición desde donde va a leer
                String msj = new String(p.getData(),0,p.getLength());
                System.out.println("Mensaje recibido desee " + p.getAddress() + ":" + p.getPort() + " con el mensaje: " + msj);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

/***Si queremos manejar objetos suponiendo que tenemos un objeto tipo Dato
 * Dato d = new Dato(parametros);1
 * ByteArrayOutputStream baos = new ByteArrayOutputStream();
 * ObjectOutputStream oos = new ObjectOutputStream(baos);
 * oos.writeObject(d);
 * oos.flush();
 * byte[] b = baos.toByteArray();
 * DatagramPacket p = new DatagramPacket(b, b.lenth, dst, 9999);
--------------------------------Para recibir------------------------------------
* s.receive(p);
* ObjectInpitStream ois = new ObjectInputStream(new ByteArrayInputStream(p.getData()));
* Datp d2 = (Dato)ois.readObject();
 **/