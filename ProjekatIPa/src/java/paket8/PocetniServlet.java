package paket8;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PocetniServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PocetniServlet</title>");            
            out.println("</head>");
            out.println("<body>"
                    + "<center>"
                    + "<form action=PocetniServlet method = post>"
                    + "Unesi pojam: <input type = text name = unos> "
                    + "<input type = submit value = Klikni>"
                    + ""
                    + "</form>"
                    + "</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         try (PrintWriter out = response.getWriter()) {
             Cookie cookies[] = request.getCookies();
             boolean pom = false;
             String unos = "";
             for(Cookie k : cookies){
                 if(k.getName().equals("rand1")){
                     pom = true;
                     unos = k.getValue();
                 }
                 else{
                     pom = false;
                     Cookie k1 = new Cookie("rand1", request.getParameter("unos"));
                     k1.setMaxAge(10);
                     response.addCookie(k1);
                 }
             }
             
             if(pom)
                 out.println("Fela kuti druzi stari! Garav brate nesvrstani, Sjecas li se kad smo se "+unos+" ?");
             else
                 out.println("Tito, Nehru, Naser, Sirimavo Bandaranajke");
         
         }
    }
}
