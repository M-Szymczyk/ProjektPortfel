package aplikacja.dane;

import java.util.Scanner;

interface BankAccountInterface {
    /**
     * Do wczytywania pol klasy
     */
    void load();

    /**
     * Zwraca wszystkie dane konta
     */
    String toString();
}

class BankAccountException extends Exception{

    BankAccountException(String message) {
        super(message);
    }
}

public class BankAccount extends IloscPieniedzy implements BankAccountInterface {
    // bede tworzyc transakcje i dodawac tutaj liste transakcji. pomysle nad ich limitem
    private int numberBankAccount;
    private UserData wlasciciel;

    // ==================== NR_KONTA ================================

    private void setNumberBankAccount(int numberBankAccount) throws BankAccountException {
        if (numberBankAccount < 0) {
            throw new BankAccountException("Numer konta bankowego nie moze byc mniejszy niz zero!");
        } else
            this.numberBankAccount = numberBankAccount;
    }

    private int getNumberBankAccount() {
        return numberBankAccount;
    }

    //===================== Wlasciciel ============================
    private UserData getWlasciciel() {
        return this.wlasciciel;
    }

    // konstruktory
    public BankAccount() {
        this.numberBankAccount = 0;
        this.wlasciciel = null;
    }

    public BankAccount(int ilosc_zl, int ilosc_gr, String nazwa, int numberBankAccount, UserData wlasciciel) {
        super(ilosc_zl, ilosc_gr,nazwa);
        this.numberBankAccount = numberBankAccount;
        this.wlasciciel = wlasciciel;
    }

    // wczytywanie danych konta, hajsu + opcjonalnie wlasciciela
    @Override
    public void load() {
        super.wczytaj();//wywoluje metode wczytaj klasy IloscPieniedzy
        Scanner scanner = new Scanner(System.in);
        boolean war_poprawnosci;
        do {
            try {
                System.out.println("Podaj nr_konta: ");
                setNumberBankAccount(WczytywanieDanychInterface.enterInt());
                war_poprawnosci = false;
            } catch (BankAccountException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);

        // daje mozliwosc dodania wlasciciela w kazdej chwili, niekoniecznie teraz, a no i poki co to nie bawimy sie
        // w tworzenie uzytkownikow i ich list ...
        System.out.println("Czy chcesz dodac dane wlasciciela tego konta? (T/N): ");
        if (scanner.nextLine().toUpperCase().equals("T")) {
            wlasciciel = new UserData();
            wlasciciel.wczytaj();
        } else System.out.println("Podpowiedz: Dane mozesz wpisac w kazdej chwili wybierajac opcje w menu startowym.");
        //FIXME nie przechytujemy wszystkich odp uzytkownika
    }

    @Override
    public String toString() {
        return "Stan " + getNazwa() + "o numerze" + getNumberBankAccount() + "ktorego wlascicielam jest: " +
                getWlasciciel() + "\nwynosi: " + super.toString();
    }
}
