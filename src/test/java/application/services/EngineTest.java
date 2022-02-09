package application.services;

import application.data.money.amount.AmountOfMoney;
import application.data.money.bank.BankAccount;
import application.data.money.wallet.Wallet;
import application.data.user.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

public class EngineTest {
    private Engine engine;
    private UserData userData;
    private BankAccount bankAccount;
    private Wallet wallet;

    @BeforeEach
    public void init() {
        engine = new Engine();
        userData = UserData.builder()
                .withName("name")
                .build();
        bankAccount = BankAccount.builder()
                .withAccountHolder(userData)
                .build();
        wallet = Wallet.builder()
                .build();
        engine.addUser(userData);
        engine.addMoneyStorage(bankAccount);
        engine.addMoneyStorage(wallet);
    }

    @Test
    public void depositMoney() {
        // given
        BigDecimal value = new BigDecimal("300");

        // when
        wallet.deposit(value);

        // then
        Assertions.assertEquals(value, engine.getMoneyStorages().get(1).getMoney());
    }

    @Test
    public void withdrawMoney() {
        // given
        BigDecimal value = new BigDecimal("300");

        // when
        bankAccount.withdraw(value);

        // then
        Assertions.assertEquals(new BigDecimal("-300"), engine.getMoneyStorages().get(0).getMoney());
    }

    @Test
    public void interTransaction() {
        // given
        BigDecimal value = new BigDecimal("300");

        // when
        engine.interTransaction(bankAccount, value, wallet);

        // then
        Assertions.assertEquals(new BigDecimal("-300"), engine.getMoneyStorages().get(0).getMoney());
        Assertions.assertEquals(value, engine.getMoneyStorages().get(1).getMoney());
    }

    @Test
    public void anyMoneyStorages() {
        // given

        // when
        boolean result = engine.anyMoneyStorages();

        // then
        Assertions.assertTrue(result);
    }

    @Test
    public void anyUser() {
        // given

        // when
        boolean result = engine.anySavedUsers();

        // then
        Assertions.assertTrue(result);
    }

    @Test
    public void addingAndDeletingMoneyStorages() {
        // given
        AmountOfMoney amountOfMoney = Mockito.mock(AmountOfMoney.class, Mockito.CALLS_REAL_METHODS);

        // when
        engine.deleteMoneyStorage(bankAccount);
        engine.addMoneyStorage(amountOfMoney);

        // then
        Assertions.assertEquals(2, engine.getMoneyStorages().size());
        Assertions.assertFalse(engine.getMoneyStorages().contains(bankAccount));
        Assertions.assertTrue(engine.getMoneyStorages().contains(wallet));
        Assertions.assertTrue(engine.getMoneyStorages().contains(amountOfMoney));
    }

    @Test
    public void addingAndDeletingUsers() {
        // given
        UserData userData1 = Mockito.mock(UserData.class, Mockito.CALLS_REAL_METHODS);

        // when
        engine.deleteUser(userData);
        engine.addUser(userData1);

        // then
        Assertions.assertEquals(1, engine.getSavedUsers().size());
        Assertions.assertFalse(engine.getSavedUsers().contains(userData));
        Assertions.assertTrue(engine.getSavedUsers().contains(userData1));
    }

    @Test
    public void checkAssignmentOfNotAssignedUser() {
        // given
        UserData userData1 = Mockito.mock(UserData.class, Mockito.CALLS_REAL_METHODS);

        // when
        boolean result = engine.isUserAssignedToAnyBankAccount(userData1);

        // then
        Assertions.assertFalse(result);
    }

    @Test
    public void checkAssignmentOfAssignedUser() {
        // given

        // when
        boolean result = engine.isUserAssignedToAnyBankAccount(userData);

        // then
        Assertions.assertTrue(result);
    }
}
