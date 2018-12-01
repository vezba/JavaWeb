/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Aleksa Kuzman
 */
public class UserList {
    
    ArrayList<User> korisnici;

    public UserList() {
        korisnici = new ArrayList<User>();
        
        korisnici.add(new User("Jovan","Sifra123"));
        korisnici.add(new User("Ivan","Lesnici123"));
        korisnici.add(new User("Ivan","Orasi"));
    }
    
    
    public boolean authentifikuj(User u)
    {
     
        for(User korisnik: korisnici)
        {
            if(korisnik.username.equals(u.username) && korisnik.password.equals(u.password))
                return true;
        }
        
        return false;
        
    }
    
    public boolean authentifikuj(String korisnik)
    {
     for(User u : this.korisnici)
        {
            if(u.toString().equals( korisnik) )
            {
                return true;

            }
                
        }
        
        return false;
    }
    
    
    
    
}
