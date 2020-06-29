package Modele.Podwykonawcy;

import Modele.Projekt;
import Modele.Technologia;

import java.util.ArrayList;
import java.util.List;

public class Podwykonawca {public String Imie;
    public String Nazwisko;
    public int StawkaMiesieczna;
    public boolean CzyPrzydzielony;
    public List<Technologia> Umiejetnosci;
    public Projekt PrzydzielonyProjekt;
    public Technologia PrzydzielonaTechnologia;
    public Podwykonawca(int StawkaMiesieczna, String Imie, String Nazwisko)
    {
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;
        Umiejetnosci = new ArrayList<Technologia>();
        this.StawkaMiesieczna = StawkaMiesieczna;
        CzyPrzydzielony = false;
    }

    public Podwykonawca Kopiuj()
    {
        Podwykonawca podwykonawca = new  Podwykonawca(StawkaMiesieczna,Imie, Nazwisko);
        podwykonawca.Umiejetnosci.addAll(Umiejetnosci);

        return podwykonawca;
    }
    public int CzasOpoznienia()
    {
        return 0;
    }
    public int Dokladnosc()
    {
        return 0;
    }
    public String Wypisz()
    {
        String wynik = "Stawka: "+StawkaMiesieczna+" Imie: "+Imie+" Nazwisko: "+Nazwisko+"\n";
        for (Technologia technologia: Umiejetnosci
        ) {
            wynik += technologia.Nazwa+"\n";
        }
        return wynik;
    }
    public int Losuj(int minimalna, int maksymalna)
    {
        return  minimalna + (int)(Math.random() * maksymalna);
    }

}
