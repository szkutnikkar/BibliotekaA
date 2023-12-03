package pl.gornik.model;

public class Produkt {
    private String tytul;
    private String autor;
    private int iloscDostepnych;

    public Produkt(String tytul, String autor, int iloscDostepnych) {
        this.tytul = tytul;
        this.autor = autor;
        this.iloscDostepnych = iloscDostepnych;
    }

    public Produkt(String tytul, int iloscDostepnych) {
        this.tytul = tytul;
        this.iloscDostepnych = iloscDostepnych;
    }


    public String getTytul() {
        return tytul;
    }



    public String getAutor() {
        return autor;
    }



    public int getIloscDostepnych() {
        return iloscDostepnych;
    }

    public void setIloscDostepnych(int iloscDostepnych) {
        this.iloscDostepnych = iloscDostepnych;
    }

    @Override
    public String toString() {
        return "Produkt: " +
                " tytul: " + tytul + '\'' +
                " autor: " + autor + '\'';
    }
}
