package Protocols;

import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.format.FormatUtils;

/*                             TRAMA IEEE 802.3
 ************************************************************************
 *  MAC   **   MAC   **           **       **      **         **       **
 *        **         ** Longitud  ** DSAP  ** SSAP ** CONTROL ** DATOS **
 * Origen ** Destino **           **       **      **         **       **
 * **********************************************************************
 */

/**********************************
 *  TRAMAS S:    - CODIGO        **
 *               - NR            **
 *               - NR_DEC        **
 **********************************
 *  TRAMAS U:    - CODIGO        **
 *               - ORDEN         **
 *               - RESPUESTA     **
 **********************************
 *  TRAMAS I:    - NR            **
 *               - NR_DEC        **
 *               - NS            **
 *               - NS_DEC        **
 **********************************
 */
public class IEEE {

    public static final int MAC_O = 0, MAC_D = 1, length = 2, DSAP = 3,
                            SSAP = 4, control = 5, data_modo=6, data_tipo=7,
                            dataCodigo = 8, data_nR =9, data_nR_dec = 10, 
                            data_nS = 11, data_nS_dec = 12, dataOrden=13, 
                            dataRespuesta=14;
    
    public static int lengthAux;

    private String[] Header = new String[15];

    public IEEE(PcapPacket packet) throws Exception {
        createHeader(packet);
    }

