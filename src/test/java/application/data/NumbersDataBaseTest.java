package application.data;

import application.services.NumbersDataBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NumbersDataBaseTest {
    /**
     * unit testing this structure means testing 'check' method which is
     * very hard to test without calling 'add' or 'delete' method (because
     * fields are private), giving access to any private field means you
     * have to give access to any occurrence of this field in denary tree...
     * impossible? nope, ofc possible. but the final result of testing it
     * in this way is not worth all this effort. in my opinion, 'main' way
     * (not unit) to test it should be quite sufficient here ;)
      */

    @Test
    public void mainTest(){
        // given
        NumbersDataBase dataBase = new NumbersDataBase(26);
        BigDecimal number1 = new BigDecimal("12345678912345678912345678");
        BigDecimal number2 = new BigDecimal("87654321987654321987654321");
        BigDecimal number3 = new BigDecimal("12345678912345678912345678");
        BigDecimal number4 = new BigDecimal("12345678955555555555555555");
        BigDecimal number5 = new BigDecimal("12345");  // to check only

        // when
        dataBase.add(number1);
        boolean check1 = dataBase.check(number1);
        boolean check2 = dataBase.check(number2);
        boolean check3 = dataBase.check(number3);
        boolean check4 = dataBase.check(number4);
        boolean check5 = dataBase.check(number5);

        dataBase.add(number2);
        boolean check6 = dataBase.check(number1);
        boolean check7 = dataBase.check(number2);
        boolean check8 = dataBase.check(number3);
        boolean check9 = dataBase.check(number4);
        boolean check10 = dataBase.check(number5);

        dataBase.delete(number1);
        boolean check11 = dataBase.check(number1);
        boolean check12 = dataBase.check(number2);
        boolean check13 = dataBase.check(number3);
        boolean check14 = dataBase.check(number4);
        boolean check15 = dataBase.check(number5);

        dataBase.delete(number2);
        boolean check16 = dataBase.check(number1);
        boolean check17 = dataBase.check(number2);
        boolean check18 = dataBase.check(number3);
        boolean check19 = dataBase.check(number4);
        boolean check20 = dataBase.check(number5);

        // then
        Assertions.assertTrue(check1);
        Assertions.assertFalse(check2);
        Assertions.assertTrue(check3);
        Assertions.assertFalse(check4);
        Assertions.assertFalse(check5);
        Assertions.assertTrue(check6);
        Assertions.assertTrue(check7);
        Assertions.assertTrue(check8);
        Assertions.assertFalse(check9);
        Assertions.assertFalse(check10);
        Assertions.assertFalse(check11);
        Assertions.assertTrue(check12);
        Assertions.assertFalse(check13);
        Assertions.assertFalse(check14);
        Assertions.assertFalse(check15);
        Assertions.assertFalse(check16);
        Assertions.assertFalse(check17);
        Assertions.assertFalse(check18);
        Assertions.assertFalse(check19);
        Assertions.assertFalse(check20);
    }
}
