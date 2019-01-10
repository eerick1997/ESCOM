package administrador;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         String str = request.getParameter("txt_tag");
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet 1</title>");
         out.println("</head>");
         
         out.println("<body>");
         out.println("<pre> " + str + " <pre>");
         out.println("</body>");
         out.println("</html>");
    }
}
