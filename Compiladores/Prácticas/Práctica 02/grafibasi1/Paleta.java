import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Paleta extends JPanel {
        AccionInt actor;
        //Mine cad;
	JButton botones[];
	int sel=0;
        

	public Paleta(/*Mine cad*/)
	{
		//this.cad=cad;
		botones=new JButton[5];
		setLayout(new GridLayout(3,2));
		for(int i=0; i<botones.length; i++){
			botones[i]=new JButton(""+i);
			add(botones[i]);
			botones[i].addActionListener(new ManejaBotones());
		} 
	}
	public Paleta(/*Mine cad,*/ String titulos[])
	{
		//this.cad=cad;
		botones=new JButton[titulos.length];
		setLayout(new GridLayout(titulos.length/2+1,2));
		for(int i=0; i < titulos.length; i++){
			botones[i]=new JButton(titulos[i]);
			add(botones[i]);
			botones[i].addActionListener(new ManejaBotones());
		}
	}
        public Paleta(String captions[], LayoutManager lm, AccionInt ai){
                botones=new JButton[captions.length];
		setLayout(lm);
                actor=ai;
		for(int i=0; i<botones.length; i++){
			botones[i]=new JButton(captions[i]);
			add(botones[i]);
			botones[i].addActionListener(new ManejaBotones());
		}
	}

	int getSeleccion(){
		return sel;
	}

	class ManejaBotones implements ActionListener {
		public void actionPerformed(ActionEvent e){
			JButton j=(JButton)e.getSource();
			for(int i=0; i<botones.length; i++){
				if(botones[i]==j){
					sel=i;
                                        //cad.Insertar(i);
				}
			}
                        actor.accion(sel, e);
		}	
	}
}
