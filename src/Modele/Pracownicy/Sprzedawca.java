package Modele.Pracownicy;

public class Sprzedawca extends Pracownik {

    public int IloscDniPoszukiwan;
    public Sprzedawca(int StawkaMiesieczna, String imie, String nazwisko) {
        super(StawkaMiesieczna,imie, nazwisko);
        IloscDniPoszukiwan = 0;
    }

    public Sprzedawca() {
    }

    @Override
    public Sprzedawca Kopiuj() {
        return new Sprzedawca(StawkaMiesieczna, imie, nazwisko);
    }
}
