import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Tablas"})
public class Tabla extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;Charset=UTF-8");
        PrintWriter salida = response.getWriter();
        
        int num = Integer.parseInt(request.getParameter("cmpnum"));
        
        salida.println("<html><head><title>Tabla de multiplicar</title></head>");
        salida.println("<body>");
        salida.println("<center><h2>Tabla de multiplicar del "+num+"</h2></center>");
        salida.println("<table align='center' border='1'>");
        for(int i=1; i<=10; i++){
            salida.println("<tr><td bgcolor='white'>"+num+" x "+i+"</td>");
            salida.println("<td bgcolor='gray'>"+(num*i)+"</td>");
        }
        salida.println("</table>");
        salida.println("<br/><br/><center><a href='http://localhost:8080/prog9/'>Volver</a></center>");
        salida.println("</body></html>");
        salida.close();
        //super.service(request, response);
    }
 
}