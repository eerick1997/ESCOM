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
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet 01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<textarea rows='"+request.getParameter("rows")+"' cols='"+request.getParameter("cols")+"'>");
        out.println(request.getParameter("txt"));
        out.println("</textarea>");
        out.println("</body>");
        out.println("</html>");
    }
}
