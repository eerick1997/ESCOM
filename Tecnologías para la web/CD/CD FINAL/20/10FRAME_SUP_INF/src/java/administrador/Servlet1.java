package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	String number = request.getParameter("number");
        HttpSession session = request.getSession();
	session.setAttribute("number", number);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet 01</title>");
        out.println("</head>");
        out.println("<body>");
	out.println("<form action='Servlet2' method='GET'>");
	for (int i = 0; i < Integer.parseInt(number); i++) {
	    out.println("Enlaces: <input type='text' name='href" + i + "'/>");
	    out.println("<br/>");
	    out.println("Texto: <input type='text' name='txt" + i + "'/>");
	    out.println("<br/>");
	}
	out.println("<input type='submit'/>");
	out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

}