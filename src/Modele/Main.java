package Modele;

import Generatory.GeneratorPodwykonawca;
import Generatory.GeneratorPracownikow;
import Generatory.GeneratorProjektow;

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

    }
}
