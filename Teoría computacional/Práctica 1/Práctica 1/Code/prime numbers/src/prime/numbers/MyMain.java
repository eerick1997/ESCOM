package prime.numbers;

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
                manual(new BigInteger("100000"));
                break;
            //Automatic option
            case 2:
                automatic(new BigInteger("100000"));
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
        String naturalNumbers = "\u03A3 = {";
        System.out.println("Escribe un numero entre 1 y 100,000");
        XYSeries oneSeries = new XYSeries("Ones");
        oneSeries.add(0,0);
        try {
            FileWriter fileWriter = new FileWriter("Primes.txt");
            fileWriter.write("\u03A3 = {");
            int size = new Scanner(System.in).nextInt();
            if (size > 0 && size <= 100000) {
                for (int i = 0; i < size; i++) {
                    Number number = new Number(new BigInteger(String.valueOf(i)));
                    if(number.getIsPrime()){
                        if(i!=2){
                            naturalNumbers = naturalNumbers + ", ";
                            fileWriter.write(", ");
                        }
                        fileWriter.write(number.getBinary());
                        if (i <= 1000)
                            oneSeries.add(i, number.getOnes());
                        naturalNumbers = naturalNumbers + number.getNumber();
                    }
                }
                showGraph(oneSeries);
                fileWriter.write("}");
                fileWriter.write("\r\n");
                fileWriter.write("\r\n");
                fileWriter.write(naturalNumbers);
                fileWriter.write("}");
                fileWriter.close();
                System.out.println("guardado en Primes.txt");
            } else {
                System.out.println("Fuera de rango establecido");
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
            String naturalNumbers = "\u03A3 = {";
            XYSeries oneSeries = new XYSeries("Ones");
            oneSeries.add(0,0);
            FileWriter fileWriter = new FileWriter("Primes.txt");
            fileWriter.write("\u03A3 = {");
            int potence = new Random().nextInt(limit.intValueExact());
            System.out.println("El sistema eligio el numero " + (potence + 1));
            for (int i = 0; i < potence + 2; i++) {
                    Number number = new Number(new BigInteger(String.valueOf(i)));
                    if(number.getIsPrime()){
                        if(i!=2){
                            naturalNumbers = naturalNumbers + ", ";
                            fileWriter.write(", ");
                        }
                        fileWriter.write(number.getBinary());
                        if (i <= 1000)
                            oneSeries.add(i, number.getOnes());
                        naturalNumbers = naturalNumbers + number.getNumber();
                    }
                }
                showGraph(oneSeries);
            fileWriter.write("}");
            fileWriter.write("\r\n");
            fileWriter.write("\r\n");
            fileWriter.write(naturalNumbers);
            fileWriter.write("}");
            fileWriter.close();
            System.out.println("Guardado en Primes.txt");
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
