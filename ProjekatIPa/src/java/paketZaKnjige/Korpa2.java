/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paketZaKnjige;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ilhan Kalac
 */
public class Korpa2 extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
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
        processRequest(request, response);
         try (PrintWriter out = response.getWriter()) {
            HttpSession sesija = request.getSession();
            
            ArrayList<String> lista =(ArrayList<String> )sesija.getAttribute("staraKnjiga");
            ArrayList<String> listaProzderavanja =(ArrayList<String> )sesija.getAttribute("staraHrana");
            if(lista==null){
                lista = new ArrayList<String>();
                sesija.setAttribute("staraKnjiga", lista);
            }
            if(listaProzderavanja==null){
                listaProzderavanja = new ArrayList<String>();
                sesija.setAttribute("staraHrana", listaProzderavanja);
            }
            
            String prozderavanje = request.getParameter("hrana");
            String[] knjige = request.getParameterValues("knjiga");
            
            if(prozderavanje!=null)
                listaProzderavanja.add(prozderavanje);
            
            if(knjige!=null)
                for(String k: knjige){
                    lista.add(k);
            }
  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Korpa</title>");            
            out.println("</head>");
            out.println("<body>"
                    + "<ul>");
               
               for (String item : lista) {
                   out.println("<li>" + item +"</li>");
               }
                out.println(  "</ul>");
                out.println(  "<ul>");
               
               for (String item : listaProzderavanja) {
                   out.println("<li>" + item +"</li>");
               }
               
            out.println("</ul>"
                    + "</body></html>");
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
        processRequest(request, response);
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
