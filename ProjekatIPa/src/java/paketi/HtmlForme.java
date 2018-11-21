/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paketi;

/**
 *
 * @author Ilhan Kalac
 */
public class HtmlForme {
    public static String forma(){
       return "<!DOCTYPE html>"+
                        "<html>"+
                        "<head>"+
                        "<title>Servlet PrvaVezba</title>"+        
                        "</head>"+
                        "<body> <center>"+
                        "<form action=\"PrvaVezba\" method=\"post\">"+
                        "<div style=\"width: 60%; background-color:lightgray; border:1px solid black; color:darkblue;  padding-right: 2px; font-style: italic\">\n" +
                        "        <h3>OSNOVNI PODACI O POSLOVNOM PARTNERU </h3>\n" +
                        "        <table border=\"1\" width=\"50%\">\n" +
                        "            <tr>\n" +
                        "                <th>Ime</th>\n" +
                        "                <th> <input  type=\"text\" name=\"ime\"></th>  \n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <th>Adresa</th>\n" +
                        "                <th> <input  type=\"text\" name=\"adresa\"></th> \n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <th>E-mail</th>\n" +
                        "                <th> <input  type=\"text\" name=\"email\"></th> \n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <th>Telefon</th>\n" +
                        "                <th> <input  type=\"text\" name=\"telefon\"></th> \n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <th>Zanimanje</th>\n" +
                        "                <th>\n" +
                        "                    <select name=\"zanimanje\">\n" +
                        "                        <option value=\"profesor\"> Profesor</option>\n" +
                        "                        <option value=\"programer\"> Programer</option>\n" +
                        "                        <option value=\"direktor\"> Direktor</option>\n" +
                        "                    </select>\n" +
                        "                </th>          \n" +
                        "            </tr>\n" +
                        "        </table> \n" +
                        "        <h4>Predznanje Jave</h4> \n" +
                        "        <input type=\"radio\" name=\"predznanje\" value=\"nema\"> Nema \n" +
                        "        <input type=\"radio\" name=\"predznanje\" value=\"Malo\"> Malo \n" +
                        "        <input type=\"radio\" name=\"predznanje\" value=\"Srednje\"> Srednje\n" +
                        "        <input type=\"radio\" name=\"predznanje\" value=\"Veliko\"> Visoko \n" +
                        "        <h4 style=\"font-style: italic\">Napomena</h4>\n" +
                        "        <textarea rows=\"5\" cols=\"35\" name=\"napomena\"> </textarea> <br> \n" +
                        "\n" +
                        "        <input type=\"checkbox\" name=\"uBazi\"> Da li želite da budete sačuvani u bazi? <br><br><br>\n" +
                        "\n"+
                        "        <div align=\"right\">\n" +
                        "            <input type=\"submit\" value=\"Obradi Partnera\">\n" +
                        "            <input type=\"reset\" value=\"Obrisi formu\">\n" +
                        "        </div> <br>\n" +
                        "    </div>"+
                        "</form>"+
                        "</center></body>"+
                        "</html>";
        
    }
}
