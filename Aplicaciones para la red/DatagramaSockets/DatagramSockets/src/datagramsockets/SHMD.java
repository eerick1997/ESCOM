package datagramsockets;

import java.net.*;
import java.io.*;

public class SHMD {

    public static void main(String[] args){
        try{
            DatagramSocket s = new DatagramSocket(5678);
            System.out.println("Servicio iniciado... preparando mensaje");
            String msj = "Hola mundo con datagramas";
            byte b[] = msj.getBytes();
            InetAddress dst = null;
            try{
                dst = InetAddress.getByName("localhost");//Si tenemos una IP pública para esta aplicación se cambia aquí
            } catch(UnknownHostException u){
                u.printStackTrace();
            }
            DatagramPacket p = new DatagramPacket(b, b.length, dst, 1234);
            for(;;){
                s.send(p);
                try{
                    Thread.currentThread().sleep(3000);
                } catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
