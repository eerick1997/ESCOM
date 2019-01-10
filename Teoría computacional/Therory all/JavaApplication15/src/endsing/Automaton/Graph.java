package endsing.Automaton;

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
        jf = new JFrame("AUTOMATA TERMINACION EN ING");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           //Cerrar la ventana con la X
        Graph lro = new Graph();
        lro.setBackground(Color.WHITE);

        jf.add(lro);                                                 //agregar el grafico
        jf.setSize(880, 520);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);                              //centrar pantalla
        jf.setVisible(true);    
    }
    
    @Override
    public void paintComponent(Graphics h)
    {
       super.paintComponent(h); //llamamos al metodo paintComponent de la superclase
       //dibujar automata
       
       h.setColor(Color.BLACK);
       h.drawLine(50, 300, 100, 300);
       h.fillOval(90, 297, 10, 5);
       h.drawString("Start", 60, 298);
       h.drawArc(90, 320, 30, 30, 310, -200);
       h.fillOval(109, 343, 7, 7);
       h.drawString("No i", 65, 345);
       
       h.drawLine(200, 300, 300, 300);
       h.fillOval(290, 297, 10, 5);
       h.drawString("i", 260, 298);
       h.drawArc(150, 220, 200, 80, 0, 180);
       h.fillOval(149, 251, 5, 10);
       h.drawString("No i o n", 223, 218);
       
       h.drawLine(400, 300, 500, 300);
       h.fillOval(490, 297, 10, 5);
       h.drawString("n", 460, 298);
       h.drawArc(140, 120, 400, 280, 0, 180);    
       h.fillOval(138, 251, 5, 10);
       h.drawString("No i o g", 313, 115);
       
       h.drawLine(600, 300, 700, 300);
       h.fillOval(690, 297, 10, 5);
       h.drawString("g", 650, 298);
       
       //start
       h.setColor(new Color(0xFFD200));
       h.fillOval(100, 260, 100, 100);
       h.setColor(Color.BLACK); 
       h.drawOval(100, 260, 100, 100);
       h.drawString("start", 145, 312);

       //q0
       h.setColor(new Color(0xFFD200));
       h.fillOval(300, 260, 100, 100);
       h.setColor(Color.BLACK); 
       h.drawOval(300, 260, 100, 100);
       h.drawString("Q0", 345, 312);
              
       //q1
       h.setColor(new Color(0xFFD200));
       h.fillOval(500, 260, 100, 100);
       h.setColor(Color.BLACK); 
       h.drawOval(500, 260, 100, 100);
       h.drawString("Q1", 545, 312);
            
       //q2
       h.setColor(new Color(0xFFD200));
       h.fillOval(700, 260, 100, 100);
       h.setColor(Color.BLACK); 
       h.drawOval(700, 260, 100, 100);
       h.drawOval(710, 270, 80, 80);
       h.drawString("Q2", 745, 312);
     }//Finalizamos metodo paintComponent
}