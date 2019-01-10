package paquete;

import java.net.*;
import java.io.*;

public class AnuncioSM {
    
    public static void main(String[] args){
        try{
            //pto1 = servidores, pto2 = clientes;
            int pto1 = 1234, pto2 = 5678;
            String dir = "228.1.1.0";//Dirección multicast
            MulticastSocket s = new MulticastSocket(pto1);
            s.setTimeToLive(255);
            s.setReuseAddress(true); //Esa opción si no se pone no funciona el socket
            System.out.println("Servicio de anuncios iniciado...");
            String msj = "Un mensaje multicast";
            byte[] b = msj.getBytes();
            InetAddress gpo = null;
            try{
                gpo = InetAddress.getByName(dir);
            } catch(UnknownHostException ex){
                ex.printStackTrace();
                System.err.println("Dirección multicast no válida");
                System.exit(1);
            }
            s.joinGroup(gpo);
            for(;;){
                DatagramPacket p = new DatagramPacket(b, b.length, gpo, pto2);
                s.send(p);
                try{
                    Thread.currentThread().sleep(1000);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
