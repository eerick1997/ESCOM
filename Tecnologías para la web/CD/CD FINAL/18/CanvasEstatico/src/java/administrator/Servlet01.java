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
        out.println("<title>Servlet 01</title>");
        
        out.println("<script type='text/javascript'>");
        out.println("function draw(){");
        out.println("var canv = document.getElementById('MCanvas');");
        out.println("var ctx = canv.getContext('2d');");
        out.println("ctx.fillStyle = 'black';");
        out.println("ctx.fillRect(0,0,150,75)");
        out.println("}");
        out.println("</script>");
        
        out.println("</head>");
        
        out.println("<body onload='draw();'>");
        out.println("<canvas id='MCanvas' width='200' height='200'>No soporta canvas</canvas>");
        out.println("</body>");
        out.println("</html>");
    }
}
