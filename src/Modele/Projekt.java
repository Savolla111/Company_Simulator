package Modele;

import Modele.Klient.Klient;

import java.util.ArrayList;
import java.util.List;

public class Projekt {
    public String Nazwa;
    public List<Technologia> Technologie;
    public Modele.Klient.Klient Klient;
    public Termin TerminOddania;
    public int WysokoscKary;
    public int CenaZaplaty;
    public Termin TerminPlatnosci;
    public Termin TerminRozpoczecia;
    public  PoziomTrudnosci poziomTrudnosci;
    public boolean CzyTestowales;
    public boolean CzyPozyskales;

    public boolean CzySkonczony;
    public Projekt(String Nazwa, Modele.Klient.Klient Klient, Termin TerminOddania, int WysokoscKary, int CenaZaplaty,
                   Termin TerminPlatnosci, Termin TerminRozpoczecia, PoziomTrudnosci PoziomTrudnosci)
    {
        this.Nazwa = Nazwa;
        this.Klient = Klient;
        this.TerminOddania = TerminOddania;
        this.WysokoscKary = WysokoscKary;
        this.CenaZaplaty = CenaZaplaty;
        this.TerminPlatnosci = TerminPlatnosci;
        this.TerminRozpoczecia = TerminRozpoczecia;
        this.poziomTrudnosci = PoziomTrudnosci;
        Technologie = new ArrayList<Technologia>();
        CzySkonczony = false;
        CzyTestowales = false;
        CzyPozyskales  =false;
    }

    public String Wypisz()
    {
        String wynik = "Nazwa: "+Nazwa+" Klient "+Klient.Wypisz()+" Termin oddania: "+TerminOddania.Wypisz()+" Wysokosc kary za opznienie: "+WysokoscKary+
                " \nCena Projektu: "+CenaZaplaty+" Termin platnosci: "+TerminPlatnosci.Wypisz()+" Termin Rozpoczecia: "+TerminRozpoczecia.Wypisz()
                +" Poziom trudnosci: "+ poziomTrudnosci +"\nTechnologie: \n";
        for (Technologia technologia: Technologie
        ) {
            wynik += technologia.Wypisz()+"\n";
        }
        return wynik;
    }
    public Projekt Kopiuj()
    {
        Projekt projekt = new Projekt(Nazwa, Klient,  TerminOddania,  WysokoscKary,  CenaZaplaty, TerminPlatnosci,
                TerminRozpoczecia, poziomTrudnosci);
        projekt.Technologie = Technologie;
        return projekt;
    }
    public boolean CzyProjektPoprawny()
    {
        int projektyNietestowane=0;
        for(Technologia technologia : Technologie)
        {
            if(!technologia.CzyTestowana)
            {
                projektyNietestowane++;
            }
        }
        if(projektyNietestowane != 0)
        {
            int liczbaLosowa = Losuj(0, 100);
            if(liczbaLosowa>=0 && liczbaLosowa<=projektyNietestowane /Technologie.size()*100)
            {
                return    false;
            }

        }
        return true;
    }
    public int Losuj(int minimalna, int maksymalna)
    {
        return  minimalna + (int)(Math.random() * maksymalna);
    }


    public enum PoziomTrudnosci
    {
        latwy,
        sredni,
        trudny
    }
}
