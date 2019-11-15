package aplikacja.dane;
import java.util.Scanner;

interface AmountOfMoneyInterface {

    /**
     * Do zmiany ilosci gotowki
     */

    void transaction();

    /**
     * Do wczytawania poczatkowego stanu gotowki
     */

    void enterData();

    /**
     * Do zwracania stanu gotowki
     */

    String toString();

    /**
     * Do listowania kont i portfeli
     * @return zwraca nazwe obiektu
     */
    String getName();

}

class AmountOfMoneyException extends Exception{
    AmountOfMoneyException(String message) {
        super(message);
    }
}

public abstract class AmountOfMoney implements AmountOfMoneyInterface,WczytywanieDanychInterface {
    private int numberOfZL; // warto rozwazyc BigDecimala aby pracowac na obiektach
    private int numberOfGR;
    private double smallNumberOfGR;

    private String name;

    //================= NAZWA ======================
    public String getName() {
        return this.name;
    }

    private void setName(String nazwa)throws AmountOfMoneyException {
        if (this.name == null || this.name.equals(""))
            throw new AmountOfMoneyException("Musisz podac nazwe!");
        else
            this.name = nazwa;
    }

    // ================ ZLOTOWKI ===================
    private int getNumberOfZL() {
        return numberOfZL;
    }

    private void setNumberOfZL(int numberOfZL) {
        this.numberOfZL = numberOfZL;
    }

    // ================= GROSZE ====================
    private int getNumberOfGR() {
        return numberOfGR;
    }

    private void setNumberOfGR(int numberOfGR) {
        this.numberOfGR = numberOfGR;
    }

    // zabezpieczenie przed typem co bedzie bledy zaokraglen na swoje konto przelewal xDD
    private double getSmallNumberGR() {
        return smallNumberOfGR;
    }

    private void setSmallNumberGR(double smallNumberOfGr) {
        this.smallNumberOfGR = smallNumberOfGr;
    }
    //transaction
    public void transaction() {
        Scanner scan = new Scanner(System.in);
        boolean condition;
        do {
            System.out.println("1.Wplata czy 2.wyplata gotowki?[1/2]");
            try {
                switch (Integer.parseInt(scan.nextLine())) {
                    case 1:
                        do {
                            System.out.println("Ile gotowki wplacono?");
                            try {
                                int input = Integer.parseInt(scan.nextLine());
                                if (input <= 0) {
                                    System.out.println("Nie mozna wplacic mniej niz zero gotowki!");
                                    condition = true;
                                } else {
                                    setNumberOfZL(getNumberOfZL() + input);
                                    condition = false;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Musisz podac liczbe!");
                                condition = true;
                            }
                        } while (condition);
                        break;
                    case 2:
                        do {
                            System.out.println("Ile gotowki wyplacono?");
                            try {
                                int input = Integer.parseInt(scan.nextLine());
                                if (input <= 0) {
                                    System.out.println("Nie mozna wyplacic mniej niz zero gotowki!");
                                    condition = true;
                                } else {
                                    setNumberOfZL(getNumberOfZL() + input);
                                    condition = false;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Musisz podac liczbe!");
                                condition = true;
                            }
                        } while (condition);
                        break;
                    default:
                        System.out.println("Brak takiej opcji!");
                        break;
                }
                condition = false;
            } catch (NumberFormatException e) {
                System.out.println("Podaj cyfre!");
                condition = true;
            }
        } while (condition);
    }

    // wczytywanie hajsu
    public void wczytaj() {
        Scanner scaner = new Scanner(System.in);
        boolean war_poprawnosci;
        do {
            try {
                System.out.println("Podaj nazwe obiektu:");
                setName(scaner.nextLine());
                war_poprawnosci = false;
            } catch (AmountOfMoneyException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        }while (war_poprawnosci);
        System.out.println("Podaj ilosc zl: ");
        setNumberOfZL(WczytywanieDanychInterface.enterInt());
        System.out.println("Podaj ilosc gr: ");
        int tmp = WczytywanieDanychInterface.enterInt();
        setNumberOfGR(tmp % 100);
        if (tmp >= 100 || tmp <= -100) setNumberOfZL(this.numberOfZL + tmp / 100);
        setSmallNumberGR(0);
    }
    // odczyt ilosci hajsu
    @Override
    public String toString() {
        return "Stan: " + getNumberOfZL() + "." + getNumberOfGR() + "  " + getSmallNumberGR();
    }
    AmountOfMoney(int numberOfZL, int numberOfGR, String name) {
        this.numberOfZL = numberOfZL;
        this.numberOfGR = numberOfGR;
        this.name = name;
    }
    AmountOfMoney() {
        this.numberOfZL = 0;
        this.numberOfGR = 0;
        this.name = null;
    }

}


    /* AmountOfMoney(int ilosc_zl) {
        this.ilosc_zl = ilosc_zl;
        this.ilosc_gr = 0;
        this.bardzo_mala_wartosc = 0;
    }






*/