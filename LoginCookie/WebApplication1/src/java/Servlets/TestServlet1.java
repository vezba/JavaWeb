/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Classes.Enkripcija;
import Classes.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import Classes.UsersList;
import javax.servlet.http.Cookie;

/**
 *
 * @author Aleksa Kuzman
 */
public class TestServlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        UsersList ul = new UsersList();
        
        User u = new User(request.getParameter("user"),request.getParameter("pass"));
        
        boolean indikacija = false;
        for(User korisnik : ul.Korisnici)
        {
            indikacija=u.Compare(korisnik);
            if(indikacija)
                break;            
        }
        
        if(!indikacija)
        response.sendRedirect("index.jsp");
        
        
        
        byte[] sifrovanoUser = Enkripcija.encrypt(u.username, "0123456789abcdef");
        
        byte[] sifrovanoPass = Enkripcija.encrypt(u.password, "0123456789abcdef");
        
        Cookie user = new Cookie("User",sifrovanoUser.toString());
        Cookie pass = new Cookie("Password",sifrovanoPass.toString());
        
        response.addCookie(user);
        response.addCookie(pass);
        
        


       
        
        
        
        
        
    
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet1 at "+ user.getValue().toString()+"</h1>");
            out.println("<form method='post' action='servletTest2'><input type='submit' value='dalje'> </form> ");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(TestServlet1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(TestServlet1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
