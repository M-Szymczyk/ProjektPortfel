package application.data;

import application.data.money.wallet.Wallet;
import application.data.money.wallet.WalletException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WalletTest {
    @Test
    public void setNameTest(){
        // given
        Wallet wallet = new Wallet();
        String name1 = "PLN";
        String name2 = "EUR";
        String name3 = "PLN";

        // when

        // then
        Assertions.assertDoesNotThrow(() -> wallet.setName(name1));
        Assertions.assertDoesNotThrow(() -> wallet.setName(name2));
        Assertions.assertThrows(WalletException.class, () -> wallet.setName(name3));
    }
}
