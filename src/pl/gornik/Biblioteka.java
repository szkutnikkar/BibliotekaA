package pl.gornik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Biblioteka {
    private List<Ksiazka> ksiazki;

    public Biblioteka() {
        this.ksiazki = new ArrayList<>();
    }

    public void dodajKsiazke(Ksiazka ksiazka) {
        ksiazki.add(ksiazka);
    }

    public List<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void wyswietlKsiazki(List<Ksiazka> koszyk) {
        System.out.println("Dostepne ksiazki:");
        for (Ksiazka ksiazka : ksiazki) {
            System.out.println(ksiazka + ", ilosc dostepnych: " + ksiazka.getIloscDostepnych());
        }
    }

    public void zmniejszIloscDostepnych(Ksiazka ksiazka, int ilosc) {
        for (Ksiazka ksiazkaMagazyn : ksiazki) {
            if (ksiazkaMagazyn.getTytul().equals(ksiazka.getTytul())) {
                int nowaIlosc = ksiazkaMagazyn.getIloscDostepnych() - ilosc;
                ksiazkaMagazyn.setIloscDostepnych(nowaIlosc);
                break;
            }
        }
    }
}
