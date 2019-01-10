package administrator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet01 extends HttpServlet {
    
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
         
         response.setContentType("text/html;charset=UTF-8");
         int number = Integer.parseInt(request.getParameter("number"));
         HttpSession session = request.getSession();
         session.setAttribute("number", number);
         PrintWriter out = response.getWriter();
         
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet 01</title>");
         out.println("</head>");
         
         out.println("<body>");
         out.println("<form action='Servlet02' method='GET'>");
         for(int i = 0; i < number; i++){
            out.println("Valor "+i+": <input type='text' name='value"+i+"'/><br/>");
            out.println("Texto "+i+": <input type='text' name='txt"+i+"'/><br/>");
         }
         out.println("<input type='submit'/>");
         out.println("</form>");
         out.println("</body>");
         out.println("</html>");
     }
}
