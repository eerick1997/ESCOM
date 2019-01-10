package sniffer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Principal extends JFrame implements ActionListener{
    Dimension dimension;
    int dim;
    
    public JTextArea salida;
    JScrollPane scroll;
    JTabbedPane tabbedPane;
    JFreeChart chart;
    ChartPanel cp;
    JButton bSaver, bRegresar;
    JFileChooser fc;
    File file;
    
    
    Captura cap;
    

    public Principal(Captura cap){
        this.cap = cap;
        
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        dim = Toolkit.getDefaultToolkit().getScreenResolution();
        
        setTitle("Sniffer");
        setResizable(false);
        setBounds(((dimension.width / 2) - 500), ((dimension.height/2) - 300), 1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        
        salida = new JTextArea("");
        salida.setWrapStyleWord(true);
        salida.setLineWrap(true);
        salida.setEditable(false);
        salida.setBounds(0,0,1000,300);
        scroll = new JScrollPane (salida);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(20,20,960,400);
        tabbedPane.addTab("Captura", scroll);
        add(tabbedPane);
        
        bSaver = new JButton("Guardar captura");
        bSaver.setBounds(100,450,150,40);
        bSaver.addActionListener(this);
        add(bSaver);
        fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fc.setSelectedFile(new File("captura.pcap"));
        fc.setFileFilter(new FileNameExtensionFilter(null, "pcap"));
        
        bRegresar = new JButton("Regresar");
        bRegresar.setBounds(300,450,150,40);
        bRegresar.addActionListener(this);
        add(bRegresar);
        
        
        setVisible(true);
    }
    
    public void crearChart(){
        DefaultPieDataset pds = new DefaultPieDataset();
        pds.setValue("IPv4 : " + cap.counterIP, cap.counterIP);
        pds.setValue("ARP : " + cap.counterARP, cap.counterARP);
        pds.setValue("IEEE : " + cap.counterIEEE, cap.counterIEEE);
        
        chart = ChartFactory.createPieChart("Cantidad de tramas", pds, true, true, true);
        cp = new ChartPanel(chart);
        cp.setVisible(true);
        tabbedPane.addTab("Chart", cp);
    }
    

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(bSaver)){
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                cap.dump(fc.getSelectedFile().getPath());
        }
        else if(e.getSource().equals(bRegresar)){
            cap.t.interrupt();
            Inicio in = new Inicio();
            this.dispose();
        }
    }
}
