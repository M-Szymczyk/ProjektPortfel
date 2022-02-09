package application.services.db;

import application.data.money.amount.AmountOfMoney;
import application.data.money.bank.BankAccount;
import application.data.money.wallet.Wallet;
import application.data.user.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class DataSeparatorTest {
    private List<AmountOfMoney> amountOfMoneyList;

    @BeforeEach
    public void init() {
        amountOfMoneyList = new ArrayList<>();
    }

    @Test
    public void getAccountsFromNullList() {
        // given

        // when
        List<AmountOfMoney> results = DataSeparator.getAccounts(null);

        // then
        Assertions.assertNull(results);
    }

    @Test
    public void getAccountsFromEmptyList() {
        // given

        // when
        List<AmountOfMoney> results = DataSeparator.getAccounts(amountOfMoneyList);

        // then
        Assertions.assertEquals(0, results.size());
    }

    @Test
    public void getAccountsFromFilledList() {
        // given
        AmountOfMoney amountOfMoney1 = Mockito.mock(AmountOfMoney.class, Mockito.CALLS_REAL_METHODS);
        AmountOfMoney amountOfMoney2 = Mockito.mock(AmountOfMoney.class, Mockito.CALLS_REAL_METHODS);
        amountOfMoneyList.add(amountOfMoney1);
        amountOfMoneyList.add(amountOfMoney2);

        // when
        List<AmountOfMoney> results = DataSeparator.getAccounts(amountOfMoneyList);

        // then
        Assertions.assertEquals(2, results.size());
        Assertions.assertEquals(amountOfMoney1, results.get(0));
        Assertions.assertEquals(amountOfMoney2, results.get(1));
    }

    @Test
    public void getUsersFromNullAccountsList() {
        // given

        // when
        List<UserData> results = DataSeparator.getUsers(null);

        // then
        Assertions.assertEquals(0, results.size());
    }

    @Test
    public void getUsersFromEmptyAccountsList() {
        // given

        // when
        List<UserData> results = DataSeparator.getUsers(amountOfMoneyList);

        // then
        Assertions.assertEquals(0, results.size());
    }

    @Test
    public void getUsersFromFilledAccountsListWithoutUsers() {
        // given
        AmountOfMoney amountOfMoney1 = Mockito.mock(AmountOfMoney.class, Mockito.CALLS_REAL_METHODS);
        AmountOfMoney amountOfMoney2 = Mockito.mock(AmountOfMoney.class, Mockito.CALLS_REAL_METHODS);
        amountOfMoneyList.add(amountOfMoney1);
        amountOfMoneyList.add(amountOfMoney2);

        // when
        List<UserData> results = DataSeparator.getUsers(amountOfMoneyList);

        // then
        Assertions.assertEquals(0, results.size());
    }

    @Test
    public void getUsersFromFilledAccountsListWithUsers() {
        // given
        UserData userData = Mockito.mock(UserData.class, Mockito.CALLS_REAL_METHODS);
        BankAccount bankAccount = Mockito.mock(BankAccount.class, Mockito.CALLS_REAL_METHODS);
        Wallet wallet = Mockito.mock(Wallet.class, Mockito.CALLS_REAL_METHODS);
        amountOfMoneyList.add(bankAccount);
        amountOfMoneyList.add(wallet);

        // when
        Mockito.when(bankAccount.getAccountHolder()).thenReturn(userData);
        List<UserData> results = DataSeparator.getUsers(amountOfMoneyList);

        // then
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(userData, results.get(0));
    }
}
