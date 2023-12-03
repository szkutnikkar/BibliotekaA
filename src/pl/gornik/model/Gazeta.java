package pl.gornik.model;

public class Gazeta extends Produkt {
    private String autor;

    public Gazeta(String tytul, String autor, int iloscDostepnych) {
        super(tytul, autor, iloscDostepnych);
        this.autor = autor;
    }

    public Gazeta(String tytul, int iloscDostepnych) {
        super(tytul, iloscDostepnych);
        this.autor = null;
    }

    @Override
    public String getAutor() {

        return (autor != null && !autor.isEmpty()) ? autor : "Nieznany";
    }

    @Override
    public String toString() {
        return "Gazeta: " +
                " tytul: " + getTytul() + ", " +
                " autor: " + getAutor();
    }
}
