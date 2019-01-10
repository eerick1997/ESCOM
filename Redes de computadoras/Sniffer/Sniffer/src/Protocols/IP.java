package Protocols;

import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.format.FormatUtils;
import org.jnetpcap.protocol.network.Icmp;
import org.jnetpcap.protocol.network.Ip4;

public class IP {

    private static final int version = 0, IHL = 1, TOS = 2, length = 3, id = 4,
            flag0 = 5, flagX = 6, flagY = 7, offset = 9, TTL = 10, protocol = 11,
            checksum = 12, IP_O = 13, IP_D = 14, checksumValid = 15;
    
    private ICMP icmp_i;
    private PcapPacket packet;
    

    private String[] Header = new String[16];

    private Ip4 IP4;
    
    public IP(Ip4 IP4, PcapPacket packet) throws Exception {
        this.packet = packet;
        this.IP4 = IP4;
        createHeader();
    }

    private void createHeader() throws Exception {
        //version
        Header[version] = String.valueOf(IP4.version());
        //IHL
        Header[IHL] = IP4.hlen() + "";
        //Type of service
        Header[TOS] = TOStype(String.valueOf(IP4.tos()));
        //Length
        Header[length] = String.valueOf(IP4.length());
        //ID
        Header[id] = String.valueOf(IP4.id());
        //--- FLAGS ---
        //First flag
        Header[flag0] = String.valueOf(0);
        //Don't Fragment
        Header[flagX] = String.valueOf(IP4.flags_DF());
        //More fragments
        Header[flagY] = String.valueOf(IP4.flags_MF());
        //Offset
        Header[offset] = String.valueOf(IP4.offset());
        //TTL
        Header[TTL] = String.valueOf(IP4.ttl());
        //prtocol
        Header[protocol] = IP4.type() + "";
        //checksum
        Header[checksum] = "0x" + Integer.toHexString(IP4.checksum());
        //IP Origin
        Header[IP_O] = FormatUtils.ip(IP4.source());
        //IP destination
        Header[IP_D] = FormatUtils.ip(IP4.destination());
        //Valid checksum
        Header[checksumValid] = "" + IP4.isChecksumValid();
        isICMP(IP4.type());

    }
    
    private void isICMP(int type){
        switch(type){
            case 1:
                Icmp icmp = new Icmp();
                if(packet.hasHeader(icmp)){
                    try{
                        icmp_i = new ICMP(icmp);
                        
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
    
    /** We need to select the type of code **/
    private String TOStype(String code){
        String str = "prioridad", aux = "";
        for(int i = code.length(); i > code.length(); i--){
            if((i >= 0 && i <= 2) && code.charAt(i) == '1')
                str = "prioridad";
            else if(i == 3 && code.charAt(i) == '1')
                str = "retardo";
            else if(i == 4 && code.charAt(i) == '1')
                str = "Desempeno";
            else if(i == 5 && code.charAt(i) == '1')
                str = "Confiabilidad";
            else aux += code.charAt(i);
        }
        
        if(aux.equalsIgnoreCase("00"))
            aux = "Sin capacidad ECN";
        if(aux.equalsIgnoreCase("01"))
            aux = "Con capacidad ECN";
        if(aux.equalsIgnoreCase("10"))
            aux = "Con capacidad ECN";
        if(aux.equalsIgnoreCase("11"))
            aux = "Congestionamiento encontrado";
        
        return str + " | " + aux;
    }
    
    
    

    /** GETTER METHODS **/
    public String getVersion() {
        return Header[version];
    }

    public String getTOS() {
        return Header[TOS];
    }

    public String getlength() {
        return Header[length];
    }

    public String getID() {
        return Header[id];
    }

    public String getOffset() {
        return Header[offset];
    }

    public String getTTL() {
        return Header[TTL];
    }

    public String getChecksum() {
        return Header[checksum];
    }

    public String getIP_O() {
        return Header[IP_O];
    }

    public String getIP_D() {
        return Header[IP_D];
    }

    public String getIsValidChecksum() {
        return Header[checksumValid];
    }

    public String getFlag0() {
        return Header[flag0];
    }

    public String getFlagX() {
        return Header[flagX];
    }

    public String getFlagY() {
        return Header[flagY];
    }

    public String[] getHeader() {
        return Header;
    }
    
    public ICMP getICMP(){
        return icmp_i;
    }
}
