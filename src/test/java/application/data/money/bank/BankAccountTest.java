package application.data.money.bank;

import application.data.user.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

public class BankAccountTest {
    private final String name = "BankAccount1";

    @Test
    public void getName() {
        // given
        BankAccount bankAccount = BankAccount.builder()
                .withName(name)
                .build();

        // when

        // then
        Assertions.assertEquals(bankAccount.getName(), name);
    }

    @Test
    public void getPrintableName() {
        // given
        BankAccount bankAccount = BankAccount.builder()
                .withName(name)
                .build();

        // when

        // then
        Assertions.assertEquals(bankAccount.printableName(), "[ACCOUNT] " + name);
    }

    @Test
    public void buildEmptyBankAccount() {
        // given
        BankAccount bankAccount = BankAccount.builder().build();

        // when

        // then
        Assertions.assertNull(bankAccount.getName());
        Assertions.assertNull(bankAccount.getNumberBankAccount());
        Assertions.assertNull(bankAccount.getAccountHolder());
        Assertions.assertEquals(new BigDecimal("0"), bankAccount.getMoney());
        Assertions.assertEquals("[ACCOUNT] null", bankAccount.printableName());
    }

    @Test
    public void buildBankAccountWithFilledData() {
        // given
        UserData userData = Mockito.mock(UserData.class, Mockito.CALLS_REAL_METHODS);
        BigDecimal number = new BigDecimal("123");
        BigDecimal money = new BigDecimal("100");
        BankAccount bankAccount = BankAccount.builder()
                .withName(name)
                .withMoney(money)
                .withAccountHolder(userData)
                .withNumberBankAccount(number)
                .build();

        // when

        // then
        Assertions.assertEquals(name, bankAccount.getName());
        Assertions.assertEquals(number, bankAccount.getNumberBankAccount());
        Assertions.assertEquals(userData, bankAccount.getAccountHolder());
        Assertions.assertEquals(money, bankAccount.getMoney());
        Assertions.assertEquals("[ACCOUNT] " + name, bankAccount.printableName());
    }
}
