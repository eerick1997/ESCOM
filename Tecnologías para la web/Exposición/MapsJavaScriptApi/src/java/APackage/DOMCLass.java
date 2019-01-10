package APackage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class DOMCLass {
 
    private static final String MARKER = "MARKER";
    
    public List getMarkers(String path){
        System.out.println("APackage.DOMCLass.getMarkers()");
        List markers = null;
        SAXBuilder saxBuilder = new SAXBuilder();
        File xml_file = new File(path);
        try{
            Document document = saxBuilder.build(xml_file);
            Element root = document.getRootElement();
            markers = root.getChildren(MARKER);
        } catch(JDOMException e){
            System.err.println("DOMClass.getMarkers() JDOMException " + e);
        } catch(IOException e){
            System.err.println("DOMClass.getMarkers() IOException " + e);
        }
        return markers;
    }
}
