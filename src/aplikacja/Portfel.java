package aplikacja;

import java.util.Scanner;

public class Portfel extends IloscPieniedzy implements PortfelInterface {
    private String wlasciciel; // mysle ze nie warto dla portfela tworzyc obiektu DaneUzytkownika xD
    private String nazwa; // jeszcze nie wiem czy sie przyda xD


    //konstruktory
    Portfel() { this.wlasciciel = null; }

    Portfel(String wlasciciel) { this.wlasciciel = wlasciciel; }

    Portfel(int ilosc_zl, String wlasciciel) {
        super(ilosc_zl);
        this.wlasciciel = wlasciciel;
    }

    Portfel(int ilosc_zl, int ilosc_gr, String wlasciciel) {
        super(ilosc_zl, ilosc_gr);
        this.wlasciciel = wlasciciel;
    }

    Portfel(int ilosc_zl, int ilosc_gr, double bardzo_mala_wartosc, String wlasciciel) {
        super(ilosc_zl, ilosc_gr, bardzo_mala_wartosc);
        this.wlasciciel = wlasciciel;
    }


    // ================= WLASCICIEL =====================
    private String getWlasciciel() {
        return wlasciciel;
    }
    private void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }
    // ==================================================


    // wczytywanie danych
    @Override
    public void wczytaj(){
        System.out.println("Prosze podac nazwe portfela: ");
        Scanner input=new Scanner(System.in);
        this.nazwa=input.nextLine();
        System.out.println("Prosze podac imie/nazwisko/ksywke wlasciciela: ");
        this.wlasciciel=input.nextLine();
    }


    // odczyt danych
    @Override
    public String toString() {
        return "Portfel" + nazwa +
                "nalezacy do: " + wlasciciel;
    }


    /*
    public static void printToFile(PrintWriter writer, Portfel portfel){
        writer.println(portfel.wlasciciel+"#"+getIlosc_zl());
    }

     */
}
