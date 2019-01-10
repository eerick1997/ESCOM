
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

public class MicroChat extends JPanel implements ActionListener{
private JTextArea incoming;
private JTextField outgoing;
private Red r;
public MicroChat (Red r) {    
	super();
        this.r=r;	
        setLayout(new GridLayout(2,1));
        incoming = new JTextArea(5,20);  // was 15,50
    	incoming.setLineWrap(true);
    	incoming.setWrapStyleWord(true);
    	incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);       
        outgoing = new JTextField(15);
        outgoing.addActionListener(this);
	add(outgoing);
	add(qScroller);
}
public void actionPerformed(ActionEvent e) { 
        //System.out.println("actionPerformed if ("+outgoing.getText()+")");
	r.escribeRed(new Mensaje("Escom","jojo", outgoing.getText()));
	outgoing.setText("");
}
public void recibir(Mensaje mensa){
	incoming.append(mensa.getTexto() + "\n");
}
}
