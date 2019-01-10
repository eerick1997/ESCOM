
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erick
 */
public class Servlet01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String str_img = request.getParameter("name_img");
        String align_value = request.getParameter("align_value");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet 01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='"+str_img+"' align='"+align_value+"'>");
        out.println("</body>");
      
        out.println("</html>");
    }

}
