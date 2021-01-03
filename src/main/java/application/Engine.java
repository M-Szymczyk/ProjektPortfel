package application;

import application.data.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Engine implements EnterDataInterface {
    private static final String MENU =
            "\nMENU" +
                    "\n1.Dodaj transakcje" +
                    "\n2.Tworzenie nowego konta" +
                    "\n3.Tworzenie nowego portfela" +
                    "\n4.Wyswietlenie stanu konta" +
                    "\n5.Wyswietlenie stanu portfela" +
                    "\n6.Koniec programu" +
                    "\nWybierz opcje: ";

    public static void main(String[] args) {
        new Engine().work();
    }

    private void work() {
        ArrayList<AmountOfMoney> bankAccounts = new ArrayList<>();
        ArrayList<AmountOfMoney> wallets = new ArrayList<>();

        /** =================== PRZYWITANIE ======================== */

        System.out.println("Witaj w programie \"MoneyManager\" !");
        System.out.println("Kobieta jak kobieta, twór ma różne rządze, zerknij tutaj bo może podpierdala Ci pieniądze...");

        /** ===================== PROGRAM ========================== */

        boolean toContinue = true;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println(MENU);
            switch (EnterDataInterface.enterInt()) {
                case 1:
                    /** ------------------ Dodawanie transakcji ------------------ */

                    System.out.println("Transakcja w portfelu,czy na koncie?[P/K]");
                    String userAnswer=scan.nextLine().toUpperCase();
                    if (userAnswer.equals("K")) {
                        if (bankAccounts.size() == 0) {
                            System.out.println("Nie masz zadnych kont!");
                        } else {
                            list(bankAccounts);
                            System.out.println("W ktorym koncie dodajemy transkacje: ");
                            bankAccounts.get(EnterDataInterface.enterInt() - 1).transaction();
                        }
                    } else if (userAnswer.equals("P")) {
                        if (wallets.size() == 0) {
                            System.out.println("Nie masz zadnych portfeli!");
                        } else {
                            list(wallets);
                            System.out.println("W ktorym portfelu dodajemy transkacje: ");
                            wallets.get(EnterDataInterface.enterInt() - 1).transaction();
                        }
                    } else {
                        System.out.println("Nie ma takiej opcji!");
                    }

                    break;
                case 2:
                    /** ------------------ Tworzenie nowego konta ------------------ */

                    BankAccount creatingBankAccount=new BankAccount(); // tworze nowe konto
                    creatingBankAccount.enterDataBankAccount();        // wczytuje je
                    bankAccounts.add(creatingBankAccount);             // no i wrzucam do arraylist
                    break;                                             // mozna dac w dwie linijki ale tak jest czytelniej
                case 3:
                    /** ---------------- Tworzenie nowego portfela ----------------- */

                    Wallet creatingWalet=new Wallet();                 // tworze nowy portfel
                    creatingWalet.enterDataWallet();                   // wczytuje go
                    wallets.add(creatingWalet);                        // no i wrzucam do arraylist
                    break;                                             // analogicznie mozna dac w dwie linijki ale po co
                case 4:
                    /** ----------------- Wyświetlenie stanu konta ----------------- */

                    if (bankAccounts.size() == 0)
                        System.out.println("Nie dodano zadnych kont!");
                    else {
                        list(bankAccounts);
                        System.out.println("Ktore konto wyswietlic: ");
                        AmountOfMoney chosenAccount = bankAccounts.get(EnterDataInterface.enterInt() - 1);
                        System.out.println(chosenAccount.toString());

                        // if you have any better idea than casting, you can improve it
                        // P.S. the problem is, when you implement it in BankAccount class,
                        // you will receive account holder question before printing it on console
                        BankAccount chosenBankAccount = (BankAccount) chosenAccount;
                        if(!chosenBankAccount.hasAccountHolder())
                            chosenBankAccount.setAccountHolder();
                    }
                    break;
                case 5:
                    /** --------------- Wyświetlenie stanu portfela ---------------- */

                    if (wallets.size() == 0)
                        System.out.println("Nie dodano zadnych portfeli!");
                    else {
                        list(wallets);
                        System.out.println("Ktore konto wyswietlic: ");
                        System.out.println(wallets.get(EnterDataInterface.enterInt() - 1).toString());
                    }
                    break;
                case 6:
                    /** -------------- Zakończenie działania programu -------------- */

                    toContinue = false;
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
                    break;
            }
        } while (toContinue);
        System.out.println("Koniec");
    }

    /**
     * metoda list listuje elementy arraylisty
     *
     * @param obj listowana arraylista
     */

    private void list(ArrayList<AmountOfMoney> obj) {
        if (obj.size() == 0) {
            System.out.println("Nie masz zadnych kont!");
        } else
            for (int i = 0; i < obj.size(); i++) {
                AmountOfMoney accounts = obj.get(i);
                System.out.println(i + 1 + "." + accounts.getName());
            }
    }
}