    private void createHeader(PcapPacket packet) throws Exception {
        /*MAC Origen*/
        byte[] mac_Origen = {(byte) packet.getUByte(0), (byte) packet.getUByte(1),
                             (byte) packet.getUByte(2), (byte) packet.getUByte(3), 
                             (byte) packet.getUByte(4), (byte) packet.getUByte(5)};
        Header[MAC_O] = FormatUtils.mac(mac_Origen);

        /*MAC Destino*/
        byte[] mac_Destino = {(byte) packet.getUByte(6),(byte) packet.getUByte(7), 
                              (byte) packet.getUByte(8),(byte) packet.getUByte(9),
                              (byte) packet.getUByte(10),(byte) packet.getUByte(11)};
        Header[MAC_D] = FormatUtils.mac(mac_Origen);

        /*Longitud*/
        Header[length] = "" + (packet.getUByte(12) << 8 | packet.getUByte(13));
        lengthAux = Integer.parseInt(Header[length]);

        /*DSAP*/
        Header[DSAP] = "" + (packet.getUByte(14));

        /*SSAP*/
        int ssap = packet.getUByte(15) & 0x00000001;
        String c_r = (ssap == 1) ? "Respuesta" : (ssap == 0) ? "Comando" : "Otro";
        Header[SSAP] = packet.getUByte(15) + ": " + c_r;
        
        /*CONTROL Y DATOS*/
            String codigo ="";  //General
            
           /*----- VARIABLES DE TRAMAS S e I -----*/
           String nR="", nRinv="", nR_dec="";
           String nS="", nSinv="", nS_dec="";
           /*---------------------------------*/
           
           /*----- VARIABLES DE TRAMAS U -----*/
           String orden="", respuesta="";
           /*---------------------------------*/
           
        if (lengthAux <= 3) {  /*TRAMA MODO: NORMAL*/
            Header[data_modo] = "MODO NORMAL";
            Header[control] = campoControl_N(packet);
            if (Header[control].charAt(0)=='1') {       /*TIPOS DE TRAMA */
                if(Header[control].charAt(1)=='0'){     /*TRAMA S*/
                    /*---------------  TRAMA S ---------------*/
                    codigo = controlFlujo_S(codigoS_normal(Header[control]));
                    nR = numeroAcuse_SeI(Header[control]);
                    /*Código S: codigo*/
                    /*Número de acuse N(R): nR -> Falta invertir y calcular en Decimal*/
                    
                    //Invertir acuse para calcular valor
                    for (int x=nR.length()-1;x>=0;x--)
                        nRinv = nRinv + nR.charAt(x);
                    
                    /*N(R) correcto: nRinv */
                    nR = nRinv;
                    /*N(R) correcto decimal*/
                    nR_dec = ""+Integer.parseInt(nR,2);
                    
                    Header[data_tipo] = "TRAMA S";
                    Header[dataCodigo] = codigo;
                    Header[data_nR] = nR;
                    Header[data_nR_dec] = nR_dec; 
                    
                    nRinv="";//Limpiar numero de acuse
                }else{               /*TRAMA U*/
                    /*---------------  TRAMA U ---------------*/
                    //Código U: codigo
                    codigo = codigoU_normal(Header[control]);
                    //Orden U: orden
                    orden = ordenU(codigo);
                    //Respuesta U: respuesta
                    respuesta = respuestaU(codigo);
                    
                    Header[data_tipo] = "TRAMA U";
                    Header[dataCodigo] = codigo;
                    Header[dataOrden] = orden;
                    Header[dataRespuesta] = respuesta;
                }
            }else{           /*TRAMA I*/
                /*------------ TRAMA I -------------*/
                 nR = numeroAcuse_SeI(Header[control]);
                 nS = numeroSecuencia_I(Header[control]);
                 
                 //|->Número de acuse N(R): nR     //Falta invertir y calcular en Decimal
                 //|->Número de secuencia N(S): nS //Falta invertir y calcular en Decimal

                 //Invertir numero de acuse
                 for (int x=nR.length()-1;x>=0;x--)
                     nRinv = nRinv + nR.charAt(x);
                
                 //Invertir numero de secuencia
                   for (int x=nS.length()-1;x>=0;x--)
                       nSinv = nSinv + nS.charAt(x);
                   
                 //N(S): nSinv
                 nS = nSinv;
                 //nN(S) Dec: nS_dec
                 nS_dec = Integer.parseInt(nSinv,2)+"";
                 
                 //N(R):  nRinv
                 nR = nRinv;
                 //N(R) Dec: Integer.parseInt(nRinv,2);
                 nR_dec = Integer.parseInt(nRinv,2)+"";
                 
                 Header[data_tipo] = "TRAMA I";
                 Header[data_nR] = nR;
                 Header[data_nR_dec] = nR_dec;
                 Header[data_nS] = nS;
                 Header[data_nS_dec] = nS_dec;
                 
                 nRinv="";    //Limpiar numero de acuse
                 nSinv="";    //Limpiar numero de secuencia
                 
                 
            }
        }else{        /*TRAMA MODO: EXTENDIDO*/
            /*--------- TRAMA MODO: EXTENDIDO ------------*/
            Header[data_modo] = "MODO EXTENDIDO";
            Header[control] = campoControl_Ex(packet);
            if (Header[control].charAt(0)=='1') {       /*TIPOS DE TRAMA */
                if(Header[control].charAt(1)=='0'){     /*TRAMA S*/
                    /*---------------  TRAMA S ---------------*/
                    codigo = controlFlujo_S(codigoS_normal(Header[control]));
                    nR = numeroAcuse_SeI_Extendida(Header[control]);
                    /*Código S: codigo*/
                    /*Número de acuse N(R): nR -> Falta invertir y calcular en Decimal*/
                    
                    //Invertir acuse para calcular valor
                    for (int x=nR.length()-1;x>=0;x--)
                        nRinv = nRinv + nR.charAt(x);
                    
                    /*N(R) correcto: nRinv */
                    nR = nRinv;
                    /*N(R) correcto decimal*/
                    nR_dec = ""+Integer.parseInt(nR,2);
                    
                    Header[data_tipo] = "TRAMA S";
                    Header[dataCodigo] = codigo;
                    Header[data_nR] = nR;
                    Header[data_nR_dec] = nR_dec;
                    
                    nRinv="";//Limpiar numero de acuse
                }else{               /*TRAMA U*/
                    /*---------------  TRAMA U ---------------*/
                    //Código U: codigo
                    codigo = codigoU_normal(Header[control]);
                    //Orden U: orden
                    orden = ordenU(codigo);
                    //Respuesta U: respuesta
                    respuesta = respuestaU(codigo);
                    
                    Header[data_tipo] = "TRAMA U";
                    Header[dataCodigo] = codigo;
                    Header[dataOrden] = orden;
                    Header[dataRespuesta] = respuesta;
                }
            }else{           /*TRAMA I*/
                /*------------ TRAMA I -------------*/
                 nR = numeroAcuse_SeI_Extendida(Header[control]);
                 nS = numeroSecuencia_I_Extendida(Header[control]);
                 
                 //|->Número de acuse N(R): nR     //Falta invertir y calcular en Decimal
                 //|->Número de secuencia N(S): nS //Falta invertir y calcular en Decimal

                 //Invertir numero de acuse
                 for (int x=nR.length()-1;x>=0;x--)
                     nRinv = nRinv + nR.charAt(x);
                
                 //Invertir numero de secuencia
                   for (int x=nS.length()-1;x>=0;x--)
                       nSinv = nSinv + nS.charAt(x);
                   
                 //N(S): nSinv
                 nS = nSinv;
                 //nN(S) Dec: nS_dec
                 nS_dec = Integer.parseInt(nSinv,2)+"";
                 
                 //N(R):  nRinv
                 nR = nRinv;
                 //N(R) Dec: Integer.parseInt(nRinv,2);
                 nR_dec = Integer.parseInt(nRinv,2)+"";
                 
                 Header[data_tipo] = "TRAMA I";
                 Header[data_nR] = nR;
                 Header[data_nR_dec] = nR_dec;
                 Header[data_nS] = nR;
                 Header[data_nS_dec] = nR_dec;
                 
                 
                 nRinv="";    //Limpiar numero de acuse
                 nSinv="";    //Limpiar numero de secuencia
            }
        }           
    }
    
