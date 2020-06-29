package Generatory;

import Modele.Podwykonawcy.NajlepszyUczen;
import Modele.Podwykonawcy.Podwykonawca;
import Modele.Podwykonawcy.SredniUczen;
import Modele.Podwykonawcy.WieWszystko;
import Modele.Technologia;

import java.util.ArrayList;
import java.util.List;

public class GeneratorPodwykonawca {
    public List<Podwykonawca> Podwykonwcy;
    GeneratorTechnologii generatorTechnologii;
    public GeneratorPodwykonawca()
    {

        generatorTechnologii = new GeneratorTechnologii();
        generatorTechnologii.Wygeneruj();
        Podwykonwcy = new ArrayList<Podwykonawca>();
    }

    public void Wygeneruj()
    {
        Podwykonwcy.clear();
        NajlepszyUczen najlepszyUczen = new NajlepszyUczen(200,"Jan", "Jankowski");
        najlepszyUczen.Umiejetnosci = WylosujUmiejetnosci();
        SredniUczen sredniUczen = new SredniUczen(100,"Przemek", "Przemkowski");
        sredniUczen.Umiejetnosci = WylosujUmiejetnosci();
        WieWszystko wieWszystko = new WieWszystko(300,"Marek", "Markowski");
        wieWszystko.Umiejetnosci = WylosujUmiejetnosci();

        Podwykonwcy.add(najlepszyUczen);
        Podwykonwcy.add(sredniUczen);
        Podwykonwcy.add(wieWszystko);
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
