package Practica2;

import Practica1.Checksum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapAddr;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.PcapBpfProgram;
import org.jnetpcap.protocol.lan.Ethernet;
import org.jnetpcap.protocol.tcpip.*;
import org.jnetpcap.protocol.network.*;
import org.jnetpcap.nio.JBuffer;
import org.jnetpcap.packet.Payload;
import org.jnetpcap.protocol.network.Arp;
import org.jnetpcap.protocol.lan.IEEE802dot2;
import org.jnetpcap.protocol.lan.IEEE802dot3;


public class Captura {

	/**
	 * Main startup method
	 *
	 * @param args
	 *          ignored
	 */
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

	public static void main(String[] args) {
            Pcap pcap=null;
               try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
		List<PcapIf> alldevs = new ArrayList<PcapIf>(); // Will be filled with NICs
		StringBuilder errbuf = new StringBuilder(); // For any error msgs
                System.out.println("[0]-->Realizar captura de paquetes al vuelo");
                System.out.println("[1]-->Cargar traza de captura desde archivo");
                System.out.print("\nElige una de las opciones:");
                int opcion = Integer.parseInt(br.readLine());
                if (opcion==1){
                    
                    /////////////////////////lee archivo//////////////////////////
                //String fname = "archivo.pcap";
                String fname = "paquetes3.pcap";
                pcap = Pcap.openOffline(fname, errbuf);
                if (pcap == null) {
                  System.err.printf("Error while opening device for capture: "+ errbuf.toString());
                  return;
                 }//if
                } else if(opcion==0){
		/***************************************************************************
		 * First get a list of devices on this system
		 **************************************************************************/
		int r = Pcap.findAllDevs(alldevs, errbuf);
		if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
			System.err.printf("Can't read list of devices, error is %s", errbuf
			    .toString());
			return;
		}

		System.out.println("Network devices found:");

		int i = 0;
		for (PcapIf device : alldevs) {
			String description =
			    (device.getDescription() != null) ? device.getDescription()
			        : "No description available";
                        final byte[] mac = device.getHardwareAddress();
			String dir_mac = (mac==null)?"No tiene direccion MAC":asString(mac);
                        System.out.printf("#%d: %s [%s] MAC:[%s]\n", i++, device.getName(), description, dir_mac);
                        List<PcapAddr> direcciones = device.getAddresses();
                        for(PcapAddr direccion:direcciones){
                            System.out.println(direccion.getAddr().toString());
                        }//foreach

		}//for
                
                System.out.print("\nEscribe el número de interfaz a utilizar:");
                int interfaz = Integer.parseInt(br.readLine());
		PcapIf device = alldevs.get(interfaz); // We know we have atleast 1 device
		System.out
		    .printf("\nChoosing '%s' on your behalf:\n",
		        (device.getDescription() != null) ? device.getDescription()
		            : device.getName());
                
		/***************************************************************************
		 * Second we open up the selected device
		 **************************************************************************/
                /*"snaplen" is short for 'snapshot length', as it refers to the amount of actual data captured from each packet passing through the specified network interface.
                64*1024 = 65536 bytes; campo len en Ethernet(16 bits) tam máx de trama */

		int snaplen = 64 * 1024;           // Capture all packets, no trucation
		int flags = Pcap.MODE_PROMISCUOUS; // capture all packets
		int timeout = 10 * 1000;           // 10 seconds in millis

                
                pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout, errbuf);

		if (pcap == null) {
			System.err.printf("Error while opening device for capture: "
			    + errbuf.toString());
			return;
		}//if
                  
