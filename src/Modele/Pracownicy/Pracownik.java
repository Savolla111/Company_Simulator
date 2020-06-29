package Modele.Pracownicy;

public class Pracownik {
    public int StawkaMiesieczna;
    public String imie;
    public String nazwisko;


    public Pracownik() {
    }

    public Pracownik(int StawkaMiesieczna, String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.StawkaMiesieczna = StawkaMiesieczna;
    }

    public String Wypisz() {
        return "Stawka miesieczna" + StawkaMiesieczna + "Imie: " + imie + " Nazwisko: " + nazwisko;
    }

    public Pracownik Kopiuj() {
        return new Pracownik(StawkaMiesieczna, imie, nazwisko);
    }


}
