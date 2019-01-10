package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet3 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
	HttpSession sesion = request.getSession();
	String number = (String) sesion.getAttribute("number");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet 03</title>");
        out.println("</head>");
        out.println("<body>");
	for (int i = 0; i < Integer.parseInt(number); i++) {
	    out.print("<a href='" + request.getParameter("href" + i) + "' target='contenidos' >");
	    out.println(request.getParameter("txt" + i) + "</a>");
	    out.println("<br/>");
	}
        out.println("</body>");
        out.println("</html>");
    }

}