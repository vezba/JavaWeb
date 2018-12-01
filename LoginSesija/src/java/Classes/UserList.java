
package Classes;

import java.util.ArrayList;


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
    
    
    
    
}
