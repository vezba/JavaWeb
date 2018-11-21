
package paketi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RadSaBazom {
      public void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
           String Ime = request.getParameter("ime");
           String Adresa = request.getParameter("adresa");
           String Telefon = request.getParameter("telefon");
           String Email = request.getParameter("email");
           String Zanimanje = request.getParameter("zanimanje");
           String Predznanje = request.getParameter("predznanje");
           String Napomena = request.getParameter("napomena");
           String uBazi = request.getParameter("uBazi");

           Class.forName("com.mysql.jdbc.Driver");
           String URL =  "jdbc:mysql://localhost:3306/its", USER = "root", PASS = "";
           Connection con = DriverManager.getConnection(URL, USER, PASS);
           
           String insert = "insert into PoslovniPartneri (ime, adresa, mail, telefon, predznanje, napomena, zanimanje)"
                   + "values (?, ?, ?, ?, ?, ?, ?)";
           
           if(uBazi!=null){
               PreparedStatement pst = con.prepareStatement(insert);
               pst.setString(1,Ime);
               pst.setString(2,Adresa);
               pst.setString(3,Telefon);
               pst.setString(4,Email);
               pst.setString(5,Zanimanje);
               pst.setString(6,Predznanje);
               pst.setString(7,Napomena);
               pst.executeUpdate();
           }           
           select(request, response, con);
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrvaVezba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrvaVezba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      public void select(HttpServletRequest request, HttpServletResponse response, Connection konekcija)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

           String select = "select *from its.PoslovniPartneri";
           
           Statement st = konekcija.createStatement();
           ResultSet rs = null;           
           rs = st.executeQuery(select);
           out.print("<form action =\"PrvaVezba\" method=\"post\" >");
           out.print("<center>"
                   + "<table border=1 >\n"
                   + " <caption>Stanje u bazi </caption>"
                   + " <tr> \n"
                   + "    <th>Id</th>\n"
                   + "    <th>Ime</th>\n"
                   + "    <th>Adresa</th>\n"
                   + "    <th>E-mail</th>\n"
                   + "    <th>Telefon</th>\n"
                   + "    <th>Zanimanje</th>\n"
                   + "    <th>Predznanje</th>\n"
                   + "    <th>Napomena</th>\n"
                   + " </tr>\n");
           while(rs.next()){
            out.println( "<tr> \n"+
                    "<td align =\"center\">"+ rs.getString(1)+ "</td>"+
                    "<td align =\"center\">"+ rs.getString(2)+ "</td>"+
                    "<td align =\"center\">"+ rs.getString(3)+ "</td>"+
                    "<td align =\"center\">"+ rs.getString(4)+ "</td>"+
                    "<td align =\"center\">"+ rs.getString(5)+ "</td>"+
                    "<td align =\"center\">"+ rs.getString(6)+ "</td>"+
                    "<td align =\"center\">"+ rs.getString(7)+ "</td>"+
                    "<td align =\"center\">"+ rs.getString(8)+ "</td>"+ 
                    "</tr>\n");
           }
               out.print("<input type=\"hidden\" name=\"action\" value=\"delete\"/>"
                   + " <input type=\"submit\" value=\"Obrisi sve\" style=\"display:inline;\"/>"
                   + "</center>"
                       + "</form>");
        } catch(SQLException ex){
            
        }
        
      
      }
       public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
           Class.forName("com.mysql.jdbc.Driver");
           String URL =  "jdbc:mysql://localhost:3306/its", USER = "root", PASS = "";
           Connection con = DriverManager.getConnection(URL, USER, PASS);
            
           String delete = "delete from PoslovniPartneri where id > 0";
           PreparedStatement pst = con.prepareStatement(delete);
           
           pst.executeUpdate();
           
           select(request,response, con);
        } catch (ClassNotFoundException | SQLException ex) {
              Logger.getLogger(RadSaBazom.class.getName()).log(Level.SEVERE, null, ex);
          }
       }
      
}
