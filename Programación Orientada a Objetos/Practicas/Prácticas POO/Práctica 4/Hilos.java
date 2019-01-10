import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class Hilos implements Runnable, ActionListener{

	private JButton buttons[];
	private JLabel TXTScore;
	private Thread hilo;
	private int TimeSleep = 0;
	private JFrame frame;

	private int score = 0, count = 0;

	public void UpdateWhackAMole(){
		System.out.println("UpdateWhackAMole() Starts!...");
		enableButtons();
		for(int i=0; i<buttons.length; i++)
		{
			buttons[i].setIcon(new ImageIcon("Hole.jpg"));
			if (Math.random() < 0.5)
				buttons[i].setIcon(new ImageIcon("Mole.jpg"));
		}
	}

	public void enableButtons(){
		for (int i=0; i<buttons.length; i++)
			buttons[i].addActionListener(this);
	}

	public Hilos(int sleep, int howMany){

		TimeSleep = sleep;
		count = howMany;

		frame = new JFrame("Whack a mole");
		TXTScore = new JLabel("Score " + score);
		buttons = new JButton[20];
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024,1424);
		frame.setLayout(new GridLayout(5,4));

		for (int i=0; i<buttons.length; i++) {
			buttons[i] = new JButton("");
			frame.add(buttons[i]);
		}
		frame.add(TXTScore);
		frame.setVisible(true);
		UpdateWhackAMole();
		hilo = new Thread(this);
		hilo.start();
	}

	public void run(){
		try{
			while(count-- > 0){
				Thread.sleep(TimeSleep);
				UpdateWhackAMole();
			}
			JOptionPane.showMessageDialog(null, "El juego ha terminado, has obtenido " + score + " puntos");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e){
		JButton jbutton = (JButton)e.getSource();
		jbutton.removeActionListener(this);
		if(jbutton.getIcon().toString().equals("Mole.jpg")){
			score++;
			jbutton.setIcon(new ImageIcon("DeadMole.jpg"));
		}
		TXTScore.setText("Score " + score);
	}

	public static void main(String s[]){
		new Hilos(5000, 10);
	}
}