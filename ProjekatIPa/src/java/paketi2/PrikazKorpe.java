package paketi2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrikazKorpe extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
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
        HttpSession sesija = request.getSession();
        
        ArrayList<String> prethodniProizvodi = (ArrayList<String>)sesija.getAttribute("prethodniArtikli");      
        
        if(prethodniProizvodi == null){
            prethodniProizvodi = new ArrayList<String>();
            sesija.setAttribute("prethodniArtikli", prethodniProizvodi);
        }
        String novi = request.getParameter("artikal");
        if((novi != null) && (!novi.trim().equals(""))){
            prethodniProizvodi.add(novi);
        }

         try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PrikazKorpe</title>");            
            out.println("</head>");
            out.println("<body>"
                      + "<center>");
            out.println("<h1>Naruceni proizvodi</h1>");
            if(prethodniProizvodi.isEmpty()){
               out.println("Nema proizvoda"); 
            }
            else{
                out.println("<ul style=\"display:table; margin: 0, auto\">");
                for (String proizvod : prethodniProizvodi) {
                    out.println("<li>"+ proizvod +"</li>");
                }
                out.println("</ul>");
            }
            out.println("<a href='DrugaVezba'>Nazad na kupovinu </a>"
                      + "</center>");
            out.println("</body>");
            out.println("</html>");
        }
        
        
        
    }
}
