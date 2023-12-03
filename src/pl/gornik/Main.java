package pl.gornik;

import pl.gornik.model.*;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteka biblioteka = new Biblioteka();

        biblioteka.dodajProdukt(new Ksiazka("Java Programming", "John Smith", 5));
        biblioteka.dodajProdukt(new Ksiazka("Władca Pierścieni", "J.R.R. Tolkien", 3));
        biblioteka.dodajProdukt(new Ksiazka("Zbrodnia i Kara", "Fiodor Dostojewski", 7));
        biblioteka.dodajProdukt(new Ksiazka("Harry Potter", "J.K. Rowling", 2));
        biblioteka.dodajProdukt(new Ksiazka("Duma i Uprzedzenie", "Jane Austen", 4));
        biblioteka.dodajProdukt(new Ksiazka("1984", "George Orwell", 6));
        biblioteka.dodajProdukt(new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", 8));
        biblioteka.dodajProdukt(new Ksiazka("Harry Potter i Komnata Tajemnic", "J.K. Rowling", 5));
        biblioteka.dodajProdukt(new Ksiazka("Złodziejka książek", 3));
        biblioteka.dodajProdukt(new Ksiazka("Wiedźmin", "Andrzej Sapkowski", 10));
        biblioteka.dodajProdukt(new Ksiazka("Dzieci z Bullerbyn", "Astrid Lindgren", 5));
        biblioteka.dodajProdukt(new Ksiazka("Wzgórze Psów", "Enid Blyton", 4));
        biblioteka.dodajProdukt(new Ksiazka("Przygody Tomka Sawyera", "Mark Twain", 6));
        biblioteka.dodajProdukt(new Ksiazka("Mistrz i Małgorzata", "Michaił Bułhakow", 7));
        biblioteka.dodajProdukt(new Ksiazka("Władcza Wiedźma", "Terry Pratchett", 9));
        biblioteka.dodajProdukt(new Ksiazka("Dżuma", "Albert Camus", 3));
        biblioteka.dodajProdukt(new Gazeta("Tygodnik", 80));
        biblioteka.dodajProdukt(new Gazeta("Wyborcza", 12));
        biblioteka.dodajProdukt(new Gazeta("Polska", 12));


        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoje imie:");
        String imie = scanner.nextLine();
        System.out.println("Podaj swoje nazwisko:");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj swoją klasę:");
        String klasa = scanner.nextLine();

        Uczen uczen = znajdzUcznia(imie, nazwisko, klasa);

        if (uczen == null) {
            System.out.println("Uczeń o podanym imieniu, nazwisku i klasie nie istnieje. Zamykam program.");
            return;
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Przeglądaj dostępne produkty");
            System.out.println("2. Dodaj produkt do koszyka");
            System.out.println("3. Wyświetl koszyk");
            System.out.println("4. Wypożycz książki");

            if (scanner.hasNextInt()) {
                int wybor = scanner.nextInt();
                scanner.nextLine();

                switch (wybor) {
                    case 1:
                        biblioteka.wyswietlProdukty();
                        break;
                    case 2:
                        System.out.println("Podaj nazwę produktu, który chcesz dodać do koszyka:");
                        String nazwaProduktu = scanner.nextLine().toLowerCase();


                        int ilosc = uczen.wczytajLiczbe("Podaj ilość egzemplarzy do wypożyczenia:");

                        Produkt produkt = biblioteka.znajdzProdukt(nazwaProduktu);

                        if (produkt != null) {
                            uczen.dodajDoKoszyka(produkt, ilosc, biblioteka);
                        } else {
                            System.out.println("Nie znaleziono produktu o podanej nazwie.");
                        }
                        break;

                    case 3:
                        uczen.wyswietlKoszyk();
                        break;
                    case 4:
                        System.out.println("Dziękujemy i zapraszamy ponownie");
                        return;
                    default:
                        System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                }
            } else {
                System.out.println("Nieprawidłowy format. Wprowadź numer opcji. Spróbuj ponownie.");
                scanner.nextLine();
            }
        }
    }


    private static Uczen znajdzUcznia(String imie, String nazwisko, String klasa) {
        Map<String, Uczen> uczniowie = new HashMap<>();
        uczniowie.put("jankowalski3bt", new Uczen("Jan", "Kowalski", "3BT"));
        uczniowie.put("annanowak3bt", new Uczen("Anna", "Nowak", "3BT"));
        uczniowie.put("jakubsulek3bt", new Uczen("Jakub", "Sulek", "3BT"));
        uczniowie.put("mariakowalska3bt", new Uczen("Maria", "Kowalska", "3BT"));
        uczniowie.put("piotrnawrocki3bt", new Uczen("Piotr", "Nawrocki", "3BT"));
        uczniowie.put("kamiladudek3bt", new Uczen("Kamila", "Dudek", "3BT"));
        uczniowie.put("mateuszmazur3bt", new Uczen("Mateusz", "Mazur", "3BT"));
        uczniowie.put("julianaszewczyk3bt", new Uczen("Juliana", "Szewczyk", "3BT"));
        uczniowie.put("michalkaczmarek3bt", new Uczen("Michał", "Kaczmarek", "3BT"));
        uczniowie.put("nataliawisniewska3bt", new Uczen("Natalia", "Wiśniewska", "3BT"));
        uczniowie.put("bartoszlis3bt", new Uczen("Bartosz", "Lis", "3BT"));
        uczniowie.put("olgapawlik3bt", new Uczen("Olga", "Pawlik", "3BT"));
        uczniowie.put("tomaszkowalczyk3bt", new Uczen("Tomasz", "Kowalczyk", "3BT"));
        uczniowie.put("alicjawojcik3bt", new Uczen("Alicja", "Wojcik", "3BT"));
        uczniowie.put("dominikpawlowski3bt", new Uczen("Dominik", "Pawlowski", "3BT"));
        uczniowie.put("kamilamarciniak3bt", new Uczen("Kamila", "Marciniak", "3BT"));
        uczniowie.put("mateuszzielinski3bt", new Uczen("Mateusz", "Zielinski", "3BT"));
        uczniowie.put("agnieszkakowal3bt", new Uczen("Agnieszka", "Kowal", "3BT"));

        String klucz = (imie.toLowerCase() + nazwisko.toLowerCase() + klasa.toLowerCase());
        return uczniowie.get(klucz);
    }
}
