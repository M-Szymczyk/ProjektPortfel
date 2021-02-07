package application.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AmountOfMoneyTest {
    @Test
    public void setNameTest(){
        try{
            // given
            AmountOfMoney amountOfMoney = new BankAccount();

            // when
            Method method = AmountOfMoney.class.getDeclaredMethod("setName", String.class);
            method.setAccessible(true);

            // then
            Assertions.assertThrows(Exception.class, () -> method.invoke(amountOfMoney));
            Assertions.assertThrows(Exception.class, () -> method.invoke(amountOfMoney, ""));
            Assertions.assertDoesNotThrow(() -> method.invoke(amountOfMoney, "Portfel"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void transactionTest(){
        try{
            // given
            AmountOfMoney amountOfMoney = new BankAccount();
            ByteArrayInputStream number1 = new ByteArrayInputStream("-1".getBytes());
            ByteArrayInputStream number2 = new ByteArrayInputStream("20".getBytes());

            // when
            Method payMethod = AmountOfMoney.class.getDeclaredMethod("pay");
            payMethod.setAccessible(true);
            Method withdrawMethod = AmountOfMoney.class.getDeclaredMethod("withdraw");
            payMethod.setAccessible(true);
            System.setIn(number1);
            boolean payResult1 = (boolean) payMethod.invoke(amountOfMoney);
            boolean withdrawResult1 = (boolean) withdrawMethod.invoke(amountOfMoney);
            System.setIn(number2);
            boolean payResult2 = (boolean) payMethod.invoke(amountOfMoney);
            boolean withdrawResult2 = (boolean) withdrawMethod.invoke(amountOfMoney);

            // then
            Assertions.assertFalse(payResult1);
            Assertions.assertFalse(withdrawResult1);
            Assertions.assertTrue(payResult2);
            Assertions.assertTrue(withdrawResult2);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