    public static String codigoS_normal(String campoControl) {
        String codigo = "" + campoControl.charAt(2) + campoControl.charAt(3);
        return codigo;
    }

    public static String controlFlujo_S(String codigoS_normal) {
        String controlFlujo = "";

        switch (codigoS_normal) {
            case "00":  //Listo para recibir.
                controlFlujo = "RR";
                break;

            case "01":  //Rechazado.
                controlFlujo = "REI";
                break;

            case "10":  //No listo para recibir.
                controlFlujo = "RNR";
                break;

            case "11":  //Rechazo selectivo.
                controlFlujo = "SREJ";
                break;
        }

        return controlFlujo;
    }

    public static String numeroAcuse_SeI(String campoControl) {
        String nR = campoControl.charAt(5) + campoControl.charAt(6)
                + campoControl.charAt(7) + "";
        return nR;
    }

    public static String numeroSecuencia_I(String campoControl) {
        String nS = "" + campoControl.charAt(1) + campoControl.charAt(2)
                + campoControl.charAt(3);
        return nS;
    }

    public static String codigoU_normal(String campoControl) {
        String codigo = "" + campoControl.charAt(2) + campoControl.charAt(3)
                + campoControl.charAt(5) + campoControl.charAt(6)
                + campoControl.charAt(7);
        return codigo;
    }

    public static String ordenU(String codigo) {
        String orden = "";
        switch (codigo) {
            case "00001":
                orden = "SNRM";
                break;
            case "11011":
                orden = "SNRME";
                break;
            case "11000":
                orden = "SARM";
                break;
            case "11010":
                orden = "SARME";
                break;
            case "11100":
                orden = "SABM";
                break;
            case "11110":
                orden = "SABME";
                break;
            case "00000":
                orden = "UI";
                break;
            case "00110":
                orden = "-";
                break;
            case "00010":
                orden = "DISC";
                break;
            case "10000":
                orden = "SIM";
                break;
            case "00100":
                orden = "UP";
                break;
            case "11001":
                orden = "RSET";
                break;
            case "11101":
                orden = "XID";
                break;
        }
        return orden;
    }

