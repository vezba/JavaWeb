
package paket7;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession sesija = request.getSession();
            
            
            
            String attemptUser = request.getParameter("user");
            String attemptPassword = request.getParameter("password");
            
            for(Korisnik k: new ListaKorisnika().korisnici()){
                if(k.userName.equals(attemptUser) && k.password.equals(attemptPassword)){
                    
                    sesija.setAttribute("username", attemptUser);
                    sesija.setAttribute("lozinka", attemptPassword);
                    response.sendRedirect("ServletZaKorisnika");
                    return;
                }
            }
            
            response.sendRedirect("loginHtml.html");
            
  
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
