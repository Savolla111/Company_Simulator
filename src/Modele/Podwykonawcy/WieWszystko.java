package Modele.Podwykonawcy;

public class WieWszystko extends Podwykonawca {
    public WieWszystko(int StawkaMiesieczna, String Imie, String Nazwisko) {
        super(StawkaMiesieczna, Imie, Nazwisko);
    }

    @Override
    public Podwykonawca Kopiuj() {
        WieWszystko wieWszystko = new WieWszystko(StawkaMiesieczna, Imie, Nazwisko);
        wieWszystko.Umiejetnosci.addAll(Umiejetnosci);
        return wieWszystko;
    }

    @Override
    public int CzasOpoznienia() {
        int lsowanieOpoznienia = Losuj(0, 100);
        if (lsowanieOpoznienia >= 0 && lsowanieOpoznienia <= 20) {
            return Losuj(1, 5);
        }
        return 0;
    }

    @Override
    public int Dokladnosc() {
        int losowanieOpoznienia = Losuj(0, 100);
        if (losowanieOpoznienia >= 0 && losowanieOpoznienia <= 20) {
            return Losuj(1, 5);
        }
        return 0;
    }

}
