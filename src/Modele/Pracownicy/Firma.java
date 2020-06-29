package Modele.Pracownicy;

import Generatory.GeneratorProjektow;
import Modele.Podwykonawcy.Podwykonawca;
import Modele.Projekt;
import Modele.Termin;

import java.util.ArrayList;
import java.util.List;

public class Firma {
    public int IloscPieniedzy;
    public Termin ObecnyTermin;
    public List<Projekt> Projekty;
    public List<Projekt> ProjektyDoOddania;
    public int IloscDniSzukaniaProjektu = 0;
    public boolean CzyNowyProjekt;
    public List<Projekt> DostepneProjekty;
    public List<Pracownik> Pracownicy;
    public List<Podwykonawca> Podwykonawcy;
    public List<Pracownik> OgloszeniaPracownicy;
    public List<Podwykonawca> OgloszeniaPodwykonawca;
    GeneratorProjektow generatorProjektow;
    public int IloscDniRozliczania = 0;
    public boolean CzyPrzegrana;
    public List<Projekt> ProjektyDoZaplaty;
    public boolean CzyWygrana;
    public Firma(int IloscPieniedzy, Termin ObecnyTermin)
    {
        this.IloscPieniedzy = IloscPieniedzy;
        this.ObecnyTermin = ObecnyTermin;
        Projekty = new ArrayList<Projekt>();
        CzyNowyProjekt = true;
        DostepneProjekty = new ArrayList<Projekt>();
        Pracownicy = new ArrayList<Pracownik>();
        Podwykonawcy = new ArrayList<Podwykonawca>();
        OgloszeniaPracownicy = new ArrayList<Pracownik>();
        OgloszeniaPodwykonawca = new ArrayList<Podwykonawca>();
        ProjektyDoOddania = new ArrayList<Projekt>();
        ProjektyDoZaplaty = new ArrayList<Projekt>();
        generatorProjektow = new GeneratorProjektow();
        CzyPrzegrana = false;
        CzyWygrana = false;

    }
}
