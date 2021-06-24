package application.data.money.wallet;

import application.data.money.amount.AmountOfMoney;
import application.data.money.amount.AmountOfMoneyException;

import java.util.HashSet;

public class Wallet extends AmountOfMoney{
    private final static HashSet<String> namesDatabase = new HashSet<>();

    @Override
    public void setName(String name) throws AmountOfMoneyException {
        super.setName(name);
        if(!namesDatabase.add(name)) throw new WalletException("Portfel o podanej nazwie już istnieje!");
    }

    @Override
    public String getName() {
        return "[WALLET] " + this.name;
    }

    @Override
    public void delete() {
        namesDatabase.remove(name);
    }
}