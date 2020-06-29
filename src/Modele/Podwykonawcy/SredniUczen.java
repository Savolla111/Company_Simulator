package Modele.Podwykonawcy;

public class SredniUczen extends Podwykonawca {
    public SredniUczen(int StawkaMiesieczna, String Imie, String Nazwisko) {
        super(StawkaMiesieczna, Imie, Nazwisko);
    }

    @Override
    public Podwykonawca Kopiuj() {
        SredniUczen sredniUczen = new SredniUczen(StawkaMiesieczna, Imie, Nazwisko);
        sredniUczen.Umiejetnosci.addAll(Umiejetnosci);
        return sredniUczen;
    }

    @Override
    public int CzasOpoznienia() {

        return 0;
    }

    @Override
    public int Dokladnosc() {
        int losowanieOpoznienia = Losuj(0, 100);
        if (losowanieOpoznienia >= 0 && losowanieOpoznienia <= 10) {
            return Losuj(1, 5);
        }
        return 0;
    }
}
