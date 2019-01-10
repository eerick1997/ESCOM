/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.ByteBuffer;  
import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;  
  
import org.jnetpcap.Pcap;  
import org.jnetpcap.PcapAddr;
import org.jnetpcap.PcapBpfProgram;
import org.jnetpcap.PcapIf;  
import org.jnetpcap.PcapSockAddr;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
  
public class Envia {
    
    private static String asString(final byte[] mac) {
    final StringBuilder buf = new StringBuilder();
    for (byte b : mac) {
      if (buf.length() != 0) {
        buf.append(':');
      }
      if (b >= 0 && b < 16) {
        buf.append('0');
      }
      buf.append(Integer.toHexString((b < 0) ? b + 256 : b).toUpperCase());
    }

    return buf.toString();
  }
    
    
  public static void main(String[] args) throws IOException {  
    List<PcapIf> alldevs = new ArrayList<PcapIf>(); // Will be filled with NICs  
    StringBuilder errbuf = new StringBuilder(); // For any error msgs  
    String ip_interfaz="";
   /***************************************************************************
		 * First get a list of devices on this system
		 **************************************************************************/
                
                /*abrimos el filechooser para el mensaje a enviar*/
                JFile jf=new JFile();
                byte[] mensaje=jf.readFile();
                
                //int identificador=counter.id;
                ///int id=0;
    
		int r = Pcap.findAllDevs(alldevs, errbuf);
		if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
			System.err.printf("Can't read list of devices, error is %s", errbuf
			    .toString());
			return;
		}

		System.out.println("Dispositivos encontrados:");
		int i = 0;
                try{
		for (PcapIf device : alldevs) {
			String description =
			    (device.getDescription() != null) ? device.getDescription()
			        : "No description available";
                        final byte[] mac = device.getHardwareAddress();
			String dir_mac = (mac==null)?"No tiene direccion MAC":asString(mac);
                        System.out.printf("\n#%d: %s [%s] MAC:[%s]\n", i++, device.getName(), description, dir_mac);
                        Iterator<PcapAddr> it = device.getAddresses().iterator();
                        while(it.hasNext()){
                            PcapAddr dir = it.next();//dir, familia, mascara,bc
                            PcapSockAddr direccion =dir.getAddr();
                            byte[]d_ip = direccion.getData();
                            int familia=direccion.getFamily();
                            int[]ipv4 = new int[4];
                            if(familia==org.jnetpcap.PcapSockAddr.AF_INET){
                                ipv4[0]=((int)d_ip[0]<0)?((int)d_ip[0])+256:(int)d_ip[0];
                                ipv4[1]=((int)d_ip[1]<0)?((int)d_ip[1])+256:(int)d_ip[1];
                                ipv4[2]=((int)d_ip[2]<0)?((int)d_ip[2])+256:(int)d_ip[2];
                                ipv4[3]=((int)d_ip[3]<0)?((int)d_ip[3])+256:(int)d_ip[3];
                                
                                System.out.println("\nIP4->"+ipv4[0]+"."+ipv4[1]+"."+ipv4[2]+"."+ipv4[3]);
                            }else if(familia==org.jnetpcap.PcapSockAddr.AF_INET6){
                                System.out.print("\nIP6-> ");
                                for(int z=0;z<d_ip.length;z++)
                                    System.out.printf("%02X:",d_ip[z]);
                            }//if
                        }//while
		}//for
                }catch(IOException io){
                  io.printStackTrace();
                }//catch
   try{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("\nElije la interfaz de red:");
       int interfaz = Integer.parseInt(br.readLine());
       PcapIf device = alldevs.get(interfaz); // We know we have atleast 1 device  
       /******************************************************/
        Iterator<PcapAddr> it1 = device.getAddresses().iterator();
        while(it1.hasNext()){
         PcapAddr dir = it1.next();//dir, familia, mascara,bc
         PcapSockAddr direccion1 =dir.getAddr();
         byte[]d_ip = direccion1.getData(); //esta sera la ip origen
         int familia=direccion1.getFamily();
         int[]ipv4_1 = new int[4];
         if(familia==org.jnetpcap.PcapSockAddr.AF_INET){
            ipv4_1[0]=((int)d_ip[0]<0)?((int)d_ip[0])+256:(int)d_ip[0];
            ipv4_1[1]=((int)d_ip[1]<0)?((int)d_ip[1])+256:(int)d_ip[1];
            ipv4_1[2]=((int)d_ip[2]<0)?((int)d_ip[2])+256:(int)d_ip[2];
            ipv4_1[3]=((int)d_ip[3]<0)?((int)d_ip[3])+256:(int)d_ip[3];
            ip_interfaz = ipv4_1[0]+"."+ipv4_1[1]+"."+ipv4_1[2]+"."+ipv4_1[3];  
            System.out.println("\nInterfaz que se usara:"+ip_interfaz);
        }
        }
       /******************************************************/
       System.out.print("MAC ORIGEN: ");   
       byte[] MACo = device.getHardwareAddress();
       for(int j=0;j<MACo.length;j++)
       System.out.printf("%02X ",MACo[j]); 
        
    /***************************************** 
     * Second we open a network interface 
     *****************************************/  
        int snaplen = 64 * 1024; // Capture all packets, no trucation  
        int flags = Pcap.MODE_PROMISCUOUS; // capture all packets  
        int timeout = 10 * 1000; // 10 seconds in millis  
        Pcap pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout, errbuf);  

    
    /********F I L T R O********/
            PcapBpfProgram filter = new PcapBpfProgram();
            String expression ="ether proto 0x1601"; // "port 80";
            int optimize = 0; // 1 means true, 0 means false
            int netmask = 0;
            int r2 = pcap.compile(filter, expression, optimize, netmask);
            if (r2 != Pcap.OK) {
                System.out.println("Filter error: " + pcap.getErr());
            }//if
            pcap.setFilter(filter);
            
    
    byte[] trama = new byte[1280];
   
