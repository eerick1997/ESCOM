package administrator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet02 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String number_str = String.valueOf(session.getAttribute("number"));
        int number = Integer.parseInt(number_str);
        
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet 02</title>");
        out.println("</head>");
        
        out.println("<body>");
        out.println("<dl>");
        for(int i = 0; i < number; i++){
            out.println("<dt>"+request.getParameter("txtdt"+i)+"</dt>");
            out.println("<dd>"+request.getParameter("txtdd"+i)+"</dl>");
        }
        out.println("</dl>");
        out.println("</body>");
        out.println("</html>");
    }
}
