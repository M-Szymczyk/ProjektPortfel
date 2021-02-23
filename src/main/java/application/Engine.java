package application;

import application.data.money.amount.AmountOfMoney;
import application.data.money.amount.AmountOfMoneyException;
import application.data.user.UserData;
import application.services.EnterDataInterface;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Engine implements EnterDataInterface {
    private final ArrayList<AmountOfMoney> moneyStorages = new ArrayList<>();
    private final ArrayList<UserData> savedUsers = new ArrayList<>();        // for objects storage only, not to list in view

    // why objects instead of indices?
    // javafx returns objects from selection in list/table view, not indices, however in console app version it doesn't matter
    public void depositMoney(AmountOfMoney moneyStorage, BigDecimal money) throws AmountOfMoneyException{
        moneyStorage.deposit(money);
    }

    public void withdrawMoney(AmountOfMoney moneyStorage, BigDecimal money) throws AmountOfMoneyException{
        moneyStorage.withdraw(money);
    }

    /**
     * Method for transactions between bank accounts and wallets, that's why it is named interTransaction, because
     * simple transaction means in this project withdrawing or depositing money from/to wallets and bank accounts
     * @param source the money storage from which we are transferring money
     * @param money transfer amount
     * @param target the money storage to which we are transferring money
     * @throws AmountOfMoneyException
     */
    public void interTransaction(AmountOfMoney source, BigDecimal money, AmountOfMoney target) throws AmountOfMoneyException{
        withdrawMoney(source, money);
        depositMoney(target, money);
    }

    public boolean anyMoneyStorages(){
        return !moneyStorages.isEmpty();
    }

    public List<AmountOfMoney> getMoneyStorages(){
        return moneyStorages;
    }

    public void addMoneyStorage(AmountOfMoney moneyStorage){
        moneyStorages.add(moneyStorage);
    }

    public boolean anySavedUsers(){
        return !savedUsers.isEmpty();
    }

    public List<UserData> getSavedUsers(){
        return savedUsers;
    }

    // it must be used not here, but in higher layer because here we have polymorphism (not see bank accounts)
    // higher layer = e.g. ConsoleApp, WindowApp during entering data to new bank account
    public void saveUser(UserData userData){
        savedUsers.add(userData);
    }
}
