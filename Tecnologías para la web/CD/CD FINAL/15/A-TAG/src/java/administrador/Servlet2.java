package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String str_number = String.valueOf(session.getAttribute("number"));
        int enlaces = Integer.parseInt(str_number);
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet 02</title>");
        out.println("</head>");
        out.println("<body>");
            for(int j = 0; j < enlaces; j++){
                out.println("<a href='"+request.getParameter("href" +j)+"'>" +request.getParameter("txt"+j)+"  </a><br/>");
            }
        out.println("</body>");
        out.println("</html>");

    }

}
