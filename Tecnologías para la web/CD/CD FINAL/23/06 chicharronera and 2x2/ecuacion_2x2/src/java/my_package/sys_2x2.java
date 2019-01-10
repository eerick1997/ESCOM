package my_package;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sys_2x2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        try {
            float A_1 = Float.parseFloat(request.getParameter("A_1"));
            float B_1 = Float.parseFloat(request.getParameter("B_1"));
            float A_2 = Float.parseFloat(request.getParameter("A_2"));
            float B_2 = Float.parseFloat(request.getParameter("B_2"));
            float R_1 = Float.parseFloat(request.getParameter("R_1"));
            float R_2 = Float.parseFloat(request.getParameter("R_2"));

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sys_2x2</title>");
            out.println("</head>");
            out.println("<body>");

            //out.println("<h1>Servlet sys_2x2 at " + request.getContextPath() + "</h1>");
            if (A_1 == 0 || B_1 == 0 || A_2 == 0 && B_2 == 0) {
                out.println("<h1>Hay soluciones infinitas</h1>");
            } else {
                out.println("<h1>" + A_1 + "x +" + B_1 + "y = " + R_1 + "</h1>");
                out.println("<br/>");
                out.println("<h1>" + A_2 + "x +" + B_2 + "y = " + R_2 + "</h1>");

                float determinante = A_1 * B_2 - B_1 * A_2;
                float determinante_X1 = R_1 * B_2 - B_1 * R_2;
                float determinante_Y1 = A_1 * R_2 - R_1 * A_2;
                out.println("<br/>");
                if (determinante_X1 != 0 || determinante_Y1 != 0) {
                    out.println("<h1> X = " + determinante_X1 / determinante + " </h1>");
                    out.println("<br/>");
                    out.println("<h1> X = " + determinante_Y1 / determinante + " </h1>");
                } else {
                    out.println("<h1>Indefinido</h1>");
                }

            }

            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            out.println("<h1>Eso no es un número</h1>");
        }
    }

}
