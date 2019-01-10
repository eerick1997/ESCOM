package MyAutomaton;

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
        jf = new JFrame("AUTOMATA PARIDAD DE 0's Y 1's");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           //Cerrar la ventana con la X
        Graph lro = new Graph();
        lro.setBackground(Color.WHITE);

        jf.add(lro);                                                 //agregar el grafico
        jf.setSize(560, 480);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);                              //centrar pantalla
        jf.setVisible(true);    
    }
    
    @Override
    public void paintComponent(Graphics h)
    {
       super.paintComponent(h); //llamamos al metodo paintComponent de la superclase
       
        //Flechas
       h.drawLine(15, 110, 46, 110);    //inicio
       h.fillOval(36, 108, 10, 5);
       h.drawString("Start",6, 105);
       //de q0 a q1
       h.drawArc(120, 50, 300, 100, 20, 135);
       h.fillOval(398, 71, 5, 10);
       h.drawString("0", 255, 45);
       //de q0 a q1
       h.drawArc(120, 58, 300, 100, 200, 150);
       h.fillOval(137, 127, 5, 10);
       h.drawString("0", 255, 150);
       
       //de q0 a q2
       h.drawArc(50, 40, 100, 300, 140, 120);
       h.fillOval(55, 257, 5, 10);
       h.drawString("1", 35, 200);
       //de q2 a q0
       h.drawArc(37, 50, 100, 300, 310, 120);
       h.fillOval(130, 140, 5, 10);
       h.drawString("1", 125, 200);
       
       //de q2 a q3
       h.drawArc(115, 268, 300, 100, 20, 135);
       h.fillOval(142, 284, 10, 5);
       h.drawString("0", 265, 260);
       //de q3 a q2
       h.drawArc(107, 266, 300, 100, 200, 150);
       h.fillOval(396, 327, 10, 5);
       h.drawString("0", 265, 400);
       
       //de q1 a q3
       h.drawArc(390, 106, 100, 180, 140, 120);
       h.fillOval(400, 254, 5, 10);
       h.drawString("1", 395, 210);
       //de q3 a q1
       h.drawArc(395, 106, 100, 180, 310, 120);
       h.fillOval(481, 135, 5, 10);
       h.drawString("1", 480, 210);
       
       //EStados
       //Q0
       h.setColor(new Color(0xFFD200));
       h.fillOval(44, 58, 100, 100);
       h.setColor(Color.BLACK);
       h.drawOval(44, 58, 100, 100);
       h.drawOval(55, 68, 80, 80);
       h.drawString("Q0", 90, 115);
       
       //Q1
       h.setColor(new Color(0xFFD200));
       h.fillOval(391, 58, 100, 100);
       h.setColor(Color.BLACK);
       h.drawOval(391, 58, 100, 100);
       h.drawString("Q1", 435, 115);
       
       //Q2
       h.setColor(new Color(0xFFD200));
       h.fillOval(45, 246, 100, 100);
       h.setColor(Color.BLACK);
       h.drawOval(45, 246, 100, 100);
       h.drawString("Q2", 85, 300);
       
        //Q2
       h.setColor(new Color(0xFFD200));
       h.fillOval(390, 246, 100, 100);
       h.setColor(Color.BLACK);
       h.drawOval(390, 246, 100, 100);
       h.drawString("Q2", 430, 300);
       
     
     }//Finalizamos metodo paintComponent
}
