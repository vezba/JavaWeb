
package paket3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NaruciKnjigu extends HttpServlet {

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
        ArrayList<String> naruceneKnjige =  (ArrayList<String>) sesija.getAttribute("sesijaKnjiga");
        
        
        if(naruceneKnjige==null){
            naruceneKnjige = new ArrayList<String>();
            sesija.setAttribute("sesijaKnjiga", naruceneKnjige);
        }
        String[] novi = request.getParameterValues("knjiga");
        
        if(novi!=null){
            for (String knjiga: novi) {
                naruceneKnjige.add(knjiga);
            }   
        }
        
        try (PrintWriter out = response.getWriter()) {
          out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<head>");
          out.println("<title>Servlet NaruciKnjigu</title>");            
          out.println("</head>");
          out.println("<body>");
          out.println("<h1>Narucene knjige </h1>");
          if(naruceneKnjige.isEmpty()){
             out.println("Nema proizvoda"); 
          }
          else{
              out.println("<ul style=\"display:table; margin: 0, auto\">");
              for (String knjiga : naruceneKnjige) {
                  out.println("<li>"+ knjiga +"</li>");
              }
              out.println("</ul>");
          }
          out.println("<a href = TrecaVezba>Nazad na narucivanje knjiga </a>");
          out.println("</body>");
          out.println("</html>");
      }
    }


}
