package Generatory;

import Modele.Klient.Klient;
import Modele.Klient.KlientSkrwl;
import Modele.Klient.KlientWyluzowany;
import Modele.Klient.KlientWymagajacy;
import Modele.Projekt;
import Modele.Technologia;
import Modele.Termin;

import java.util.ArrayList;
import java.util.List;

public class GeneratorProjektow {
    public List<Projekt> Projekty;
    GeneratorKlientow generatorKlientow;
    GeneratorTechnologii generatorTechnologii;
    public GeneratorProjektow()
    {
        Projekty = new ArrayList<Projekt>();
        generatorKlientow = new GeneratorKlientow();
        generatorTechnologii = new GeneratorTechnologii();
        generatorTechnologii.Wygeneruj();
        generatorKlientow.Wygeneruj();
    }

    public void Wygeneruj(int iloscProjektow, Termin bierzacyTermin)
    {
        Projekty.clear();
        for (int i=0; i<iloscProjektow; i++)
        {
            Termin terminOddania =  bierzacyTermin.DodajDni(Losuj(5,100));
            Termin terminPlatnosci = terminOddania.DodajDni(Losuj(0,20));
            Projekt projekt = new Projekt("Projekt", generatorKlientow.Klienci.get(Losuj(0,generatorKlientow.Klienci.size())),
                    terminOddania, Losuj(50,600), Losuj(50,600),
                    terminPlatnosci, bierzacyTermin,LosujPoziomTrudnosci());
            WylosujTechnologie(projekt);
            Projekty.add(projekt);
        }


    }
    public Projekt.PoziomTrudnosci LosujPoziomTrudnosci()
    {
        int liczbaLosowa = Losuj(0,3);
        if(liczbaLosowa == 0)
        {
            return Projekt.PoziomTrudnosci.latwy;
        }
        else if(liczbaLosowa == 1)
        {
            return Projekt.PoziomTrudnosci.sredni;
        }
        else
        {
            return Projekt.PoziomTrudnosci.trudny;
        }
    }
    public void WylosujTechnologie(Projekt projekt)
    {
        int iloscProjektow;

        if(projekt.poziomTrudnosci.equals(Projekt.PoziomTrudnosci.latwy) )
        {
            iloscProjektow = Losuj(1,2);
            projekt.Technologie = DodajTechnologie(iloscProjektow, projekt);
        }
        else if(projekt.poziomTrudnosci.equals(Projekt.PoziomTrudnosci.sredni))
        {
            iloscProjektow = Losuj(2,3);
            projekt.Technologie = DodajTechnologie(iloscProjektow, projekt);
        }
        else
        {
            iloscProjektow = Losuj(3,5);
            projekt.Technologie = DodajTechnologie(iloscProjektow, projekt);
        }
    }
    public List<Technologia> DodajTechnologie(int ilosc, Projekt projekt)
    {
        List<Technologia> technologie = new ArrayList<Technologia>();
        List<Technologia> technologieDoLosowania = new ArrayList<Technologia>();
        technologieDoLosowania.addAll(generatorTechnologii.technologie);
        int sumaGodzin = 0;
        int wylosowanuIndeks;
        for (int i=0; i<ilosc; i++)
        {
            wylosowanuIndeks = Losuj(0,technologieDoLosowania.size()-1);
            Technologia technologia = technologieDoLosowania.get(wylosowanuIndeks).Kpiuj();

            if(i == ilosc - 1)
            {
                technologia.DniRobocze = projekt.TerminOddania.IloscDniMiedzyDatami(projekt.TerminRozpoczecia) - sumaGodzin;
            }
            else
            {
                technologia.DniRobocze = Losuj(1, (projekt.TerminOddania.IloscDniMiedzyDatami(projekt.TerminRozpoczecia))-sumaGodzin-ilosc);
                sumaGodzin += technologia.DniRobocze;
            }
            technologie.add(technologia);
            technologieDoLosowania.remove(wylosowanuIndeks);
        }
        return technologie;
    }
    public int Losuj(int minimalna, int maksymalna)
    {
        return  minimalna + (int)(Math.random() * maksymalna);
    }

}
