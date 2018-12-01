
package paketiLogovanja;


public class Korisnik {
    String KorisnickoIme;
    String Lozinka;

    public Korisnik(String KorisnickoIme, String Lozinka) {
        this.KorisnickoIme = KorisnickoIme;
        this.Lozinka = Lozinka;
    }

    @Override
    public String toString() {
        return KorisnickoIme;
    }
    
    
    
    
}
