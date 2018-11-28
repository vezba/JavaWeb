
package paket6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletLista extends HttpServlet {


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
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession sesija = request.getSession();
            
            
            
            ArrayList<String> listaPolova = (ArrayList<String>)sesija.getAttribute("pol");
            ArrayList<String> listaRez = (ArrayList<String>)sesija.getAttribute("rez");
            ArrayList<String> listaFilmova = (ArrayList<String>)sesija.getAttribute("film");
            
            
            if(listaPolova == null)
            {
                listaPolova = new ArrayList<String>();
                sesija.setAttribute("pol", listaPolova);
            }
            
            if(listaRez == null)
            {
                listaRez = new ArrayList<String>();
                sesija.setAttribute("rez", listaRez);
            }
            
            if(listaFilmova == null)
            {
                listaFilmova = new ArrayList<String>();
                sesija.setAttribute("film", listaFilmova);
            }    

            String[] rejdio = request.getParameterValues("Pol");
            
            if(rejdio!=null){
                for(String pol : rejdio){
                    listaPolova.add(pol);
                }
            }
            String[] reziseri = request.getParameterValues("reziser");
            
            if(reziseri!=null){
                for(String reziser : reziseri){
                    listaRez.add(reziser);
                }
            }
            String omiljeniFilm = request.getParameter("omiljenifilm");
           
            listaFilmova.add(omiljeniFilm);
                
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Informacije</h2>");
            if(listaPolova.isEmpty())
                out.print("Nema podataka!");
            else{
                out.print("Polovi:<ul>");
                for(String data : listaPolova)
                    out.print("<li>" + data + "</li>");
            }
            if(listaRez.isEmpty())
                out.print("Nema podataka!");
            else{
                out.print("Reziseri:<ul>");
                for(String data : listaRez)
                    out.print("<li>" + data + "</li>");
            }
            
            if(listaFilmova.isEmpty())
                out.print("Nema podataka!");
            else{
                out.print("Filmovi:<ul>");
                for(String data : listaFilmova)
                    out.print("<li>" + data + "</li>");
            }
            out.print("</ul>");
                
            out.print("<a href=index1.html>Nazad na popunjavanje podataka</a>");
            out.println("</body>");
            out.println("</html>");
            
        }
    }

}
