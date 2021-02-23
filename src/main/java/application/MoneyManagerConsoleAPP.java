package application;

import application.data.money.amount.AmountOfMoney;
import application.data.money.amount.AmountOfMoneyException;
import application.data.money.bank.BankAccount;
import application.data.money.wallet.Wallet;
import application.services.EnterDataInterface;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class MoneyManagerConsoleAPP {
    private final Engine engine = new Engine();
    private static final String MENU =
            "\nMENU" +
                    "\n1.Dodaj transakcje" +
                    "\n2.Tworzenie nowego konta" +
                    "\n3.Tworzenie nowego portfela" +
                    "\n4.Wyswietlenie stanu konta/portfela" +
                    "\n5.Wyswietlenie pelnych danych konta/portfela" +
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

                    // @TODO refactor here, I think some things can be unnecessary now

                    if (engine.anyMoneyStorages()) {
                        int payOrWithdraw=0;
                        boolean toContinuePayOrWithdraw;
                        do {
                            System.out.println("1.Wplata czy 2.wyplata gotowki?[1/2]");
                            try {
                                switch (Integer.parseInt(scan.nextLine())) {
                                    case 1:
                                        payOrWithdraw=1;
                                        toContinuePayOrWithdraw = false;
                                        break;
                                    case 2:
                                        payOrWithdraw=2;
                                        toContinuePayOrWithdraw = false;
                                        break;
                                    default:
                                        System.out.println("Brak takiej opcji! Dostępne opcje to 1 lub 2");
                                        toContinuePayOrWithdraw = true;
                                        break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Podaj cyfre!");
                                toContinuePayOrWithdraw = true;
                            }
                        } while (toContinuePayOrWithdraw);

                        transaction(payOrWithdraw);
                    } else
                        System.out.println("Nie masz zadnych portfeli!"
                                + "Nie masz zadnych kont!"
                                + "Musisz najpierw dodac konto lub portfel");
                    break;
                case 2:
                    /* ------------------ Tworzenie nowego konta ------------------ */

                    BankAccount bankAccount = new BankAccount();

                    // @TODO entering data for bank account; remember about Userdata !!!!!!!!

                    engine.addMoneyStorage(bankAccount);
                    break;
                case 3:
                    /* ---------------- Tworzenie nowego portfela ----------------- */

                    Wallet wallet = new Wallet();

                    // @TODO entering data for wallets

                    engine.addMoneyStorage(wallet);
                    break;
                case 4:
                    /* ----------------- Wyświetlenie stanu konta/portfela ----------------- */

                    if (!engine.anyMoneyStorages())
                        System.out.println("Nie dodano zadnych kont bankowych ani portfeli!");
                    else {
                        listMoneyStorages();
                        System.out.println("Ktorego konta/portfela stan wyswietlic?: ");
                        AmountOfMoney chosenAccount = engine.getMoneyStorages().get(EnterDataInterface.enterInt() - 1);
                        System.out.println("Stan " + chosenAccount.getName() + " wynosi " + chosenAccount.getMoney());
                    }
                    break;
                case 5:
                    /* ----------------- Wyświetlenie stanu konta/portfela ----------------- */

                    if (!engine.anyMoneyStorages())
                        System.out.println("Nie dodano zadnych kont bankowych ani portfeli!");
                    else {
                        listMoneyStorages();
                        System.out.println("Ktorego konta/portfela dane wyswietlic?: ");
                        AmountOfMoney chosenAccount = engine.getMoneyStorages().get(EnterDataInterface.enterInt() - 1);
                        System.out.println(chosenAccount.toString());
                    }
                    break;
                case 6:
                    /* -------------- Zakończenie działania programu -------------- */

                    toContinue = false;
                    break;
                default:
                    System.out.println("Nie ma takiej opcji!");
                    break;
            }
        } while (toContinue);
        System.out.println("Koniec!");
    }

    /**
     * Method to list all bank accounts and wallets
     */
    private void listMoneyStorages() {
        if(!engine.anyMoneyStorages()){
            System.out.println("Nie masz zadnych kont bankowych ani portfeli!");
        } else{
            AtomicInteger i= new AtomicInteger(1);
            engine.getMoneyStorages().forEach(moneyStorage -> System.out.println(i.getAndIncrement() + ". " + moneyStorage.getName()));
        }
    }

    /**
     * Method to list all users saved in app (necessary when creating new bank account -
     * - at first, choosing saved one, if not then create new)
     */
    private void listSavedUsers(){
        if(!engine.anySavedUsers()){
            System.out.println("Nie ma żadnych zapisanych użytkowników z kont bankowych!");
        } else{
            AtomicInteger i= new AtomicInteger();
            engine.getSavedUsers().forEach(user -> System.out.println(i.getAndIncrement()
                    + ". " + user.getName() + " " + user.getSurname() + " " + user.getPesel()));
        }
    }

    void deposit(int index) {
        boolean isCorrect;
        do {
            try {
                System.out.println("Ile gotowki wplacono?");
                BigDecimal toPay = EnterDataInterface.enterBigDecimal();
                engine.depositMoney(engine.getMoneyStorages().get(index), toPay);
                isCorrect = true;
            } catch (NumberFormatException e) {
                System.out.println("Musisz podac liczbe!");
                isCorrect = false;
            } catch (AmountOfMoneyException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                isCorrect = false;
            }
        } while (!isCorrect);
    }

    void withdraw(int index){
        boolean isCorrect;
        do {
            try {
                System.out.println("Ile gotowki wyplacaono?");
                BigDecimal toPay = EnterDataInterface.enterBigDecimal();
                engine.withdrawMoney(engine.getMoneyStorages().get(index), toPay);
                isCorrect = true;
            } catch (NumberFormatException e) {
                System.out.println("Musisz podac liczbe!");
                isCorrect = false;
            } catch (AmountOfMoneyException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                isCorrect = false;
            }
        } while (!isCorrect);
    }

    private void transaction(int payOrWithDraw) {
        listMoneyStorages();
        System.out.println("Na ktorym koncie/portfelu robimy transkacje?: ");
        if(payOrWithDraw==1)
            deposit(EnterDataInterface.enterInt() - 1);
        else
            withdraw(EnterDataInterface.enterInt() - 1);
    }
}