    for(int k=0;k<MACo.length;k++){ //mc destino y origen
        trama[k] = (byte) 0xff;
        trama[k+6]=MACo[k];
    }
       
    trama[12]= (byte) 0x16; //tipo sin asignar
    trama[13]= (byte) 0x01; //tipo sin asignar rfc 1340 
    trama[14]=(byte)2; //destino
    trama[15]=(byte)1; //origen
    /*nombre del archivo*/
    System.out.println("");
    System.out.println("PATH: "+jf.getOriginPath()+ " ,tamanio: "+jf.getOriginPath().length());
    byte bpath[]=jf.getOriginPath().getBytes();
    //caso en que el nombre sea mas corto de 20 bytes
    if(bpath.length < 20){
        
        //variable aux
        int aux=16;
        //lenamos con el tamaño del archivp
        for(int j=0;j<bpath.length;j++){
            trama[16+j]=bpath[j];
            aux++;
        }
        System.out.println("aux "+aux);
        for(int j=aux;j<36;j++){
            trama[j]=(byte)0;     
        }
    }
    /*si es mas largo de 20 bytes*/
    else{
        for(int j=0;j<20;j++){
            trama[16+j]=bpath[j];
        }
    }
    Counter countersec=new Counter(1);
    Counter counterack=new Counter(0);
    Counter countermsj=new Counter(0); 
    
    byte sec=(byte)countersec.id;
    
                                System.out.println("no. sec: "+sec);
                                trama[36]=sec;
                                countersec.incrementa(1);
                                
                                byte ack=(byte)counterack.id;
                                System.out.println("no. acuse: "+ack);
                                trama[37]=ack;
                                counterack.incrementa(1);
                                
                                System.out.println("Tamaño del mensaje:" +mensaje.length);  
                                //si el mensaje se manda en un solo paquete
                                
