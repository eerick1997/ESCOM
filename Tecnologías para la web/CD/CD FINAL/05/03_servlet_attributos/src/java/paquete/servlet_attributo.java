package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Un atributo también es un par, pero a cambio de un parámetro este recibe un objeto
public class servlet_attributo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        
        String valor1 = request.getParameter("clave1");
        PrintWriter out = response.getWriter();
        //Vamos a utilizar el valor HttpSession
        HttpSession session = request.getSession();
        session.setAttribute("Clave1_atributo", valor1);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet servlet_attributo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet servlet_attributo at " + valor1 + "</h1>");
        out.println("</body>");
        out.println("</html>");

    }

}
