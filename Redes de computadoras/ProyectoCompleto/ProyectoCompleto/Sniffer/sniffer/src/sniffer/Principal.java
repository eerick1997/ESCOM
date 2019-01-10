package sniffer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Principal extends JFrame implements ActionListener{
    Dimension dimension;
    int dim;
    
    public JTextArea salida;
    JScrollPane scroll;
    JButton bSaver, bRegresar;
    JFileChooser fc;
    File file;
    JPanel graficaRED, graficaTRANS;
    JComboBox bEth;
    /*variables de las graficas*/
    int ARP,ICMP,TCP,UDP,IEEE,ETH;
    
    Captura cap;
    

    public Principal(Captura cap){
        this.cap = cap;
        
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        dim = Toolkit.getDefaultToolkit().getScreenResolution();
        
        setTitle("Sniffer");
        setResizable(false);
        setBounds(((dimension.width / 2) - 500), ((dimension.height/2) - 300), 1300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        /*Inicio grafica de red*/
        graficaRED= new JPanel();
        graficaRED.setBounds(590,22,680,430);
        graficaRED.setBorder(null);
        graficaRED.setBackground(Color.white);
        
        /*variables de la grafica de barras*/
        IEEE=60;ETH=34;
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        dataset.addValue(IEEE, "IEEE", "");
        dataset.addValue(ETH, "ETHERNET", "");

        JFreeChart chart=ChartFactory.createBarChart("Paquetes recibidos", "", "", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        CategoryPlot catPlot= chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel=new ChartPanel(chart);
        graficaRED.removeAll();
        graficaRED.add(chartPanel,BorderLayout.CENTER);
        graficaRED.validate();
        add(graficaRED);
        graficaRED.setVisible(true);
        
        /*boton de grafica*/
        JLabel jl=new JLabel("Graficar por capa: ");
        jl.setBounds(160,350,120,30);
        add(jl);
        bEth=new JComboBox();
        bEth.setBounds(300,350,120,30);
        add(bEth);
        bEth.addItem("RED");
        bEth.addItem("TRANSPORTE");
        bEth.addActionListener(this);
        /* fin boton grafica*/
        /*fin grafica de red*/
        
        /*Inicio grafica de transporte*/
        graficaTRANS= new JPanel();
        graficaTRANS.setBounds(590,22,680,430);
        graficaTRANS.setBorder(null);
        graficaTRANS.setBackground(Color.white);
        
        /*variables de la grafica de barras*/
        ARP=12;ICMP=46;TCP=34;UDP=60;
        DefaultCategoryDataset datasetT=new DefaultCategoryDataset();
        datasetT.addValue(ARP, "ARP", "");
        datasetT.addValue(ICMP, "ICMP", "");
        datasetT.addValue(TCP, "TCP", "");
        datasetT.addValue(UDP, "UDP", "");
        
        JFreeChart chart1=ChartFactory.createBarChart("Paquetes recibidos", "", "", datasetT, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot catPlot1= chart1.getCategoryPlot();
        catPlot1.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel1=new ChartPanel(chart1);
        graficaTRANS.removeAll();
        graficaTRANS.add(chartPanel1,BorderLayout.CENTER);
        graficaTRANS.validate();
        add(graficaTRANS);
        graficaTRANS.setVisible(false);
        /* fin grafica de transporte*/
        
        salida = new JTextArea("");
        salida.setWrapStyleWord(true);
        salida.setLineWrap(true);
        salida.setEditable(false);
        salida.setBounds(0,0,600,300);
        scroll = new JScrollPane (salida);
        scroll.setBounds(20,20,560,300);
        add(scroll);
        
        bSaver = new JButton("Guardar captura");
        bSaver.setBounds(20,350,120,30);
        bSaver.addActionListener(this);
        add(bSaver);       
        
        fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fc.setSelectedFile(new File("captura.pcap"));
        fc.setFileFilter(new FileNameExtensionFilter(null, "pcap"));
        
        bRegresar = new JButton("Regresar");
        bRegresar.setBounds(440,350,120,30);
        bRegresar.addActionListener(this);
        add(bRegresar);
        
        
        setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(bSaver)){
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                cap.dump(fc.getSelectedFile().getPath());
        }
        if(e.getSource().equals(bEth)){
            if(bEth.getSelectedIndex()==0){
                graficaRED.setVisible(true);
                graficaTRANS.setVisible(false);
            }
            else{
                graficaRED.setVisible(false);
                graficaTRANS.setVisible(true);
            }
        }
        else if(e.getSource().equals(bRegresar)){
            cap.t.interrupt();
            Inicio in = new Inicio();
            this.dispose();
        }
        
    }
}
