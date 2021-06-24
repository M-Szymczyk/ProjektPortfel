package application.data;

import application.data.money.bank.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;

public class BankAccountTest {
    private BankAccount bankAccount1;

    @Test
    public void setNumberBankAccountTest(){
        try{
            // given
            bankAccount1 = new BankAccount();

            // when
            Method method = BankAccount.class.getDeclaredMethod("setNumberBankAccount", BigDecimal.class);
            method.setAccessible(true);

            // then
            Assertions.assertThrows(Exception.class, () -> method.invoke(bankAccount1, new BigDecimal("-12345678912345678912345678")));
            Assertions.assertThrows(Exception.class, () -> method.invoke(bankAccount1, new BigDecimal("123456789123456789123456789")));
            Assertions.assertDoesNotThrow(() -> method.invoke(bankAccount1, new BigDecimal("12345678912345678912345678")));
            Assertions.assertThrows(Exception.class, () -> method.invoke(bankAccount1, new BigDecimal("12345678912345678912345678")));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
