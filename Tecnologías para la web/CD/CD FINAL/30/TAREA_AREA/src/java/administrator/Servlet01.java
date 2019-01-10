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
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Area TAG</title>");
        out.println("</head>");
        
  
        
        out.println("<body>");
        
        out.println("<map name='content'>");
                out.println("<area href='' shape='circle' coords='"+x+","+y+","+r+"' alt='Something' >");
        out.println("</map>");
        
            out.println("<canvas id='canvas' width='1920px' height='1080px' usemap='#content'>");
            out.println("El navegador no soporta canvas</canvas>");
            out.println("<script>");
                    out.println("var canvas = document.getElementById('canvas');");
                    out.println("var ctx = canvas.getContext('2d');");
                    out.println("ctx.arc("+x+","+y+","+r+",0, (Math.PI*180)/360, true);");
                    out.println("ctx.fillStyle = '#f00';");
                    out.println("ctx.fill();");
                    out.println("ctx.stroke();");
                out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }

}
