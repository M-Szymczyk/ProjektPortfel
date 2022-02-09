package application.data.money.bank;

import application.data.money.amount.AmountOfMoney;
import application.data.user.UserData;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Getter
@Jacksonized
@SuperBuilder(setterPrefix = "with", toBuilder = true)
public class BankAccount extends AmountOfMoney{
    private final BigDecimal numberBankAccount;
    private final UserData accountHolder;

    @Override
    public String printableName() {
        return "[ACCOUNT] " + super.getName();
    }

    @Override
    public String toString() {
        return super.toString() + "\nNumber: " + numberBankAccount.toString() +
                "\nUserdata: " + accountHolder;
    }
}
