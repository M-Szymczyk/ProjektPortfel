package application.data;

import java.math.BigDecimal;
import java.util.Scanner;

interface BankAccountInterface {

    /**
     * Do wczytywania pol klasy
     */

    void enterDataBankAccount();

    /**
     * Zwraca wszystkie data konta
     */

    String toString();
}

class BankAccountException extends Exception{

    BankAccountException(String message) {
        super(message);
    }
}

public class BankAccount extends AmountOfMoney implements BankAccountInterface {
    // bede tworzyc transakcje i dodawac tutaj liste transakcji. pomysle nad ich limitem

    private BigDecimal numberBankAccount;
    private UserData accountHolder;

    /** ==================== KONSTRUKTORY ========================= */

    public BankAccount() {
        this.numberBankAccount = null;
        this.accountHolder = null;
    }

    public BankAccount(BigDecimal money, String name, BigDecimal numberBankAccount, UserData accountHolder) {
        super(money,name);
        this.numberBankAccount = numberBankAccount;
        this.accountHolder = accountHolder;
    }

    /** ======================= METODY ============================ */

    /** ---------------- Numer konta bankowego -------------------- */

    private void setNumberBankAccount(BigDecimal numberBankAccount) throws BankAccountException {
        if (numberBankAccount.compareTo(new BigDecimal(0)) < 0) {
            throw new BankAccountException("Numer konta bankowego nie moze byc mniejszy niz zero!");
        } else
            this.numberBankAccount = numberBankAccount;
    }

    private BigDecimal getNumberBankAccount() {
        return numberBankAccount;
    }

    /** --------------------- Wlasciciel -------------------------- */

    private UserData getAccountHolder() {
        return this.accountHolder;
    }

    /** ---------- Wczytywanie danych konta bankowego ------------- */

    public void enterDataBankAccount() {
        super.enterMoney();//wywoluje metode enterMoney klasy AmountOfMoney
        Scanner scanner = new Scanner(System.in);
        boolean toContinue;
        do {
            try {
                System.out.println("Podaj nr_konta: ");
                setNumberBankAccount(EnterDataInterface.enterBigDecimal());
                toContinue = false;
            } catch (BankAccountException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        } while (toContinue);

        System.out.println("Czy chcesz dodac dane wlasciciela tego konta? (T/N): ");
        if (scanner.nextLine().toUpperCase().equals("T")) {
            accountHolder = new UserData();
            accountHolder.enterUserData();
        } else System.out.println("Podpowiedz: Dane mozesz wpisac w kazdej chwili wybierajac opcje w menu startowym.");
    }

    /** ------------ Odczyt danych konta bankowego --------------- */

    @Override
    public String toString() {
        return "Stan konta \"" + getName() + "\" o numerze " + getNumberBankAccount().toString() +
                " ktorego wlascicielam jest: " + getAccountHolder().toString() + "\nwynosi: " + super.toString();
    }
}
