package universe;

import Graph.Graph;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.data.xy.XYSeries;

public class MyMain {

    void display() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n> > >Menu< < <\n");
        System.out.println("Elige una opcion\n");

        System.out.println("1. Manual");
        System.out.println("2. Automatico");
        System.out.println("3. Salir");

        switch (new Scanner(System.in).nextInt()) {
            //Manual option
            case 1:
                manual(new BigInteger("1000"));
                break;
            //Automatic option
            case 2:
                automatic(new BigInteger("1000"));
                break;
            case 3:
                break;
            default:
                System.out.println("Esa opcion no existe.");
                display();
                break;
        }
    }

    void manual(BigInteger limit) {
        System.out.println("Escribe un numero entre 1 y 1,000");
        XYSeries oneSeries = new XYSeries("Unos");
        try {
            FileWriter fileWriter = new FileWriter("Universe.txt");
            fileWriter.write("\u03A3 = {\u03B5");
            int size = new Scanner(System.in).nextInt();
            if (size > 0 && size <= 1000) {
                for (int i = 1; i < size + 1; i++) {
                    Number number = new Matrix().fillMatrix(i);
                    new Files().saveUniverse(number, fileWriter);
                    if (i <= 20)
                        oneSeries.add(i, number.getOnes());
                    if (i == 20 && size >= 20)
                        showGraph(oneSeries);
                    if (size < 20 && i == size)
                        showGraph(oneSeries);
                }
                fileWriter.write("}");
                fileWriter.close();
                System.out.println("Todos los numeros se han guardado en Universe.txt");
            } else {
                System.out.println("Lo siento pero ese numero no esta en el rango establecido");
                manual(limit);
            }
        } catch (Exception e) {
            System.err.println("Error! " + e);
        } finally {

            display();
        }
    }

    void automatic(BigInteger limit) {
        try {
            XYSeries oneSeries = new XYSeries("Unos");
            FileWriter fileWriter = new FileWriter("Universe.txt");
            fileWriter.write("\u03A3 = {\u03B5");
            int potence = new Random().nextInt(25);
            System.out.println("El sistema eligio el numero " + (potence + 1));
            for (int i = 1; i < potence + 2; i++) {
                Number number = new Matrix().fillMatrix(i);
                new Files().saveUniverse(number, fileWriter);
                if (i <= 20)
                    oneSeries.add(i, number.getOnes());
                if (i == 20 && potence + 1 >= 20)
                    showGraph(oneSeries);
                if (potence + 1 < 20 && i == potence + 1)
                    showGraph(oneSeries);
            }
            fileWriter.write("}");
            fileWriter.close();
            System.out.println("Todos los numeros se han guardado en Universe.txt");
        } catch (Exception e) {
            System.err.println("Error! " + e);
        } finally {
            display();
        }
    }

    void showGraph(XYSeries onesSerie) {
        JPanel jpanel;
        JLabel jlabel;
        JFrame jframe;
        jpanel = new JPanel();
        jlabel = new JLabel();
        jframe = new JFrame();
        jframe.setSize(1300, 700);
        jpanel.setSize(1300, 700);
        jlabel.setIcon(new Graph(jpanel.getSize(), onesSerie));
        jlabel.setText("");
        jpanel.add(jlabel);
        jframe.add(jpanel);
        jframe.setVisible(true);
    }
}
