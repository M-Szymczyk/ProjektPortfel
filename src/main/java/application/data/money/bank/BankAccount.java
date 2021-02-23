package application.data.money.bank;

import application.data.money.amount.AmountOfMoney;
import application.services.NumbersDataBase;
import application.data.user.UserData;

import java.math.BigDecimal;

public class BankAccount extends AmountOfMoney{
    private final static int accountNumberDigits = 26;
    private final static NumbersDataBase numbersDataBase = new NumbersDataBase(accountNumberDigits);
    private BigDecimal numberBankAccount;
    private UserData accountHolder;

    public BankAccount() {
        this.numberBankAccount = null;
        this.accountHolder = null;
    }

    public BigDecimal getNumberBankAccount() {
        return numberBankAccount;
    }

    public void setNumberBankAccount(BigDecimal numberBankAccount) throws BankAccountException {
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

    public UserData getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(UserData accountHolder) {
        this.accountHolder = accountHolder;
    }

    @Override
    public String getName() {
        return "[ACCOUNT] " + this.name;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNumber: " + numberBankAccount.toString() +
                "\nUserdata: " + accountHolder;
    }
}
