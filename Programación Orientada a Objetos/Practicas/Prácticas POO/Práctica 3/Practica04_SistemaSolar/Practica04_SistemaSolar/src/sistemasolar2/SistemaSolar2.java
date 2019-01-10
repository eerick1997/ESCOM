package sistemasolar2;

/*@author Home */
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class SistemaSolar2 implements ActionListener {

    private final JComboBox jcb;

    public SistemaSolar2() {
        
        BranchGroup group = new BranchGroup();
        
        Appearance appsol = new Appearance();
        Appearance appearth = new Appearance();
        Appearance appmarte = new Appearance();
        Appearance appjupiter = new Appearance();
        
        TextureLoader tex = new TextureLoader("c:\\textura\\TIERRA.JPG", null);
        appearth.setTexture(tex.getTexture());
        tex = new TextureLoader("C:\\textura\\SOL.JPG", null);
        appsol.setTexture(tex.getTexture());
        tex = new TextureLoader("C:\\textura\\MARTE.JPG",null);
        appmarte.setTexture(tex.getTexture());
        tex = new TextureLoader("C:\\textura\\JUPITER.JPG",null);
        appjupiter.setTexture(tex.getTexture());
        
        
        Sphere earth = new Sphere(0.063f, Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 32, appearth);
        Sphere sol = new Sphere(0.35f, Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 32, appsol);
        Sphere marte = new Sphere(0.043f, Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 32, appmarte);
        Sphere jupiter = new Sphere(0.093f, Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 32, appjupiter);
        
        TransformGroup solRotXformGroup = rotate(sol, new Alpha(-1, 1250));
        TransformGroup earthRotXformGroup = rotate(earth, new Alpha(-1, 3000));
        TransformGroup marteRotXformGroup = rotate(marte, new Alpha(-1,4000));
        TransformGroup jupiterRotXformGroup = rotate(jupiter, new Alpha(-1,7000));
        
        TransformGroup earthTransXformGroup = translate(earthRotXformGroup, new Vector3f(0.0f, 0.0f, 0.50f));
        TransformGroup earthRotGroupXformGroup = rotate(earthTransXformGroup, new Alpha(-1, 6000));
        TransformGroup marteTransXfromGroup = translate(marteRotXformGroup, new Vector3f(0.0f, 0.0f, 0.64f)); //*Distancia de traslacion
        TransformGroup marteRotGroupXformGroup =  rotate(marteTransXfromGroup,new Alpha(-1,6600));//*Rapidez de rotacion
        TransformGroup jupiterTransXformGroup = translate(jupiterRotXformGroup, new Vector3f(0.0f,0.0f, 0.70f));
        TransformGroup jupiterRotGroupXformGroup = rotate(jupiterTransXformGroup, new Alpha(-1,8000));
        
        group.addChild(earthRotGroupXformGroup);
        group.addChild(marteRotGroupXformGroup);
        group.addChild(jupiterRotGroupXformGroup);
        group.addChild(solRotXformGroup);
        
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas = new Canvas3D(config);
        canvas.setSize(400, 400);
        
        SimpleUniverse universe = new SimpleUniverse(canvas);
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(group);
        
        Vector nomPlanet = new Vector();
        nomPlanet.addElement("Sol");
        nomPlanet.addElement("Tierra");
        nomPlanet.addElement("Marte");
        nomPlanet.addElement("Jupiter");
        jcb = new JComboBox(nomPlanet);
        jcb.addActionListener(this);
        JPanel jp = new JPanel();
        jp.add(jcb);
        JFrame f = new JFrame("Planetario");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.add("Center", canvas);
        f.add("South", jp);
        f.pack();
        f.setVisible(true);
    }

    TransformGroup rotate(Node node, Alpha alpha) {
        TransformGroup xformGroup = new TransformGroup();
        xformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        RotationInterpolator interpolator = new RotationInterpolator(alpha, xformGroup);
        interpolator.setSchedulingBounds(new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 1.0));
        xformGroup.addChild(interpolator);
        xformGroup.addChild(node);
        return xformGroup;
    }

    TransformGroup translate(Node node, Vector3f vector) {
        Transform3D transform3D = new Transform3D();
        transform3D.setTranslation(vector);
        TransformGroup transformGroup = new TransformGroup();
        transformGroup.setTransform(transform3D);
        transformGroup.addChild(node);
        return transformGroup;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println((String) jcb.getSelectedItem());
    }
}