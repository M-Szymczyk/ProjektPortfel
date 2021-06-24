package application;

import application.data.money.bank.BankAccount;
import application.data.money.wallet.Wallet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MoneyManagerWindowAPP extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new MoneyManagerWindowAPP();
    }
    // tworzymy tablice-liste kont bankowych gdzie bedziemy przechowywac data kont i portfeli
    ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    ArrayList<Wallet> wallets=new ArrayList<>();

    //tworze przyciski odpowiadajace wyborom z menu
    JButton transactionButton =new JButton("Dodaj transakcje");
    JButton bankAccountCreatingButton= new JButton("Stworz nowe konto");
    JButton walletCreatingButton=new JButton("Stworz nowy portfel");
    JButton displayAccountBalanceButton=new JButton("Wyswietl stan konta");
    JButton displayWalletBalanceButton=new JButton("Wyswietl stan portfela");
    JButton closeButton=new JButton("Koniec programu");

    MoneyManagerWindowAPP(){
        setTitle("MoneyManager");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000,1000);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}



