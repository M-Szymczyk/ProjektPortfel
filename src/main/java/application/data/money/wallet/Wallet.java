package application.data.money.wallet;

import application.data.money.amount.AmountOfMoney;
import lombok.experimental.SuperBuilder;

@SuperBuilder(setterPrefix = "with", toBuilder = true)
public class Wallet extends AmountOfMoney{
    @Override
    public String getName() {
        return "[WALLET] " + super.getName();
    }
}