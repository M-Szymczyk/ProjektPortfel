package aplikacja;

public class Portfel extends IloscPieniedzy implements PortfelInterface {
    private String wlasciciel;

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

    Portfel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    Portfel() {
        this.wlasciciel = null;
    }

    private String getWlasciciel() {
        return wlasciciel;
    }

    private void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    @Override
    public void wczytaj(){
        //uzupelnic
    }
    @Override
    public String toString() {
        return "Portfel{" +
                "nalezacy do: " + wlasciciel;
    }
    /*
    public static void printToFile(PrintWriter writer, Portfel portfel){
        writer.println(portfel.wlasciciel+"#"+getIlosc_zl());
    }

     */
}
