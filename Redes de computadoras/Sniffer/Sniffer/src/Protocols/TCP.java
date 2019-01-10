package Protocols;

import javax.swing.JOptionPane;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.packet.format.FormatUtils;
import org.jnetpcap.protocol.network.Icmp;
import org.jnetpcap.protocol.network.Icmp.IcmpType;

/*@author Home*/
 /*                    PSEUDOENCABEZADO                     **
**************************************************************
**            IHL            **             LONGITUD        **              
**************************************************************
**             PROTOCOLO     **             CHECKSUM        **
**************************************************************
**                       IP DESTINO                         **
**************************************************************
**                       IP ORIGEN                          **
**************************************************************
 */
public class TCP {
    private static final int IHL = 0, LONGITUD = 1, PROTOCOLO = 2, 
                             PROTOCOLO_CODIGO=3, CHECKSUM = 4, IP_DESTINO = 5,
                             IP_ORIGEN = 6, CEROS=7;
    
    String[] Header = new String[9];
    private TCP tcp;
    private Ip4 IP4;
    
    public TCP(PcapPacket packet) throws Exception {
        IP4 = new Ip4();
        this.tcp = tcp;
        createHeader(packet);
    }
    
    public void createHeader(PcapPacket packet){
        /***********************************************
        **  SE DEBE VERIFICAR QUE EL CAMPO PROTOCOLO  **
        **                TCP = 0X06                  **
        ************************************************
        *   SI SE JUNTA CON IP, SERÁ PROTOCOLO TCP-IP **
        ************************************************
        */
        byte[] ipDestino = new byte[5];
        byte[] ipOrigen = new byte[5];
        byte[] pseudoEncabezado = new byte[IHL];
        
        int protocol = (packet.getUByte(23));
        if ((byte)protocol == 0X06)  /*PROTOCOLO TCP*/
        {
            /*---------------------IHL: 45---------------------*/
            byte IHL_limpio = (byte) (packet.getUByte(14) & 0x0000000F);
            int ihl = (IHL_limpio * 4);           //Longitud del encabezado 
            /*Solamente se requiere la longitud del encabezado: 5
            La otra parte especifica la versión: 4*/
            /*-------------------------------------------------*/
            
            /*---------------------PDU de IP---------------------*/
            int longitud = (int) ((packet.getUByte(16) * (Math.pow(2, 8))) 
                                + (packet.getUByte(17)));
            /*---------------------------------------------------*/
            int longitudTotal = longitud - IHL; /*USADO PARA EL PSEUDO-ENCABEZADO*/
            
            for (int j = 0; j < 4; j++) {
                /*----------------------IP ORIGEN----------------------*/
                pseudoEncabezado[j] = (byte) (packet.getUByte(26 + j));
                ipOrigen[j] = (byte) (packet.getUByte(26 + j));
                /*-----------------------------------------------------*/

                /*---------------------IP DESTINO---------------------*/
                pseudoEncabezado[j + 4] = (byte) (packet.getUByte(30 + j));
                ipDestino[j] = (byte) (packet.getUByte(30 + j));
                /*----------------------------------------------------*/
            }
            
            //Reservado para la longitud de encabezado (TCP O UDP)
            pseudoEncabezado[8] = 0x00;
            
            /*-------------------PROTOCOLO (0x06)------------------*/
            pseudoEncabezado[9] = (byte) (packet.getUByte(23));
            /*----------------------------------------------------*/
            
            /*-------------------LONGITUD-------------------------*/
            pseudoEncabezado[10] = (byte)packet.getUByte(16);
            pseudoEncabezado[11] = (byte)(packet.getUByte(17)-IHL);
            /*---------------------------------------------------*/
                            
            /*El pseudoEncabezado representa la primer mitad para obtener el Checksum*/
                            
            /*---La segunda mitad es representada por el PDU_Trans---*/
            byte[] PDU_Trans = new byte[longitudTotal];
            for (int k = 34,q=0; k < 34+longitudTotal; k++,q++) 
                {
                    PDU_Trans[q]=(byte)packet.getUByte(k);
                }
            /*------------------------------------------------------*/
                            
            /*-----------UNION de PDU_Trans con pseudoEncabezado----*/
            int length_pseudoE   = pseudoEncabezado.length;
            int length_PDU_Trans = PDU_Trans.length;
                            
            byte[] encabezadoFinal;
            encabezadoFinal= new byte[length_pseudoE + length_PDU_Trans];
                            
            System.arraycopy(pseudoEncabezado, 0, encabezadoFinal, 0, length_pseudoE);
            System.arraycopy(PDU_Trans, 0, encabezadoFinal, length_pseudoE, length_PDU_Trans);
                            
            /*long checksumTCP = Checksum.calculateChecksum(encabezadoFinal);*/
                        
            Header[PROTOCOLO] = "TCP";
            Header[PROTOCOLO_CODIGO] = pseudoEncabezado[9]+"";
            Header[IHL] = ihl+"";
            Header[LONGITUD] = longitud+"";
            Header[CEROS] = pseudoEncabezado[8]+"";
            Header[CHECKSUM] = IP4.isChecksumValid() + "";
            Header[IP_DESTINO] = FormatUtils.ip(IP4.source());
            Header[IP_ORIGEN] = FormatUtils.ip(IP4.destination());
            
        }else{
            JOptionPane.showMessageDialog(null, "THIS IS NOT TCP");
        }
        
    }
    
    public String[] Header(){
        return Header;
    }
    
    public String getIHL(){
        return Header[IHL];
    }
    
    public String getLongitud(){
        return Header[LONGITUD];
    }
    
    public String getProtocolo(){
        return Header[PROTOCOLO];
    }
    
    public String getProtocolo_Codigo(){
        return Header[PROTOCOLO_CODIGO];
    }
    
    public String getChecksum(){
        return Header[CHECKSUM];
    }
    
    public String getIP_Destino(){
        return Header[IP_DESTINO];
    }
    
    public String getIP_Origen(){
        return Header[IP_ORIGEN];
    }
    
    public String getCeros(){
        return Header[CEROS];
    }
}
