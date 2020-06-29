package Menu;



import Generatory.GeneratorPodwykonawca;
import Generatory.GeneratorPracownikow;
import Generatory.GeneratorProjektow;
import Modele.Podwykonawcy.Podwykonawca;
import Modele.Pracownicy.Firma;
import Modele.Pracownicy.Pracownik;
import Modele.Projekt;
import Modele.Termin;

import java.util.Scanner;

public class MenuGlowne {
    public static class MenuGlowneMetody {
        public static Scanner sc = new Scanner(System.in);
        public static int indeks = 0;


        public static void Wypisz(int wartosc, Firma firma, GeneratorProjektow generatorProjektow, GeneratorPodwykonawca generatorPodwykonawca, GeneratorPracownikow generatorPracownikow) {
            switch (wartosc) {
                case 1:
                    WybierzProjekt(firma);
                    break;
                case 2:
                    SzukajNowegoProjektu(firma, generatorProjektow);
                    break;
                case 3:
                    firma.NastepnyDzien();
                    break;
                case 4:
                    Programuj(firma);
                    break;
                case 5:
                    Testuj(firma);
                    break;
                case 6:
                    MenuWypisz.MenuWypiszMetody.Szablon(MenuWypisz.MenuWypiszMetody.MenuZatrudnijPracownika());
                    indeks = sc.nextInt();
                    MenuZatrudnijPracownika.MenuZatrudnijPracownikaMetody.Wypisz(indeks, firma);
                    break;
                case 7:
                    MenuWypisz.MenuWypiszMetody.Szablon(MenuWypisz.MenuWypiszMetody.MenuOgloszeniePracownika());
                    indeks = sc.nextInt();
                    MenuOgloszeniePrawnika.MenuOgloszeniePrawnikaMetody.Wybierz(indeks,generatorPracownikow, generatorPodwykonawca, firma);
                    break;
                case 8:
                    MenuWypisz.MenuWypiszMetody.Szablon(MenuWypisz.MenuWypiszMetody.MenuZwolnijPracownika());
                    indeks = sc.nextInt();
                    MenuZwolnijPracownika.MenuZwolnijPracownikaMetodu.Wybierz(indeks, firma);
                    break;
                case 9:
                    MenuWypisz.MenuWypiszMetody.Szablon(MenuWypisz.MenuWypiszMetody.MenuPrzypiszPrace());
                    indeks = sc.nextInt();
                    MenuPrzypiszPrace.MenuPrzypiszPraceMetody.Wybierz(indeks, firma);
                    break;
                case 10:
                    MenuWypisz.MenuWypiszMetody.Szablon(MenuWypisz.MenuWypiszMetody.MenuZestwienie());
                    indeks = sc.nextInt();
                    MenuZestawinie.MenuZestwienieMetody.Wybierz(indeks, firma);
                    break;
                case 11:
                    WypiszPrzyjeteProjekty(firma);
                    break;
                case 12:
                    RozliczSieZUrzedem(firma);
                    break;
                case 13:
                    OddajGotowyProjekt(firma);
                    break;
                default:
                    System.out.println("Bledne dane sprobuj jeszcze raz");
                    break;
            }
        }


