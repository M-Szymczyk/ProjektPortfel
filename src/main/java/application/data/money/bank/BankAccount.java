package application.data.money.bank;

import application.data.money.amount.AmountOfMoney;
import application.data.user.UserData;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class BankAccount extends AmountOfMoney{
    private final BigDecimal numberBankAccount;
    private final UserData accountHolder;

    @Builder(setterPrefix = "with", toBuilder = true)
    private BankAccount(String name, BigDecimal numberBankAccount, UserData accountHolder) {
        super(name);
        this.numberBankAccount = numberBankAccount;
        this.accountHolder = accountHolder;
    }

    @Override
    public String getName() {
        return "[ACCOUNT] " + super.getName();
    }

    @Override
    public String toString() {
        return super.toString() + "\nNumber: " + numberBankAccount.toString() +
                "\nUserdata: " + accountHolder;
    }
}
