package pl.gornik.model;

public class Ksiazka extends Produkt {

    public Ksiazka(String tytul, String autor, int iloscDostepnych) {
        super(tytul, autor, iloscDostepnych);
    }

    public Ksiazka(String tytul, int iloscDostepnych) {
        super(tytul, iloscDostepnych);
    }

    @Override
    public String getAutor() {
        String autor = super.getAutor();
        return (autor != null && !autor.isEmpty()) ? autor : "Nieznany";
    }

    @Override
    public String toString() {
        return "Ksiazka: " +
                " tytul: " + getTytul() + ", " +
                " autor: " + getAutor();
    }
}

