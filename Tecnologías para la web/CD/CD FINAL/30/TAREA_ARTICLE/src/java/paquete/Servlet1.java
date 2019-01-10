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
        PrintWriter out = response.getWriter();
        String t1 = request.getParameter("txt_t1");
        String p1 = request.getParameter("txt_p1");
        String t2 = request.getParameter("txt_t2");
        String p2 = request.getParameter("txt_p2");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<article>");
        
        out.println("<h1>"+t1+"</h1>");
        out.println("<p>"+p1+"</p>");
        out.println("<h1>"+t2+"</h1>");
        out.println("<p>"+p2+"</p>");
        
        out.println("</article>");
        out.println("</body>");
        out.println("</html>");
    }
}
