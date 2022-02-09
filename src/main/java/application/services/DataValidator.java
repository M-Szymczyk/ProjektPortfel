package application.services;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Optional;

public class DataValidator {
    public static String check(String sequence){
        return Optional.ofNullable(sequence)
                .filter(StringUtils::isNotBlank)
                .orElseThrow(DataValidator::stringException);
    }

    public static BigDecimal check(BigDecimal number){
        return Optional.ofNullable(number)
                .filter(DataValidator::bigDecimalPositiveFilter)
                .orElseThrow(DataValidator::bigDecimalException);
    }

    private static boolean bigDecimalPositiveFilter(BigDecimal number){
        return number.compareTo(BigDecimal.ZERO) >= 0;
    }

    private static IllegalArgumentException stringException(){
        return new IllegalArgumentException("String cannot be null, empty or contains blank spaces.");
    }

    private static IllegalArgumentException bigDecimalException(){
        return new IllegalArgumentException("Number cannot be negative.");
    }
}
