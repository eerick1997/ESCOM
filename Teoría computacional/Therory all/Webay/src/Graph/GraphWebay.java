package Graph;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphWebay extends JPanel {

    public void graph() {
        JFrame jf;          //Nombre de la ventana
        jf = new JFrame("WEB - EBAY Automata");
        GraphWebay lro = new GraphWebay();
        lro.setBackground(Color.WHITE);

        jf.add(lro);//agregar el grafico
        jf.setSize(1280, 900);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);//centrar pantalla
        jf.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //llamamos al metodo paintComponent de la superclase
        //dibujar automata
        //flechas
        g.setColor(Color.BLACK);

        //salen de q0
        g.drawLine(162, 489, 204, 434);
        g.fillOval(198, 431, 12, 9);
        g.drawString("Inicio", 131, 500);
        g.drawLine(272, 369, 459, 281);
        g.fillOval(448, 279, 12, 9);
        g.drawString("w", 308, 341);
        g.drawLine(273, 432, 410, 474);
        g.fillOval(400, 467, 12, 9);
        g.drawString("e", 308, 460);
        g.drawArc(168, 359, 50, 50, 60, 210);
        g.fillOval(202, 358, 11, 11);
        g.drawString("E-e-w", 134, 371);

        //salen de q1
        g.drawLine(537, 249, 637, 249);
        g.fillOval(630, 243, 12, 9);
        g.drawString("e", 582, 245);
        g.drawArc(453, 183, 50, 50, 0, 300);
        g.fillOval(451, 212, 11, 11);
        g.drawString("w", 469, 172);
        g.drawArc(239, 262, 410, 200, 90, 100);
        g.fillOval(237, 343, 11, 11);
        g.drawString("E-e-w", 337, 265);

        //salen de q2
        g.drawLine(731, 249, 879, 249);
        g.fillOval(872, 243, 12, 9);
        g.drawString("b", 781, 221);
        g.drawArc(525, 181, 130, 90, 0, 180);
        g.fillOval(522, 209, 11, 11);
        g.drawString("w", 580, 180);
        g.drawArc(239, 126, 465, 460, 30, 160);
        g.drawString("E-b-e-w", 484, 113);
        g.drawLine(651, 280, 475, 472);
        g.fillOval(474, 465, 11, 11);
        g.drawString("e", 640, 282);

        //salen de q3
        g.drawLine(897, 287, 475, 472);
        g.drawString("e", 865, 290);
        g.drawLine(935, 302, 933, 476);
        g.fillOval(930, 450, 8, 10);
        g.drawString("a", 947, 318);
        g.drawArc(524, 124, 378, 180, 0, 185);
        g.drawString("w", 698, 122);
        g.drawArc(239, 58, 750, 600, 20, 150);
        g.drawString("E-a-e-w", 788, 73);

        //salen de q4
        g.drawLine(442, 465, 488, 297);
        g.fillOval(484, 300, 11, 12);
        g.drawString("w", 445, 390);
        g.drawArc(361, 510, 50, 50, 90, 270);
        g.fillOval(386, 503, 11, 9);
        g.drawString("e", 360, 520);
        g.drawArc(239, 300, 207, 300, 180, 165);
        g.drawString("E-b-e-w", 320, 590);
        g.fillOval(236, 449, 9, 11);
        g.drawLine(488, 505, 624, 505);
        g.fillOval(613, 502, 11, 8);
        g.drawString("b", 547, 500);

        //salen de q5
        g.drawLine(633, 478, 525, 281);
        g.fillOval(526, 283, 16, 14);
        g.drawString("w", 532, 316);
        g.drawLine(715, 505, 883, 505);
        g.fillOval(876, 502, 11, 8);
        g.drawString("a", 763, 500);
        g.drawArc(472, 504, 207, 75, 180, 180);
        g.fillOval(470, 546, 10, 10);
        g.drawString("e", 643, 563);
        g.drawArc(240, 200, 450, 500, 180, 170);
        g.drawString("E-a-e-w", 459, 685);

        //salen de q6
        g.drawLine(896, 485, 525, 281);
        g.drawString("w", 810, 437);
        g.drawLine(939, 505, 1030, 505);
        g.fillOval(1029, 502, 11, 8);
        g.drawString("y", 999, 486);
        g.drawArc(472, 504, 450, 100, 180, 180);
        g.drawString("e", 900, 572);
        g.drawArc(240, 157, 704, 600, 180, 170);
        g.drawString("E-e-w-y", 760, 700);

        //salen de q7
        g.drawLine(1054, 463, 525, 281);
        g.drawString("w", 1017, 434);
        g.drawArc(472, 475, 630, 155, 180, 180);
        g.drawString("e", 1050, 592);
        g.drawArc(240, 90, 880, 750, 180, 170);
        g.drawString("E-e-w", 959, 764);

        //estados
        //q0
        g.setColor(new Color(0xFFD200));
        g.fillOval(193, 353, 96, 96);
        g.setColor(Color.BLACK);
        g.drawOval(193, 353, 96, 96);
        g.drawString("Q0", 235, 405);
        //q1
        g.setColor(new Color(0xFFD200));
        g.fillOval(445, 205, 96, 96);
        g.setColor(Color.BLACK);
        g.drawOval(445, 205, 96, 96);
        g.drawString("Q1", 486, 258);
        //q2
        g.setColor(new Color(0xFFD200));
        g.fillOval(639, 200, 96, 96);
        g.setColor(Color.BLACK);
        g.drawOval(639, 200, 96, 96);
        g.drawString("Q2", 678, 258);
        //q3 estado final
        g.setColor(new Color(0xFFD200));
        g.fillOval(882, 191, 116, 116);
        g.setColor(Color.BLACK);
        g.drawOval(882, 191, 116, 116);
        g.drawOval(891, 200, 96, 96);
        g.drawString("Q3", 931, 250);
        //q4
        g.setColor(new Color(0xFFD200));
        g.fillOval(396, 461, 96, 96);
        g.setColor(Color.BLACK);
        g.drawOval(396, 461, 96, 96);
        g.drawString("Q4", 436, 515);
        //q5
        g.setColor(new Color(0xFFD200));
        g.fillOval(623, 460, 96, 96);
        g.setColor(Color.BLACK);
        g.drawOval(623, 460, 96, 96);
        g.drawString("Q5", 662, 515);
        //q6
        g.setColor(new Color(0xFFD200));
        g.fillOval(884, 460, 96, 96);
        g.setColor(Color.BLACK);
        g.drawOval(884, 460, 96, 96);
        g.drawString("Q6", 925, 515);
        //q7 estado final
        g.setColor(new Color(0xFFD200));
        g.fillOval(1034, 448, 116, 116);
        g.setColor(Color.BLACK);
        g.drawOval(1034, 449, 116, 116);
        g.drawOval(1045, 460, 96, 96);
        g.drawString("Q7", 1085, 515);
    }//Finalizamos metodo paintComponent

}
