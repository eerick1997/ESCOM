package Protocols;

import org.jnetpcap.packet.format.FormatUtils;
import org.jnetpcap.protocol.network.Arp;

public class ARP {
    
    private static final int HardwareType = 0, ProtocolType = 1,
            HardAddLength = 2, ProtAddLength = 3, Opcode = 4,
            SenderHardAdd = 5, SenderProtAdd = 6, TargHardAdd = 7,
            TargProtAdd = 8;
    
    private String Header[] = new String[7];
    
    private Arp arp;
    
    public ARP(Arp arp) throws Exception{
        this.arp = arp;
    }
    
    private void createHeader() throws Exception{
        //Hardware Type
        Header[HardwareType] = arp.hardwareType() + "";
        //Protocol Type
        Header[ProtocolType] = arp.protocolType() + "";
        //Hardware Address length
        Header[HardAddLength] = arp.hlen() + "";
        //Protocol Address length
        Header[ProtAddLength] = arp.plen() + "";
        //Option code
        Header[Opcode] = operation(arp.operation());
        //Sender hardware Address
        Header[SenderHardAdd] = FormatUtils.mac(arp.sha());
        //Sender protocol address
        Header[SenderProtAdd] = FormatUtils.asString(arp.spa());
        //Target hardware address
        Header[TargHardAdd] = FormatUtils.mac(arp.tha());
        //Target protocol address
        Header[TargProtAdd] = FormatUtils.asString(arp.tpa());
    }
    
    public String getHardwareType(){
        return Header[HardwareType];
    }
    
    public String getProtocolType(){
        return Header[ProtocolType];
    }
    
    public String getHardAddLength(){
        return Header[HardAddLength];
    }
    
    public String getProtAddLength(){
        return Header[ProtAddLength];
    }
    
    public String getOpcode(){
        return Header[Opcode];
    }
    
    public String fetSenderHardAdd(){
        return Header[SenderHardAdd];
    }
    
    public String getTargHardAdd(){
        return Header[TargHardAdd];
    }
    
    public String getTargProtAdd(){
        return Header[TargProtAdd];
    }
    
    public String[] getHeader(){
        return Header;
    }
    
    private String operation(int option){
        String str = "";
        switch(option){
            case 1:
                str = "request";
                break;
            case 2:
                str = "response";
                break;
                
            //For RARP    
            case 3:
                str = "request";
                break;
            case 4:
                str = "response";
                break;
        }
        return str;
    }
}
