package sniffer;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapBpfProgram;
import org.jnetpcap.PcapDumper;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;

public class Captura implements Runnable{
    Principal principal;
    
    Pcap pcap;
    PcapPacketHandler<String> jpacketHandler;
    String[] sType, uType = new String[32];
    StringBuilder errbuf;
    int numPackets, timeout;
    public List<PacketPair> packets;
    public Thread t;
    
    public Captura(File file){
        this();
        numPackets = -1;
        timeout = -1;
        
        pcap = Pcap.openOffline(file.getPath(), errbuf);
        if (pcap == null) {
            JOptionPane.showMessageDialog(
                null,
                "Error al abrir el archivo " + file.getPath() + ": " + errbuf.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            System.err.printf("Error al abrir el archivo " + file.getPath() + ": " + errbuf.toString());
            principal.dispose();
            Inicio in = new Inicio();
        }
        else{
            t = new Thread(this);
            t.start();
        }
    }
    
    public Captura(PcapIf device, int snaplen, int flags, int timeout, int numPackets){
        this();
        this.numPackets = numPackets;
        this.timeout = timeout;
        
        pcap = Pcap.openLive(device.getName(), snaplen, flags, 10000, errbuf);
        if (pcap == null) {
            JOptionPane.showMessageDialog(
                null,
                "Error al abrir el dispositivo " + device.getName()+ ": " + errbuf.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            System.err.printf("Error al abrir el dispositivo " + device.getName() + ": " + errbuf.toString());
            principal.dispose();
            Inicio in = new Inicio();
        }
        else{
            crearFiltro();
            t = new Thread(this);
            t.start();
        }
    }
    
    private Captura(){
        principal = new Principal(this);
        
        this.packets = new ArrayList<>();
        errbuf = new StringBuilder();
        
        sType = new String[]{
            "Receive Ready (RR)",
            "Receive Not Ready (RNR)",
            "Reject (REJ)",
            "Selective Reject (SREJ)"
        };
        uType = new String[]{
            "Unnumbered Information (UI)",
            "Set Initialization Mode (SIM)",
            "Nonreserved 0 (NR0)",
            "Set Asynchronous Response (SARM)",
            "Unnumbered Poll (UP)",
            "Request Initialization Mode (RIM)",
            "Disconnect Mode (DM)",
            "Set Asynchronous Balanced Mode(SABM)",
            "Disconnect (DISC)",
            "Request Disconnect (RD)",
            "Nonreserved 2 (NR2)",
            "Set Asynchronous Response Extended Mode (SARME)",
            "Unnumbered Aknowledgement (UA)",
            "Invalido",
            "Invalido",
            "Set Asynchronous Balanced Extended Mode (SABME)",
            "Set Normal Response (SNRM)",
            "Frame Reject (FRMR)",
            "Nonreserved 1 (NR1)",
            "Reset (RSET)",
            "Invalido",
            "Invalido",
            "Invalido",
            "Exchange Identification (XID)",
            "Invalido",
            "Configure For Test (CFGR)",
            "Nonreserved 3 (NR3)",
            "Set Normal Response Extended Mode (SNRME)",
            "Test (TEST)",
            "Invalido",
            "Invalido",
            "Beacon (BCN)"
        };
        
        jpacketHandler = (PcapPacket packet, String user) -> {
            packets.add(new PacketPair(packet, user));
            analizar(packet, user);
        };
    }
    
    private void crearFiltro(){
        PcapBpfProgram filter = new PcapBpfProgram();
        String expression ="";
        int optimize = 0;
        int netmask = 0;
        int r2 = pcap.compile(filter, expression, optimize, netmask);
        if (r2 != Pcap.OK) {
            JOptionPane.showMessageDialog(
                null,
                "Error en el filtro: " + pcap.getErr(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            System.err.printf("Error en el filtro: " + pcap.getErr());
            principal.dispose();
            Inicio in = new Inicio();
        }
        pcap.setFilter(filter);
    }
    
    private void analizar(PcapPacket packet, String user){
        System.out.println("OK");
        principal.salida.append("\n");
        for(int i = 0; i < 100; i++)
            principal.salida.append("*");
        principal.salida.append(
            String.format(
                "\n\nPaquete recibido el %s caplen=%-4d longitud=%-4d %s\n\n",
                new Date(packet.getCaptureHeader().timestampInMillis()),
                packet.getCaptureHeader().caplen(),
                packet.getCaptureHeader().wirelen(),
                user
            )
        );

        for(int i = 0; i < packet.size(); i++){
            principal.salida.append(String.format("%02X ", packet.getUByte(i)));
            if(i % 16 == 15)
                principal.salida.append("\n");
        }

        int longitud = packet.getUByte(12) * 256 + packet.getUByte(13);
        principal.salida.append(String.format("\nLongitud: %d (%04X)", longitud, longitud));
        if(longitud < 1500){
            principal.salida.append("\n--->Trama IEEE802.3");
            principal.salida.append(String.format(" |-->MAC Destino: %02X:%02X:%02X:%02X:%02X:%02X", packet.getUByte(0), packet.getUByte(1), packet.getUByte(2), packet.getUByte(3), packet.getUByte(4), packet.getUByte(5)));
            principal.salida.append(String.format("\n |-->MAC Origen: %02X:%02X:%02X:%02X:%02X:%02X", packet.getUByte(6), packet.getUByte(7), packet.getUByte(8), packet.getUByte(9), packet.getUByte(10), packet.getUByte(11)));
            principal.salida.append(String.format("\n |-->DSAP: %02X", packet.getUByte(14)));
            int ssap = packet.getUByte(15) & 0x00000001;
            String c_r = ssap == 1 ? "Respuesta (R)" : ssap == 0 ? "Comando (C)" : "Otro (C/R)";
            principal.salida.append(String.format("\n |-->SSAP: %02X   %s", packet.getUByte(15), c_r));

            int control, frameType, ns, nr, pf;
            String controlBin;

            if(longitud > 3){
                control = packet.getUByte(17) * 256 + packet.getUByte(16);
                nr = (control >> 9) & 0b1111111;
                pf = (control >> 8) & 0b1;
                if((control & 0b1) == 0){
                    frameType = 0;
                    ns = (control >> 1) & 0b1111111;
                }
                else{
                    frameType = control & 0b11;
                    ns = (control >> 2) & 0b11;
                }
                controlBin = Integer.toBinaryString(control);
                for(int i = controlBin.length(); i < 16; i++)
                    controlBin = "0" + controlBin;
            }
            else{
                control = packet.getUByte(16);
                nr = (control >> 5) & 0b111;
                pf = (control >> 4) & 0b1;
                if((control & 0b1) == 0){
                    frameType = 0;
                    ns = (control >> 1) & 0b111;
                }
                else{
                    frameType = control & 0b11;
                    ns = (control >> 2) & 0b11;
                }
                controlBin = Integer.toBinaryString(control);
                for (int i = controlBin.length(); i < 8; i++) 
                    controlBin = "0" + controlBin;
            }
            if(longitud > 3)
                principal.salida.append(String.format("\n\tControl = \t0X%04X (%s)", control, controlBin));
            else
                principal.salida.append(String.format("\n\tControl = \t0X%02X (%s)", control, controlBin));
            principal.salida.append("\n\tMarco = \t");
            switch (frameType){
                case 0:
                    principal.salida.append("Informacion (I)");
                    principal.salida.append("\n\tN(r) = \t\t" + nr);
                    principal.salida.append("\n\tN(s) = \t\t" + ns);
                    principal.salida.append("\n\tP/F = \t\t" + pf + "\n");
                    break;
                case 1:
                    principal.salida.append("Supervision (S)");
                    principal.salida.append("\n\tN(r) = \t\t" + nr);
                    principal.salida.append("\n\tTipo = \t\t" +  ns + " - " +  sType[ns]);
                    principal.salida.append("\n\tP/F = \t\t" + pf + "\n");
                    break;
                case 3:
                    ns |= nr << 2;
                    principal.salida.append("No numerado (U)");
                    principal.salida.append("\n\tTipo = \t\t" + ns);
                    switch (ssap) {
                        case 1:
                            if(ns == 1)
                                ns = 5;
                            if(ns == 3)
                                ns = 6;
                            if(ns == 8)
                                ns = 9;

                            if (ns < 32)
                                principal.salida.append(String.format(" - %s\n\tF = \t\t%d\n", uType[ns], pf));
                            else
                                principal.salida.append("Invalido\n\tF = \t\t" + pf + "\n");
                            break;
                        case 0:
                            if(ns < 32)
                                principal.salida.append(String.format(" - %s\n\tP = \t\t%d\n", uType[ns], pf));
                            else
                                principal.salida.append("Invalido\n\tP = \t\t" + pf + "\n");
                            break;
                        default:
                            if(ns < 32)
                                principal.salida.append(String.format(" - %s\n\tP/F = \t\t%d\n", uType[ns], pf));
                            else
                                principal.salida.append("Invalido\n\tP/F = \t\t" + pf + "\n");
                    }
                    break;
            }
        }
        else
            principal.salida.append("-->Trama ETHERNET\n");
    }
    
    public void dump(String dumpFile){
        Pcap defaultPcap = Pcap.openOffline(".\\src\\sniffer\\default.pcap", errbuf);
        PcapDumper dumper = defaultPcap.dumpOpen(dumpFile);
        packets.stream().forEach((packetPair) -> {
            dumper.dump(packetPair.packet.getCaptureHeader(), packetPair.packet);
        });
        dumper.close();
        defaultPcap.close();
    }
    @Override
    public void run(){
        if(timeout != -1){
            timeout *= 1000;
            long startTime = System.currentTimeMillis();
            while(System.currentTimeMillis() - startTime < timeout)
                pcap.loop(1, jpacketHandler, " ");
        }
        else
            pcap.loop(numPackets, jpacketHandler, " ");
        pcap.close();
        
    }
}
