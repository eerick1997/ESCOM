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
        PrintWriter out = response.getWriter();
        String no_btns = request.getParameter("no_btn");
        int i_no_btns = Integer.parseInt(no_btns);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Using buttons</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("</head>");
        out.println("<body>");
        for(int i = 0; i < i_no_btns; i++){
            out.println("<button>");
            out.println("<h1>Se pueden anidar etiquetas en el boton #"+i+"</h1>");
            out.println("<p>Por ejemplo podemos aniadir un parrafo</p>");
            out.println("</button><br/>");
        }
        out.println("</body>");
        out.println("</html>");
        
    }
}
