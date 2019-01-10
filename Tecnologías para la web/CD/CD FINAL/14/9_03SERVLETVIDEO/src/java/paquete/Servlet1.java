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
        String str = request.getParameter("clave_video");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet video</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<video width='320' height='240' controls>");
        out.println("<source src='" + str + "'>");
        out.println("Your browser doesn't support the video tag");
        out.println("</video>");
        out.println("</body>");
        out.println("</html>");
    }
}
