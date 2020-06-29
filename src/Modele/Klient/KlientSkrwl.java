package Modele.Klient;

public class KlientSkrwl extends Klient {
    public KlientSkrwl(String Imie, String Nazwisko) {
        super(Imie, Nazwisko);
    }

    @Override
    public int IloscDniOpoznieniaOplaty() {
        int wylosowana = Losuj(0, 100);
        if (wylosowana >= 0 && wylosowana <= 5) {
            return 30;
        }

        if (wylosowana >= 0 && wylosowana <= 30) {
            return 7;
        }
        return 0;
    }

    @Override
    public boolean CzyUnikniecieKaryZaSpoznienie(int opoznienie) {
        return false;
    }

    @Override
    public boolean CzyUnikniecieKaryZaZlyProjekt() {
        return false;
    }

    @Override
    public boolean CzyZaplaci() {
        if (Losuj(0, 100) == 1) {
            return false;
        }
        return true;
    }

    public int Losuj(int minimalna, int maksymalna) {
        return minimalna + (int) (Math.random() * maksymalna);
    }
}
