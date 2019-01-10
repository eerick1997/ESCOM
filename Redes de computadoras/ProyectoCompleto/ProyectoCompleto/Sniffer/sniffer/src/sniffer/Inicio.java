package sniffer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

public class Inicio extends JFrame implements ActionListener{
    Dimension dimension;
    int dim;
    
    JLabel l1;
    JTextArea descripcion;
    JRadioButton rb1, rb2;
    ButtonGroup bg;
    JComboBox cb;
    JFileChooser fc;
    JButton bChooser, bSubmit;
    File file;
    List<PcapIf> alldevs;
    StringBuilder errbuf;
    
    public Inicio(){
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        dim = Toolkit.getDefaultToolkit().getScreenResolution();
        
        setTitle("Sniffer");
        setResizable(false);
        setBounds(((dimension.width / 2) - 200), ((dimension.height/2) - 200), 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        
        getDevices();
        
        
        l1 = new JLabel("Configuracion");
        l1.setBounds(50,0,150,40);
        add(l1);
        
        rb1 = new JRadioButton("Al vuelo");
        rb1.setBounds(50,50,150,40);
        rb1.addActionListener(this);
        add(rb1);
        rb2 = new JRadioButton("Desde archivo");
        rb2.setBounds(200,50,150,40);
        rb2.addActionListener(this);
        add(rb2);
        bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        
        cb = new JComboBox();
        cb.setBounds(50,100,150,40);
        cb.addItem("");
        if(alldevs.isEmpty())
            rb1.setEnabled(false);
        else{
            for(PcapIf device : alldevs){
                String descrip = device.getDescription() + ": " + device.getName();
                cb.addItem(descrip);
                System.out.println(descrip);
            }
        }
        cb.setEnabled(false);
        cb.addItemListener((ItemEvent e) -> {
            if(e.getStateChange() == ItemEvent.SELECTED){
                if(cb.getSelectedIndex() == 0)
                    descripcion.setText("");
                else
                    descripcion.setText(getDeviceInfo(cb.getSelectedIndex() - 1));
            }
        });
        add(cb);
        
        bChooser = new JButton("Seleccionar archivo");
        bChooser.setBounds(200,100,150,40);
        bChooser.addActionListener(this);
        bChooser.setEnabled(false);
        add(bChooser);
        fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fc.setFileFilter(new FileNameExtensionFilter(null, "pcap"));
        file = new File("");
        
        descripcion = new JTextArea();
        descripcion.setText("");
        descripcion.setWrapStyleWord(true);
        descripcion.setLineWrap(true);
        descripcion.setOpaque(false);
        descripcion.setEditable(false);
        descripcion.setFocusable(false);
        descripcion.setBounds(50,150,300,150);
        add(descripcion);
        
        bSubmit = new JButton("Iniciar Captura");
        bSubmit.setBounds(50,300,150,40);
        bSubmit.addActionListener(this);
        add(bSubmit);
        
        
        setVisible(true);
    }
    
    public void getDevices(){
        alldevs = new ArrayList<>();
        errbuf = new StringBuilder();
        if(Pcap.findAllDevs(alldevs, errbuf) == Pcap.NOT_OK || alldevs.isEmpty()){
            JOptionPane.showMessageDialog(null, "No puede leerse la lista de dispositivos.\nError: " + errbuf.toString());
            return;
        }
        System.out.println("Dispositivos de red encontrados.");
    }
    
    public String getDeviceInfo(int i){
        try{
            PcapIf device = alldevs.get(i);
            final byte[] mac = device.getHardwareAddress();
            String dirMac = mac == null ? "No tiene direccion MAC" : asString(mac);
            String info = device.getName() + " [" +  device.getDescription() + "], MAC: [" + dirMac + "]";
            return info;
        }
        catch(IOException ex){
            ex.printStackTrace();
            return "";
        }
    }
    
    private static String asString(final byte[] mac) {
        final StringBuilder buf = new StringBuilder();
        for (byte b : mac) {
            if (buf.length() != 0)
                buf.append(':');
            if (b >= 0 && b < 16)
                buf.append('0');
            buf.append(Integer.toHexString((b < 0) ? b + 256 : b).toUpperCase());
        }
        return buf.toString();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(rb1)){
            if(cb.getSelectedIndex() == 0)
                descripcion.setText("");
            else
                descripcion.setText(getDeviceInfo(cb.getSelectedIndex() - 1));
            cb.setEnabled(true);
            bChooser.setEnabled(false);
        }
        if(e.getSource().equals(rb2)){
            descripcion.setText(file.exists() ? file.getPath() : "");
            bChooser.setEnabled(true);
            cb.setEnabled(false);
        }
        if(e.getSource().equals(bChooser)){
                if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    file = fc.getSelectedFile();
                    if(file.exists())
                        descripcion.setText(file.getPath());
                    else
                        descripcion.setText("");
                }
        }
        if(e.getSource().equals(bSubmit)){
            if(rb1.isSelected()){
                if(cb.getSelectedIndex() > 0){
                    PcapIf device = alldevs.get(cb.getSelectedIndex() - 1);
                    int snaplen = 64 * 1024, flags = Pcap.MODE_PROMISCUOUS, timeout, numPackets;
                    String[] opcionesCap = {"Por tiempo", "Por numero de paquetes"};
                    Object resp = JOptionPane.showInputDialog(
                        null,
                        "Selecciona una forma de captura:",
                        "Captura al vuelo",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opcionesCap,
                        opcionesCap[0]);
                    if(resp == null)
                        return;
                    if(resp.toString().equals(opcionesCap[0]))
                        while(true){
                            String timeS = JOptionPane.showInputDialog(
                                    null,
                                    "Ingresa el tiempo de captura:",
                                    "Captura por tiempo",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            if(timeS == null)
                                return;
                            try{
                                timeout = Integer.parseInt(timeS);
                                if(timeout <= 0)
                                    JOptionPane.showMessageDialog(null, "El dato ingresado debe ser mayor a cero.");
                                else{
                                    numPackets = -1;
                                    break;
                                }
                            }
                            catch(Exception ex){
                                JOptionPane.showMessageDialog(null, "El dato ingresado debe ser un entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    else 
                        while(true){
                            Object numS = JOptionPane.showInputDialog(
                                    null,
                                    "Ingresa el numero de paquetes que deseas capturar:",
                                    "Captura por numero de paquetes",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            if(numS == null)
                                return;
                            try{
                                numPackets = Integer.parseInt(numS.toString());
                                if(numPackets <= 0)
                                    JOptionPane.showMessageDialog(null, "El dato ingresado debe ser mayor a cero.");
                                else{
                                    timeout = -1;
                                    break;
                                }
                            }
                            catch(Exception ex){
                                JOptionPane.showMessageDialog(null, "El dato ingresado debe ser un entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    Captura cap = new Captura(device, snaplen, flags, timeout, numPackets);
                    this.dispose();
                }
            }
            else if(rb2.isSelected()){
                if(!file.getPath().equals("") && file.exists()){
                    Captura cap = new Captura(file);
                    this.dispose();
                }
            }
        }
    }
}
