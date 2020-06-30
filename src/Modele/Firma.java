package Modele;

import Generatory.GeneratorProjektow;
import Modele.Podwykonawcy.Podwykonawca;
import Modele.Pracownicy.Pracownik;
import Modele.Pracownicy.Programista;
import Modele.Pracownicy.Sprzedawca;
import Modele.Pracownicy.Tester;
import Modele.Projekt;
import Modele.Termin;

import java.util.ArrayList;
import java.util.List;

public class Firma {
    public int IloscPieniedzy;
    public Termin ObecnyTermin;
    public List<Projekt> Projekty;
    public List<Projekt> ProjektyDoOddania;
    public int IloscDniSzukaniaProjektu = 0;
    public boolean CzyNowyProjekt;
    public List<Projekt> DostepneProjekty;
    public List<Pracownik> Pracownicy;
    public List<Podwykonawca> Podwykonawcy;
    public List<Pracownik> OgloszeniaPracownicy;
    public List<Podwykonawca> OgloszeniaPodwykonawca;
    GeneratorProjektow generatorProjektow;
    public int IloscDniRozliczania = 0;
    public boolean CzyPrzegrana;
    public List<Projekt> ProjektyDoZaplaty;
    public boolean CzyWygrana;

    public Firma(int IloscPieniedzy, Termin ObecnyTermin) {
        this.IloscPieniedzy = IloscPieniedzy;
        this.ObecnyTermin = ObecnyTermin;
        Projekty = new ArrayList<Projekt>();
        CzyNowyProjekt = true;
        DostepneProjekty = new ArrayList<Projekt>();
        Pracownicy = new ArrayList<Pracownik>();
        Podwykonawcy = new ArrayList<Podwykonawca>();
        OgloszeniaPracownicy = new ArrayList<Pracownik>();
        OgloszeniaPodwykonawca = new ArrayList<Podwykonawca>();
        ProjektyDoOddania = new ArrayList<Projekt>();
        ProjektyDoZaplaty = new ArrayList<Projekt>();
        generatorProjektow = new GeneratorProjektow();
        CzyPrzegrana = false;
        CzyWygrana = false;

    }

    public void NastepnyDzien() {
        //dodanie dnia
        ObecnyTermin = ObecnyTermin.DodajDni(1);
        if (IloscPieniedzy == 0) {
            CzyPrzegrana = true;
        }

        if (CzyGraWygrana()) {
            System.out.println("Wygrales");
            CzyWygrana = true;
        }
        int IloscTesterow = 0;
        try {
            ////Zaplacenie wyplaty
            if (ObecnyTermin.Dzien % 30 == 0) {
                for (Podwykonawca podwykonawca :
                        Podwykonawcy) {
                    IloscPieniedzy -= podwykonawca.StawkaMiesieczna;

                }
                for (Pracownik pracownik : Pracownicy) {
                    IloscPieniedzy -= pracownik.StawkaMiesieczna;

                }

                ////Sprawdzenie czy dwa razy w miesiacu sie rozliczales
                if (IloscDniRozliczania >= 2) {
                    System.out.println("Nie rozliczyles sie w pore z urzedem. Firma zostaje zamknieta");
                    CzyPrzegrana = true;
                } else {
                    IloscDniRozliczania = 0;
                }
            }

            PracujPodwykonawca();

            PracujPracownik(IloscTesterow);
            //Sprawdzanie przypadku jak jest jeden tester na trzech pracownikow - wtedy na pewno projekt bedzie poprawny
            //Sprawdzenie czy projekt zostal zakonczony i dodanie na liste zakonczonych projektow
            List<Integer> indeksyZakonczonychProjektow = new ArrayList<Integer>();
            int iterator = 0;
            for (int i = 0; i < Projekty.size(); i++
            ) {

                if (IloscTesterow != 0) {
                    if (Pracownicy.size() + Podwykonawcy.size() % IloscTesterow == 3) {
                        for (Technologia technologia : Projekty.get(i).Technologie) {
                            technologia.CzyTestowana = true;
                        }
                    }
                }


                if (CzyProjektZakonczony(Projekty.get(i))) {
                    ProjektyDoOddania.add(Projekty.get(i).Kopiuj());
                    System.out.println("Zakonczyles projekt");
                    indeksyZakonczonychProjektow.add(i);

                }


            }
            //usuniecie zakonczonych projektow z listy projektow
            for (int i : indeksyZakonczonychProjektow) {
                Projekty.remove(i);
            }


            List<Integer> indeksyOplaconychProjektow = new ArrayList<Integer>();
            for (int i = 0; i < ProjektyDoZaplaty.size(); i++
            ) {
                if (ProjektyDoZaplaty.get(i).TerminPlatnosci.Dzien == ObecnyTermin.Dzien && ProjektyDoZaplaty.get(i).TerminPlatnosci.Rok == ObecnyTermin.Rok) {
                    IloscPieniedzy += ProjektyDoZaplaty.get(i).CenaZaplaty;
                    indeksyOplaconychProjektow.add(i);
                }
            }

            for (int i : indeksyOplaconychProjektow
            ) {
                ProjektyDoZaplaty.remove(i);
            }
        } catch (Exception ex) {
            System.out.println("Bledne dane");
        }

    }

    //Losowanie przypadku choroby
    public boolean CzyChory() {
        if (Losuj(0, 100) == 1) {
            return true;
        }
        return false;
    }

    public boolean CzyProjektZakonczony(Projekt projekt) {
        int sumaDni = 0;

        for (Technologia technologia : projekt.Technologie
        ) {
            sumaDni += technologia.DniRobocze;
        }
        return sumaDni == 0;
    }

