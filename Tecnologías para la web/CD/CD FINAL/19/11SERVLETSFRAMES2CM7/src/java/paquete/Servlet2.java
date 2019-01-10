package paquete;

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
        String numero = (String) session.getAttribute("anumero");
        String parametros = "?";
        int numeroi = Integer.parseInt(numero);
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet2</title>");
        out.println("</head>");
        out.println("<frameset cols='30%, *'/>");
        for (int i = 0; i < numeroi; i++) {
            parametros += "href" + i + "=" + request.getParameter("href" + i) + "&texto" + i + "=" + request.getParameter("texto" + i) + "&";
        }
        out.println("<frame src='Servlet3" + parametros + "'/>");
        out.println("<frame src='Servlet5' name='contenidos'/>");
        out.println("<body>");

        out.println("</body>");
        out.println("</html>");
    }
}
