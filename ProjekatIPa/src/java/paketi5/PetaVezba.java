package paketi5;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PetaVezba extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Cookie cookies[] = request.getCookies();
            String html ="";
            for (Cookie k : cookies) {
   
               if (k.getValue().equals("novi5")){
                   html = "Drago nam je da ste opet tu";
               }
               else{
                Cookie kolac = new Cookie("hehe", "novi5"); 
                kolac.setMaxAge(20);
                response.addCookie(kolac);
                html = "Dobrodosli";
               
               }
           }
            String mentalitet = "Ujna mi za 20 maraka radi u Kombinat\n<br>" +
                                "da nadje bolji pos'o nece za inat\n<br>" +
                                "striko skuplja staro gvozdje\n<br>" +
                                "pod teretom kicma stenje\n<br>" +
                                "on u bolji pos'o nema povjerenje\n<br>" +
                                "seja mi za dragim svake noci vene reze\n<br>" +
                                "preko dana njega rucerdama steze\n<br><br>" +
                                "\n" +
                                "Mentalitet, mentalitet, mentalitet\n<br>" +
                                "sveukupni ljudski kvalitet<br><br>";
            
            String propalitet = "Moj entitet gaji natalitet\n<br>" +
                                "jer kvantitet proizvodi kvalitet\n<br>" +
                                "tako misli svaki propalitet\n<br>" +
                                "suze i sline isti salinitet\n<br><br>" +
                                "\n" +
                                "Mentalitet, mentalitet, mentalitet\n<br>" +
                                "sveukupni ljudski kvalitet\n<br><br>" +
                                "\n" +
                                "BOLJE JEDNO VRUCE PIVO NEGO CETIRI LADNA\n<br>" +
                                "BOLJE STARA BABA NEGO PICKA MLADA........... X5";
            
            Cookie kolac1 = new Cookie ("prenos1", mentalitet);
            Cookie kolac2 = new Cookie ("prenos2", propalitet);
            response.addCookie(kolac1);
            response.addCookie(kolac2);

            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PetaVezba</title>");            
            out.println("</head>");
            out.println("<body align=center>");
            out.println("<h1>" +html + "</h1>"
                    + " <a href = CookieServlet> Prikazi genijalni tekst </a>");
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
