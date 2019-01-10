package APackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Element;

public class Servlet_get_xml extends HttpServlet {

    private static final String TIT = "TITLE";
    private static final String LAT = "LATITUDE";
    private static final String LNG = "LONGITUDE";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List markers = new DOMCLass().getMarkers(request.getRealPath("\\Markers.xml"));
        out.println("<!DOCTYPE html>");
        out.println("<html>");
            out.println("<head>");
                out.println("<title>Servlet map</title>");
                out.println("<meta name='viewport' content='initial-scale=1.0'>");
                out.println("<m eta charset='UTF-8'>");
                out.println("<style>");
                    out.println("#map{");
                        out.println("height: 100%;");
                    out.println("}");
                    out.println("html, body{");
                        out.println("height: 100%;");
                        out.println("maigin: 0;");
                        out.println("padding: 0;");
                    out.println("}");

                out.println("</style>");
                
                out.println("<script>");
                
                out.println("var map;");
                out.println("function initMap(){");
                
                    out.println("var infoWindow = new google.maps.InfoWindow();");
                    out.println("map = new google.maps.Map(document.getElementById('map'), {");
                        out.println("center: {lat: -34, lng: 150.644},");
                        out.println("zoom:4");
                    out.println("});");
                    
                    out.println("function addMarker(lat, lng, txt){");
                        out.println("var LatLng = new google.maps.LatLng(lat, lng);");
                        out.println("var marker = new google.maps.Marker({");
                            out.println("position: LatLng,");
                            out.println("map: map");
                        out.println("});");
                        
                        out.println("google.maps.event.addListener(marker, 'click', function(){");
                            out.println("infoWindow.close();");
                            out.println("infoWindow.setContent('<p>'+txt+'</p>');");
                            out.println("infoWindow.open(map, marker);");
                        out.println("});");
                    out.println("}");
                        
                    for(int i = 0; i < markers.size(); i++){
                        Element marker = (Element)markers.get(i);
                        out.println("addMarker("+marker.getChildText(LAT)+", "+marker.getChildText(LNG)+", '"+marker.getChildText(TIT)+"');");
                    }
                out.println("}");
            out.println("</script>");
            
            out.println("</head>");
        
            out.println("<body>");
            out.println("<div id='map' />");

            out.println("<script src='https://maps.googleapis.com/maps/api/js?key=AIzaSyAS4fTewZ1VDbuK8escHtAwFVdm-xAM9G4&callback=initMap'"
                    + "async defer/>");

            out.println("</body>");
        out.println("</html>");
    }
}
