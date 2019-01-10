/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Protocols;
import org.jnetpcap.protocol.network.Icmp;
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
    String a="";
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
                a="Echo reply";
        }
        else if (Header[type].equals("3"))
        {
            switch(Integer.parseInt(Header[code]))
            {
                case 0:
                    a="Network unreachable";
                    break;
                case 1:
                    a="Host unreachable";
                    break;
                case 2:
                    a="Protocol unreachable";
                    break;
                case 3:
                    a="Port unreachable";
                    break;
                case 4:
                    a="Fragmentation required, but do not fragment bit set";
                    break;
                case 5:
                    a="Source route failed";
                    break;
                case 6:
                    a="Destination network unknown";
                    break;
                case 7:
                    a="Destination host unknown";
                    break;
                case 8:
                    a="Source host isolated error (military use only)";
                    break;
                case 9:
                    a="The destionation network is administratively prohibited";
                    break;
                case 10:
                    a="The destination host is administartively prohibited";
                    break;
                case 11:
                    a="The network is unreachable for Type Of Service";
                    break;
                case 12:
                    a="The host is unreachable for Type Of Service";
                    break;
                case 13:
                    a="Communication administratively prohibited (administrative filtering prevents packet from being forwarded)";
                    break;
                case 14:
                    a="Host precedence violation (indicates the requested precedence is not permitted for the combination of host or network and port)";
                    break;
                case 15:
                    a="Precedence cutoff in effect (precedence of datagram is below the level set by the network administrators)";
                    break;
                    
            }//Fin de switch
        }
        else if (Header[type].equals("4") && Header[code].equals("0"))
        {
            a="Source Quench";
        }
        else if (Header[type].equals("5"))
        {
            a="Redirect.";
            switch (Integer.parseInt(Header[code]))
            {
                case 0:
                    a+="Network redirect";
                    break;
                case 1:
                    a+="Host redirect";
                    break;
                case 2:
                    a+="Network redirect for this Type Of Service";
                    break;
                case 3:
                    a+="Host redirect for this Type Of Service";
                    break;
            }
        }
        else if(Header[type].equals("8") && Header[code].equals("0"))
        {
            a="Echo Request";
        }
        else if(Header[type].equals("11"))
        {
            switch(Integer.parseInt(Header[code]))
            {
                case 0: 
                    a="transit TTL exceeded";
                    break;
                case 1:
                    a="reasembly TTL exceeded";
            }
        }
        else if(Header[type].equals("12"))
        {
            switch(Integer.parseInt(Header[code]))
            {
                case 0: 
                    a="Pointer problem";
                    break;
                case 1:
                    a="Missing a required operand";
                    break;
                case 2:
                    a="Bad length";
                    break;
            }
        }
        else if (Header[type].equals("13") && Header[code].equals("0"))
        {
            a="Timestamp Request";
        }
        else if (Header[type].equals("14") && Header[code].equals("0"))
        {
            a="Timestamp Reply";
        }
        
    }
    public String getCodigo()
    {
        return a;
    }
}