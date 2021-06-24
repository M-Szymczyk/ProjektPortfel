package application.data.money.wallet;

import application.data.money.amount.AmountOfMoneyException;

public class WalletException extends AmountOfMoneyException {
    WalletException(String message) {
        super(message);
    }
}
