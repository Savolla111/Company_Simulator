package Modele.Klient;

public class KlientWyluzowany extends Klient {
    public KlientWyluzowany(String Imie, String Nazwisko) {
        super(Imie, Nazwisko);
    }

    @Override
    public int IloscDniOpoznieniaOplaty() {
        int wylosowana = Losuj(0, 100);
        if (wylosowana >= 0 && wylosowana <= 30) {
            return 7;
        }
        return 0;
    }

    @Override
    public boolean CzyUnikniecieKaryZaSpoznienie(int opoznienie) {
        int wylosowana = Losuj(0, 100);
        if (wylosowana >= 0 && wylosowana <= 20 && opoznienie <= 7) {
            return true;
        }
        return false;
    }


    public int Losuj(int minimalna, int maksymalna) {
        return minimalna + (int) (Math.random() * maksymalna);
    }

}
