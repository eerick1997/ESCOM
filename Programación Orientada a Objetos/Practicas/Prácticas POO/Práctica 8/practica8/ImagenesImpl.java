import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
import javax.swing.*;
import java.util.*;

//java -Djava.security.policy=no.policy ImagenesImpl
public class ImagenesImpl extends UnicastRemoteObject implements Imagenes {
  Vector <ImageIcon> ima=new Vector<ImageIcon>();
  Vector <String> nombre = new Vector<String>();

  public ImagenesImpl() throws RemoteException  {
    super();

    nombre.addElement("t.JPG");
    ima.addElement(new ImageIcon("t.JPG"));

  }

  public Vector getNombres() throws java.rmi.RemoteException {
   return nombre;
 }
 public ImageIcon getImage(String imageID) throws RemoteException , Exception {
  int j=0;
  try
  { 
    for(int i=0;i<nombre.size();i++){

      if((nombre.elementAt(i)).equals(imageID)){j=i;}
    }


    return ima.elementAt(j);

  //javax.swing.ImageIcon img = new javax.swing.ImageIcon(imageID);
//return img;
  }
  catch (Exception e){ 
    System.out.println("Fehler in GetImageIcon:\n "+ e.toString()+"\n");
  throw e;
}
}

public void setIma(String nom , ImageIcon iman) throws RemoteException , Exception{

  nombre.addElement(nom);
  ima.addElement(iman);

}

public static void main(String args[]) {

  try {
    ImagenesImpl i = new ImagenesImpl();
    Naming.rebind("imagenes", i);
    System.out.println("Servidor Imagenes listo.");
  }
  catch (RemoteException re) {
    System.out.println("Exception in ImagenesImpl.main: " + re);
      //re.printStackTrace();
  }
  catch (MalformedURLException e) {
    System.out.println("MalformedURLException en HelloImpl.main: " + e);
  }

}

}

