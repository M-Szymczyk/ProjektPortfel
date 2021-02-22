package application;

import application.data.money.amount.AmountOfMoney;
import application.data.money.amount.AmountOfMoneyException;
import application.data.money.bank.BankAccount;
import application.data.money.wallet.Wallet;
import application.services.EnterDataInterface;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Engine implements EnterDataInterface {
    private final ArrayList<AmountOfMoney> bankAccounts = new ArrayList<>();
    private final ArrayList<AmountOfMoney> wallets = new ArrayList<>();

    public void DepositMoney(int index, String type, BigDecimal money) throws AmountOfMoneyException, IllegalArgumentException {
        if (type.equals("b"))
            bankAccounts.get(index).depositMoney(money);
        else if (type.equals("w"))
            wallets.get(index).depositMoney(money);
        else throw new IllegalArgumentException("Unavailable type! Available types: b - bankAccount, w - wallet");
    }

    public void WithDrawMoney(int index, String type, BigDecimal money) throws AmountOfMoneyException,IllegalArgumentException {
        if (type.equals("b"))
            bankAccounts.get(index).withdraw(money);
        else if(type.equals("w"))
            wallets.get(index).withdraw(money);
        else throw new IllegalArgumentException("Unavailable type! Available types: b - bankAccount, w - wallet");
    }

    public boolean thereAreAnyBanksAccounts() {
        return bankAccounts.size() > 0;
    }

    public boolean thereAreAnyWallets() {
        return wallets.size() > 0;
    }

    public ArrayList<AmountOfMoney> getBankAccounts() {
        return bankAccounts;
    }

    public ArrayList<AmountOfMoney> getWallets() {
        return wallets;
    }

    public void addWallet(Wallet w) {
        wallets.add(w);
    }

    public void addBankAccount(BankAccount w) {
        bankAccounts.add(w);
    }
}
