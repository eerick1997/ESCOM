/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Protocols;
import org.jnetpcap.packet.format.FormatUtils;
import org.jnetpcap.protocol.network.Icmp;
import org.jnetpcap.protocol.network.Icmp.IcmpType;
/**
 *
 * @author aesquivelv1200
 */
public class ICMP {
    private static final int type = 0, code = 1, checksum = 2;
    private String[] Header = new String[16];

    private Icmp ICMP;

    public ICMP(Icmp ICMP) throws Exception {
        this.ICMP= ICMP;
        createHeader();
    }
    private void createHeader() throws Exception {
        //Type
        Header[type] = String.valueOf(ICMP.type());
        //Code
        Header[code]=String.valueOf(ICMP.code());
        //Checksum
        int cs=ICMP.checksum();
        Header[checksum] = String.valueOf(Integer.toHexString(cs));        
        //Impresiones
        if(Header[type].equals("0") && Header[code].equals("0"))
        {
                System.out.println("Echo reply");
        }
        else if (Header[type].equals("3"))
        {
            switch(Integer.parseInt(Header[code]))
            {
                case 0:
                    System.out.println("Network unreachable");
                    break;
                case 1:
                    System.out.println("Host unreachable");
                    break;
                case 2:
                    System.out.println("Protocol unreachable");
                    break;
                case 3:
                    System.out.println("Port unreachable");
                    break;
                case 4:
                    System.out.println("Fragmentation required, but do not fragment bit set");
                    break;
                case 5:
                    System.out.println("Source route failed");
                    break;
                case 6:
                    System.out.println("Destination network unknown");
                    break;
                case 7:
                    System.out.println("Destination host unknown");
                    break;
                case 8:
                    System.out.println("Source host isolated error (military use only)");
                    break;
                case 9:
                    System.out.println("The destionation network is administratively prohibited");
                    break;
                case 10:
                    System.out.println("The destination host is administartively prohibited");
                    break;
                case 11:
                    System.out.println("The network is unreachable for Type Of Service");
                    break;
                case 12:
                    System.out.println("The host is unreachable for Type Of Service");
                    break;
                case 13:
                    System.out.println("Communication administratively prohibited (administrative filtering prevents packet from being forwarded)");
                    break;
                case 14:
                    System.out.println("Host precedence violation (indicates the requested precedence is not permitted for the combination of host or network and port)");
                    break;
                case 15:
                    System.out.println("Precedence cutoff in effect (precedence of datagram is below the level set by the network administrators)");
                    break;
                    
            }//Fin de switch
        }
        else if (Header[type].equals("4") && Header[code].equals("0"))
        {
            System.out.println("Source Quench");
        }
        else if (Header[type].equals("5"))
        {
            System.out.println("Redirect.");
            switch (Integer.parseInt(Header[code]))
            {
                case 0:
                    System.out.println("Network redirect");
                    break;
                case 1:
                    System.out.println("Host redirect");
                    break;
                case 2:
                    System.out.println("Network redirect for this Type Of Service");
                    break;
                case 3:
                    System.out.println("Host redirect for this Type Of Service");
                    break;
            }
        }
        else if(Header[type].equals("8") && Header[code].equals("0"))
        {
            System.out.println("Echo Request");
        }
        else if(Header[type].equals("11"))
        {
            switch(Integer.parseInt(Header[code]))
            {
                case 0: 
                    System.out.println("transit TTL exceeded");
                    break;
                case 1:
                    System.out.println("reasembly TTL exceeded");
            }
        }
        else if(Header[type].equals("12"))
        {
            switch(Integer.parseInt(Header[code]))
            {
                case 0: 
                    System.out.println("Pointer problem");
                    break;
                case 1:
                    System.out.println("Missing a required operand");
                    break;
                case 2:
                    System.out.println("Bad length");
                    break;
            }
        }
        else if (Header[type].equals("13") && Header[code].equals("0"))
        {
            System.out.println("Timestamp Request");
        }
        else if (Header[type].equals("14") && Header[code].equals("0"))
        {
            System.out.println("Timestamp Reply");
        }
        
    }

}