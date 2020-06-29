package Generatory;

import Modele.Klient.Klient;
import Modele.Klient.KlientSkrwl;
import Modele.Klient.KlientWyluzowany;
import Modele.Klient.KlientWymagajacy;

import java.util.ArrayList;
import java.util.List;

public class GeneratorKlientow {
    public List<Klient> Klienci;

    public GeneratorKlientow() {
        Klienci = new ArrayList<Klient>();
    }

    public void Wygeneruj() {
        KlientWyluzowany klientWyl1 = new KlientWyluzowany("Marek1", "Kwiatkowski1");
        KlientWyluzowany klientWyl2 = new KlientWyluzowany("Marek2", "Kwiatkowski2");
        KlientSkrwl klientS1 = new KlientSkrwl("Krystian1", "Dabrowski1");
        KlientSkrwl klientS2 = new KlientSkrwl("Krystian2", "Dabrowski2");
        KlientWymagajacy klientWym1 = new KlientWymagajacy("Przemek1", "Kowalski1");
        KlientWymagajacy klientWym2 = new KlientWymagajacy("Przemek2", "Kowalski2");

        Klienci.add((Klient) klientWyl1);
        Klienci.add((Klient) klientWyl2);
        Klienci.add((Klient) klientWym1);
        Klienci.add((Klient) klientWym2);
        Klienci.add((Klient) klientS1);
        Klienci.add((Klient) klientS2);
    }
}
