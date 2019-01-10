import java.awt.*;
import java.awt.event.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.image.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class Chat3D extends Frame {
Canvas3D canvas3D;
Appearance ap;
Texture feliz;
Texture enfermo;
private static Texture texture;
private Appearance appearance;
private TextureLoader loader;
Body b;

Panel p;
Button bfeliz;
Button benfer;
Button BTNAA2Mareado, BTNA4Sospechoso, BTNA1Feliz;

EventHandler eh; 

public Chat3D() {
   super("Texturas");  
   setResizable(false); setSize(500, 400);
   GraphicsConfiguration config =
           SimpleUniverse.getPreferredConfiguration();
   canvas3D = new Canvas3D(config);
   eh = new EventHandler();  

   bfeliz=new Button("Feliz");
   bfeliz.addActionListener(eh);
   benfer=new Button("Enfermo");
   benfer.addActionListener(eh);

   BTNAA2Mareado = new Button("Mareado");
   BTNAA2Mareado.addActionListener(eh);
   BTNA4Sospechoso = new Button("Sospechando");
   BTNA4Sospechoso.addActionListener(eh);
   BTNA1Feliz = new Button("Sonriendo");
   BTNA1Feliz.addActionListener(eh);

   p=new Panel();
   p.add(bfeliz); p.add(benfer);
   p.add(BTNAA2Mareado);p.add(BTNA1Feliz);p.add(BTNA4Sospechoso);
   add("North", p); add("Center",canvas3D);
   addWindowListener(eh);
   setup3DGraphics();
   setVisible(true);
}
void setup3DGraphics(){
   DirectionalLight light1;
   SimpleUniverse universe = new SimpleUniverse(canvas3D);;
   universe.getViewingPlatform().setNominalViewingTransform();
   b=new Body(-0.4f, 0.0f, 0.0f, "", true, this, "Avatar1");
   b.changeTextureCab(texture, "carafeliz.jpg");
   BranchGroup group= b.mybody();
   Color3f light1Color = new Color3f(1.0f, 1.0f, 0.0f);
   BoundingSphere bounds =new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
   Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
   light1 = new DirectionalLight(light1Color, light1Direction);
   light1.setInfluencingBounds(bounds);
   group.addChild(light1);
   universe.addBranchGraph(group);
}
class EventHandler extends WindowAdapter implements ActionListener {  
  public void actionPerformed(ActionEvent e) {  
     Button btn=(Button)e.getSource();
     if(btn==bfeliz)
       b.changeTextureCab(texture, "carafeliz.jpg");
     if(btn==benfer)
       b.changeTextureCab(texture, "caraenfermo.jpg");
     if(btn==BTNAA2Mareado)
      b.changeTextureCab(texture, "babeando.jpg");
    if(btn==BTNA1Feliz)
      b.changeTextureCab(texture, "Avatar1.jpg");
    if(btn==BTNA4Sospechoso)
      b.changeTextureCab(texture, "Avatar 4.jpg");
  }
  public void windowClosing(WindowEvent e){ System.exit(0);}
 }
public static void main(String[] args) { new Chat3D();}
}

