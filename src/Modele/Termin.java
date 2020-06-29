package Modele;

public class Termin {
    public int Dzien;
    public int Rok;

    public Termin(int Dzien, int Rok)
    {
        this.Dzien = Dzien;
        this.Rok = Rok;
    }
    public Termin DodajDni(int wartosc)
    {
        if(Dzien + wartosc < 365)
        {
            return new Termin(Dzien+wartosc, Rok);
        }
        return new Termin((Dzien+wartosc)%365, Rok+((Dzien+wartosc)/365));
    }
    public int IloscDniMiedzyDatami(Termin termin)
    {
        if(Dzien>=termin.Dzien)
        {
            return ((Dzien - termin.Dzien) + ((Rok - termin.Rok)*365));
        }
        return (Rok - termin.Rok)*365 + Dzien - termin.Dzien;
    }

    public String Wypisz()
    {
        return Dzien+"dzien"+Rok+"rok";
    }
    public Termin Kopiuj()
    {
        return new Termin(Dzien,Rok);
    }

}