    public int Losuj(int minimalna, int maksymalna) {
        return minimalna + (int) (Math.random() * maksymalna);
    }

    public boolean CzyGraWygrana() {
        int ilosc = 0;
        for (Projekt projekt : Projekty) {
            if (projekt.poziomTrudnosci.equals(Projekt.PoziomTrudnosci.trudny)) {
                for (Technologia technologia : projekt.Technologie) {
                    if (technologia.CzyPrzezWlascicielaProgramowane || technologia.CzyPrzezWlascicielaTestowane) {
                        return false;
                    }
                }
                if (projekt.CzyPozyskales) {
                    ilosc++;
                }
            }

        }
        return ilosc != 3 && IloscPieniedzy > 1000;
    }

    public void PracujPodwykonawca() {

        for (Podwykonawca podwykonawca :
                Podwykonawcy) {
            if (ObecnyTermin.Dzien % 6 != 0 && ObecnyTermin.Dzien % 7 != 0) {
                if (!CzyChory()) {
                    if (podwykonawca.CzyPrzydzielony) {

                        for (Projekt projekt : Projekty) {
                            if (podwykonawca.PrzydzielonyProjekt.Wypisz().equals(projekt.Wypisz())) {

                                for (Technologia technologia : projekt.Technologie) {
                                    if (technologia.Nazwa.equals(podwykonawca.PrzydzielonaTechnologia.Nazwa + "")) {
                                        if (technologia.DniRobocze != 0) {
                                            technologia.DniRobocze--;
                                        } else {
                                            int czasOpoznienia = podwykonawca.CzasOpoznienia();
                                            int dokladnosc = podwykonawca.Dokladnosc();
                                            if (czasOpoznienia > 0) {
                                                System.out.println("Twoj pracownik " + podwykonawca.Imie + " nie wyrobil sie na czas opoznienie bedzie trwalo: " + czasOpoznienia);
                                                technologia.DniRobocze += czasOpoznienia;
                                            } else {
                                                if (dokladnosc > 0) {
                                                    System.out.println("Twoj pracownik " + podwykonawca.Imie + " nie byl zbyt dokladny musisz przypisac kogos do poprawienia zadan,\n" +
                                                            " czas na wniesienie poprawek wynosi: " + dokladnosc);
                                                    technologia.DniRobocze += dokladnosc;

                                                }
                                                podwykonawca.CzyPrzydzielony = false;
                                                podwykonawca.PrzydzielonaTechnologia = null;
                                                podwykonawca.PrzydzielonyProjekt = null;
                                            }

                                        }

                                    }
                                }
                            }

                        }
                    }
                } else {
                    System.out.println(podwykonawca.Imie + " Zachorowal");
                }
            }

        }
    }

    public void PracujPracownik(int IloscTesterow) {
        for (Pracownik pracownik :
                Pracownicy) {
            if (ObecnyTermin.Dzien % 6 != 0 && ObecnyTermin.Dzien % 7 != 0) {
                if (!CzyChory()) {
                    if (pracownik instanceof Programista) {
                        if (((Programista) pracownik).CzyPrzydzielony) {

                            for (Projekt projekt : Projekty) {

                                if (((Programista) pracownik).PrzydzielonyProjekt.Wypisz().equals(projekt.Wypisz())) {

                                    for (Technologia technologia : projekt.Technologie) {

                                        if (technologia.Nazwa.equals(((Programista) pracownik).PrzydzielonaTechnologia.Nazwa + "")) {

                                            if (technologia.DniRobocze != 0) {
                                                technologia.DniRobocze--;
                                            } else {
                                                int czasOpoznienia = ((Programista) pracownik).Punktualnosc();
                                                int dokladnosc = ((Programista) pracownik).Dokladnosc();
                                                if (czasOpoznienia > 0) {
                                                    System.out.println("Twoj pracownik " + pracownik.imie + " nie wyrobil sie na czas opoznienie bedzie trwalo: " + czasOpoznienia);
                                                    technologia.DniRobocze += czasOpoznienia;
                                                } else {
                                                    if (dokladnosc > 0) {
                                                        System.out.println("Twoj pracownik " + pracownik.imie + " nie byl zbyt dokladny musisz przypisac kogos do poprawienia zadan,\n" +
                                                                " czas na wniesienie poprawek wynosi: " + dokladnosc);
                                                        technologia.DniRobocze += dokladnosc;

                                                    }
                                                    ((Programista) pracownik).CzyPrzydzielony = false;
                                                    ((Programista) pracownik).PrzydzielonaTechnologia = null;
                                                    ((Programista) pracownik).PrzydzielonyProjekt = null;
                                                }

                                            }

                                        }
                                    }
                                }

                            }
                        }
                    }

                    if (pracownik instanceof Sprzedawca) {
                        if (((Sprzedawca) pracownik).IloscDniPoszukiwan == 5) {
                            ((Sprzedawca) pracownik).IloscDniPoszukiwan = 0;
                            generatorProjektow.Wygeneruj(1, ObecnyTermin);
                            DostepneProjekty.addAll(generatorProjektow.Projekty);
                            CzyNowyProjekt = true;
                            System.out.println("Znaleziono nowy projekt");
                        } else {
                            ((Sprzedawca) pracownik).IloscDniPoszukiwan++;
                        }
                    }

                    if (pracownik instanceof Tester)
                        IloscTesterow++;

                } else {
                    System.out.println(pracownik.imie + " Zachorowal");
                }
            }

        }
    }
}
