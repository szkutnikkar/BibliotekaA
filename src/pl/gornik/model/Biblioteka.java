package pl.gornik.model;


import java.util.ArrayList;
import java.util.List;

public class Biblioteka {
    private List<Produkt> produkty;

    public Biblioteka() {
        this.produkty = new ArrayList<>();
    }

    public void dodajProdukt(Produkt produkt) {
        produkty.add(produkt);
    }

    public List<Produkt> getProdukty() {
        return produkty;
    }

    public void wyswietlProdukty() {
        System.out.println("Dostępne produkty:");
        for (Produkt produkt : produkty) {
            System.out.println(produkt + ", ilość dostępnych: " + produkt.getIloscDostepnych());
        }
    }

    public void zmniejszIloscDostepnych(Produkt produkt, int ilosc) {
        for (Produkt produktMagazyn : produkty) {
            if (produktMagazyn.getTytul().equals(produkt.getTytul())) {
                int nowaIlosc = produktMagazyn.getIloscDostepnych() - ilosc;
                produktMagazyn.setIloscDostepnych(nowaIlosc);

                if (nowaIlosc == 0) {
                    produkty.remove(produktMagazyn);
                    System.out.println("Produkt " + produktMagazyn.getTytul());
                }
                break;
            }
        }
    }

    public Produkt znajdzProdukt(String nazwa) {
        for (Produkt produkt : produkty) {
            if (produkt.getTytul().equalsIgnoreCase(nazwa)) {
                return produkt;
            }
        }
        return null;
    }


}
