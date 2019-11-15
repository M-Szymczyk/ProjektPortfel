package aplikacja.dane;

interface PortfelInterface {
    /**
     * prawdo podobnie bd wyorzystane do
     * wczytywanie danych do portfela
     */
    void wczytaj();

    /**
     * odczyt danych portfela
     */
    String toString();
}

public class Portfel extends AmountOfMoney implements PortfelInterface {

    //=========================konstruktory=========================
    public Portfel() {
    }

    Portfel(int ilosc_zl, int ilosc_gr, String nazwa) {
        super(ilosc_zl, ilosc_gr, nazwa);
    }

    // wczytywanie danych
    @Override
    public void wczytaj() {
        super.wczytaj();
    }

    // odczyt danych
    @Override
    public String toString() {
        return "Portfel" + getNazwa() +
                "nalezacy do: " + getNazwa()+" ktorego stan wynosi: "+super.toString();
    }
}
    /*
    public static void printToFile(PrintWriter writer, Portfel portfel){
        writer.println(portfel.wlasciciel+"#"+getIlosc_zl());
    }
    */


