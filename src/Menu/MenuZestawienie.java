package Menu;

import Modele.Firma;
import Modele.Podwykonawcy.Podwykonawca;
import Modele.Pracownicy.Pracownik;

public class MenuZestawienie {
    public static class MenuZestwienieMetody
    {
        public static void Wybierz(int wartosc, Firma firma)
        {
            switch (wartosc)
            {
                case 1:
                    ZestawieniePodwykonwcy(firma);
                    break;
                case 2:
                    ZestawieniePracownika(firma);
                    break;
                default:
                    System.out.println("Bledne dane");
                    break;
            }

        }

        public static void ZestawieniePodwykonwcy(Firma firma)
        {
            try {
                for (Podwykonawca podwykonawca: firma.Podwykonawcy
                ) {
                    System.out.println(podwykonawca.Wypisz()+" Przydzielony projekt: "
                            +podwykonawca.PrzydzielonyProjekt.Wypisz()+"Przydzielona technologia: "+podwykonawca.PrzydzielonaTechnologia.Nazwa);
                }
            }
            catch (Exception ex)
            {
                System.out.println("Bledne Dane");
            }

        }

        public static void ZestawieniePracownika(Firma firma)
        {
            try {
                for (Pracownik pracownik: firma.Pracownicy
                ) {

                    pracownik.Wypisz();

                }
            }
            catch (Exception ex)
            {
                System.out.println("Bledne Dane");
            }

        }
    }
}
