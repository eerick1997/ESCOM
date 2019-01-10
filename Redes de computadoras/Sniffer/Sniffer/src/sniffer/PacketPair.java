package sniffer;

import org.jnetpcap.packet.PcapPacket;

public class PacketPair {
    String user;
    PcapPacket packet;

    public PacketPair(PcapPacket packet, String user){
        this.packet = packet;
        this.user = user;
    }
}
