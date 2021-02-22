package application.services;
import java.math.BigDecimal;

class digit{
    int number;
    digit[] nextDigit;

    digit(int number){
        this.nextDigit = null;
        this.number = number;
    }
}

public class NumbersDataBase {
    private int numberOfDigits;         // okresla ile cyfr moze miec numer konta
    private digit sentinel = null;      // wartownik na tablice "wskaznikow"

    public NumbersDataBase(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
        this.sentinel = new digit(-1);
        this.sentinel.nextDigit = null;
    }

    public boolean check(BigDecimal bankAccountNumber) {
        if(this.sentinel == null) return false;
        if(this.sentinel.nextDigit == null) return false;

        int[] digitsToCheck = NumbersDataBase.bigDecimalToIntArray(bankAccountNumber, this.numberOfDigits);

        return NumbersDataBase.checkDigitsInAllLevels(this.sentinel, digitsToCheck, 0, this.numberOfDigits);
    }

    private static boolean checkDigitsInAllLevels(digit levelToCheck, int[] numbers, int level, int numberOfDigits) {
        if(level == numberOfDigits) return true;

        if(levelToCheck.nextDigit == null) return false;
        if(levelToCheck.nextDigit[numbers[level]] == null) return false;

        return NumbersDataBase.checkDigitsInAllLevels(levelToCheck.nextDigit[numbers[level]], numbers,level+1, numberOfDigits);
    }

    public void add(BigDecimal bankAccountNumber) {
        if(this.check(bankAccountNumber)) return;

        if(this.sentinel == null) this.sentinel = new digit(-1);
        if(this.sentinel.nextDigit == null) this.sentinel.nextDigit = new digit[10];

        int[] digitsToAdd = NumbersDataBase.bigDecimalToIntArray(bankAccountNumber, this.numberOfDigits);

        if(this.sentinel.nextDigit[digitsToAdd[0]] == null)
            this.sentinel.nextDigit[digitsToAdd[0]] = new digit(digitsToAdd[0]);

        NumbersDataBase.addDigitsToAnyLevel(this.sentinel.nextDigit[digitsToAdd[0]], digitsToAdd, 1, this.numberOfDigits);
    }

    private static void addDigitsToAnyLevel(digit levelToAdd, int[] numbers, int level, int numberOfDigits){
        levelToAdd.number = numbers[level-1];

        if(level == numberOfDigits) return;

        if(levelToAdd.nextDigit == null) levelToAdd.nextDigit = new digit[10];
        if(levelToAdd.nextDigit[numbers[level]] == null) levelToAdd.nextDigit[numbers[level]] = new digit(numbers[level]);

        NumbersDataBase.addDigitsToAnyLevel(levelToAdd.nextDigit[numbers[level]], numbers, level+1, numberOfDigits);
    }

    public void delete(BigDecimal bankAccountNumber){
        if(!this.check(bankAccountNumber)) return;

        int[] digitsToDelete = NumbersDataBase.bigDecimalToIntArray(bankAccountNumber, this.numberOfDigits);

        NumbersDataBase.deleteDigitsFromAnyLevel(this.sentinel, digitsToDelete, 0, this.numberOfDigits);
    }

    private static boolean deleteDigitsFromAnyLevel(digit leveltoDelete, int[] numbers, int level, int numberOfDigits){
        boolean canDelete = true;

        if(level < numberOfDigits - 1)
            canDelete = NumbersDataBase.deleteDigitsFromAnyLevel(leveltoDelete.nextDigit[numbers[level]], numbers, level+1, numberOfDigits);

        if(canDelete){
            leveltoDelete.nextDigit[numbers[level]] = null;
            canDelete = NumbersDataBase.countNumberOfDeclaredDigitsInLevel(leveltoDelete) == 0;
        }

        return canDelete;
    }

    private static int countNumberOfDeclaredDigitsInLevel(digit levelToDelete){
        int counter = 0;
        for(int i=0; i<10; i++)
            if(levelToDelete.nextDigit[i] != null) counter++;
        return counter;
    }

    private static int[] bigDecimalToIntArray (BigDecimal numberToConvert, int numberOfDigits){
        int[] digits = new int[numberOfDigits];
        BigDecimal numberToCheck = new BigDecimal(numberToConvert.toString());

        for(int i = numberOfDigits - 1; i >= 0; i--){
            digits[i] = numberToCheck.remainder(new BigDecimal(10)).intValue();
            numberToCheck = numberToCheck.divide(new BigDecimal(10));
        }

        return digits;
    }
}
