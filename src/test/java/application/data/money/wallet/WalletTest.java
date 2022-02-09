package application.data.money.wallet;

import application.data.user.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

public class WalletTest {
    private final String name = "Wallet1";

    @Test
    public void getName() {
        // given
        Wallet wallet = Wallet.builder()
                .withName(name)
                .build();

        // when

        // then
        Assertions.assertEquals(wallet.getName(), name);
    }

    @Test
    public void getPrintableName() {
        // given
        Wallet wallet = Wallet.builder()
                .withName(name)
                .build();

        // when

        // then
        Assertions.assertEquals(wallet.printableName(), "[WALLET] " + name);
    }

    @Test
    public void buildEmptyWallet() {
        // given
        Wallet wallet = Wallet.builder().build();

        // when

        // then
        Assertions.assertNull(wallet.getName());
        Assertions.assertEquals(new BigDecimal("0"), wallet.getMoney());
        Assertions.assertEquals("[WALLET] null", wallet.printableName());
    }

    @Test
    public void buildWalletWithFilledData() {
        // given
        UserData userData = Mockito.mock(UserData.class, Mockito.CALLS_REAL_METHODS);
        BigDecimal money = new BigDecimal("100");
        Wallet wallet = Wallet.builder()
                .withName(name)
                .withMoney(money)
                .build();

        // when

        // then
        Assertions.assertEquals(name, wallet.getName());
        Assertions.assertEquals(money, wallet.getMoney());
        Assertions.assertEquals("[WALLET] " + name, wallet.printableName());
    }
}
