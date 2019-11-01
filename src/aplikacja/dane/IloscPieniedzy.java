package aplikacja.dane;

import java.util.Scanner;
interface IloscPieniedzyInterface {
    /**
     * Do zmiany ilosci gotowki
     */
    void transakcja();

    /**
     * Do wczytawania poczatkowego stanu gotowki
     */
    void wczytaj();

    /**
     * Do zwracania stanu gotowki
     */
    String toString();

    /**
     * Do listowania kont i portfeli
     * @return zwraca nazwe obiektu
     */
    String getNazwa();
}
class IloscPieniedzyException extends Exception{
    IloscPieniedzyException(String message) {
        super(message);
    }
}

public abstract class IloscPieniedzy implements IloscPieniedzyInterface,WczytywanieDanychInterface {
    private int ilosc_zl; // warto rozwazyc BigDecimala aby pracowac na obiektach
    private int ilosc_gr;
    private double bardzo_mala_wartosc;

    private String nazwa;




    //================= NAZWA ======================
    public String getNazwa() {
        return nazwa;
    }

    private void setNazwa(String nazwa)throws IloscPieniedzyException {
        if (nazwa == null || nazwa.equals(""))
            throw new IloscPieniedzyException("Musisz podac nazwe!");
        else
            this.nazwa = nazwa;
    }

    // ================ ZLOTOWKI ===================
    private int getIlosc_zl() {
        return ilosc_zl;
    }

    private void setIlosc_zl(int ilosc_zl) {

        this.ilosc_zl = ilosc_zl;
    }

    // ================= GROSZE ====================
    private int getIlosc_gr() {
        return ilosc_gr;
    }

    private void setIlosc_gr(int ilosc_gr) {
        this.ilosc_gr = ilosc_gr;
    }

    // zabezpieczenie przed typem co bedzie bledy zaokraglen na swoje konto przelewal xDD
    private double getBardzo_mala_wartosc() {
        return bardzo_mala_wartosc;
    }

    private void setBardzo_mala_wartosc(double bardzo_mala_wartosc) {
        this.bardzo_mala_wartosc = bardzo_mala_wartosc;
    }
    //transakcja
    public void transakcja() {
        Scanner scan = new Scanner(System.in);
        boolean war_poprawnosci;
        do {
            System.out.println("1.Wplata czy 2.wyplata gotowki?[1/2]");
            try {
                switch (Integer.parseInt(scan.nextLine())) {
                    case 1:
                        do {
                            System.out.println("Ile gotowki wplacono?");
                            try {
                                int zmienna = Integer.parseInt(scan.nextLine());
                                if (zmienna <= 0) {
                                    System.out.println("Nie mozna wplacic mniej niz zero gotowki!");
                                    war_poprawnosci = true;
                                } else {
                                    setIlosc_zl(getIlosc_zl() + zmienna);
                                    war_poprawnosci = false;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Musisz podac liczbe!");
                                war_poprawnosci = true;
                            }
                        } while (war_poprawnosci);
                        break;
                    case 2:
                        do {
                            System.out.println("Ile gotowki wyplacono?");
                            try {
                                int zmienna = Integer.parseInt(scan.nextLine());
                                if (zmienna <= 0) {
                                    System.out.println("Nie mozna wyplacic mniej niz zero gotowki!");
                                    war_poprawnosci = true;
                                } else {
                                    setIlosc_zl(getIlosc_zl() + zmienna);
                                    war_poprawnosci = false;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Musisz podac liczbe!");
                                war_poprawnosci = true;
                            }
                        } while (war_poprawnosci);
                        break;
                    default:
                        System.out.println("Brak takiej opcji!");
                        break;
                }
                war_poprawnosci = false;
            } catch (NumberFormatException e) {
                System.out.println("Podaj cyfre!");
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
    }

    // wczytywanie hajsu
    public void wczytaj() {
        Scanner scane = new Scanner(System.in);
        boolean war_poprawnosci;
        do {
            try {
                System.out.println("Podaj nazwe obiektu:");
                setNazwa(scane.nextLine());
                war_poprawnosci = false;
            } catch (IloscPieniedzyException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        }while (war_poprawnosci);
        System.out.println("Podaj ilosc zl: ");
        setIlosc_zl(WczytywanieDanychInterface.enterInt());
        System.out.println("Podaj ilosc gr: ");
        int tmp = WczytywanieDanychInterface.enterInt();
        setIlosc_gr(tmp % 100);
        if (tmp >= 100 || tmp <= -100) setIlosc_zl(this.ilosc_zl + tmp / 100);
        setBardzo_mala_wartosc(0);
    }
    // odczyt ilosci hajsu
    @Override
    public String toString() {
        return "Stan: " + getIlosc_zl() + "." + getIlosc_gr() + "  " + getBardzo_mala_wartosc();
    }
    IloscPieniedzy(int ilosc_zl, int ilosc_gr, String nazwa) {
        this.ilosc_zl = ilosc_zl;
        this.ilosc_gr = ilosc_gr;
        this.nazwa = nazwa;
    }
    IloscPieniedzy() {
        this.ilosc_zl = 0;
        this.ilosc_gr = 0;
        this.nazwa = null;
    }

}


    /* IloscPieniedzy(int ilosc_zl) {
        this.ilosc_zl = ilosc_zl;
        this.ilosc_gr = 0;
        this.bardzo_mala_wartosc = 0;
    }






*/