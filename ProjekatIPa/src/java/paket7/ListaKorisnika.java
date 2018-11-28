
package paket7;

import java.util.ArrayList;

/**
 *
 * @author Ilhan Kalac
 */
public class ListaKorisnika {
    public ArrayList<Korisnik> korisnici (){
        ArrayList<Korisnik> korisnici = new ArrayList<>();
        
        korisnici.add(new Korisnik("user1", "pass1"));
        korisnici.add(new Korisnik("user2", "pass2"));
        korisnici.add(new Korisnik("user3", "pass3"));
        korisnici.add(new Korisnik("user4", "pass4"));
        return korisnici;
    }
}
