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
    private List<Ksiazka> koszyk;
    Scanner scanner = new Scanner(System.in);

    public Uczen(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.koszyk = new ArrayList<>();
    }

    public void dodajDoKoszyka(Ksiazka ksiazka, int ilosc) {
        boolean znaleziono = false;

        for (Ksiazka koszykKsiazka : koszyk) {
            if (koszykKsiazka.getTytul().equals(ksiazka.getTytul())) {
                int dostepnaIlosc = ksiazka.getIloscDostepnych() - koszykKsiazka.getIloscDostepnych();
                if (ilosc <= dostepnaIlosc) {
                    koszykKsiazka.setIloscDostepnych(koszykKsiazka.getIloscDostepnych() + ilosc);
                } else {
                    System.out.println("Przepraszamy, dostepna jest tylko ilosc " + dostepnaIlosc + " egzemplarzy.");
                    System.out.println("Podaj ilosc egzemplarzy do wypozyczenia:");
                    int nowaIloscPoprawiona = scanner.nextInt();
                    dodajDoKoszyka(ksiazka, nowaIloscPoprawiona);
                }
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
    }

    public void wyswietlKoszyk() {
        System.out.println("Koszyk " + getImie() + " " + getNazwisko() + ":");
        for (Ksiazka ksiazkaWKoszyku : koszyk) {
            System.out.println(ksiazkaWKoszyku);
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

    public List<Ksiazka> getKoszyk() {
        return koszyk;
    }
}
