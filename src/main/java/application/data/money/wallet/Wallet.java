package application.data.money.wallet;

import application.data.money.amount.AmountOfMoney;

public class Wallet extends AmountOfMoney implements WalletInterface {
    public void enterDataWallet() {
        super.enterMoney();
    }

    @Override
    public String toString() {
        return "Stan portfela \"" + getName() + "\" wynosi: "+super.toString();
    }
}