package application.data.money.amount;

import java.math.BigDecimal;

public interface AmountOfMoneyInterface {
    /**
     * Method to deposit money
     * @param valueToDeposit how much money to deposit
     * @throws AmountOfMoneyException if money was less than 0
     */
    void deposit(BigDecimal valueToDeposit) throws AmountOfMoneyException;

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

    /**
     * Method to list accounts' and wallets' names
     * @return name of object
     */
    String getName();

}
