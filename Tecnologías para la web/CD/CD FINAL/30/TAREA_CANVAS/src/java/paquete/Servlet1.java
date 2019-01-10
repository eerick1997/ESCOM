package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s_no_sqrt = request.getParameter("no_sqr");
        HttpSession session = request.getSession();
        session.setAttribute("no_sqr", s_no_sqrt);
        int i_no_sqrt = Integer.parseInt(s_no_sqrt);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Form canvas</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("</head>");
        
        out.println("<body>");
        out.println("<form action='Servlet2' method='get'>");
        for(int i = 0; i < i_no_sqrt; i++){
            out.println("X: <input type='text' name='x"+i+"'/>");
            out.println("Y: <input type='text' name='y"+i+"'/>");
            out.println("tamanio <input type='text' name='size"+i+"'/><br/>");
        }
        out.println("<input type='submit'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    
}
