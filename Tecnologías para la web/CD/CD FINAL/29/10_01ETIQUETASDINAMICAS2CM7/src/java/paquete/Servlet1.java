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
        response.setContentType("text/html;charset=;UTF-8");
        PrintWriter out = response.getWriter();
        String str = request.getParameter("clave_texto");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Uso de la etiqueta h1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + str + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

}