                                if(mensaje.length < 1200){
                                    //variable aux
                                    int aux=38;
                                    //llenamos con el tamaño del archivo
                                    for(int j=0;j<mensaje.length;j++){
                                        trama[38+j]=mensaje[j];
                                        aux++;
                                        countermsj.incrementa(1);
                                    }
                                    for(int j=aux;j<1238;j++){
                                        trama[j]=(byte)0;     
                                    }
                                }
                                /*si es mas largo de 20 bytes*/
                                else{                                 
                                    for(int j=0;j<1238;j++){
                                        trama[38+countermsj.id]=mensaje[j];
                                        countermsj.incrementa(1);
                                    }
                                    System.out.println("esto es una bandera de no recursion");
                                    System.out.println("indice del mensaje: "+countermsj.id);
                                }
                                /*ultimo paso, crear checksum*/
                                byte[] ck= new byte[1268];
                                int n=0;
                                for(int j=12;j<1278;j++) {
                                    ck[n]=trama[j];
                                    n++;
                                }
                                System.out.println(" ");
                                long checksum=Checksum.calculateChecksum(ck);
                                String cadena=Long.toBinaryString(checksum);
                                
                                String str1="",str2="",aux="";
                                if(cadena.length()<=16){
                                    for(int j=0;j<16-cadena.length();j++){
                                        aux=aux+"0";
                                    }
                                        aux=aux+cadena;
                                }
                                System.out.println(aux);
                                for(int j=0;j<8;j++){
                                    str1+=aux.charAt(j);
                                }
                                for(int j=8;j<16;j++){
                                    str2+=aux.charAt(j);
                                }  
                                int n1=Integer.parseInt(str1,2);
                                byte b1 = (byte)(n1);
                                int n2=Integer.parseInt(str2,2);
                                byte b2 = (byte)n2;
                                System.out.printf("checksum antes de convertir: %02X",checksum);
                                System.out.println("");
                                System.out.printf("checksum despues de convertir: %02X",b1);
                                System.out.printf("%02X",b2);
                                System.out.println("");
                                trama[1278]=b1;
                                trama[1279]=b2; 
                                //
                                int m=0;
                                byte[] ck2= new byte[1268];
                                for(int j=12;j<1280;j++) {
                                    ck2[m]=trama[j];
                                    m++;
                                }
                                System.out.println(" ");
                                long checksum2=Checksum.calculateChecksum(ck2);
                                System.out.println("gran total: "+checksum2);
                                //
                                System.out.println("");
                                pcap.sendPacket(trama);     
                                
                                
                                
    /*********primer mensaje que se envia************/
    /*agregamos los datos (mensaje) a la trama*/
    
