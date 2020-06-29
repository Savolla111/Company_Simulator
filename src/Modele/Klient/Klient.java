package Modele.Klient;

public class Klient {
    public String Imie;
    public String Nazwisko;
    public Klient(String Imie, String Nazwisko)
    {
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;
    }
    public String Wypisz()
    {
        return "Imie: "+Imie+" Nazwisko: "+Nazwisko;
    }

    public int IloscDniOpoznieniaOplaty()
    {
        return 0;
    }

    public boolean CzyUnikniecieKaryZaSpoznienie(int opoznienies)
    {
        return true;
    }

    public boolean CzyUnikniecieKaryZaZlyProjekt()
    {
        return  true;
    }
    public boolean CzyZaplci()
    {
        return true;
    }
}
