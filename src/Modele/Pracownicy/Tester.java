package Modele.Pracownicy;

public class Tester extends Pracownik {

    public Tester(int StawkaMiesieczna,String imie, String nazwisko) {
        super(StawkaMiesieczna,imie, nazwisko);
    }

    public Tester() {
    }

    @Override
    public Tester Kopiuj() {
        return new Tester(StawkaMiesieczna, imie, nazwisko);
    }
}
