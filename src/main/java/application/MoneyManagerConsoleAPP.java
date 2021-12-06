package application;

import application.data.money.amount.AmountOfMoney;
import application.data.money.bank.BankAccount;
import application.data.money.wallet.Wallet;
import application.data.user.UserData;
import application.services.EnterDataInterface;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class MoneyManagerConsoleAPP {
    private final Engine engine = new Engine();
    private static final String MENU =
            """

                    MENU
                    1.Dodaj transakcje
                    2.Przelew między kontami/portfelami (intertransakcja)
                    3.Tworzenie nowego konta
                    4.Tworzenie nowego portfela
                    5.Wyswietlenie stanu konta/portfela
                    6.Wyswietlenie pelnych danych konta/portfela
                    7.Usuwanie konta/portfela
                    8.Koniec programu
                    Wybierz opcje:\s""";

    public static void main(String[] args) {
        new MoneyManagerConsoleAPP().work();
    }

    private void work() {
        /* =================== PRZYWITANIE ======================== */

        System.out.println("Witaj w programie \"MoneyManager\" !");
        System.out.println("Kobieta jak kobieta, twór ma różne rządze, zerknij tutaj, może kradnie Ci pieniądze...");

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
                                    case 1 -> {
                                        payOrWithdraw = 1;
                                        toContinuePayOrWithdraw = false;
                                    }
                                    case 2 -> {
                                        payOrWithdraw = 2;
                                        toContinuePayOrWithdraw = false;
                                    }
                                    default -> {
                                        System.out.println("Brak takiej opcji! Dostępne opcje to 1 lub 2");
                                        toContinuePayOrWithdraw = true;
                                    }
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
                    /* ------------------ Intertransakcja ------------------ */

                    if(!engine.anyMoneyStorages())
                        System.out.println("Nie dodano zadnych kont bankowych ani portfeli!");
                    else{
                        listMoneyStorages();
                        System.out.println("Z ktorego konta/portfela chcialbys przelac hajs?: ");
                        AmountOfMoney source = engine.getMoneyStorages().get(EnterDataInterface.enterInt() - 1);
                        System.out.println("Na ktore konto/portfel chcialbys przelac hajs?: ");
                        AmountOfMoney target = engine.getMoneyStorages().get(EnterDataInterface.enterInt() - 1);
                        System.out.println("Podaj kwote jaka chcesz przelac: ");
                        BigDecimal value = EnterDataInterface.enterBigDecimal();

                        engine.interTransaction(source, value, target);
                    }
                    break;
                case 3:
                    /* ------------------ Tworzenie nowego konta ------------------ */

                    BankAccount bankAccount = BankAccount.builder().build();

                    // @TODO entering data for bank account; remember about Userdata !!!!!!!!

                    engine.addMoneyStorage(bankAccount);
                    break;
                case 4:
                    /* ---------------- Tworzenie nowego portfela ----------------- */

                    Wallet wallet = Wallet.builder().build();

                    // @TODO entering data for wallets

                    engine.addMoneyStorage(wallet);
                    break;
                case 5:
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
                case 6:
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
                case 7:
                    /* ----------------- Usuwanie konta/portfela ----------------- */

                    if(!engine.anyMoneyStorages())
                        System.out.println("Nie dodano zadnych kont bankowych ani portfeli!");
                    else{
                        listMoneyStorages();
                        System.out.println("Ktorego konta/portfela chcialbys sie pozbyc?: ");
                        AmountOfMoney chosenAccount = engine.getMoneyStorages().get(EnterDataInterface.enterInt() - 1);
                        engine.deleteMoneyStorage(chosenAccount);
                    }
                    break;
                case 8:
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

    private void deposit(int index) {
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
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                isCorrect = false;
            }
        } while (!isCorrect);
    }

    private void withdraw(int index){
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
            } catch (IllegalArgumentException e) {
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
