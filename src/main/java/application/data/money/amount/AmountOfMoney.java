package application.data.money.amount;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@SuperBuilder(setterPrefix = "with", toBuilder = true)
public abstract class AmountOfMoney implements AmountOfMoneyInterface {
    @Builder.Default
    private BigDecimal money = new BigDecimal(0);
    private String name;

    @Override
    public void deposit(BigDecimal toDeposit){
        this.money = getMoney().add(toDeposit);
    }

    @Override
    public void withdraw(BigDecimal toWithdraw) {
        this.money = getMoney().subtract(toWithdraw);
    }

    @Override
    public String toString() {
        return getName() + "\nMoney = " + money;
    }
}
