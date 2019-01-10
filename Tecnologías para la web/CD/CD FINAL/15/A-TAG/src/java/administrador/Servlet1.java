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
        String number_str = request.getParameter("number");
        int number = Integer.parseInt(number_str);
        
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.setAttribute("number", number);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet 01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet2' method='GET'>");
        for(int i = 0; i < number; i++){
            out.println("URL "+i+": <input type='text' name='href"+i+"'>");
            out.println("<br/>");
            out.println("Texto " + i + ": <input type='text' name='txt"+i+"'/>");
            out.println("<br/>");
        }
        out.println("<br/>");
        out.println("<input type='submit'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}