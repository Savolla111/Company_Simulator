package Menu;

import Modele.Firma;

import java.util.Scanner;

public class MenuZwolnijPracownika {
    public static class MenuZwolnijPracownikaMetodu {
        public static Scanner sc = new Scanner(System.in);
        public static int indeks;

        public static void Wybierz(int wartosc, Firma firma) {
            switch (wartosc) {
                case 1:
                    ZwolnijPodwykonawce(firma);
                    break;
                case 2:
                    ZwolnijPracownika(firma);
                    break;
                default:
                    System.out.println("Bledne dane");
                    break;
            }
        }


        public static void ZwolnijPodwykonawce(Firma firma) {
            try {
                String wynik = "Zwolnij: ";
                for (int i = 0; i < firma.Podwykonawcy.size(); i++) {
                    wynik += "|" + i + "|" + firma.Podwykonawcy.get(i).Wypisz() + "\n";
                }
                MenuWypisz.MenuWypiszMetody.Szablon(wynik);
                indeks = sc.nextInt();
                firma.Podwykonawcy.remove(indeks);
                firma.IloscPieniedzy -= firma.Podwykonawcy.get(indeks).StawkaMiesieczna;
                System.out.println("Zwolniles podwykonawce pomyslnie");
            } catch (Exception ex) {

            }
        }

        public static void ZwolnijPracownika(Firma firma) {
            try {
                String wynik = "Zwolnij: ";
                for (int i = 0; i < firma.Pracownicy.size(); i++) {
                    wynik += "|" + i + "|" + firma.Pracownicy.get(i).Wypisz() + "\n";
                }
                MenuWypisz.MenuWypiszMetody.Szablon(wynik);
                indeks = sc.nextInt();
                firma.Pracownicy.remove(indeks);
                firma.IloscPieniedzy -= firma.Pracownicy.get(indeks).StawkaMiesieczna;
                System.out.println("Zwolniles pracownika pomyslnie");
            } catch (Exception ex) {

            }
        }
    }
}
