package administrador;

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Element raiz = new Element("ROOT");
            Element hoja = new Element("hoja");
            hoja.setAttribute("numerodehojas", "4");
            hoja.setText("VALORDELNODO");
            raiz.addContent(hoja);

            Document newdoc = new Document(raiz);
            XMLOutputter fmt = new XMLOutputter();
            FileWriter writer = new FileWriter("c:\\pregunta2.xml");
            fmt.output(newdoc, writer);//Crear el archivo físicamente
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
