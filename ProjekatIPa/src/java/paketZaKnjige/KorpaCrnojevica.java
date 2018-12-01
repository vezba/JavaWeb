package paketZaKnjige;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class KorpaCrnojevica extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
     
     
    }


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
            
           // String prozderavanje = request.getParameter("hrana");
            String[] knjige = request.getParameterValues("knjiga");
            
//            if(!prozderavanje.isEmpty())
//                listaProzderavanja.add(prozderavanje);
            

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
            out.println("</ul>"
                    + "</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
