package Menu;

import Modele.Firma;
import Modele.Pracownicy.Programista;
import Modele.Projekt;
import Modele.Technologia;

import java.util.Scanner;

public class MenuPrzypiszPrace {
    public static class MenuPrzypiszPraceMetody{
        static Scanner sc = new Scanner(System.in);
        static int indeks;
        public static void Wybierz(int wartosc, Firma firma)
        {
            System.out.println("dklkdlwakdlaw");

            switch (wartosc)
            {
                case 1:
                    PrzypiszPracePodwykonawca(firma);
                    break;
                case 2:
                    PrzypiszPracePracownikoowi(firma);
                    break;
                default:
                    System.out.println("Bledne dane");
                    break;
            }
        }


        public static void PrzypiszPracePodwykonawca(Firma firma)
        {
            try {

                if (firma.Projekty.size()!=0)
                {
                    String wypiszProjekty = "Wybierz projekt:\n";
                    for(int i=0; i<firma.Projekty.size(); i++)
                    {
                        wypiszProjekty +="|"+i+"|"+firma.Projekty.get(i).Wypisz()+"\n";
                    }
                    MenuWypisz.MenuWypiszMetody.Szablon(wypiszProjekty);
                    int indeksProjektu = sc.nextInt();

                    String wynik = "Przypisz pracownika: \n";
                    int [] indeksPrzydzielony  = new int[firma.Podwykonawcy.size()];
                    int iterator  = 0;
                    for(int i=0; i<firma.Podwykonawcy.size(); i++)
                    {
                        if(!firma.Podwykonawcy.get(i).CzyPrzydzielony)
                        {
                            wynik += "|"+iterator+"|"+firma.Podwykonawcy.get(i).Wypisz();

                            indeksPrzydzielony[iterator] = i;
                            iterator++;
                        }
                    }
                    if(iterator != 0)
                    {
                        MenuWypisz.MenuWypiszMetody.Szablon(wynik);
                        int indeksPracownika = sc.nextInt();

                        String wypiszTechnologie = "Wybierz technologie:\n";
                        int [] indeksPrzydzielonyUmiejetnosci  = new int[firma.Podwykonawcy.get(indeksPrzydzielony[indeksPracownika]).Umiejetnosci.size()];
                        int iteratorumiejetnosci =0;
                        for(int i=0; i<firma.Podwykonawcy.get(indeksPrzydzielony[indeksPracownika]).Umiejetnosci.size(); i++)
                        {
                            if(CzyUmiejetnoscJestWProjekcie(firma.Projekty.get(indeksProjektu), firma.Podwykonawcy.get(indeksPrzydzielony[indeksPracownika]).Umiejetnosci.get(i))) {
                                wypiszTechnologie += "|" + iteratorumiejetnosci + "|" + firma.Podwykonawcy.get(indeksPrzydzielony[indeksPracownika]).Umiejetnosci.get(i).Wypisz()+"\n";
                                indeksPrzydzielonyUmiejetnosci[iteratorumiejetnosci] = i;

                                iteratorumiejetnosci++;
                            }
                        }


                        if(iteratorumiejetnosci != 0)
                        {
                            MenuWypisz.MenuWypiszMetody.Szablon(wypiszTechnologie);
                            int wybranaTechnologia = sc.nextInt();
                            firma.Podwykonawcy.get(indeksPrzydzielony[indeksPracownika]).CzyPrzydzielony = true;
                            firma.Podwykonawcy.get(indeksPrzydzielony[indeksPracownika]).PrzydzielonyProjekt = firma.Projekty.get(indeksProjektu).Kopiuj();
                            firma.Podwykonawcy.get(indeksPrzydzielony[indeksPracownika]).PrzydzielonaTechnologia
                                    = firma.Podwykonawcy.get(indeksPrzydzielony[indeksPracownika]).Umiejetnosci.get(indeksPrzydzielonyUmiejetnosci[wybranaTechnologia]).Kopiuj();

                            System.out.println("Przydzielono pracownika do projektu");
                        }
                        else
                        {
                            System.out.println("Nie masz odpowiedniego pracownika");
                        }
                    }
                    else {
                        System.out.println("Nie masz odpowiedniego podwykonawcy");
                    }

                }
                else
                {
                    System.out.println("Brak projektow");
                }


            }
            catch (Exception ex)
            {
                System.out.println("Bledne dane "+ex.getMessage());
            }
        }


