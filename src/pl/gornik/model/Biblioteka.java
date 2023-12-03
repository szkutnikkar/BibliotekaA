package pl.gornik.model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Biblioteka {
    private List<Produkt> produkty;

    public Biblioteka() {
        this.produkty = new ArrayList<>();
    }

    public void dodajProdukt(Produkt produkt) {
        produkty.add(produkt);
    }

    public void wyswietlProdukty() {
        System.out.println("Dostępne produkty:");
        for (Produkt produkt : produkty) {
            System.out.println(produkt + ", ilość dostępnych: " + produkt.getIloscDostepnych());
        }
    }

    public void zmniejszIloscDostepnych(Produkt produkt, int ilosc) {
        Iterator<Produkt> iterator = produkty.iterator();

        while (iterator.hasNext()) {
            Produkt produktWKoszyku = iterator.next();

            if (produktWKoszyku.equals(produkt)) {
                int nowaIlosc = produktWKoszyku.getIloscDostepnych() - ilosc;
                produktWKoszyku.setIloscDostepnych(nowaIlosc);

                if (nowaIlosc == 0) {
                    iterator.remove();
                    System.out.println("Produkt " + produktWKoszyku.getTytul() + " został wypożyczony.");
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