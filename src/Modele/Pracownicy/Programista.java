package Modele.Pracownicy;

import Modele.Projekt;
import Modele.Technologia;

import java.util.ArrayList;
import java.util.List;

public class Programista extends Pracownik{
    public int StawkaMiesieczna;
    public List<Technologia> Umiejetnosci;
    public int punktualnosc;
    public int dokladnosc;
    public boolean CzyPrzydzielony;
    public Projekt PrzydzielonyProjekt;
    public Technologia PrzydzielonaTechnologia;

    public Programista() {
    }

    public Programista(	int StawkaMiesieczna, String imie, String nazwisko, int punktualnosc, int dokladnosc) {
        super(StawkaMiesieczna, imie, nazwisko);
        this.punktualnosc=punktualnosc;
        this.dokladnosc=dokladnosc;
        Umiejetnosci = new ArrayList<Technologia>();
        CzyPrzydzielony = false;
    }

    @Override
    public String Wypisz() {
        String wynik =  super.Wypisz()+" Punktualnosc: "+punktualnosc+" Dokladnosc: "+dokladnosc+"\n";
        for (Technologia technologia:Umiejetnosci
        ) {
            wynik += technologia.Wypisz()+"\n";
        }
        wynik += "Przydzielony projekt: "+PrzydzielonyProjekt+"\nPrzydzielona technologia: "+PrzydzielonaTechnologia;
        return wynik;
    }

    @Override
    public Programista Kopiuj() {
        Programista programista = new  Programista(StawkaMiesieczna, imie, nazwisko, punktualnosc, dokladnosc);
        programista.Umiejetnosci.addAll(Umiejetnosci);
        return programista;
    }

    public int Dokladnosc() {
        int losowanieOpoznienia = Losuj(0,100);
        if(losowanieOpoznienia>=0 && losowanieOpoznienia<=dokladnosc)
        {
            return Losuj(1,5);
        }
        return 0;
    }


    public int Punktualnosc() {
        int lsowanieOpoznienia = Losuj(0,100);
        if(lsowanieOpoznienia>=0 && lsowanieOpoznienia<=punktualnosc)
        {
            return Losuj(1,5);
        }
        return 0;
    }

    public int Losuj(int minimalna, int maksymalna)
    {
        return  minimalna + (int)(Math.random() * maksymalna);
    }
}
