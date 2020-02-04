package application.data;

import java.math.BigDecimal;

interface WalletInterface {

    /**
     * prawdo podobnie bd wyorzystane do
     * wczytywanie danych do portfela
     */
    void enterDataWallet();

    /**
     * odczyt danych portfela
     */

    String toString();
}

public class Wallet extends AmountOfMoney implements WalletInterface {

    /** ================= KONSTRUKTORY ====================== */

    public Wallet() { }

    /** ==================== METODY ========================= */

    /** ---------- Wczytywanie danych portfela -------------- */

    public void enterDataWallet() {
        super.enterMoney();
    }

    /** ------------------ Zwrot danych --------------------- */

    @Override
    public String toString() {
        return "Stan portfela \"" + getName() + "\" wynosi: "+super.toString();
    }
}
    /*
    public static void printToFile(PrintWriter writer, Wallet portfel){
        writer.println(portfel.wlasciciel+"#"+getIlosc_zl());
    }
    */


