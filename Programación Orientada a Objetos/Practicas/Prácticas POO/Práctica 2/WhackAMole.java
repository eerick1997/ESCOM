import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class WhackAMole extends Applet implements ActionListener{

	private JButton buttons[];
	private Label TXTPunctuation, TXTYouWin;
	private int punctuation = 0, moles = 0;

	public void init(){
		buttons = new JButton[20];
		TXTPunctuation = new Label("Tienes 0 puntos");
		TXTYouWin = new Label("");

		setLayout(new GridLayout(5,4));
		for (int i=0; i<buttons.length; i++) {
			add(buttons[i] = new JButton(""));
			buttons[i].setIcon(new ImageIcon("Hole.jpg"));
			buttons[i].setPreferredSize(new Dimension(20,20));
			if(Math.random() < 0.5){
				moles++;
				buttons[i].setIcon(new ImageIcon("Mole.jpg"));
			}

			buttons[i].addActionListener(this);
		}

		add(TXTPunctuation);add(TXTYouWin);

	}

	public void actionPerformed(ActionEvent e){
		JButton button = (JButton)e.getSource();
		if(button.getIcon().toString().equals("Mole.jpg")){
			button.setIcon(new ImageIcon("DeadMole.jpg"));

			button.removeActionListener(this);
			punctuation++;
		}
		if (moles == punctuation) {
			TXTYouWin.setText("HAS GANADO!");
		}
		TXTPunctuation.setText("Tienes " + punctuation + " puntos");
	}

}