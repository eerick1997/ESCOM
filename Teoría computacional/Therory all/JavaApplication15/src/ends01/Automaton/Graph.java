package ends01.Automaton;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph extends JPanel
{
    //Parte Grafica del Automata
    public void graph()
    {
        JFrame jf;          //Nombre de la ventana
        jf = new JFrame("AUTOMATA TERMINACION 01");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cerrar la ventana con la X
        Graph lro = new Graph();
        lro.setBackground(Color.WHITE);

        jf.add(lro);//agregar el grafico
        jf.setSize(725, 276);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);//centrar pantalla
        jf.setVisible(true);    
    }
    
    @Override
    public void paintComponent(Graphics h)
    {
       super.paintComponent(h); //llamamos al metodo paintComponent de la superclase
       //dibujar automata
       //flechas
       h.setColor(Color.BLACK);
       
       h.drawString("Start", 0, 132);
       h.drawLine(0, 132, 35, 132);
       h.fillOval(22, 128, 8, 8);
       
       h.drawLine(411, 136, 568, 136);
       h.fillOval(562, 132, 8, 8);
       h.drawString("1", 485, 132);
       h.drawLine(140, 136, 301, 136);
       h.fillOval(292, 132, 8, 8);
       h.drawString("0", 214, 132);
       h.drawArc(46, 55, 80, 90, 0, 220);
       h.fillOval(44, 87, 8, 9);
       h.drawString("0, 1", 73, 50);
       
       //ESTADOS
       //q0
       h.setColor(new Color(0xFFD200));
       h.fillOval(29, 80, 111, 111);
       h.setColor(Color.BLACK);
       h.drawOval(29, 80, 111, 111);
       h.drawString("Q0", 74, 140);
       //q1
       h.setColor(new Color(0xFFD200));
       h.fillOval(300, 80, 111, 111);
       h.setColor(Color.BLACK);
       h.drawOval(300, 80, 111, 111);
       h.drawString("Q1", 347, 140);
       //q2
       h.setColor(new Color(0xFFD200));
       h.fillOval(569, 80, 111, 111);
       h.setColor(Color.BLACK);
       h.drawOval(569, 80, 111, 111);
       h.drawOval(579, 91, 92, 92);
       h.drawString("Q2", 618, 140);
    }
}
