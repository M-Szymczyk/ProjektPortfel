package application.data.money.amount;

import application.services.EnterDataInterface;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
public abstract class AmountOfMoney implements AmountOfMoneyInterface, EnterDataInterface {
    @Setter(AccessLevel.PRIVATE)
    private BigDecimal money;
    protected String name;

    protected AmountOfMoney(String name) {
        this.name = name;
    }

    @Override
    public void deposit(BigDecimal toDeposit){
        setMoney(getMoney().add(toDeposit));
    }

    @Override
    public void withdraw(BigDecimal toWithdraw) {
        setMoney(getMoney().subtract(toWithdraw));
    }

    @Override
    public String toString() {
        return getName() + "\nMoney = " + money;
    }
}
