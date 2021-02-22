package application.data.money.amount;

import application.services.EnterDataInterface;

import java.math.BigDecimal;
import java.util.Scanner;

public abstract class AmountOfMoney implements AmountOfMoneyInterface, EnterDataInterface {
    private BigDecimal money;
    private String name;

    public AmountOfMoney() {
        this.money = null;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) throws AmountOfMoneyException {
        if (name == null || name.equals("")) {
            throw new AmountOfMoneyException("Musisz podac nazwe zlozona ze znakow!");
        } else
            this.name = name;
    }

    public BigDecimal getMoney() {
        return this.money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * Method to deposit money
     * @param depositMoney how much money to deposit
     * @throws AmountOfMoneyException if money was less than 0
     */
    public void depositMoney(BigDecimal depositMoney) throws AmountOfMoneyException {
        if (depositMoney.compareTo(new BigDecimal(0)) <= 0)
            throw new AmountOfMoneyException("Nie mozna wplacic zero lub mniej niz zero gotowki!");
        else
            setMoney(getMoney().add(depositMoney));
    }

    /**
     * Method to withdraw money
     * @param toWithdraw how much money to withdraw
     */
    public void withdraw(BigDecimal toWithdraw) {
        if (toWithdraw.compareTo(new BigDecimal(0)) <= 0)
            throw new IllegalArgumentException("Nie mozna wyplacic zero lub mniej niz zero gotowki!");
        this.money = this.money.subtract(toWithdraw);
    }

    public void enterMoney() {
        Scanner scaner = new Scanner(System.in);
        boolean toContinue;
        do {
            try {
                System.out.println("Podaj nazwe obiektu:");
                setName(scaner.nextLine());
                toContinue = false;
            } catch (AmountOfMoneyException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        } while (toContinue);
        System.out.println("Podaj ilosc pieniedzy: ");
        setMoney(EnterDataInterface.enterBigDecimal());
    }

    @Override
    public String toString() {
        return this.getMoney().toString();
    }
}