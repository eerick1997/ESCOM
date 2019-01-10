package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String object_filas = (String)(session.getAttribute("clave_atributo_filas"));
        String object_columnas = (String)(session.getAttribute("clave_atributo_columnas"));
        int filas = Integer.parseInt(object_filas);
        int columnas = Integer.parseInt(object_columnas);
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servket tabla</title>");
        out.println("</head>");
        out.println("<body>");
        int k = 0;
        out.println("<table style ='border:1px solid black'>");
        for(int i = 0; i < columnas; i++){
            out.println("<tr style='border:1px solid black'>");
            for(int j = 0; j < filas; j++){
                out.println("<td style='border:1px solid black'>");
                out.println("<a> "+request.getParameter("clave_txt" +k++)+"</a>");
                out.println("</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }

}
