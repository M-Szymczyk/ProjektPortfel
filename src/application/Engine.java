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
                        System.out.println(bankAccounts.get(EnterDataInterface.enterInt() - 1).toString());
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
/**

przydalby sie jakis alarm od słabego stanu konta, tzn np w ciągu tygodnia załóżmy twój stan konta 'x' spadł o 90%
i wtedy jakies powiadomienie ze niski stan konta 'x'

mozliwosc ustawienia stalych dochodow i wydatkow (np doladowanie, netflix itp)

(opcjonalnie) jak wylaczasz apke to wyskakuje okienko z obrotami jakie zrobiles (o ile zrobiles) przykladowo:
wydales dzis: 50 zł, otrzymales dzis: 150zł. i tak za kazdym razem jak wylaczasz apke i dokonales jakis zmian
(czyli wpisales transakcje). mysle jednak ze to powinno byc opcjonalnie w ustawieniach i ewentualnie alternatywa
że nie po kazdym wylaczeniu apki tylko np na koniec dnia dopiero

jak konczy sie dzien to jezeli nie bylo zadnej transakcji to przypomnienie o tym ze nie wykonales zadnej transakcji

 testy - zajme sie tym

 numery kont bankowych powinny byc unikalne - zajme sie tym

*/

