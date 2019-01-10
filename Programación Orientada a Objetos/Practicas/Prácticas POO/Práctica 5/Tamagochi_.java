import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.image.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.io.*;
import java.net.*;


public class Tamagochi_ extends JFrame  implements Runnable {
/*
static String[][] KnowledgeBase = {
		{"COMO TE LLAMAS", 
		 "MI NOMBRE ES TAMAGOCHI"
		},		
		{"DONDE VIVES", 
		 "EN LA COMPU",
		}
};*/
static String preguntas []= { "COMO TE LLAMAS","DONDE VIVES"};
static String respuestas []= {"MI NOMBRE ES TAMAGOCHI","EN LA COMPU"};
private Canvas3D canvas3D;
private Appearance ap;
//private Texture feliz, enfermo;
private static Texture texture;

private JPanel jp;
private JButton bcambia;
private EventHandler eh; 
private String nombres[]={"carafeliz.jpg","caraenfermo.jpg"};

private Socket cliente;  

private ObjectInputStream oisNet;
private ObjectOutputStream oosNet;
private int puerto;
private int turno;
private Thread hilo;

Body body;
int val;


public Tamagochi_(){
   super("Tamagochi 3D");
   turno=0; puerto=5000;
   val=0;
   setResizable(false); setSize(450, 300);
   GraphicsConfiguration config =     
   SimpleUniverse.getPreferredConfiguration();
   canvas3D = new Canvas3D(config);
   eh = new EventHandler();  
   bcambia=new JButton("Cambiar");
   bcambia.addActionListener(eh);
   jp=new JPanel();
   jp.add(bcambia);
   add("North", jp); add("Center",canvas3D);
   setup3DGraphics();
   setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   setVisible(true);
   int i=0;
   while(i==0)
   {
    	i=1;
    	System.out.println("Esperando por el servidor . . .");
    	try {
		cliente=new Socket("localhost", puerto);
    	} catch ( IOException e) {
            	System.out.println("Fallo creacion Socket");
            	i=0;
   	}
   }
   System.out.println("Connectado al servidor.");
   try {
            oisNet = getOISNet(cliente.getInputStream());
            oosNet = getOOSNet(cliente.getOutputStream()); 
   } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al crear los fujos de objeto"+e);
   }
   hilo= new Thread(this);
   hilo.start();
}
void setup3DGraphics(){
   DirectionalLight light1;
   SimpleUniverse universe = new SimpleUniverse(canvas3D);
   universe.getViewingPlatform().setNominalViewingTransform();
   body=new Body(-0.4f,0.0f,0.0f,"",true, this, "Avatar1");
   body.changeTextureCab(texture, "carafeliz.jpg");
   BranchGroup group= body.mybody();
   Color3f light1Color = new Color3f(1.0f, 1.0f, 0.0f);
   BoundingSphere bounds =new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
   Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
   light1 = new DirectionalLight(light1Color, light1Direction);
   light1.setInfluencingBounds(bounds);
   group.addChild(light1);
   universe.addBranchGraph(group);
}
public static void main(String[] args) { new Tamagochi(); }
class EventHandler implements ActionListener {  
  public void actionPerformed(ActionEvent e) {  
     JButton btn=(JButton)e.getSource();
     Object c=null; 
     if(btn==bcambia){ 
	 turno=1-turno;     	
     }
     body.changeTextureCab(texture, nombres[turno]);
     c=new Icono("Tamagochi", turno);    
     try {
              oosNet.writeObject(c);
     } catch (IOException ex) {
              ex.printStackTrace();
     }   
  }
}
public void run()
{
	Object c=null;
	int j,k=0;
        System.out.println("run");
   	for(;;)
   	{
    		j=0;
    		try {
                        c=oisNet.readObject();	
    		} catch (IOException e) {
			System.out.println("IO ex"+e);
         		j=1;
                } catch (ClassNotFoundException ex) {
                     	System.out.println("Class no found"+ex);
			j=1;
		} 
    		if (j==0) {
 		        if(c instanceof Icono){      
                           Icono i=(Icono)c;  
                           if(i.getPrograma().equals("Tamagochi")){
                                 System.out.println("recibi");
                                 body.changeTextureCab(texture, nombres[i.getTurno()]);                   
			   }	
			}
                 }
        }
}
static String findMatch(String str) {
		String result = "";
/*		for(int i = 0; i < KnowledgeBase.length; ++i) {
			if(KnowledgeBase[i][0].equalsIgnoreCase(str)) {
				result = KnowledgeBase[i][1];
				break;
			}
		} */
		for(int i = 0; i < preguntas.length; ++i) {
			if(preguntas[i].equalsIgnoreCase(str)) {
				result = respuestas[i];
				break;
			}
		} 
		return result;
}
ObjectOutputStream getOOSNet(OutputStream os) throws IOException {
	return new ObjectOutputStream(os);
}
ObjectInputStream getOISNet(InputStream is) throws IOException {
	return new ObjectInputStream(is);
}
}

