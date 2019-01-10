package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//La palabra reservada class está a nivel de encapsulamiento
public class Servlet01 extends HttpServlet {

    //protected = nivel de acceso
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
            //Establecemos el tipo de contenido
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            //Indicador de que es un documento HTML5
            out.println("<!DOCTYPE html>");
            //Inicio del documento
            out.println("<html>");
            //JavaScript o algunas otras cosas
            out.println("<head>"); //Dentro de estas etiquetas va la funcionalidad y estílo
            out.println("<title>Servlet Servlet01</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello world</h1>");
            out.println("</body>");
            out.println("</html>");
    }
}
/**Tenemos dos tipos de flujo para el println texto y bit**/
/*Una página estátita existe físicamente el archivo la dinámica no*/