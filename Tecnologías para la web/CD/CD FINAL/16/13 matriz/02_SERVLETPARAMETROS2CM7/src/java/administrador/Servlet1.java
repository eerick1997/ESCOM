package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Usamos parámetros cuando 
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String valor_filas = request.getParameter("clave_parametro_filas");
        String valor_columnas = request.getParameter("clave_parametro_columnas");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.setAttribute("clave_atributo_filas", valor_filas);
        session.setAttribute("clave_atributo_columnas", valor_columnas);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Formulario servlet 01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet2' message = 'get'>");
        out.println("<table style='border:1px solid black' >");
        for(int i = 0, k = 0; i < Integer.parseInt(valor_columnas); i++){
            out.println("<tr style='border:1px solid black'>");
            for(int j=0; j<Integer.parseInt(valor_filas); j++, k++){
                out.println("<td style='border:1px solid black'>texto: <input type='text' name='clave_txt"+k+"'></td>");
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