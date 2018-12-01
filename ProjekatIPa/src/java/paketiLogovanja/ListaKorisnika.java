
package paketiLogovanja;

import java.util.ArrayList;


public class ListaKorisnika {
    ArrayList<Korisnik> korisnici;

    public ListaKorisnika() {
        korisnici = new ArrayList<Korisnik>();
        korisnici.add(new Korisnik("admin", "admin"));
        korisnici.add(new Korisnik("admin1", "admin1"));
        korisnici.add(new Korisnik("admin123", "admin123"));
    }
    
    public boolean provjeraKorisnika(Korisnik korisnik){
        
        for(Korisnik k : korisnici){
            if(korisnik.KorisnickoIme.equals(k.KorisnickoIme) && korisnik.Lozinka.equals(k.Lozinka))
                return true;
        }
        return false ;
    }

}
