package application.services;

import application.data.money.amount.AmountOfMoney;
import application.data.money.amount.AmountOfMoneyInterface;
import application.data.money.bank.BankAccount;
import application.data.user.UserData;
import application.services.db.DBController;
import application.services.db.DataSeparator;
import lombok.Getter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Engine {
    private final ArrayList<AmountOfMoney> moneyStorages = new ArrayList<>();
    private final ArrayList<UserData> savedUsers = new ArrayList<>();

    public void depositMoney(AmountOfMoneyInterface moneyStorage, BigDecimal money){
        moneyStorage.deposit(money);
    }

    public void withdrawMoney(AmountOfMoneyInterface moneyStorage, BigDecimal money){
        moneyStorage.withdraw(money);
    }

    /**
     * Method for transactions between bank accounts and wallets, that's why it is named interTransaction, because
     * simple transaction means in this project withdrawing or depositing money from/to wallets and bank accounts
     * @param source the money storage from which we are transferring money
     * @param money transfer amount
     * @param target the money storage to which we are transferring money
     */
    public void interTransaction(AmountOfMoneyInterface source, BigDecimal money, AmountOfMoneyInterface target){
        withdrawMoney(source, money);
        depositMoney(target, money);
    }

    public boolean anyMoneyStorages(){
        return !moneyStorages.isEmpty();
    }

    public void addMoneyStorage(AmountOfMoney moneyStorage){
        moneyStorages.add(moneyStorage);
    }

    public void deleteMoneyStorage(AmountOfMoney moneyStorage){
        moneyStorages.remove(moneyStorage);
    }

    public boolean anySavedUsers(){
        return !savedUsers.isEmpty();
    }

    public void addUser(UserData userData){
        savedUsers.add(userData);
    }

    public void deleteUser(UserData userData){
        savedUsers.remove(userData);
    }

    public boolean isUserAssignedToAnyBankAccount(UserData userData) {
        return moneyStorages.stream()
                .filter(BankAccount.class::isInstance)
                .map(BankAccount.class::cast)
                .anyMatch(bankAccount -> bankAccount.getAccountHolder().equals(userData));
    }

    public void dumpAll() {
        DBController.dumpDatabaseState(moneyStorages);
    }

    public void loadAll() throws IOException {
        List<AmountOfMoney> amountOfMoneyList = DBController.importDataBaseState();
        moneyStorages.addAll(DataSeparator.getAccounts(amountOfMoneyList));
        savedUsers.addAll(DataSeparator.getUsers(amountOfMoneyList));
    }

    public boolean preCheckDatabase() {
        return DBController.checkDataBaseExistence();
    }
}
