package paketi4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CetvrtaVezba extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CetvrtaVezba</title>");            
            out.println("</head>");
            out.println("<body>"
                    + "<form action = PrviServlet>"
                    + "<h1>Unesite tekst i kliknite posalji: </h1>"
                    + " Skola <input type = text name = skola> <br> <br>"
                    + " Smer<input type = text name = smer> <br> <br>"
                    + " Glupost profesora 1-10 <input type = text name=its> <br> <br>"
                    + "<input type = submit value=Posalji> "
                    + "</form>");
            out.println("</body>");
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
