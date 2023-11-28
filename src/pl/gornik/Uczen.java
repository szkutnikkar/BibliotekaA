package pl.gornik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void dodajDoKoszyka(Ksiazka ksiazka, int ilosc, Biblioteka biblioteka) {
        // Sprawdzenie dostępności przed dodaniem do koszyka
        int dostepnaIlosc = ksiazka.getIloscDostepnych();
        if (ilosc > dostepnaIlosc) {
            System.out.println("Przepraszamy, dostepna jest tylko ilosc " + dostepnaIlosc + " egzemplarzy.");
            System.out.println("Podaj ilosc egzemplarzy do wypozyczenia:");
            int nowaIloscPoprawiona = scanner.nextInt();
            dodajDoKoszyka(ksiazka, nowaIloscPoprawiona, biblioteka);
            return;
        }

        boolean znaleziono = false;

        for (Ksiazka koszykKsiazka : koszyk) {
            if (koszykKsiazka.getTytul().equals(ksiazka.getTytul())) {
                koszykKsiazka.setIloscDostepnych(koszykKsiazka.getIloscDostepnych() + ilosc);
                znaleziono = true;
                break;
            }
        }

        if (!znaleziono) {
            Ksiazka ksiazkaWKoszyku = new Ksiazka(ksiazka.getTytul(), ksiazka.getAutor(), ilosc);
            koszyk.add(ksiazkaWKoszyku);
        }

        System.out.println(getImie() + " " + getNazwisko() + " dodal(a) " + ilosc +
                " egzemplarzy ksiazki do koszyka: " + ksiazka.getTytul());

        // Aktualizacja dostępności w bibliotece tylko jeśli książka nie istnieje w koszyku
        if (!znaleziono) {
            biblioteka.zmniejszIloscDostepnych(ksiazka, ilosc);
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