        public static void PrzypiszPracePracownikoowi(Firma firma)
        {
            try {

                if (firma.Projekty.size()!=0)
                {
                    String wypiszProjekty = "Wybierz projekt:\n";
                    for(int i=0; i<firma.Projekty.size(); i++)
                    {
                        wypiszProjekty +="|"+i+"|"+firma.Projekty.get(i).Wypisz()+"\n";
                    }
                    MenuWypisz.MenuWypiszMetody.Szablon(wypiszProjekty);
                    int indeksProjektu = sc.nextInt();

                    String wynik = "Przypisz pracownika: \n";
                    int [] indeksPrzydzielony  = new int[firma.Pracownicy.size()];
                    int iterator  = 0;
                    for(int i=0; i<firma.Pracownicy.size(); i++)
                    {
                        if(!((Programista)firma.Pracownicy.get(i)).CzyPrzydzielony && firma.Pracownicy.get(i) instanceof Programista)
                        {
                            wynik += "|"+iterator+"|"+firma.Pracownicy.get(i).Wypisz();

                            indeksPrzydzielony[iterator] = i;
                            iterator++;
                        }
                    }
                    if(iterator != 0)
                    {
                        MenuWypisz.MenuWypiszMetody.Szablon(wynik);
                        int indeksPracownika = sc.nextInt();

                        String wypiszTechnologie = "Wybierz technologie:\n";
                        int [] indeksPrzydzielonyUmiejetnosci  = new int[((Programista) firma.Pracownicy.get(indeksPrzydzielony[indeksPracownika])).Umiejetnosci.size()];
                        int iteratorumiejetnosci =0;
                        Programista wybranyProgramista = (Programista) firma.Pracownicy.get(indeksPrzydzielony[indeksPracownika]);
                        for(int i=0; i<wybranyProgramista.Umiejetnosci.size(); i++)
                        {
                            if(CzyUmiejetnoscJestWProjekcie(firma.Projekty.get(indeksProjektu), wybranyProgramista.Umiejetnosci.get(i))) {
                                wypiszTechnologie += "|" + iteratorumiejetnosci + "|" + wybranyProgramista.Umiejetnosci.get(i).Wypisz()+"\n";
                                indeksPrzydzielonyUmiejetnosci[iteratorumiejetnosci] = i;

                                iteratorumiejetnosci++;
                            }
                        }


                        if(iteratorumiejetnosci != 0)
                        {
                            MenuWypisz.MenuWypiszMetody.Szablon(wypiszTechnologie);
                            int wybranaTechnologia = sc.nextInt();
                            wybranyProgramista.CzyPrzydzielony = true;
                            wybranyProgramista.PrzydzielonyProjekt = firma.Projekty.get(indeksProjektu).Kopiuj();
                            wybranyProgramista.PrzydzielonaTechnologia
                                    = wybranyProgramista.Umiejetnosci.get(indeksPrzydzielonyUmiejetnosci[wybranaTechnologia]).Kopiuj();

                            System.out.println("Przydzielono pracownika do projektu");
                        }
                        else
                        {
                            System.out.println("Nie masz odpowiedniego pracownika");
                        }
                    }
                    else {
                        System.out.println("Nie masz odpowiedniego pracownika");
                    }

                }
                else
                {
                    System.out.println("Brak projektow");
                }


            }
            catch (Exception ex)
            {
                System.out.println("Bledne dane "+ex.getMessage());
            }
        }


        public static boolean CzyUmiejetnoscJestWProjekcie(Projekt projekt, Technologia technologia)
        {

            for(Technologia technologia1: projekt.Technologie)
            {
                if(technologia1.Nazwa.equals(technologia.Nazwa))
                {
                    return true;
                }
            }
            return false;
        }
    }

}
