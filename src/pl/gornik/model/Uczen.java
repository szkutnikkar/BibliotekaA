package pl.gornik.model;

import java.util.*;

public class Uczen {
    private String imie;
    private String nazwisko;
    private String klasa;
    private List<Produkt> koszyk;
    Scanner scanner = new Scanner(System.in);

    public Uczen(String imie, String nazwisko, String klasa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.klasa = klasa;
        this.koszyk = new ArrayList<>();
    }

    public void dodajDoKoszyka(Produkt produkt, int ilosc, Biblioteka biblioteka) {
        int dostepnaIlosc = biblioteka.znajdzProdukt(produkt.getTytul()).getIloscDostepnych();

        while (true) {
            if (ilosc > dostepnaIlosc) {
                System.out.println("Przepraszamy, dostępna jest tylko ilość " + dostepnaIlosc + " egzemplarzy.");
                System.out.println("Podaj ilość egzemplarzy do wypożyczenia:");
                ilosc = wczytajLiczbe("");
            } else {
                break;
            }
        }

        if (ilosc > 0) {
            boolean znaleziono = false;

            for (Produkt produktWKoszyku : koszyk) {
                if (produktWKoszyku.equals(produkt)) {
                    int dostepnaIloscWKoszyku = produktWKoszyku.getIloscDostepnych();
                    if (ilosc <= dostepnaIloscWKoszyku) {
                        produktWKoszyku.setIloscDostepnych(produktWKoszyku.getIloscDostepnych() + ilosc);
                        biblioteka.zmniejszIloscDostepnych(produkt, ilosc);
                        System.out.println(getImie() + " " + getNazwisko() + " dodał " + ilosc +
                                " egzemplarzy do koszyka: " + produkt.getTytul());
                    } else {
                        System.out.println("Przepraszamy, dostępna jest tylko ilość " + dostepnaIloscWKoszyku + " egzemplarzy.");
                    }
                    znaleziono = true;
                    break;
                }
            }

            if (!znaleziono) {
                if (ilosc <= dostepnaIlosc) {
                    Produkt produktDoKoszyka = new Produkt(produkt.getTytul(), produkt.getAutor(), ilosc);
                    koszyk.add(produktDoKoszyka);
                    biblioteka.zmniejszIloscDostepnych(produkt, ilosc);
                    System.out.println(getImie() + " " + getNazwisko() + " dodał " + ilosc +
                            " egzemplarzy do koszyka: " + produkt.getTytul());
                }
            }
        } else {
            System.out.println("Błąd! Podaj liczbę większą od zera.");
        }
    }

    public void wyswietlKoszyk() {
        System.out.println("Koszyk " + getImie() + " " + getNazwisko() + ":");

        Map<String, Integer> ilosciWKoszyku = new HashMap<>();

        for (Produkt produktWKoszyku : koszyk) {
            String klucz = produktWKoszyku.getTytul();
            int ilosc = produktWKoszyku.getIloscDostepnych();
            ilosciWKoszyku.put(klucz, ilosciWKoszyku.getOrDefault(klucz, 0) + ilosc);
        }

        for (Map.Entry<String, Integer> entry : ilosciWKoszyku.entrySet()) {
            String tytul = entry.getKey();
            int iloscWKoszyku = entry.getValue();
            System.out.println("Produkt: " + tytul + ", ilość w koszyku: " + iloscWKoszyku);
        }
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int wczytajLiczbe(String komunikat) {
        while (true) {
            try {
                System.out.println(komunikat);
                int ilosc = scanner.nextInt();
                scanner.nextLine();
                if (ilosc > 0) {
                    return ilosc;
                } else {
                    System.out.println("Błąd! Wprowadź liczbę większą od zera.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Błąd! Wprowadź poprawną liczbę.");
                scanner.nextLine();
            }
        }
    }
}