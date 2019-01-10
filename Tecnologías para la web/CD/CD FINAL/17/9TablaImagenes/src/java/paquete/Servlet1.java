package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String Scolumnas = request.getParameter("clave_columnas");
        String Sfilas = request.getParameter("clave_filas");
        session.setAttribute("clave_filas", Sfilas);
        session.setAttribute("clave_columnas", Scolumnas);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet2' message = 'get'>");
        out.println("<table style='border:1px solid black' >");
        for (int i = 0, k = 0; i < Integer.parseInt(Scolumnas); i++) {
            out.println("<tr style='border:1px solid black'>");
            for (int j = 0; j < Integer.parseInt(Sfilas); j++, k++) {
                out.println("<td style='border:1px solid black'>Nombre imagen: <input type='text' name='clave_imagen" + k +"'>");
                out.println("<br/>URL:<input type='text' name='clave_url" + k+"'></td>");
            }
            out.println("<tr/>");
        }
        out.println("</table><br/>");
        out.println("<input type='submit'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    }
}
