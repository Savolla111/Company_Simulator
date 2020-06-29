package Modele.Podwykonawcy;

public class NajlepszyUczen extends Podwykonawca {

    public NajlepszyUczen(int StawkaMiesieczna, String Imie, String Nazwisko) {
        super(StawkaMiesieczna, Imie, Nazwisko);
    }

    @Override
    public Podwykonawca Kopiuj() {

        NajlepszyUczen najlepszyUczen = new NajlepszyUczen(StawkaMiesieczna, Imie, Nazwisko);
        najlepszyUczen.Umiejetnosci.addAll(Umiejetnosci);
        return najlepszyUczen;
    }
}
