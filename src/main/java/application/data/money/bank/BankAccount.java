package application.data.money.bank;

import application.data.money.amount.AmountOfMoney;
import application.services.NumbersDataBase;
import application.data.user.UserData;
import application.services.EnterDataInterface;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankAccount extends AmountOfMoney implements BankAccountInterface {
    private final static int accountNumberDigits = 26;
    private final static NumbersDataBase numbersDataBase = new NumbersDataBase(accountNumberDigits);
    private BigDecimal numberBankAccount;
    private UserData accountHolder;

    public BankAccount() {
        this.numberBankAccount = null;
        this.accountHolder = null;
    }

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

    public void enterDataBankAccount() {
        super.enterMoney();     //wywoluje metode enterMoney klasy AmountOfMoney
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

    @Override
    public String toString() {
        return "Stan konta \"" + getName() + "\" o numerze " + getNumberBankAccount().toString() +
                " ktorego wlascicielam jest: " +
                (hasAccountHolder() ? accountHolder.toString() : "(brak informacji)") +
                "\nwynosi: " + super.toString();
    }
}
