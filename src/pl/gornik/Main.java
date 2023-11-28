package pl.gornik;

import pl.gornik.Biblioteka;
import pl.gornik.Uczen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteka biblioteka = new Biblioteka();


        biblioteka.dodajKsiazke(new Ksiazka("Java Programming", "John Smith", 5));
        biblioteka.dodajKsiazke(new Ksiazka("Władca Pierścieni", "J.R.R. Tolkien", 3));
        biblioteka.dodajKsiazke(new Ksiazka("Zbrodnia i Kara", "Fiodor Dostojewski", 7));
        biblioteka.dodajKsiazke(new Ksiazka("Harry Potter", "J.K. Rowling", 2));
        biblioteka.dodajKsiazke(new Ksiazka("Duma i Uprzedzenie", "Jane Austen", 4));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoje imie:");
        String imie = scanner.nextLine();
        System.out.println("Podaj swoje nazwisko:");
        String nazwisko = scanner.nextLine();

        Uczen uczen = new Uczen(imie, nazwisko);


        Map<String, Ksiazka> mapaKsiazek = new HashMap<>();
        for (Ksiazka ksiazka : biblioteka.getKsiazki()) {
            mapaKsiazek.put(ksiazka.getTytul().toLowerCase(), ksiazka);
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Przegladaj dostepne ksiazki");
            System.out.println("2. Dodaj ksiazke do koszyka");
            System.out.println("3. Wyswietl koszyk");
            System.out.println("4. Zakoncz zakupy");

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    biblioteka.wyswietlKsiazki(uczen.getKoszyk());
                    break;
                case 2:
                    System.out.println("Podaj nazwe ksiazki, ktora chcesz dodac do koszyka:");
                    String nazwaKsiazki = scanner.nextLine().toLowerCase();
                    System.out.println("Podaj ilosc egzemplarzy do wypozyczenia:");
                    int ilosc = scanner.nextInt();
                    scanner.nextLine();

                    Ksiazka ksiazka = mapaKsiazek.get(nazwaKsiazki);
                    if (ksiazka != null) {
                        uczen.dodajDoKoszyka(ksiazka, ilosc);
                        biblioteka.zmniejszIloscDostepnych(ksiazka, ilosc);
                    } else {
                        System.out.println("Nie znaleziono ksiazki o podanej nazwie.");
                    }
                    break;
                case 3:
                    uczen.wyswietlKoszyk();
                    break;
                case 4:
                    System.out.println("Dziekujemy za zakupy!");
                    return;
                default:
                    System.out.println("Nieprawidlowy wybor. Sprobuj ponownie.");
            }
        }
    }
}