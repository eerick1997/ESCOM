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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String numero = (String) session.getAttribute("numero");
        int numeroi = Integer.parseInt(numero);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet2</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<canvas id='myCanvas' width='600' height='800'/>");
        out.println("<script>");
        out.println("var canvas = document.getElementById('myCanvas');");
        out.println("var context = canvas.getContext('2d');");
        for (int i = 0; i < numeroi; i++) {
            out.println("context.beginPath();");
            out.println("context.moveTo("+request.getParameter("xi"+i)+", "+request.getParameter("xi"+i)+");");
            out.println("context.lineTo("+request.getParameter("xf"+i)+", "+request.getParameter("yf"+i)+");");
            out.println("context.stroke();");
        }
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }

}
