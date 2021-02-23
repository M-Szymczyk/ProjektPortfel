package application.data.money.wallet;

import application.data.money.amount.AmountOfMoney;

public class Wallet extends AmountOfMoney{
    @Override
    public String getName() {
        return "[WALLET] " + this.name;
    }
}