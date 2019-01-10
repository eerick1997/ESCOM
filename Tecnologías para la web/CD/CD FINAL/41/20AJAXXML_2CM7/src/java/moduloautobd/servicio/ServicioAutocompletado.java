//ServicioAutocompletado.java
package moduloautobd.servicio;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ServicioAutocompletado {

    Connection con = null;

    //Cerrando la conexión con la base de datos
    public void cerrarConexion() {

    }

    //Obteniendo la lista de palabras
    public ArrayList obtListaPalabras() {   
        ArrayList palabras = new ArrayList();
        try {
            URL url = new URL("http://localhost:8080/20AJAXXML_2CM7/archivoXML.xml");
            SAXBuilder builder = new SAXBuilder();
            //File archivoXML = new File(url);
            Document documento = builder.build(url);
            Element raiz = documento.getRootElement();
            List lista = raiz.getChildren("name");
            for (int i = 0; i < lista.size(); i++) {
                Element elemento = (Element) lista.get(i);
                String cadena = elemento.getTextTrim();
                palabras.add(cadena);
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return palabras;
    }
}
