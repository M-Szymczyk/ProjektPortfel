package application.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DataValidatorTest {
    @Test
    public void checkNullString() {
        // given

        // when

        // then
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> DataValidator.check((String) null));
    }

    @Test
    public void checkEmptyString() {
        // given
        String input = "";

        // when

        // then
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> DataValidator.check(input));
    }

    @Test
    public void checkBlankSpaceString() {
        // given
        String input = " ";

        // when

        // then
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> DataValidator.check(input));
    }

    @Test
    public void checkNormalString() {
        // given
        String input = "normalString";

        // when
        String result = DataValidator.check(input);

        // then
        Assertions.assertEquals(input, result);
    }

    @Test
    public void checkNullBigDecimal() {
        // given

        // when

        // then
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> DataValidator.check((BigDecimal) null));
    }

    @Test
    public void checkNegativeBigDecimal() {
        // given
        BigDecimal input = new BigDecimal("-100");

        // when

        // then
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> DataValidator.check(input));
    }

    @Test
    public void checkNormalBigDecimal() {
        // given
        BigDecimal input = new BigDecimal("100");

        // when
        BigDecimal result = DataValidator.check(input);

        // then
        Assertions.assertEquals(input, result);
    }
}
