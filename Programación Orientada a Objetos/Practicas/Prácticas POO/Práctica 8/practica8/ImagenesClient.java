import java.rmi.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;


//java -Djava.security.policy=no.policy ImagenesClient
public class ImagenesClient extends JFrame implements ActionListener {
   
   JLabel jimg;
   JComboBox jbbn;
   Container c;
   JPanel p,p2;
   JTextField t;

   JButton b;
   static ImageIcon img = null;
   static Imagenes i;
   Vector <String> nombres=new Vector<String>();

   public ImagenesClient(){
          try {
          	nombres=i.getNombres();
	  } 
         catch (RemoteException re) {
                System.out.println("Exception in HelloClient.constru: " + re);
         }
         p=new JPanel();
         p2= new JPanel();
          jbbn=new JComboBox(nombres);
          b = new JButton("Agregar");
          b.addActionListener(this);
          t=new JTextField(10);
          jbbn.addActionListener(this);
          jimg=new JLabel(img); 
          c=getContentPane();
          p.add(jimg);
          p2.add(b);p2.add(t);p2.add(jbbn);
          c.add(p , BorderLayout.CENTER);c.add(p2,BorderLayout.SOUTH);
          setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	  setVisible(true);
         
  }
  public void actionPerformed(ActionEvent e){
  	Object obj = (Object)e.getSource();
	  
	 if(obj instanceof JButton){
	  		System.out.println("Boton");
	  	try{
            if (!(t.getText()).equals("") ){
              ImageIcon  tem= new ImageIcon(t.getText());
							i.setIma( t.getText(),tem);
                nombres=i.getNombres();
              jbbn.addItem(t.getText());
							t.setText("");}
							
						}catch(Exception ex){
									System.out.println("falla imagen");
						System.out.println(ex.toString());
						}
	  
	  }
	  
	  
	  if(obj instanceof JComboBox){
							String nomimg=(String)jbbn.getSelectedItem();
										try{
							img = i.getImage(nomimg);
						}catch(Exception ex){
									System.out.println("falla imagen");
						System.out.println(ex.toString());
						}
									jimg.setIcon(img);}
          
  }
  public static void main(String args[]) {
        
    System.setSecurityManager(new RMISecurityManager());

    try {

      i = (Imagenes) Naming.lookup("imagenes");
      
	try{
		img = i.getImage("gato.jpg");
	}catch(Exception ex){
        System.out.println("falla imagen");
	System.out.println(ex.toString());
	}
      System.out.println("ImagenesClient: ");
    } 
    catch (Exception e) {
      System.out.println("Exception in main: " + e);
    }
    ImagenesClient hc=new ImagenesClient();
  }

}

