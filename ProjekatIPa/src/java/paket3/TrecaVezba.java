
package paket3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TrecaVezba extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TrecaVezba</title>");            
            out.println("</head>");
            out.println("<body>"
                    + "<form action = NaruciKnjigu method = post>");
            out.println(" <h2>Narucivanje knjiga - Potrosacka korpa</h2>\n" +
                        "    <h2>Proizvodi</h2>\n" +
                        "    <input type =\"checkbox\" name=\"knjiga\" value=\"Decaci Pavlove ulice\">Decaci Pavlove ulice  <br>  \n" +
                        "    <input type =\"checkbox\" name=\"knjiga\" value=\"Pedeset nijansi sive\">Pedeset nijansi sive  <br>\n" +
                        "    <input type =\"checkbox\" name=\"knjiga\" value=\"Moj potpis\">Moj potpis<br>  \n" +
                        "    <input type =\"checkbox\" name=\"knjiga\" value=\"Autobiografija Bobana Rajovica\">Autobiografija Bobana Rajovica<br>  \n" +
                        "    \n" +
                        "    <input type=\"submit\" value=\"Naruci knjigu\" style=\"margin-left:  25%\"> \n" +
                        "  "
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
