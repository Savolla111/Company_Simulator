package Generatory;

import Modele.Technologia;

import java.util.ArrayList;
import java.util.List;

public class GeneratorTechnologii {
    public List<Technologia> technologie;

    public GeneratorTechnologii() {
        technologie = new ArrayList<Technologia>();
    }

    public void Wygeneruj() {
        Technologia frontEnd = new Technologia("Front-end", 0);
        Technologia backend = new Technologia("Backend", 0);
        Technologia bazaDanych = new Technologia("Baza danych", 0);
        Technologia mobilne = new Technologia("Mobilne", 0);
        Technologia wordpress = new Technologia("Wordpress", 0);
        Technologia prestashop = new Technologia("Prestashop", 0);

        technologie.add(frontEnd);
        technologie.add(backend);
        technologie.add(bazaDanych);
        technologie.add(mobilne);
        technologie.add(wordpress);
        technologie.add(prestashop);

    }

}
