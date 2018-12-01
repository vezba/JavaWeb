package Servlets;
import Classes.User;
import Classes.UserList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean indikator = false;
        UserList korisnici = new UserList();
        HttpSession sesija = request.getSession();
        User user;
        
        if(korisnici.authentifikuj(user = new User(request.getParameter("username"), request.getParameter("password"))))
        {
            indikator = true;
            sesija.setAttribute("user", user);
        }
            
        
        
        
       
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            if(indikator){
                out.println("<h1>Ulogovali ste se</h1>");
                out.println("<a href='servlet2'> dalje </a>");

            }
            else{
                out.println("<h1>Doslo je do greske</h1>");
            }
            
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
