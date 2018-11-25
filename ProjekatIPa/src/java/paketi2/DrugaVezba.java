package paketi2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DrugaVezba extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DrugaVezba</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("    <center>\n" +
                        "        <h1>Narudzbenica</h1>\n" +
                        "        <form action=\"PrikazKorpe\" method=\"post\">\n" +
                        "            Unesite artikal koji zelite da porucite:\n" +
                        "            <input type=\"text\" name=\"artikal\"> <br><br>\n" +
                        "            <input type=\"submit\" value=\"Dodaj u korpu\"> \n" +
                        "        </form>\n" +
                        "    </center>\n" +
                        "    \n" +
                        "    ");
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
