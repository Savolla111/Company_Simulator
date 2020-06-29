package Modele.Klient;

public class KlientWymagajacy extends Klient {
    public KlientWymagajacy(String Imie, String Nazwisko) {
        super(Imie, Nazwisko);
    }

    @Override
    public int IloscDniOpoznieniaOplaty() {
        return 0;
    }

    @Override
    public boolean CzyUnikniecieKaryZaZlyProjekt() {

        if (Losuj(0, 1) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean CzyUnikniecieKaryZaSpoznienie(int opoznienie) {
        return false;
    }

    public int Losuj(int minimalna, int maksymalna) {
        return minimalna + (int) (Math.random() * maksymalna);
    }

}
