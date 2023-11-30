package pl.gornik.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ksiazka {
    private String tytul;
    private String autor;
    private int iloscDostepnych;

    public Ksiazka(String tytul, String autor, int iloscDostepnych) {
        this.tytul = tytul;
        this.autor = autor;
        this.iloscDostepnych = iloscDostepnych;
    }

    public String getTytul() {
        return tytul;
    }

    public String getAutor() {
        return autor;
    }

    public int getIloscDostepnych() {
        return iloscDostepnych;
    }

    public void setIloscDostepnych(int iloscDostepnych) {
        this.iloscDostepnych = iloscDostepnych;
    }

    @Override
    public String toString() {
        return "Ksiazka: " +
                " tytul: " + tytul + '\'' +
                " autor: " + autor + '\''
               ;
    }
}
