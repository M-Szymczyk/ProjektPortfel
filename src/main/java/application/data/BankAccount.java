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

class BankAccountException extends Exception {

    BankAccountException(String message) {
        super(message);
    }
}

public class BankAccount extends AmountOfMoney implements BankAccountInterface {
    // bede tworzyc transakcje i dodawac tutaj liste transakcji. pomysle nad ich limitem
    private final static int accountNumberDigits = 26;
    private final static NumbersDataBase numbersDataBase = new NumbersDataBase(accountNumberDigits);
    private BigDecimal numberBankAccount;
    private UserData accountHolder;

    /**
     * ==================== KONSTRUKTORY =========================
     */

    public BankAccount() {
        this.numberBankAccount = null;
        this.accountHolder = null;
    }

    /** ======================= METODY ============================ */

    /**
     * ---------------- Numer konta bankowego --------------------
     */

    private void setNumberBankAccount(BigDecimal numberBankAccount) throws BankAccountException {
        if (numberBankAccount.compareTo(new BigDecimal(0)) < 0) {
            throw new BankAccountException("Numer konta bankowego nie moze byc mniejszy niz zero!");
        } else if (numberBankAccount.precision() - numberBankAccount.scale() != accountNumberDigits) {
            throw new BankAccountException("Numer konta bankowego nie moze byc innej dlugosci niz " + accountNumberDigits);
        } else if (numbersDataBase.check(numberBankAccount)) {
            throw new BankAccountException("Podany numer konta jest już w bazie!");
        } else {
            this.numberBankAccount = numberBankAccount;
            numbersDataBase.add(numberBankAccount);
        }
    }

    private BigDecimal getNumberBankAccount() {
        return numberBankAccount;
    }

    /**
     * --------------------- Wlasciciel --------------------------
     */

    public boolean hasAccountHolder() {
        // it gives information about existence of account holder in current bank account, concurrently avoiding getter
        return this.accountHolder != null;
    }

    public void enterAccountHolder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Czy chcesz dodac dane wlasciciela tego konta? (T/N): ");
        if (scanner.nextLine().equalsIgnoreCase("T")) {
            accountHolder = new UserData();
            accountHolder.enterUserData();
        } else System.out.println("Podpowiedz: Dane mozesz wpisac w kazdej chwili wybierajac opcje w menu startowym.");
    }

    /**
     * ---------- Wczytywanie danych konta bankowego -------------
     */

    public void enterDataBankAccount() {
        super.enterMoney();//wywoluje metode enterMoney klasy AmountOfMoney
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

        enterAccountHolder();
    }

    /**
     * ------------ Odczyt danych konta bankowego ---------------
     */

    @Override
    public String toString() {
        return "Stan konta \"" + getName() + "\" o numerze " + getNumberBankAccount().toString() +
                " ktorego wlascicielam jest: " +
                (hasAccountHolder() ? accountHolder.toString() : "(brak informacji)") +
                "\nwynosi: " + super.toString();
    }
}
