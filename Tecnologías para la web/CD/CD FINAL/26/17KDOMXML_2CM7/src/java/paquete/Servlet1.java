package paquete;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.*;
import org.jdom.output.XMLOutputter;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Servlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String path = request.getRealPath("\\a");
            System.out.println(">>>" + path);
            //Generamos dos eleementos
            //Elemento raiz
            Element raiz = new Element("ROOT");
            //Elemento hoja
            Element hoja = new Element("hoja");
            //Al elemento hoja le añanidos un atributo
            hoja.setAttribute("numerodehojas", "4");
            //En el elemento hay
            hoja.setText("VALORDELNODO");
            //Ligamos ambos elementos a raiz le agregamos hoja
            raiz.addContent(hoja);

            //Declaramos un documento raiz
            Document newdoc = new Document(raiz);
            //Generamos un elemento XMLOutputter
            XMLOutputter fmt = new XMLOutputter();
            //Crando archivo
            FileOutputStream fileOutputStream = new FileOutputStream(path + "\\file.xml");
            //Imprimimos el documento
            fmt.output(newdoc, fileOutputStream);
            //Cerramos
            fileOutputStream.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
