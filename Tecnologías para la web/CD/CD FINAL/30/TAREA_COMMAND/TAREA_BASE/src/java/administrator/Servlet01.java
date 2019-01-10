package administrator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String img_title = request.getParameter("img");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>BASE TAG</title>");
        out.println("<base src='http://localhost:8080/TAREA_BASE/' target='_blank'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='"+img_title+"' alt='fractal'/>");
        out.println("</body>");
        
        out.println("</html>");
    }
}
