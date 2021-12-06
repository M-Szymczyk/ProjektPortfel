package application.data.money.wallet;

import application.data.money.amount.AmountOfMoney;
import lombok.Builder;

public class Wallet extends AmountOfMoney{
    @Builder(setterPrefix = "with", toBuilder = true)
    public Wallet(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return "[WALLET] " + super.getName();
    }
}