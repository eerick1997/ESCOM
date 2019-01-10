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
        PrintWriter out = response.getWriter();
        int cuadritos = Integer.parseInt(request.getParameter("clave_cuadritos"));
        int dimen = Integer.parseInt(request.getParameter("clave_dimen"));

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet1</title>");
        out.println("<script type='text/javascript'>");
        out.println("function draw(){");
        out.println("var canvas = document.getElementById('UsingCanvas');");
        out.println("if(canvas.getContext){");
        out.println("var ctx = canvas.getContext('2d');");
        //Aquí comenzamos a dibujar
        int position = 0;
        for(int i = 0; i < cuadritos; i++){
            position+=10;
            out.println("ctx.fillStyle='rgb(200,0,0)'");//Ponemos color
            out.println("ctx.fillRect("+(position+10)+","+(position+10)+","+(dimen)+", "+dimen+")");//Posición de nuestros cuadritos
            out.println("ctx.fillStyle='rgba(0,0,200,0.5)'");
            out.println("ctx.fillRect("+(position+30)+","+(position+30)+","+(dimen)+", "+dimen+")");
        }
        out.println("   }");
        out.println("}");
        out.println("</script>");
        out.println("<style type='text/css'>");
        out.println("canvas{border: 1px solid black;}");
        out.println("</style>");
        out.println("</canvas>");
        out.println("</head>");

        out.println("<body onload='draw();'>");
            out.println("<canvas id='UsingCanvas' width='500' height='500'></canvas>");
        out.println("</body>");
        out.println("</html>");
    }
}
