package my_package;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet_send_direct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String parameter = request.getParameter("parameter");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet servlet_send_direct</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet servlet_send_direct at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");

    }

}
