package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String str = request.getParameter("clave_texto");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Uso de la etiqueta p y align</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p align='left'>" + str + "</p><br/><p align='center'>" + str+ "</p><br/><p align='right'> " + str + " </p>");
        out.println("</body>");
        out.println("</html>");
    }

}