                       /********F I L T R O********/
            PcapBpfProgram filter = new PcapBpfProgram();
            String expression =""; // "port 80";
            int optimize = 0; // 1 means true, 0 means false
            int netmask = 0;
            int r2 = pcap.compile(filter, expression, optimize, netmask);
            if (r2 != Pcap.OK) {
                System.out.println("Filter error: " + pcap.getErr());
            }//if
            pcap.setFilter(filter);
                /****************/
            }//else if

		/***************************************************************************
		 * Third we create a packet handler which will receive packets from the
		 * libpcap loop.
		 **********************************************************************/
		PcapPacketHandler<String> jpacketHandler = new PcapPacketHandler<String>() {

			public void nextPacket(PcapPacket packet, String user) {

				System.out.printf("\n\nPaquete recibido el %s caplen=%-4d longitud=%-4d %s\n\n",
				    new Date(packet.getCaptureHeader().timestampInMillis()),
				    packet.getCaptureHeader().caplen(),  // Length actually captured
				    packet.getCaptureHeader().wirelen(), // Original length
				    user                                 // User supplied object
				    );
                                
                                
                                /******Desencapsulado********/
                                for(int i=0;i<packet.size();i++){
                                System.out.printf("%02X ",packet.getUByte(i));
                                
                                if(i%16==15)
                                    System.out.println("");
                                }
                                
                                
                                int longitud = (packet.getUByte(12)*256)+(packet.getUByte(13));
                                System.out.printf("\nLongitud: %d (%04X)",longitud,longitud );
                                        
                                //Checando si es una trama tipo IEEE 802.3
                                if(longitud<1500){
                                    
                                        String s1=String.format("%8s", Integer.toBinaryString((byte)(packet.getUByte(16))& 0xFF)).replace(' ', '0');
                                        String s2=String.format("%8s", Integer.toBinaryString((byte)(packet.getUByte(17))& 0xFF)).replace(' ', '0');
 
                                        String tipoTrama1="",tipoTrama2="";
                                        for(int i=s1.length()-1;i>=0;i--){
                                            tipoTrama1=tipoTrama1+s1.charAt(i);
                                        }
                                        for(int i=s2.length()-1;i>=0;i--){
                                            tipoTrama2=tipoTrama2+s2.charAt(i);
                                        }
                                    
                                    
                                    /* LA TRAMA ES IEEE*/
                                    System.out.println("--->Trama IEEE802.3");
                                    /*se imprimen los 6 bytes de MAC destino*/
                                    System.out.printf(" |-->MAC Destino: %02X:%02X:%02X:%02X:%02X:%02X",packet.getUByte(0),packet.getUByte(1),packet.getUByte(2),packet.getUByte(3),packet.getUByte(4),packet.getUByte(5));
                                    /*se imprimen los 6 bytes de MAC origen*/
                                    System.out.printf("\n |-->MAC Origen: %02X:%02X:%02X:%02X:%02X:%02X",packet.getUByte(6),packet.getUByte(7),packet.getUByte(8),packet.getUByte(9),packet.getUByte(10),packet.getUByte(11));
                                    
                                    System.out.printf("\n |-->DSAP: %02X",packet.getUByte(14));
                                    int ssap = packet.getUByte(15)& 0x00000001;
                                    String c_r = (ssap==1)?"Respuesta":(ssap==0)?"Comando":"Otro";
                                    System.out.printf("\n |-->SSAP: %02X   %s\n",packet.getUByte(15), c_r);
                                                                                                               
                                    System.out.println("Trama recibida : "+tipoTrama1+"|"+tipoTrama2);
                                
                                //la longitud es tres y por lo tanto solo checamos un bit del control
                                if(longitud==3){
                                    if(tipoTrama1.charAt(0)=='0'){
                                        System.out.println("Es una trama de información.");
                                        System.out.println("N(S): "+((packet.getUByte(16)<<4)>>5)); //ignorar los ultimos 4 bits, creo que es asi
                                        System.out.println("N(R): "+(packet.getUByte(16)>>5));
                                        
                                    }else if(tipoTrama1.charAt(0)=='1' && tipoTrama1.charAt(1)=='0'){
                                        System.out.println("Es una trama de supervisión.");
                                        int cod = Integer.parseInt("" + tipoTrama1.charAt(2) + tipoTrama1.charAt(3));
                                 switch (cod){
                                      case 0: 
                                            System.out.println("RR -Listo para recibir-");
                                             break;
                                      case 1: 
                                          System.out.println("REI -Rechazado-");
                                          break;
                                      case 10:
                                          System.out.println("RNR -No Listo para Recibir");
                                          break;
                                      case 11: 
                                          System.out.println("SREI -Rechazo Selecctivo");
                                         break;
                                  }
                                    } else{
                                        System.out.println("Es una trama no numerada.");
                                        int bit = Integer.parseInt("" + tipoTrama1.charAt(2) + tipoTrama1.charAt(3) + tipoTrama1.charAt(5) + tipoTrama1.charAt(6) + tipoTrama1.charAt(7));
                                        switch(bit){
                                            case 1:
                                                System.out.println("SNRM");
                                                break;
                                            case 11011: 
                                                System.out.println("SNRME");
                                                break;
                                            case 11000:
                                                if(ssap == 0)
                                                System.out.println("SARM");
                                                if(ssap == 1)
                                                    System.out.println("DM");
                                                break;
                                            case 11010: 
                                                System.out.println("SARME");
                                                break;
                                            case 11100: 
                                                System.out.println("SABM");
                                                break;
                                            case 11110: 
                                                System.out.println("SABME");
                                                break;
                                            case 0:
                                                if(ssap == 0)
                                                System.out.println("UI");
                                                if(ssap == 1)
                                                    System.out.println("UI");
                                                break;
                                            case 110:
                                                System.out.println("UA");
                                                break;
                                            case 10: 
                                                if(ssap == 0)
                                                System.out.println("DISC");
                                                if(ssap == 1)
                                                    System.out.println("RD");
                                                break;
                                            case 10000: 
                                                if(ssap == 0)
                                                System.out.println("SIM");
                                                if(ssap == 1)
                                                    System.out.println("RIM");
                                                break;
                                            case 100: 
                                                System.out.println("UP");
                                                break;
                                            case 11001:
                                                System.out.println("RSET");
                                                break;
                                            case 11101:
                                                if(ssap == 0)
                                                System.out.println("XID");
                                                if(ssap == 1)
                                                    System.out.println("XID");
                                                break;
                                        }
                                    }                                  
                                }else{ //la longitud es diferente a tres y checaremos dos bits de control
                                     String trama=tipoTrama1+tipoTrama2;
                                     if(trama.charAt(0)=='1'){
                                         System.out.println("Trama de supervisión extendida");
                                         int cod = Integer.parseInt("" + tipoTrama1.charAt(2) + tipoTrama1.charAt(3));
                                         System.out.println("Numero de acuse: "+(packet.getUByte(17)>>1)); //es tooodo el byte
                              switch (cod){
                                  case 0: 
                                        System.out.println("RR -Listo para recibir-");
                                         break;
                                  case 1: 
                                      System.out.println("REI -Rechazado-");
                                      break;
                                  case 10:
                                      System.out.println("RNR -No Listo para Recibir");
                                      break;
                                  case 11: 
                                      System.out.println("SREI -Rechazo Selecctivo");
                                      break;
                              }
                                       }else{ 
                                        System.out.println("Trama de información extendida.");
                                        //imprimimos
                                        System.out.println("Numero de secuencia: "+(packet.getUByte(16)>>1));
                                        System.out.println("Numero de acuse:     "+(packet.getUByte(17)>>1));
                                     }
                                }
                                }//la trama es tipo ethernet
                                else if(longitud>=1500){
                                    System.out.println("-->Trama ETHERNET");
                                    byte checksum[]={(byte)packet.getUByte(24),(byte)packet.getUByte(25)};
                                
                                byte[] paqueteIP=new byte[50];
                                int j=0,k=0;
                                int tipo;
                                tipo=packet.getUByte(12)<<8 | packet.getUByte(13);
                                    //IPV6
                                    if(tipo==0x86DD){
                                        System.out.println("Es tipo IPV6, no tiene checksum.");
                                    }
                                    //IV4
                                    else if(tipo==0x0800){
                                        System.out.println("Es tipo IPV4");
                                        /* aqui capturo desde el byte 14 al 34, ya que son los 20
                                        bytes de longitud de una trama IP*/
                                        for(int i=14;i<34;i++){
                                            paqueteIP[j]=(byte)packet.getUByte(i);
                                            if(i==24||i==25){
                                                paqueteIP[j]=(byte) 0x00;
                                            }
                                            j++;
                                        }
                                        /*  Mandamos la cadena de bytes al metodo checksum y debe
                                            dar como resultado el checksum*/            
                                        long resultadoIP = Checksum.calculateChecksum(paqueteIP);
                                        System.out.printf("Valor del checksum: %02X\n",resultadoIP);
                                    }
                                    
                                    
                                    /*ahora checamos el valor del checksum de TCP o UDP*/
                                    
                                    //validamos el IHL del encabezado
                                    
                                    
                                    //caso de valor de 20 bytes de ip (4500)
                                    if((byte)packet.getUByte(14)==69){
                                        //encuentro cual es la longitud
                                        int numero=packet.getUByte(16);
                                        int desplazado=numero <<8;
                                        int numero2=packet.getUByte(17);
                                        int longitudRelativa=desplazado+numero2;
                                        
                                        System.out.println("Longitud relativa: "+longitudRelativa);
                                        
                                        //TCP
                                        if((byte)packet.getUByte(23)==0x06){
                                            //encuentro la longitud real restando IHL - longitud
                                            int longitudReal=longitudRelativa-20;
                                            System.out.println("Longitud real: "+longitudReal);
                                            
                                            System.out.println("Es tipo tcp/ip");
                                            
                                            /* Ahora checaremos el checksum del TCP*/
                                            
                                            /*creando pseudoencabezado*/
                                            
                                            byte primeraMitad[]={(byte)packet.getUByte(26),(byte)packet.getUByte(27),(byte)packet.getUByte(28),(byte)packet.getUByte(29),
                                                (byte)packet.getUByte(30),(byte)packet.getUByte(31),(byte)packet.getUByte(32),(byte)packet.getUByte(33),00000000,00000006,
                                                (byte)packet.getUByte(16),(byte)(packet.getUByte(17)-20)};                                          
                                            
                                            k=0;
                                            byte segundaMitad[]=new byte[longitudReal];
                                            for(int i=34;i<34+longitudReal;i++){
                                                    segundaMitad[k]=(byte)packet.getUByte(i);
                                                    k++;
                                                }
                                            
                                            //Uniendo ambas partes

                                            int aLen = primeraMitad.length;
                                            int bLen = segundaMitad.length;
                                            byte[] c= new byte[aLen+bLen];
                                            System.arraycopy(primeraMitad, 0, c, 0, aLen);
                                            System.arraycopy(segundaMitad, 0, c, aLen, bLen);
                                                
                                            /*for(int i=0;i<c.length;i++){
                                                System.out.printf("%02X ",c[i]);
                                            }*/
                                            
                                            /*calculando checksum tcp*/
                                                
                                            long resultado = Checksum.calculateChecksum(c);
                                            System.out.printf("Valor del checksum (TCP): %04X\n",resultado);
                                        } 
                                        
                                        //UDP
                                        else if((byte)packet.getUByte(23)==0x11){
                                            //encuentro la longitud real restando IHL - longitud
                                            int longitudReal=longitudRelativa-20;
                                            System.out.println("Longitud real: "+longitudReal);
                                            
                                            System.out.println("Es tipo UDP");

                                            
                                            /* Ahora checaremos el checksum del UDP*/
                                            
                                            /*creando pseudoencabezado*/
                                            
                                            byte primeraMitad[]={(byte)packet.getUByte(26),(byte)packet.getUByte(27),(byte)packet.getUByte(28),(byte)packet.getUByte(29),
                                                (byte)packet.getUByte(30),(byte)packet.getUByte(31),(byte)packet.getUByte(32),(byte)packet.getUByte(33),00000000,0x11,
                                                (byte)packet.getUByte(16),(byte)(packet.getUByte(17)-20)};     
                                            
                                            k=0;
                                            byte segundaMitad[]=new byte[longitudReal];
                                            for(int i=34;i<34+longitudReal;i++){
                                                    segundaMitad[k]=(byte)packet.getUByte(i);
                                                    k++;
                                                }

                                            //Uniendo ambas partes

                                            int aLen = primeraMitad.length;
                                            int bLen = segundaMitad.length;
                                            byte[] c= new byte[aLen+bLen];
                                            System.arraycopy(primeraMitad, 0, c, 0, aLen);
                                            System.arraycopy(segundaMitad, 0, c, aLen, bLen);
                                            
                                            /*for(int i=0;i<c.length;i++){
                                                System.out.printf("%02X ",c[i]);
                                            }*/
                                                
                                            /*calculando checksum UDP*/
                                                
                                            long resultadoUDP = Checksum.calculateChecksum(c);
                                            System.out.printf("Valor del checksum (UDP): %04X\n",resultadoUDP);
                                        }
                                        
                                        
                                    }
                                    else{
                                        System.out.println("Proximamente mas validaciones XD");
                                    }
                                    
                                }
			}       
		};


		/***************************************************************************
		 * Fourth we enter the loop and tell it to capture 10 packets. The loop
		 * method does a mapping of pcap.datalink() DLT value to JProtocol ID, which
		 * is needed by JScanner. The scanner scans the packet buffer and decodes
		 * the headers. The mapping is done automatically, although a variation on
		 * the loop method exists that allows the programmer to sepecify exactly
		 * which protocol ID to use as the data link type for this pcap interface.
		 **************************************************************************/
		pcap.loop(-1, jpacketHandler, " ");

		/***************************************************************************
		 * Last thing to do is close the pcap handle
		 **************************************************************************/
		pcap.close();
                }catch(IOException e){e.printStackTrace();}
	}
}