package application.ui.console;

import application.data.user.UserData;
import application.services.Engine;
import application.data.money.amount.AmountOfMoney;
import application.data.money.bank.BankAccount;
import application.data.money.wallet.Wallet;

import java.math.BigDecimal;
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
                            8.Usuwanie danych uzytkownika
                            9.Koniec programu
                            Wybierz opcje:\s
                    """;

    public static void main(String[] args) {
        new MoneyManagerConsoleAPP().work();
    }

    private void work() {
        /* =================== PRZYWITANIE ======================== */

        System.out.println("Witaj w programie \"MoneyManager\" !");
        System.out.println("Kobieta jak kobieta, twór ma różne rządze, zerknij tutaj, może kradnie Ci pieniądze...");

        /* ===================== PROGRAM ========================== */

        while (true) {
            System.out.println(MENU);
            int function = DataEnter.enterInt();
            if (function == 1) {    /* ------------------ Dodawanie transakcji ------------------ */
                if (engine.anyMoneyStorages()) {
                    while (true) {
                        System.out.println("1.Wplata czy 2.wyplata gotowki?[1/2]: ");
                        int transactionTypeChoice = DataEnter.enterInt();
                        if (transactionTypeChoice == 1 || transactionTypeChoice == 2) {
                            transaction(transactionTypeChoice);
                            break;
                        } else {
                            System.out.println("Brak takiej opcji! Dostępne opcje to 1 lub 2");
                        }
                    }
                } else {
                    System.out.println("Nie masz zadnych portfeli!"
                            + "Nie masz zadnych kont!"
                            + "Musisz najpierw dodac konto lub portfel");
                }
            } else if (function == 2) {    /* ------------------ Intertransakcja ------------------ */
                if (!engine.anyMoneyStorages()) {
                    System.out.println("Nie dodano zadnych kont bankowych ani portfeli!");
                } else {
                    listMoneyStorages();

                    System.out.println("Z ktorego konta/portfela chcialbys przelac hajs?: ");
                    AmountOfMoney source = engine.getMoneyStorages().get(DataEnter.enterInt() - 1);
                    System.out.println("Na ktore konto/portfel chcialbys przelac hajs?: ");
                    AmountOfMoney target = engine.getMoneyStorages().get(DataEnter.enterInt() - 1);
                    System.out.println("Podaj kwote jaka chcesz przelac: ");
                    BigDecimal value = DataEnter.enterBigDecimal();

                    engine.interTransaction(source, value, target);
                }
            } else if (function == 3) {    /* ------------------ Tworzenie nowego konta ------------------ */
                BankAccount.BankAccountBuilder<?, ?> builder = BankAccount.builder();

                System.out.println("Wprowadź nazwę konta bankowego: ");
                builder.withName(DataEnter.enterString());
                System.out.println("Wprowadź numer konta bankowego: ");
                builder.withNumberBankAccount(DataEnter.enterBigDecimal());

                while (true) {
                    System.out.println("1.Przypisanie istniejącego użytkownika czy 2.Stworzenie nowego?[1/2]: ");
                    int userAssignMode = DataEnter.enterInt();
                    if (userAssignMode == 1) {
                        listSavedUsers();
                        System.out.println("Ktorego uzytkownika chcesz przypisac do nowego konta?: ");
                        UserData accountHolder = engine.getSavedUsers().get(DataEnter.enterInt() - 1);
                        builder.withAccountHolder(accountHolder);
                        engine.addUser(accountHolder);
                        break;
                    } else if (userAssignMode == 2) {
                        UserData accountHolder = createUserData();
                        builder.withAccountHolder(accountHolder);
                        engine.addUser(accountHolder);
                        break;
                    } else {
                        System.out.println("Brak takiej opcji! Dostępne opcje to 1 lub 2");
                    }
                }

                engine.addMoneyStorage(builder.build());
            } else if (function == 4) {    /* ---------------- Tworzenie nowego portfela ----------------- */
                Wallet.WalletBuilder<?, ?> builder = Wallet.builder();

                System.out.println("Wprowadź nazwe portfela: ");
                builder.withName(DataEnter.enterString());

                engine.addMoneyStorage(builder.build());
            } else if (function == 5) {    /* ----------------- Wyświetlenie stanu konta/portfela ----------------- */
                if (!engine.anyMoneyStorages()) {
                    System.out.println("Nie dodano zadnych kont bankowych ani portfeli!");
                } else {
                    listMoneyStorages();
                    System.out.println("Ktorego konta/portfela stan wyswietlic?: ");
                    AmountOfMoney chosenAccount = engine.getMoneyStorages().get(DataEnter.enterInt() - 1);
                    System.out.println("Stan " + chosenAccount.getName() + " wynosi " + chosenAccount.getMoney());
                }
            } else if (function == 6) {    /* ----------------- Wyświetlenie danych konta/portfela ----------------- */
                if (!engine.anyMoneyStorages()) {
                    System.out.println("Nie dodano zadnych kont bankowych ani portfeli!");
                } else {
                    listMoneyStorages();
                    System.out.println("Ktorego konta/portfela dane wyswietlic?: ");
                    AmountOfMoney chosenAccount = engine.getMoneyStorages().get(DataEnter.enterInt() - 1);
                    System.out.println(chosenAccount.toString());
                }
            } else if (function == 7) {    /* ----------------- Usuwanie konta/portfela ----------------- */
                if (!engine.anyMoneyStorages()) {
                    System.out.println("Nie dodano zadnych kont bankowych ani portfeli!");
                } else {
                    listMoneyStorages();
                    System.out.println("Ktorego konta/portfela chcialbys sie pozbyc?: ");
                    AmountOfMoney chosenAccount = engine.getMoneyStorages().get(DataEnter.enterInt() - 1);
                    engine.deleteMoneyStorage(chosenAccount);
                }
            } else if (function == 8) {    /* ----------------- Usuwanie danych użytkownika ----------------- */
                if (!engine.anySavedUsers()) {
                    System.out.println("Nie dodano zadnych danych uzytkownika!");
                } else {
                    listSavedUsers();
                    System.out.println("Ktorego uzytkownika chcialbys sie pozbyc?: ");
                    UserData chosenUser = engine.getSavedUsers().get(DataEnter.enterInt() - 1);
                    if (engine.isUserAssignedToAnyBankAccount(chosenUser)) {
                        System.out.println("Nie mozna usunac uzytkownika! Jest on przypisany do niektórych kont!");
                    } else {
                        engine.deleteUser(chosenUser);
                    }
                }
            } else if (function == 9) {    /* -------------- Zakończenie działania programu -------------- */
                System.out.println("Konczenie dzialania programu!");
                break;
            } else {
                System.out.println("Nie ma takiej opcji!");
            }
        }
    }

    /**
     * Method to list all bank accounts and wallets
     */
    private void listMoneyStorages() {
        if (!engine.anyMoneyStorages()) {
            System.out.println("Nie masz zadnych kont bankowych ani portfeli!");
        } else {
            AtomicInteger i = new AtomicInteger(1);
            engine.getMoneyStorages().forEach(moneyStorage -> System.out.println(i.getAndIncrement() + ". " + moneyStorage.getName()));
        }
    }

    /**
     * Method to list all users saved in app (necessary when creating new bank account -
     * - at first, choosing saved one, if not then create new)
     */
    private void listSavedUsers() {
        if (!engine.anySavedUsers()) {
            System.out.println("Nie ma żadnych zapisanych użytkowników z kont bankowych!");
        } else {
            AtomicInteger i = new AtomicInteger();
            engine.getSavedUsers().forEach(user -> System.out.println(i.getAndIncrement()
                    + ". " + user.getName() + " " + user.getSurname() + " " + user.getPesel()));
        }
    }

    private void deposit(int index) {
        System.out.println("Ile gotowki wplacono?");
        BigDecimal toPay = DataEnter.enterBigDecimal();
        engine.depositMoney(engine.getMoneyStorages().get(index), toPay);
    }

    private void withdraw(int index) {
        System.out.println("Ile gotowki wyplacaono?");
        BigDecimal toPay = DataEnter.enterBigDecimal();
        engine.withdrawMoney(engine.getMoneyStorages().get(index), toPay);
    }

    private void transaction(int payOrWithDraw) {
        listMoneyStorages();
        System.out.println("Na ktorym koncie/portfelu robimy transkacje?: ");
        if (payOrWithDraw == 1) {
            deposit(DataEnter.enterInt() - 1);
        }
        else {
            withdraw(DataEnter.enterInt() - 1);
        }
    }

    private UserData createUserData() {
        UserData.UserDataBuilder userDataBuilder = UserData.builder();

        System.out.println("Wprowadz imie: ");
        userDataBuilder.withName(DataEnter.enterString());
        System.out.println("Wprowadz nazwisko: ");
        userDataBuilder.withSurname(DataEnter.enterString());
        System.out.println("Wprowadz PESEL: ");
        userDataBuilder.withName(DataEnter.enterString());
        System.out.println("Wprowadz numer dowodu: ");
        userDataBuilder.withSurname(DataEnter.enterString());
        System.out.println("Wprowadz miasto zamieszkania: ");
        userDataBuilder.withName(DataEnter.enterString());
        System.out.println("Wprowadz ulice zamieszKania: ");
        userDataBuilder.withSurname(DataEnter.enterString());
        System.out.println("Wprowadz numer budynku: ");
        userDataBuilder.withName(DataEnter.enterString());
        System.out.println("Wprowadz numer mieszkania: ");
        userDataBuilder.withSurname(DataEnter.enterString());
        System.out.println("Wprowadz kod pocztowy: ");
        userDataBuilder.withName(DataEnter.enterString());
        System.out.println("Wprowadz poczte: ");
        userDataBuilder.withSurname(DataEnter.enterString());

        return userDataBuilder.build();
    }
}