        public static void OddajGotowyProjekt()
        {
            if(firma.ProjektyDoOddania.size() != 0)
            {
                String wynik ="Wybierz: ";
                for (int i=0; i<firma.ProjektyDoOddania.size(); i++)
                {
                    wynik +="|"+i+"|"+ firma.ProjektyDoOddania.get(i);
                }
                MenuWypisz.MenuWypiszMetody.Szablon(wynik);
                indeks = sc.nextInt();

                if(firma.ProjektyDoOddania.get(indeks).Klient.CzyZaplci())
                {
                    if(!firma.ProjektyDoOddania.get(indeks).CzyProjektPoprawny())
                    {
                        System.out.println("Dales niepoprawny projekt");
                        if(!firma.ProjektyDoOddania.get(indeks).Klient.CzyUnikniecieKaryZaZlyProjekt())
                        {
                            System.out.println("Placisz kare");
                            firma.IloscPieniedzy -= 100;
                        }else
                        {
                            Termin terminZaplaty = firma.ProjektyDoOddania.get(indeks).TerminPlatnosci.Kopiuj();
                            terminZaplaty = terminZaplaty.DodajDni(firma.ProjektyDoOddania.get(indeks).Klient.IloscDniOpoznieniaOplaty());
                            Projekt projektDoZaplaty = firma.ProjektyDoOddania.get(indeks).Kopiuj();
                            projektDoZaplaty.TerminPlatnosci = terminZaplaty;
                            firma.ProjektyDoZaplaty.add(projektDoZaplaty);
                        }
                    }
                    else
                    {
                        System.out.println("oddales poprawny projekt");
                        Termin terminZaplaty = firma.ProjektyDoOddania.get(indeks).TerminPlatnosci.Kopiuj();
                        terminZaplaty = terminZaplaty.DodajDni(firma.ProjektyDoOddania.get(indeks).Klient.IloscDniOpoznieniaOplaty());
                        Projekt projektDoZaplaty = firma.ProjektyDoOddania.get(indeks).Kopiuj();
                        projektDoZaplaty.TerminPlatnosci = terminZaplaty;
                        firma.ProjektyDoZaplaty.add(projektDoZaplaty);
                    }

                    if(firma.ProjektyDoOddania.get(indeks).TerminOddania.Dzien <= firma.ObecnyTermin.Dzien && firma.ProjektyDoOddania.get(indeks).TerminOddania.Rok <= firma.ObecnyTermin.Rok)
                    {
                        if( firma.ProjektyDoOddania.get(indeks).Klient.
                                CzyUnikniecieKaryZaSpoznienie(firma.ObecnyTermin.IloscDniMiedzyDatami(firma.ProjektyDoOddania.get(indeks).TerminOddania)))
                        {
                            System.out.println("Spozniles sie i nie udalo ci sie uniknac kary");
                            firma.IloscPieniedzy -= firma.ProjektyDoOddania.get(indeks).CenaZaplaty;
                        }
                    }
                    else
                    {
                        System.out.println("Projekt byl oddany w terminie");
                    }
                }
                else
                {
                    System.out.println("Klient postanowil ci nigdy nie placic");
                }
                firma.ProjektyDoOddania.remove(indeks);
            }
            else
            {
                System.out.println("Nie posiadasz gotowych projektow");
            }

        }


        public static void RozliczSieZUrzedem()
        {
            for (Podwykonawca podwykonawca:firma.Podwykonawcy
            ) {
                firma.IloscPieniedzy -= 20 /podwykonawca.StawkaMiesieczna*100;
            }
            for (Pracownik pracownik:firma.Pracownicy
            ) {
                firma.IloscPieniedzy -= 20 /pracownik.StawkaMiesieczna*100;
            }
            System.out.println("Rozliczyles sie pomyslnie");
            firma.IloscDniRozliczania++;
        }


        public static void WypiszPrzyjeteProjekty()
        {
            System.out.println("Projekty:");
            for(Projekt projekt: firma.Projekty)
            {
                System.out.println(projekt.Wypisz());
            }
        }


        public  static  void SzukajNowegoProjektu()
        {
            if(firma.IloscDniSzukaniaProjektu!=5)
            {
                firma.IloscDniSzukaniaProjektu++;
                System.out.println("Nie znaleziono nowego projektu");
                firma.NastepnyDzien();

            }
            else
            {
                firma.IloscDniSzukaniaProjektu = 0;
                firma.CzyNowyProjekt = true;
                generatorProjektow.Wygeneruj(1, firma.ObecnyTermin);
                firma.DostepneProjekty.addAll(generatorProjektow.Projekty);
                System.out.println("Znaleziono nowe projekty");
                firma.NastepnyDzien();
            }
        }


