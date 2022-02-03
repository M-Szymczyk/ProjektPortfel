package application.services.db;

import application.data.money.amount.AmountOfMoney;
import application.data.money.bank.BankAccount;
import application.data.user.UserData;

import java.util.List;

public class DataSeparator {
    public static List<AmountOfMoney> getAccounts(List<AmountOfMoney> amountOfMoneyList) {
        return amountOfMoneyList;
    }

    public static List<UserData> getUsers(List<AmountOfMoney> amountOfMoneyList) {
        return amountOfMoneyList.stream()
                .filter(BankAccount.class::isInstance)
                .map(BankAccount.class::cast)
                .map(BankAccount::getAccountHolder)
                .distinct()
                .toList();
    }
}
