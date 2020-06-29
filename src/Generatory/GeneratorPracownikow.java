package Generatory;

import Modele.Pracownicy.Pracownik;
import Modele.Pracownicy.Programista;
import Modele.Pracownicy.Sprzedawca;
import Modele.Pracownicy.Tester;
import Modele.Technologia;

import java.util.ArrayList;
import java.util.List;

public class GeneratorPracownikow {
    public List<Pracownik> Pracownicy;
    public GeneratorTechnologii generatorTechnologii;
    public GeneratorPracownikow()
    {
        Pracownicy = new ArrayList<Pracownik>();
        generatorTechnologii = new GeneratorTechnologii();
        generatorTechnologii.Wygeneruj();
    }

    public void Wygeneruj()
    {
        Pracownicy.clear();
        Programista programista = new Programista(200,"Anna", "Joanna", Losuj(0,20),Losuj(0,20));
        programista.Umiejetnosci.addAll(WylosujUmiejetnosci());
        Sprzedawca sprzedawca = new Sprzedawca(400, "Marcin", "Przemek");
        Tester tester = new Tester(200, "Michal", "Michal");
        Pracownicy.add((Pracownik)programista);
        Pracownicy.add((Pracownik)sprzedawca);
        Pracownicy.add((Pracownik)tester);
    }
    public List<Technologia> WylosujUmiejetnosci()
    {
        List<Technologia> mozliweTechnologie = new ArrayList<Technologia>();
        mozliweTechnologie.addAll(generatorTechnologii.technologie);
        List<Technologia> wylosowaneUmiejetnosci = new ArrayList<Technologia>();
        int iloscTechnologii = Losuj(1, generatorTechnologii.technologie.size()-1);
        for(int i =0; i<iloscTechnologii; i++)
        {
            int wylosowanyIndkes = Losuj(0, mozliweTechnologie.size()-1);
            Technologia technologia = mozliweTechnologie.get(wylosowanyIndkes).Kpiuj();
            mozliweTechnologie.remove(wylosowanyIndkes);
            wylosowaneUmiejetnosci.add(technologia);
        }
        return wylosowaneUmiejetnosci;
    }
    public int Losuj(int minimalna, int maksymalna)
    {
        return  minimalna + (int)(Math.random() * maksymalna);
    }

}
