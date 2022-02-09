package application.data.money.amount;

import application.data.money.wallet.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AmountOfMoneyTest {
    private AmountOfMoney amountOfMoney;

    @BeforeEach
    public void init() {
        amountOfMoney = Wallet.builder().build();
    }

    @Test
    public void depositMoney() {
        // given

        // when
        amountOfMoney.deposit(new BigDecimal("100"));

        // then
        Assertions.assertEquals(amountOfMoney.getMoney(), new BigDecimal("100"));
    }

    @Test
    public void withdrawMoney() {
        // given

        // when
        amountOfMoney.withdraw(new BigDecimal("100"));

        // then
        Assertions.assertEquals(amountOfMoney.getMoney(), new BigDecimal("-100"));
    }
}
