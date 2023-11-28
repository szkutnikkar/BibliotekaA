package pl.gornik;


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
        biblioteka.dodajKsiazke(new Ksiazka("1984", "George Orwell", 6));
        biblioteka.dodajKsiazke(new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", 8));
        biblioteka.dodajKsiazke(new Ksiazka("Harry Potter i Komnata Tajemnic", "J.K. Rowling", 5));
        biblioteka.dodajKsiazke(new Ksiazka("Złodziejka książek", "Markus Zusak", 3));
        biblioteka.dodajKsiazke(new Ksiazka("Wiedźmin", "Andrzej Sapkowski", 10));
        biblioteka.dodajKsiazke(new Ksiazka("Dzieci z Bullerbyn", "Astrid Lindgren", 5));
        biblioteka.dodajKsiazke(new Ksiazka("Wzgórze Psów", "Enid Blyton", 4));
        biblioteka.dodajKsiazke(new Ksiazka("Przygody Tomka Sawyera", "Mark Twain", 6));
        biblioteka.dodajKsiazke(new Ksiazka("Mistrz i Małgorzata", "Michaił Bułhakow", 7));
        biblioteka.dodajKsiazke(new Ksiazka("Władcza Wiedźma", "Terry Pratchett", 9));
        biblioteka.dodajKsiazke(new Ksiazka("Dżuma", "Albert Camus", 3));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoje imie:");
        String imie = scanner.nextLine();
        System.out.println("Podaj swoje nazwisko:");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj swoją klasę:");
        String klasa = scanner.nextLine();

        // Wyszukaj ucznia w liście uczniów
        Uczen uczen = znajdzUcznia(imie, nazwisko, klasa);

        if (uczen == null) {
            System.out.println("Uczeńn o podanym imieniu i nazwisku nie istnieje. Zamykam program.");
            return;  // Zakończ program, jeśli uczeń nie istnieje
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

                    Ksiazka ksiazka = biblioteka.znajdzKsiazke(nazwaKsiazki);

                    if (ksiazka != null) {
                        uczen.dodajDoKoszyka(ksiazka, ilosc, biblioteka);
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


    private static Uczen znajdzUcznia(String imie, String nazwisko, String klasa) {

        Map<String, Uczen> uczniowie = new HashMap<>();
        uczniowie.put("jankowalski3bt", new Uczen("Jan", "Kowalski", "3BT"));
        uczniowie.put("annanowak3bt", new Uczen("Anna", "Nowak", "3BT"));

        String klucz = (imie.toLowerCase() + nazwisko.toLowerCase() + klasa.toLowerCase());
        return uczniowie.get(klucz);
    }
}