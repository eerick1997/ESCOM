package APackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet01 extends HttpServlet {
    
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
         
         response.setContentType("text/html;charset=utf-8");
         PrintWriter out = response.getWriter();
         int number = Integer.parseInt(request.getParameter("nmarkers"));
         HttpSession session = request.getSession();
         session.setAttribute("nmarkers", number);
         
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet markers info</title>");
         out.println("<meta charset='UTF-8'>");
         out.println("</head>");
         
         out.println("<body>");
         out.println("<h1>Escribe las coordenadas de los marcadores</h1>");
         out.println("<form action='Servlet_map' method='GET'>");
         for(int i = 0; i < number; i++){
             out.println("<p>Marcador " + (i+1) + " de " + number + "</p><br/>");
             out.println("Titulo: <br/><input type='text' name='tit"+i+"'/><br/>");
             out.println("Latitud: <br/><input type='text' name='lat"+i+"'/> <br/>");
             out.println("Longitud: <br/><input type='text' name='lng"+i+"'/> <br/>");
         }
         out.println("<input type='submit' />");
         out.println("</form>");
         out.println("</body>");
         out.println("</html>");
         
     }
}
