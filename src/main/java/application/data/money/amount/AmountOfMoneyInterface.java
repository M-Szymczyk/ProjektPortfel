package application.data.money.amount;

import java.math.BigDecimal;

public interface AmountOfMoneyInterface {
    /**
     * Method to deposit money
     * @param valueToDeposit how much money to deposit
     */
    void deposit(BigDecimal valueToDeposit);

    /**
     * Method to withdraw money
     * @param toWithdraw how much money to withdraw
     */
    void withdraw(BigDecimal toWithdraw);

    /**
     * Method to show actual amount of money
     * @return money in BigDecimal
     */
    BigDecimal getMoney();
}
