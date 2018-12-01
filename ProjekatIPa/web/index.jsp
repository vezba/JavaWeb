<%-- 
    Document   : index
    Created on : 21-Nov-2018, 17:31:35
    Author     : Ilhan Kalac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        #listaVezbi {
            font-size : 130%

        }   
    </style>
     
    <body>
    <center>
        <h1> Lista vjezbi </h1>
            <div id = "listaVezbi">
                <form action ="LoginServletAplikacije">
                    
                    Korisnicko ime vidite:   <input type="text" name="Ime">  <br>  
                    Dr. Aleksandar kostic:  <input type="password" name="Lozinka">  <br>
                    
                    
                    <br>
                 <input type="submit" value="Uloguj se">
                </form>             
            </div>
    </center>
    
   
    </body>
</html>
