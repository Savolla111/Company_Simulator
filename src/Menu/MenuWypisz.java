package Menu;

public class MenuWypisz {
    public static class MenuWypiszMetody{

        public static void Szablon(String tekst)
        {
            System.out.println("-----------------------");
            System.out.println(tekst);
            System.out.println("-----------------------");
            System.out.print("Opcja:");
        }

        public static String MenuGlowne()
        {
            return "wybierz:\n|1|Przyjmij projekt\n|2|Poswiec dzien na szukanie nowego projektu\n|3|Nastepny dzien" +
                    "\n|4|Programuj\n|5|Testuj\n|6|Dodaj Pracownika\n|7|Wykup ogloszenie w celu wyszukania pracownika" +
                    "\n|8|Zwolnij pracownika\n|9|Przydziel prace\n|10|Pokaz zastawienie przydzielenia pracownikow" +
                    "\n|11|Przyjete projekty\n|12|Rozlicz urzedy\n|13|Oddaj gotowy projekt\n|14|Wyjscie";
        }

        public static String MenuZatrudnijPracownika()
        {
            return "zatrudnij:\n|1|Podwykonawce\n|2|Pracownika";
        }

        public static String MenuOgloszeniePracownika()
        {
            return "Wystaw ogloszenie na:\n|1|Podwykonawce\n|2|Pracownika";
        }

        public static String MenuZwolnijPracownika()
        {
            return "Zwolnij: \n|1|Podwykonawce\n|2|Pracownika";
        }

        public static String MenuPrzypiszPrace()
        {
            return "Przypisz: \n|1|Podwykonawce\n|2|Pracownika";
        }

        public static String MenuZestwienie()
        {
            return "Zobacz zestawienie: \n|1|Podwykonawcy\n|2|Pracownicy";
        }



    }
}
