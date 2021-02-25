package application.data.money.bank;

import application.data.money.amount.AmountOfMoneyException;

public class BankAccountException extends AmountOfMoneyException {
    BankAccountException(String message) {
        super(message);
    }
}
