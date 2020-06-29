package Modele;

public class Technologia {
    public String Nazwa;
    public int DniRobocze;
    public boolean CzyTestowana;
    public boolean CzyPrzezWlascicielaProgramowane;
    public boolean CzyPrzezWlascicielaTestowane;

    public Technologia(String Nazwa, int DniRobcze) {
        this.Nazwa = Nazwa;
        this.DniRobocze = DniRobcze;
        CzyTestowana = false;
        CzyPrzezWlascicielaProgramowane = false;
        CzyPrzezWlascicielaTestowane = false;
    }

    public String Wypisz() {
        return "Nazwa: " + Nazwa + " Dni robocze: " + DniRobocze;
    }

    public Technologia Kopiuj() {
        return new Technologia(Nazwa, DniRobocze);
    }
}
