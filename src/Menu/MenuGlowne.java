package Menu;



import java.util.Scanner;

public class MenuGlowne {
    public static class MenuGlowneMetody {
        public static Scanner sc = new Scanner(System.in);
        public static int indeks = 0;


        public static void Wypisz() {
            switch (wartosc) {
                case 1:
                    WybierzProjekt();
                    break;
                case 2:
                    SzukajNowegoProjektu();
                    break;
                case 3:
                    NastepnyDzien();
                    break;
                case 4:
                    Programuj();
                    break;
                case 5:
                    Testuj();
                    break;
                case 6:
                    WypiszPrzyjeteProjekty(firma);
                    break;
                case 7:
                    RozliczSieZUrzedem(firma);
                    break;
                case 8:
                    OddajGotowyProjekt(firma);
                    break;
                default:
                    System.out.println("Bledne dane sprobuj jeszcze raz");
                    break;
            }
        }


        public static void OddajGotowyProjekt()
        {


        }


        public static void RozliczSieZUrzedem()
        {

        }


        public static void WypiszPrzyjeteProjekty()
        {

        }


        public  static  void SzukajNowegoProjektu()
        {

        }


        public static void Programuj()
        {

        }


        public static void Testuj()
        {


        }


        public static void WybierzProjekt() {

    }
}
}
