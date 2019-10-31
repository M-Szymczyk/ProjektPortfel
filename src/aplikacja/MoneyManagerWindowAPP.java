package aplikacja;

import aplikacja.dane.KontoBankowe;
import aplikacja.dane.Portfel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MoneyManagerWindowAPP extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new MoneyManagerWindowAPP();
    }
    // tworzymy tablice-liste kont bankowych gdzie bedziemy przechowywac dane kont i portfeli
    ArrayList<KontoBankowe> konta_bankowe = new ArrayList<>();
    ArrayList<Portfel>portfele=new ArrayList<>();

    //tworze przyciski odpowiadajace wyborom z menu
    JButton transakjcaButton =new JButton("Dodaj transakcje");
    JButton noweKontoButton= new JButton("Stworz nowe konto");
    JButton nowyPortfelButton=new JButton("Stworz nowy portfel");
    JButton wyswietlStanKontaButton=new JButton("Wyswietl stan konta");
    JButton wyswietlStanPortfelaButton=new JButton("Wyswietl stan portfela");
    JButton koniecButton=new JButton("Koniec programu");

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



