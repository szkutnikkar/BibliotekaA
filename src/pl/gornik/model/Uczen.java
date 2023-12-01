package pl.gornik.model;



import pl.gornik.model.Biblioteka;
import pl.gornik.model.Ksiazka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uczen {
    private String imie;
    private String nazwisko;

    private String klasa;
    private List<Ksiazka> koszyk;
    Scanner scanner = new Scanner(System.in);

    public Uczen(String imie, String nazwisko, String klasa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.klasa = klasa;
        this.koszyk = new ArrayList<>();
    }



    public void dodajDoKoszyka(Produkt produkt, int ilosc, Biblioteka biblioteka) {
        int dostepnaIlosc = produkt.getIloscDostepnych();
        if (ilosc > dostepnaIlosc) {
            System.out.println("Przepraszamy, dostepna jest tylko ilosc " + dostepnaIlosc + " egzemplarzy.");
            System.out.println("Podaj ilosc egzemplarzy do wypozyczenia:");
            int nowaIloscPoprawiona = scanner.nextInt();
            dodajDoKoszyka(produkt, nowaIloscPoprawiona, biblioteka);
            return;
        }

        boolean znaleziono = false;

        for (Ksiazka koszykKsiazka : koszyk) {
            if (koszykKsiazka.getTytul().equals(produkt.getTytul())) {
                koszykKsiazka.setIloscDostepnych(koszykKsiazka.getIloscDostepnych() + ilosc);
                znaleziono = true;
                break;
            }
        }

        if (!znaleziono) {
            Ksiazka ksiazkaWKoszyku = new Ksiazka(produkt.getTytul(), produkt.getAutor(), ilosc);
            koszyk.add(ksiazkaWKoszyku);
        }

        System.out.println(getImie() + " " + getNazwisko() + " dodal " + ilosc +
                " egzemplarzy do koszyka: " + produkt.getTytul());


        if (!znaleziono) {
            biblioteka.zmniejszIloscDostepnych(produkt, ilosc);
        }
    }

    public void wyswietlKoszyk() {
        System.out.println("Koszyk " + getImie() + " " + getNazwisko() + ":");
        for (Ksiazka ksiazkaWKoszyku : koszyk) {
            System.out.println(ksiazkaWKoszyku + ", ilość w koszyku: " + ksiazkaWKoszyku.getIloscDostepnych());
        }
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public String getKlasa() {
        return klasa;
    }

    public List<Ksiazka> getKoszyk() {
        return koszyk;
    }
}
