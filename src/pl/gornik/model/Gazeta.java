package pl.gornik.model;

public class Gazeta extends Produkt {
    private String autor;
    public Gazeta(String tytul, String autor, int iloscDostepnych) {
        super(tytul, autor, iloscDostepnych);
    }

    public Gazeta(String tytul, int iloscDostepnych) {
        super(tytul,iloscDostepnych);
    }

    public String getTytul() {
        return super.getTytul();
    }

    public String getAutor() {
        return (autor != null) ? autor : "Nieznany";
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
