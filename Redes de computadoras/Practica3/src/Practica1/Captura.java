package Practica1;

import java.util.ArrayList;//hola 
import java.util.Date;//holis:P
import java.util.List;
import java.io.*;
import java.util.Arrays;

import org.jnetpcap.Pcap;
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


public class Captura{


    public void check(){

    }
    
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
		List<PcapIf> alldevs = new ArrayList<PcapIf>(); // Will be filled with NICs
		StringBuilder errbuf = new StringBuilder(); // For any error msgs

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
                try{
		for (PcapIf device : alldevs) {
			String description =
			    (device.getDescription() != null) ? device.getDescription()
			        : "No description available";
                        final byte[] mac = device.getHardwareAddress();
			String dir_mac = (mac==null)?"No tiene direccion MAC":asString(mac);
                        System.out.printf("#%d: %s [%s] MAC:[%s]\n", i++, device.getName(), description, dir_mac);

		}//for

		PcapIf device = alldevs.get(2); // We know we have atleast 1 device
		System.out
		    .printf("\nChoosing '%s' on your behalf:\n",
		        (device.getDescription() != null) ? device.getDescription()
		            : device.getName());

		/***************************************************************************
		 * Second we open up the selected device
		 **************************************************************************/
                /*"snaplen" is short for 'snapshot length', as it refers to the amount of actual data captured from each packet passing through the specified network interface.
                64*1024 = 65536 bytes; campo len en Ethernet(16 bits) tam mÃ¡x de trama */

		int snaplen = 64 * 1024;           // Capture all packets, no trucation
		int flags = Pcap.MODE_PROMISCUOUS; // capture all packets
		int timeout = 10 * 1000;           // 10 seconds in millis
                Pcap pcap =
		    Pcap.openLive(device.getName(), snaplen, flags, timeout, errbuf);

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


		/***************************************************************************
		 * Third we create a packet handler which will receive packets from the
		 * libpcap loop.
		 **********************************************************************/
		PcapPacketHandler<String> jpacketHandler = new PcapPacketHandler<String>() {

			public void nextPacket(PcapPacket packet, String user) {

				System.out.printf("Received packet at %s caplen=%-4d len=%-4d %s\n",
				    new Date(packet.getCaptureHeader().timestampInMillis()),
				    packet.getCaptureHeader().caplen(),  // Length actually captured
				    packet.getCaptureHeader().wirelen(), // Original length
				    user                                 // User supplied object
				    );//
                                /******Desencapsulado********/
                                for(int i=0;i<packet.size();i++){
                                System.out.printf("%02X ",packet.getUByte(i));
                                if(i%16==15)
                                    System.out.println("");
                                }
                                
                                System.out.println("\n\nEncabezado: \n"+ packet.toHexdump());
                                
                                /*********** Verificando checksum ************/                        

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
		};

		/***************************************************************************
		 * Fourth we enter the loop and tell it to capture 10 packets. The loop
		 * method does a mapping of pcap.datalink() DLT value to JProtocol ID, which
		 * is needed by JScanner. The scanner scans the packet buffer and decodes
		 * the headers. The mapping is done automatically, although a variation on
		 * the loop method exists that allows the programmer to sepecify exactly
		 * which protocol ID to use as the data link type for this pcap interface.
		 **************************************************************************/
		pcap.loop(10, jpacketHandler,"\nPaquete capturado:");

		/***************************************************************************
		 * Last thing to do is close the pcap handle
		 **************************************************************************/
		pcap.close();
                }catch(IOException e){e.printStackTrace();}
	}
}