        public static void Programuj()
        {
            try
            {
                int indeksTechnologie ;
                if(firma.Projekty.size()!=0)
                {
                    String wynikProjekty = "Wybierz projekt przy ktorym chcesz programowac:\n";
                    for(int i=0; i<firma.Projekty.size(); i++)
                    {
                        wynikProjekty += "|"+i+"|"+firma.Projekty.get(i).Wypisz()+"\n";
                    }
                    MenuWypisz.MenuWypiszMetody.Szablon(wynikProjekty);
                    indeks = sc.nextInt();
                    String wynikTechnologie = "Wybierz technologie\n";
                    for(int i=0; i<firma.Projekty.get(indeks).Technologie.size(); i++)
                    {
                        wynikTechnologie += "|"+i+"|"+firma.Projekty.get(indeks).Technologie.get(i).Wypisz()+"\n";
                    }
                    MenuWypisz.MenuWypiszMetody.Szablon(wynikTechnologie);
                    indeksTechnologie = sc.nextInt();
                    if(!firma.Projekty.get(indeks).Technologie.get(indeksTechnologie).Nazwa.equals("Mobilne") && firma.Projekty.get(indeks).Technologie.get(indeksTechnologie).DniRobocze>0)
                    {
                        firma.Projekty.get(indeks).Technologie.get(indeksTechnologie).DniRobocze--;
                        firma.Projekty.get(indeks).Technologie.get(indeksTechnologie).CzyPrzezWlascicielaProgramowane = true;
                        System.out.println("Przepracowales w "+ firma.Projekty.get(indeks).Technologie.get(indeksTechnologie).Nazwa);
                    }
                    else if(firma.Projekty.get(indeks).Technologie.get(indeksTechnologie).Nazwa.equals("Mobilne"))
                    {
                        System.out.println("Nie umiesz technologii mobilnych. Musisz zlecic komus");
                    }
                    else
                    {
                        System.out.println("Juz wypracowales wszystkie godziny w tej technologii");
                    }
                    firma.NastepnyDzien();
                }
                else
                {
                    System.out.println("Nie masz dostepnych projektow");
                }
            }
            catch(Exception ex)
            {
                System.out.println("Bledne dane");
            }
        }


        public static void Testuj()
        {
            try {
                if(firma.Projekty.size() !=0)
                {
                    String wynik = "Wybierz projekt: \n";
                    for(int i = 0; i<firma.Projekty.size(); i++)
                    {
                        wynik += "|"+i+"|"+firma.Projekty.get(i).Wypisz();
                    }
                    MenuWypisz.MenuWypiszMetody.Szablon(wynik);
                    indeks = sc.nextInt();
                    wynik = "Wybierz technologie, ktora chcesz testowac:\n";
                    for(int i = 0; i<firma.Projekty.get(indeks).Technologie.size(); i++)
                    {
                        wynik += "|"+i+"|"+firma.Projekty.get(indeks).Technologie.get(i).Wypisz();
                    }
                    MenuWypisz.MenuWypiszMetody.Szablon(wynik);
                    indeks = sc.nextInt();
                    firma.Projekty.get(indeks).Technologie.get(indeks).CzyTestowana = true;
                    firma.Projekty.get(indeks).Technologie.get(indeks).CzyPrzezWlascicielaTestowane = true;
                    System.out.println("Przetestowales pomyslnie");
                }
                else
                {
                    System.out.println("Brak projektow");
                }
            }
            catch (Exception ex)
            {
                System.out.println("Bledne dane");
            }


        }


        public static void WybierzProjekt() {
            if(firma.CzyNowyProjekt)
            {
                String wynik = "Wybierz projekt: \n";
                for (int i = 0; i < firma.DostepneProjekty.size(); i++) {
                    wynik +="|"+i+"|"+ firma.DostepneProjekty.get(i).Wypisz() + " Poziom trudnosci: "+firma.DostepneProjekty.get(i).poziomTrudnosci+"\n\n";
                }
                MenuWypisz.MenuWypiszMetody.Szablon(wynik);
                try {
                    indeks = sc.nextInt();

                    if(firma.DostepneProjekty.get(indeks).poziomTrudnosci.equals(Projekt.PoziomTrudnosci.latwy) ||
                            firma.DostepneProjekty.get(indeks).poziomTrudnosci.equals(Projekt.PoziomTrudnosci.sredni) &&
                                    firma.Podwykonawcy.size()==0 && firma.Pracownicy.size() == 0)
                    {
                        Projekt projekt = firma.DostepneProjekty.get(indeks).Kopiuj();
                        firma.Projekty.add(projekt);
                        firma.DostepneProjekty.remove(indeks);
                        System.out.println("Przyjeto projekt pomyslnie");
                        firma.CzyNowyProjekt = false;
                    }
                    else if(firma.Podwykonawcy.size()>0 || firma.Pracownicy.size()> 0)
                    {
                        Projekt projekt = firma.DostepneProjekty.get(indeks).Kopiuj();
                        firma.Projekty.add(projekt);
                        firma.DostepneProjekty.remove(indeks);
                        System.out.println("Przyjeto projekt pomyslnie");
                        firma.CzyNowyProjekt = false;
                    }
                    else
                    {

                        System.out.println("Nie posiadasz zadnych pracownkow, nie mozesz przyjmowac trudnych projektow");
                    }

                } catch (Exception ex) {
                    System.out.println("Bledne dane");
                }

            }

            else
            {
                System.out.println("Brak nowych projektow");
            }

        }
    }
    }
