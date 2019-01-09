import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.util.StringTokenizer;
import javax.swing.text.*;

public class PanelEjecuta extends JPanel {
   private Maquina maq;
   private Parser par;
   private boolean newline;
   private String etiqs[]={"Ejecuta", "Limpia"};
   private Paleta paleta;
   static JTextArea cmd;
   public PanelEjecuta(Maquina maq, Parser par){
      this.maq=maq; this.par=par;
      setLayout(new GridLayout(3,1));
      cmd = new JTextArea(3, 40);   
      JScrollPane qScroller = new JScrollPane(cmd);
      add(qScroller);
      paleta=new Paleta(etiqs,new GridLayout(etiqs.length, 1), new ManejaAccionInt()); 
      add(paleta);
      add(new JButton(new DefaultEditorKit.PasteAction()));
   }
   class ManejaAccionInt implements AccionInt {
      public void accion(int n, ActionEvent e){ 
         //System.out.println("accion");
	 if(n==0){ 
            //System.out.println("if accion");
            par.setTokenizer(new StringTokenizer(cmd.getText()));
    	    par.setNewline(false);
	    for(maq.initcode(); par.yyparse ()!=0; maq.initcode())
	       maq.execute(maq.progbase);
         }
         if(n==1){
            cmd.setText("");
        }
     }
   }
}
