package application.data.money.wallet;

import application.data.money.amount.AmountOfMoney;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@SuperBuilder(setterPrefix = "with", toBuilder = true)
public class Wallet extends AmountOfMoney{
    @Override
    public String printableName() {
        return "[WALLET] " + super.getName();
    }
}