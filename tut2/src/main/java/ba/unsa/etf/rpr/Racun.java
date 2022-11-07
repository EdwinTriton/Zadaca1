package ba.unsa.etf.rpr;

public class Racun {
    private Osoba korisnikRacuna;
    private final Long brojRacuna;
    private double stanjeRacuna;

    private boolean odobrenjePrekoracenje;
    Racun(Long x,Osoba lik) {
        this.brojRacuna=x;
        this.korisnikRacuna=lik;
        odobrenjePrekoracenje=false;
    }
    private boolean provjeriodobrenjePrekoracenja(double x) {
        return (odobrenjePrekoracenje);
    }
    public boolean izvrsiUplatu(double x) {
        if (x<=0) return false;
        this.stanjeRacuna+=x;
        return true;
    }
    public boolean izvrsiIsplatu(double x) {
        if (x>stanjeRacuna || x<0) return false;
        this.stanjeRacuna-=x;
        return true;
    }
    public void odobriPrekoracenje() {odobrenjePrekoracenje=true;}


}
