package my_package;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class atributos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String valor_01 = (String)session.getAttribute("clave_atributo_01");
        String valor_02 = (String)session.getAttribute("clave_atributo  _02");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet atributos</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>" + valor_01 + "</h1>");
        out.println("<br/>");
        out.println("<h1>"+ valor_02 + "</h1>");

        out.println("</body>");
        out.println("</html>");

    }
}
