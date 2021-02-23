package application.data.money.amount;

import application.services.EnterDataInterface;

import java.math.BigDecimal;

public abstract class AmountOfMoney implements AmountOfMoneyInterface, EnterDataInterface {
    protected BigDecimal money;
    protected String name;

    public AmountOfMoney() {
        this.money = null;
    }

    private void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setName(String name) throws AmountOfMoneyException {
        if (name == null || name.equals(""))
            throw new AmountOfMoneyException("Musisz podac nazwe zlozona ze znakow!");
        else
            this.name = name;
    }

    @Override
    public void deposit(BigDecimal toDeposit) throws AmountOfMoneyException {
        if (toDeposit.compareTo(new BigDecimal(0)) <= 0)
            throw new AmountOfMoneyException("Nie mozna wplacic zero lub mniej niz zero gotowki!");
        else
            setMoney(getMoney().add(toDeposit));
    }

    @Override
    public void withdraw(BigDecimal toWithdraw) {
        if (toWithdraw.compareTo(new BigDecimal(0)) <= 0)
            throw new IllegalArgumentException("Nie mozna wyplacic zero lub mniej niz zero gotowki!");
        else
            setMoney(getMoney().subtract(toWithdraw));
    }

    @Override
    public BigDecimal getMoney(){
        return this.money;
    }

    @Override
    public abstract String getName();

    @Override
    public String toString() {
        return getName() + "\nMoney = " + money;
    }
}
