
package paketiLogovanja;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.ant.ListTask;


public class LoginServletAplikacije extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession sesija = request.getSession();
            
            boolean indikator = false;
            ListaKorisnika korisnici = new ListaKorisnika();
            Korisnik k = new Korisnik(request.getParameter("Ime"), request.getParameter("Lozinka"));
            
            if(korisnici.provjeraKorisnika(k)){
                sesija.setAttribute("korisnik", k);
                indikator = true;
            }
                
            
            
            Korisnik ulogovaniKorisnik = (Korisnik) sesija.getAttribute("korisnik");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServletAplikacije</title>");            
            out.println("</head>");
            out.println("<body>"
                    + "<center>");
            if(indikator){
                out.println("<h1>Uspesno ste se ulogovali "+ ulogovaniKorisnik.KorisnickoIme +"  </h1><br>"
                        + "<a href=\"HomeJsp.jsp\">Idite na pocetnu stranicu </a>");
            }
            else
            out.println("<h1>Doslo je do greske pokusajte ponovo!</h1>"
                    + "<a href = index.jsp> Nazad na login!</a>");
            out.println(""
                    + "</center></body>");
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
