package pl.gornik.model;

public class Ksiazka extends Produkt {
    public Ksiazka(String tytul, String autor, int iloscDostepnych) {
        super(tytul, autor, iloscDostepnych);
    }

    public Ksiazka(String tytul, int iloscDostepnych) {
        super(tytul,iloscDostepnych);
    }

    public String getTytul() {
        return super.getTytul();
    }

    public String getAutor() {
        return super.getAutor();
    }

    public int getIloscDostepnych() {
        return super.getIloscDostepnych();
    }

    public void setIloscDostepnych(int iloscDostepnych) {
        super.setIloscDostepnych(iloscDostepnych);
    }

    @Override
    public String toString() {
        return "Ksiazka: " +
                " tytul: " + getTytul() + '\'' +
                " autor: " + getAutor() + '\'';
    }
}

