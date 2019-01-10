package administrator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
            out.println("<title>COMMAND TAG</title>");
            out.println("<script type='text/javascript'>");
                out.println("function click(){");
                out.println("alert('" + request.getParameter("str")+"');");
                out.println("}");
            out.println("</script>");
        out.println("</head>");
        out.println("<body>");
            out.println("<p>Command es una etiqueta depreciada podría no funcionar an algunos navegadores<p>");
            out.println("<command type='command' label='click' onclick='click()'>");
            out.println("Clickeame ;)");
            out.println("</command>");
            out.println("</body>");
        out.println("</html>");
        
    }
}