    public static String respuestaU(String codigo) {
        String respuesta = "";
        switch (codigo) {
            case "00001":
                respuesta = "-";
                break;
            case "11011":
                respuesta = "-";
                break;
            case "11000":
                respuesta = "DM";
                break;
            case "11010":
                respuesta = "-";
                break;
            case "11100":
                respuesta = "-";
                break;
            case "11110":
                respuesta = "-";
                break;
            case "00000":
                respuesta = "UI";
                break;
            case "00110":
                respuesta = "UA";
                break;
            case "00010":
                respuesta = "RD";
                break;
            case "10000":
                respuesta = "RIM";
                break;
            case "00100":
                respuesta = "-";
                break;
            case "11001":
                respuesta = "-";
                break;
            case "11101":
                respuesta = "XID";
                break;
        }
        return respuesta;
    }

    public static String numeroAcuse_SeI_Extendida(String campoControl_General) {
        String nR = "";
        for (int i = 9; i < campoControl_General.length(); i++) {
            nR = nR + campoControl_General.charAt(i);
        }

        return nR;
    }

    public static String numeroSecuencia_I_Extendida(String campoControl_General) {
        String nS = "";

        for (int i = 1; i < 8; i++) {
            nS = nS + campoControl_General.charAt(i);
        }

        return nS;
    }
    
    public static String campoControl_N (PcapPacket packet){
        /*|-------TRAMA MODO NORMAL -------|*/
        String campoControl ="", campoControlInv="";
        campoControl = String.format("%8s", Integer.toBinaryString((byte)(packet.getUByte(16)) & 0xFF)).replace(' ', '0');
        /*|-->C.Control : campoControl */
        for (int i = campoControl.length()-1; i>=0 ;i--) {      //Invertir campo de control
            campoControlInv = campoControlInv + campoControl.charAt(i);
        }
        /*|-->C.Control Inv: campoControlInv */
        return campoControlInv;
    }
    
    public static String campoControl_Ex (PcapPacket packet){
        String campoControl ="", campoControl_2="";
        String campoControlInv="", campoControlInv_2="";
        String campoControl_General="";
        
        
        campoControl = String.format("%8s", Integer.toBinaryString((byte)(packet.getUByte(16)) & 0xFF)).replace(' ', '0');
        campoControl_2 = String.format("%8s", Integer.toBinaryString((byte)(packet.getUByte(17)) & 0xFF)).replace(' ', '0');
        
        //C.Control Inv: campoControl - campoControl_2
        for (int i = campoControl.length()-1; i>=0 ;i--)     //Invertir campo de control
            campoControlInv = campoControlInv + campoControl.charAt(i);
        
        for (int i = campoControl_2.length()-1; i>=0 ;i--)    //Invertir campo de control
            campoControlInv_2 = campoControlInv_2 + campoControl_2.charAt(i);
        
        campoControl_General = campoControlInv+campoControlInv_2;
        //|-->C.Control : campoControlInv - campoControlInv_2
        
        return campoControl_General;
    }

    public String[] getHeader() {
        return Header;
    }    
       
    public String getMac_O(){
        return Header[MAC_O];
    }
    
    public String getMac_D(){
        return Header[MAC_D];
    }
    
    public String getLength(){
        return Header[length];
    }
    
    public String getDSAP(){
        return Header[DSAP];
    }
    
    public String getSSAP(){
        return Header[SSAP];
    }
    
    public String getControl(){
        return Header[control];
    }
    
    public String getModo(){
        return Header[data_modo];
    }
    
    public String getTipo(){
        return Header[data_tipo];
    }
    
    public String getCodigo(){
        return Header[dataCodigo];
    }
    
    public String getOrden(){
        return Header[dataOrden];
    }
    
    public String getRespuesta(){
        return Header[dataRespuesta];
    }
    
    public String get_nR(){
        return Header[data_nR];
    }
    
    public String get_nR_dec(){
        return Header[data_nR_dec];
    }
    
    public String get_nS(){
        return Header[data_nS];
    }
    
    public String get_nS_dec(){
        return Header[data_nS_dec];
    }
}
