package Menu;

import Modele.Firma;
import Modele.Podwykonawcy.Podwykonawca;
import Modele.Pracownicy.Pracownik;

import java.util.Scanner;

public class MenuZatrudnijPracownika {
    public static class MenuZatrudnijPracownikaMetody {
        public static Scanner sc = new Scanner(System.in);
        public static int indeks = 0;

        public static void Wypisz(int wartosc, Firma firma) {
            switch (wartosc) {
                case 1:
                    WybierzPodwykonawce(firma);
                    break;
                case 2:
                    WybierzPracownika(firma);
                    break;
                default:
                    System.out.println("Bledne dane");
                    break;
            }
        }


        public static void WybierzPodwykonawce(Firma firma) {
            try {
                String wynik = "Wybierz podwykonawce:\n";
                for (int i = 0; i < firma.OgloszeniaPodwykonawca.size(); i++) {
                    wynik += "|" + i + "|" + firma.OgloszeniaPodwykonawca.get(i).Wypisz() + " " + firma.OgloszeniaPodwykonawca.get(i).getClass() + "\n";
                }
                MenuWypisz.MenuWypiszMetody.Szablon(wynik);
                indeks = sc.nextInt();
                Podwykonawca podwykonawca = firma.OgloszeniaPodwykonawca.get(indeks).Kopiuj();
                firma.Podwykonawcy.add(podwykonawca);
                firma.OgloszeniaPodwykonawca.remove(indeks);
                firma.IloscPieniedzy -= podwykonawca.StawkaMiesieczna;

            } catch (Exception ex) {
                System.out.println("Bledne dane");
            }
        }

        public static void WybierzPracownika(Firma firma) {
            try {
                String wynik = "Wybierz podwykonawce:\n";
                for (int i = 0; i < firma.OgloszeniaPracownicy.size(); i++) {
                    wynik += "|" + i + "|" + firma.OgloszeniaPracownicy.get(i).Wypisz() + " " + firma.OgloszeniaPracownicy.get(i).getClass() + "\n";
                }
                MenuWypisz.MenuWypiszMetody.Szablon(wynik);
                indeks = sc.nextInt();
                Pracownik pracownik = firma.OgloszeniaPracownicy.get(indeks).Kopiuj();
                firma.Pracownicy.add(pracownik);
                firma.OgloszeniaPracownicy.remove(indeks);
                firma.IloscPieniedzy -= pracownik.StawkaMiesieczna;

            } catch (Exception ex) {
                System.out.println("Bledne dane");
            }
        }


    }
}
