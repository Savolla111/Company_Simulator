package Modele;

import Generatory.GeneratorPodwykonawca;
import Generatory.GeneratorPracownikow;
import Generatory.GeneratorProjektow;
import Menu.MenuGlowne;
import Menu.MenuWypisz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcjaWyboru = 0;
        GeneratorProjektow generatorProjektow = new GeneratorProjektow();
        Termin obecnyTermin = new Termin(1, 2020);
        generatorProjektow.Wygeneruj(3, obecnyTermin);
        for (Projekt projekt : generatorProjektow.Projekty) {
            projekt.CzyPozyskales = true;
        }
        GeneratorPodwykonawca generatorPodwykonawca = new GeneratorPodwykonawca();
        generatorPodwykonawca.Wygeneruj();
        GeneratorPracownikow generatorPracownikow = new GeneratorPracownikow();
        generatorPracownikow.Wygeneruj();

        Firma firma = new Firma(1000, obecnyTermin);
        firma.OgloszeniaPodwykonawca.addAll(generatorPodwykonawca.Podwykonawcy);
        firma.OgloszeniaPracownicy.addAll(generatorPracownikow.Pracownicy);
        firma.DostepneProjekty.addAll(generatorProjektow.Projekty);

        while (opcjaWyboru != 14 && !firma.CzyPrzegrana && !firma.CzyWygrana) {
            System.out.println("Pieniadze: " + firma.IloscPieniedzy + "----------data: " + firma.ObecnyTermin.Dzien + " dzien " + firma.ObecnyTermin.Rok);
            MenuWypisz.MenuWypiszMetody.Szablon(MenuWypisz.MenuWypiszMetody.MenuGlowne());
            opcjaWyboru = sc.nextInt();
            MenuGlowne.MenuGlowneMetody.Wypisz(opcjaWyboru, firma, generatorProjektow, generatorPodwykonawca, generatorPracownikow);
        }
    }
}