    int tam=mensaje.length;
       System.out.println("el tamanio es:" +tam);                  
    PcapPacketHandler<String> jpacketHandler = new PcapPacketHandler<String>() {
			
        public void nextPacket(PcapPacket packet, String user) {
        int tam=mensaje.length;
        
   System.out.printf("Paquete recibido el %s bytes capturados=%-4d tam original=%-4d %s\n",
				    new Date(packet.getCaptureHeader().timestampInMillis()),
				    packet.getCaptureHeader().caplen(),  // Length actually captured
				    packet.getCaptureHeader().wirelen(), // Original length
				    user                                 // User supplied object
				    );
                            for(int l=0;l<packet.size();l++){
                                System.out.printf("%02X ",packet.getUByte(l));
                                if(l%16==15)
                                    System.out.println("");
                                }
                            /*contruyendo*/                               
                                byte sec=(byte)countersec.id;
                                System.out.println("no. sec: "+sec);
                                trama[36]=sec;
                                countersec.incrementa(1);
                                
                                byte ack=(byte)counterack.id;
                                System.out.println("no. acuse: "+ack);
                                trama[37]=ack;
                                counterack.incrementa(1);
                                
                                System.out.println("Tamaño del mensaje:" +mensaje.length);  
                                //si el mensaje se manda en un solo paquete
                                if(mensaje.length-countermsj.id < 1200){
                                    //variable aux
                                    System.out.println("esto es una bandera recursion, menor a 1200");
                                    System.out.println("Restante: "+ (mensaje.length-countermsj.id));
                                    int aux=38;
                                    int aux2=mensaje.length-countermsj.id;
                                    //lenamos con el tamaño del archivp
                                    for(int j=0;j<aux2;j++){
                                        trama[38+j]=mensaje[countermsj.id];
                                        aux++;
                                        countermsj.incrementa(1);
                                    }
                                    for(int j=aux;j<1238;j++){
                                        trama[j]=(byte)0;     
                                    }
                                    System.out.println("Contador del programa: "+countermsj.id);
                                    
                                }
                                /*si es mas largo de 20 bytes*/
                                else{
                                    System.out.println("esto es una bandera recursion, mayor a 1200");
                                    System.out.println("indice del mensaje: "+countermsj.id);
                                    int aux=38+countermsj.id;
                                    for(int j=0;j<1238;j++){
                                        trama[38+j]=mensaje[countermsj.id];
                                        countermsj.incrementa(1);
                                    }   
                                }
                                
                                /*ultimo paso, crear checksum*/
                                byte[] ck= new byte[1268];
                                int n=0;
                                for(int j=12;j<1278;j++) {
                                    ck[n]=trama[j];
                                    n++;
                                }
                                System.out.println(" ");
                                long checksum=Checksum.calculateChecksum(ck);
                                String cadena=Long.toBinaryString(checksum);
                                
                                String str1="",str2="",aux="";
                                if(cadena.length()<=16){
                                    for(int j=0;j<16-cadena.length();j++){
                                        aux=aux+"0";
                                    }
                                        aux=aux+cadena;
                                }
                                System.out.println(aux);
                                for(int i=0;i<8;i++){
                                    str1+=aux.charAt(i);
                                }
                                for(int i=8;i<16;i++){
                                    str2+=aux.charAt(i);
                                }  
                                int n1=Integer.parseInt(str1,2);
                                byte b1 = (byte)(n1);
                                int n2=Integer.parseInt(str2,2);
                                byte b2 = (byte)n2;
                                System.out.printf("checksum antes de convertir: %02X",checksum);
                                System.out.println("");
                                System.out.printf("checksum despues de convertir: %02X",b1);
                                System.out.printf("%02X",b2);
                                System.out.println("");
                                
                                trama[1278]=b1;
                                trama[1279]=b2;   
                                //
                                int m=0;
                                byte[] ck2= new byte[1268];
                                for(int j=12;j<1280;j++) {
                                    ck2[m]=trama[j];
                                    m++;
                                }
                                System.out.println(" ");
                                long checksum2=Checksum.calculateChecksum(ck2);
                                System.out.println("gran total: "+checksum2);
                                //
                                
                            }
                            
                            //Arrays.fill(a, (byte) 0xff);  
                           
                            
        /*fin de construccion de trama*/ 	
		};

    /*contador del numero de veces que se mandara la trama*/

    while(countermsj.id<tam){
            if (pcap.sendPacket(trama) != Pcap.OK) {
          System.err.println(pcap.getErr());  
        }
            System.out.println("Envie un paquete******");
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println("Hubo un error.");
        }
        pcap.loop(1, jpacketHandler, "");    
    }
        //mandamos una trama mas, que sera la ultima
        if (pcap.sendPacket(trama) != Pcap.OK) {
          System.err.println(pcap.getErr());  
        }
            System.out.println("Envie un paquete******");
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println("Hubo un error.");
        }
        pcap.loop(1, jpacketHandler, ""); 
 
    pcap.close();  
            
   }catch(Exception e){
       e.printStackTrace();
   }
}
}  