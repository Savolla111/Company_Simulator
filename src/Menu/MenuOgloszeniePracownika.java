package Menu;

import Generatory.GeneratorPodwykonawca;
import Generatory.GeneratorPracownikow;
import Modele.Firma;

public class MenuOgloszeniePracownika {
    public static class MenuOgloszeniePracownikaMetody {
        //dodanie nowych ogloszen
        public static void Wybierz(int wartosc, GeneratorPracownikow generatorPracownikow, GeneratorPodwykonawca generatorPodwykonawca, Firma firma) {
            switch (wartosc) {
                case 1:
                    OglosPodwykonawca(firma, generatorPodwykonawca);
                    break;
                case 2:
                    OglosPracownikow(firma, generatorPracownikow);
                    break;
                default:
                    System.out.println("Bledne dane");
                    break;
            }
        }

        //szukanie podwykonawcow
        public static void OglosPodwykonawca(Firma firma, GeneratorPodwykonawca generatorPodwykonawca) {
            try {

                int CzyZnaleziono = Losuj(0, 1);
                if (CzyZnaleziono == 0) {
                    generatorPodwykonawca.Wygeneruj();
                    firma.OgloszeniaPodwykonawca.addAll(generatorPodwykonawca.Podwykonawcy);
                    firma.IloscPieniedzy -= 50;
                    System.out.println("Znaleziono nowych podwykonawcow");
                } else {
                    System.out.println("Nie znalazles nowych podwykonawcow");
                }
            } catch (Exception ex) {
                System.out.println("Bledne dane");
            }
        }

        //szukanie pracownikow
        public static void OglosPracownikow(Firma firma, GeneratorPracownikow generatorPracownikow) {
            try {

                int CzyZnaleziono = Losuj(0, 1);
                if (CzyZnaleziono == 0) {
                    generatorPracownikow.Wygeneruj();
                    firma.OgloszeniaPracownicy.addAll(generatorPracownikow.Pracownicy);
                    firma.IloscPieniedzy -= 50;
                    System.out.println("Znaleziono nowych pracownikow");
                } else {
                    System.out.println("Nie znalazles nowych pracownikow");
                }
            } catch (Exception ex) {
                System.out.println("Bledne dane");
            }
        }

        public static int Losuj(int minimalna, int maksymalna) {
            return minimalna + (int) (Math.random() * maksymalna);
        }

    }
}
