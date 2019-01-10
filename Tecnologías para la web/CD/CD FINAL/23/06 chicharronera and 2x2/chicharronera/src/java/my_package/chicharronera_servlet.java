package my_package;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*Este programa tiene como objetivo resolver ecuaciones de segundo órden
del tipo AX^2 + BX + C = 0*/
public class chicharronera_servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {
            response.setContentType("text/html;charset=UTF-8");
            float A = Float.parseFloat(request.getParameter("A"));
            float B = Float.parseFloat(request.getParameter("B"));
            float C = Float.parseFloat(request.getParameter("C"));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet chicharronera_servlet</title>");
            out.println("</head>");
            out.println("<body>");
            //Verificamos si tanto A, B y C son cero
            if (A == 0 && B == 0 && C == 0) { //Si todos son cero
                out.println("<h1>El valor de X1 y X2 es 0 </h1>");
            } else {//Si alguno no es cero entonces
                //Verificamos que A no se acero
                if (A != 0) {
                    //Verificamos si lo que hay dentro de la raiz es o no negativo
                    float raiz = (B * B) - 4 * A * C;
                    if (raiz > 0) {
                        out.println("<h1>El valor de X1 es " + (-B + Math.sqrt(raiz)) / (2 * A) + "</h1>");
                        out.println("<br></br>");
                        out.println("<h1>El valor de X2 es " + (-B - Math.sqrt(raiz)) / (2 * A) + "</h1>");
                        out.println("<br></br>");
                    } else if (raiz < 0) {
                        out.println("<h1>La solución está en el dominio de los complejos</h1>");
                        out.println("<br></br>");
                        out.println("<h1>El valor de X1 es " + -B / (2 * A) + " + i" + Math.sqrt(Math.abs(raiz)) / (2 * A) + "</h1>");
                        out.println("<br></br>");
                        out.println("<h1>El valor de X1 es " + -B / (2 * A) + " - i" + Math.sqrt(Math.abs(raiz)) / (2 * A) + "</h1>");
                        out.println("<br></br>");
                    } else {
                        out.println("<h1>El valor de X1 es " + (-B + Math.sqrt(raiz)) / (2 * A) + "</h1>");
                        out.println("<br></br>");
                        out.println("<h1>El valor de X2 es " + (-B - Math.sqrt(raiz)) / (2 * A) + "</h1>");
                        out.println("<br></br>");
                    }
                } else {
                    out.println("<h1>No hay solución para esa ecuación</h1>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            out.println("<h1>Eso no es un numero</h1>");
        }

    }

}
