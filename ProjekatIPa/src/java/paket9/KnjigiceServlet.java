
package paket9;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KnjigiceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesija = request.getSession();
            
            ArrayList<String> listaProizvoda = (ArrayList<String>) sesija.getAttribute("proizvod");
            
            if (listaProizvoda==null){
                listaProizvoda = new ArrayList<String>();
                sesija.setAttribute("proizvod", listaProizvoda);
            }
            String[] knjige = request.getParameterValues("proizvod");
            
            if(knjige!=null)
                for(String knjiga: knjige){
                    listaProizvoda.add(knjiga);
                }
            

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet KnjigiceServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Narucili ste</h1>");
            if(listaProizvoda.isEmpty()){
                out.println("Niste odabrali nista!");
            }
            else{
                out.println("<h2> Lista knjiga </h2>"
                        + "<ul>");
                for(String data: listaProizvoda){
                    out.println("<li> "+ data +"</li>");
                }
                out.println("</ul>");
            }
            
            out.println("<a href = knjigeHtml.html> Vrati se nazad </a>  ");
            out.println("<a href = NovinaServlet> Idi dublje </a>");
            
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
