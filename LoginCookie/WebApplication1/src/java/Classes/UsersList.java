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
public class UsersList {
    
    public ArrayList<User> Korisnici;
    
    
    public UsersList()
    {
        Korisnici = new ArrayList<User>();
        Korisnici.add(new User("Pera","Sifra1"));
        Korisnici.add(new User("Mika","Sifra2"));
        Korisnici.add(new User("Sima","Sifra3"));
        Korisnici.add(new User("Nesa","Sifra4"));

    }
    
    
    
    
}
