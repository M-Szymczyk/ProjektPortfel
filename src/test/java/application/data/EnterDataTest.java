package application.data;

import application.services.EnterDataInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class EnterDataTest {
    @Test
    public void enterIntTest(){
        // given
        ByteArrayInputStream number = new ByteArrayInputStream("20".getBytes());
        ByteArrayInputStream word = new ByteArrayInputStream("word".getBytes());

        // when
        System.setIn(number);
        int result = EnterDataInterface.enterInt();
        System.setIn(word);

        // then
        Assertions.assertEquals(result, 20);
        Assertions.assertThrows(NoSuchElementException.class, EnterDataInterface::enterInt);
    }

    @Test
    public void enterBigDecimalTest(){
        // given
        ByteArrayInputStream number = new ByteArrayInputStream("123456789987654321e-9".getBytes());
        ByteArrayInputStream word = new ByteArrayInputStream("word".getBytes());

        // when
        System.setIn(number);
        BigDecimal result = EnterDataInterface.enterBigDecimal();
        System.setIn(word);

        // then
        Assertions.assertEquals(result, new BigDecimal("123456789.987654321"));
        Assertions.assertThrows(NoSuchElementException.class, EnterDataInterface::enterBigDecimal);
    }
}
