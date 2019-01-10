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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String s_no_sqr = (String)session.getAttribute("no_sqr");
        int i_no_sqr = Integer.parseInt(s_no_sqr);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>CANVAS</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("<script type='text/javascript'>");
        out.println("function draw(){");
        out.println("var canvas = document.getElementById('my_canvas');");
        out.println("if(canvas.getContext){");
        out.println("var ctx = canvas.getContext('2d')");
        for(int i = 0; i < i_no_sqr; i++){
            out.println("ctx.fillStyle='black';");
            out.println("ctx.fillRect("+request.getParameter("x"+i)+", "+request.getParameter("y"+i)+", "+request.getParameter("size"+i)+", "+request.getParameter("size"+i)+");");
        }
        out.println("}");
        out.println("}");
        out.println("</script>");
        out.println("<body onload='draw();'>");
        out.println("<canvas id='my_canvas' width='1000' height='1000'>Canvas no soportado</canvas>");
        out.println("</body>");
        out.println("</html>");
    }
}
