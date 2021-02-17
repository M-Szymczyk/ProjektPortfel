package application;

import application.data.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


public class MoneyManagerConsoleAPP {
    private final Engine engine = new Engine();
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
        new MoneyManagerConsoleAPP().work();
    }

    void work() {
        /* =================== PRZYWITANIE ======================== */

        System.out.println("Witaj w programie \"MoneyManager\" !");
        System.out.println("Kobieta jak kobieta, twór ma różne rządze, zerknij tutaj bo może podpierdala Ci pieniądze...");

        /* ===================== PROGRAM ========================== */

        System.out.println(MENU);
        boolean toContinue = true;
        Scanner scan = new Scanner(System.in);

        do {
            switch (EnterDataInterface.enterInt()) {
                case 1:
                    /* ------------------ Dodawanie transakcji ------------------ */
                    if (engine.thereAreAnyBanksAccounts() && engine.thereAreAnyWallets()) {
                        //transakcja jezeli sa portfele i konta
                        System.out.println("Transakcja w portfelu,czy na koncie?[P/K]");
                        String userAnswer = scan.nextLine().toUpperCase();
                        if (userAnswer.equals("K")) {
                            list(engine.getBankAccounts());
                            System.out.println("W ktorym koncie dodajemy transkacje: ");
                            pay("b", EnterDataInterface.enterInt() - 1);
                        } else if (userAnswer.equals("P")) {
                            list(engine.getWallets());
                            System.out.println("W ktorym portfelu dodajemy transkacje: ");
                            pay("w", EnterDataInterface.enterInt() - 1);
                        } else {
                            System.out.println("Nie ma takiej opcji!");
                        }
                    } else if (engine.thereAreAnyBanksAccounts()) {
                        //transakcja jezeli sa tylko konta
                        list(engine.getBankAccounts());
                        System.out.println("W ktorym koncie dodajemy transkacje: ");
                        pay("b", EnterDataInterface.enterInt() - 1);
                    } else if (engine.thereAreAnyWallets()) {
                        //transakcja jezeli sa tylko portfele
                        list(engine.getWallets());
                        System.out.println("W ktorym portfelu dodajemy transkacje: ");
                        pay("w", EnterDataInterface.enterInt() - 1);
                    } else {
                        //informacja o braku portfeli i kont
                        System.out.println("Nie masz zadnych portfeli!");
                        System.out.println("Nie masz zadnych kont!");
                        System.out.println("Musisz najpierw dodac konto lub portfel");
                    }

                    break;
                case 2:
                    /* ------------------ Tworzenie nowego konta ------------------ */

                    BankAccount creatingBankAccount = new BankAccount(); // tworze nowe konto
                    creatingBankAccount.enterDataBankAccount();        // wczytuje je
                    engine.addBankAccount(creatingBankAccount);             // no i wrzucam do arraylist
                    break;                                             // mozna dac w dwie linijki ale tak jest czytelniej
                case 3:
                    /* ---------------- Tworzenie nowego portfela ----------------- */

                    Wallet creatingWallet = new Wallet();                 // tworze nowy portfel
                    creatingWallet.enterDataWallet();                   // wczytuje go
                    engine.addWallet(creatingWallet);                        // no i wrzucam do arraylist
                    break;                                             // analogicznie mozna dac w dwie linijki ale po co
                case 4:
                    /* ----------------- Wyświetlenie stanu konta ----------------- */

                    if (!engine.thereAreAnyBanksAccounts())
                        System.out.println("Nie dodano zadnych kont!");
                    else {
                        list(engine.getBankAccounts());
                        System.out.println("Ktore konto wyswietlic: ");
                        AmountOfMoney chosenAccount = engine.getBankAccounts().get(EnterDataInterface.enterInt() - 1);
                        System.out.println(chosenAccount.toString());

                        // if you have any better idea than casting, you can improve it
                        // P.S. the problem is, when you implement it in BankAccount class,
                        // you will receive account holder question before printing it on console
                        BankAccount chosenBankAccount = (BankAccount) chosenAccount;
                        if (!chosenBankAccount.hasAccountHolder())
                            chosenBankAccount.enterAccountHolder();
                    }
                    break;
                case 5:
                    /* --------------- Wyświetlenie stanu portfela ---------------- */

                    if (!engine.thereAreAnyWallets())
                        System.out.println("Nie dodano zadnych portfeli!");
                    else {
                        list(engine.getWallets());
                        System.out.println("Ktore konto wyswietlic: ");
                        System.out.println(engine.getWallets().get(EnterDataInterface.enterInt() - 1).toString());
                    }
                    break;
                case 6:
                    /* -------------- Zakończenie działania programu -------------- */

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

    void pay(String type, int index) {
        boolean isCorrect;
        do {
            try {
                System.out.println("Ile gotowki wplacono?");
                BigDecimal toPay = EnterDataInterface.enterBigDecimal();
                engine.DepositMoney(index, type, toPay);
                isCorrect=true;
            } catch (NumberFormatException e) {
                System.out.println("Musisz podac liczbe!");
                isCorrect = false;
            } catch (AmountOfMoneyException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                isCorrect = false;
            }
        } while (!isCorrect);
    }
}
