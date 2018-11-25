package paketi5;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Cookie[] cookies = request.getCookies();
        String[] tekstovi = new String[2];
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("prenos1")){
                tekstovi[0] = cookie.getValue();
            } 
            else if(cookie.getName().equals("prenos2")){
                tekstovi[1] = cookie.getValue();
            }
        }
        
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookieServlet</title>");            
            out.println("</head>");
            out.println("<body>"
                    + "<center>"
                    + "<div style= padding: 15px> ");
            out.println("<h1>Bolje jedno vruce pivo nego cetiri ladna</h1>");
            out.println(tekstovi[0] +"<br>");
            out.println(tekstovi[1]);
            out.println("</div>"
                    + "<br>  <a href = PetaVezba> Vrati se nazad </a>"
                    + "</center>"
                   
                    + "</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }



}
