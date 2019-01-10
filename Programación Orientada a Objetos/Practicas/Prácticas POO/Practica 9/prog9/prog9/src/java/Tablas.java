import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns = {"/Tablas"})
public class Tablas extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;Charset=UTF-8");
        PrintWriter salida = response.getWriter();
        
        int num = Integer.parseInt(request.getParameter("cmpnum"));
        
        if(num>0 && num<=12){
            response.sendRedirect("Tabla?cmpnum="+num);
        }else{
            salida.println("<html><body>");
            salida.println("<center><h2><font color='red'>No existe esta tabla de multiplicar</font></h2></center>");
            //salida.println("<br/><br/><center><a href='http://localhost:8080/prog9/'>Volver</a></center>");
            salida.println("</body></html>");
            super.doPost(request, response);
        }
        salida.println("<br/><br/><center><a href='http://localhost:8080/prog9/'>Volver</a></center>");
        salida.close();
    }
 
}

