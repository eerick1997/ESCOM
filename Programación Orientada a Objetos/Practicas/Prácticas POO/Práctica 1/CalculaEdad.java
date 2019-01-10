import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class CalculaEdad extends Applet implements ActionListener{

	private Button BTNCalculaEdad;
	private Label TXTMuestraEdad;
	private TextField TXTIngresaAno;

	public void init(){
		BTNCalculaEdad = new Button("Calcula mi edad");
		TXTMuestraEdad = new Label("*********");
		TXTIngresaAno = new TextField(30);
		add(TXTIngresaAno);add(TXTMuestraEdad);add(BTNCalculaEdad);
		BTNCalculaEdad.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		TXTMuestraEdad.setText("Tienes " + (2017 - Integer.parseInt(TXTIngresaAno.getText())) + " Años");
	}
}