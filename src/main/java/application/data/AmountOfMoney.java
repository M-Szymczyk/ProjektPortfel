package application.data;

import java.math.BigDecimal;
import java.util.Scanner;

interface AmountOfMoneyInterface {

    /**
     * Do zmiany ilosci gotowki
     */

    void transaction();

    /**
     * Do wczytawania poczatkowego stanu gotowki
     */

    void enterMoney();

    /**
     * Do zwracania stanu gotowki
     */

    String toString();

    /**
     * Do listowania kont i portfeli
     * @return zwraca nazwe obiektu
     */

    String getName();

}

class AmountOfMoneyException extends Exception{
    AmountOfMoneyException(String message) {
        super(message);
    }
}

public abstract class AmountOfMoney implements AmountOfMoneyInterface, EnterDataInterface {
    private BigDecimal money;
    private String name;

    /** ====================== KONSTRUKTORY =========================== */

    AmountOfMoney(BigDecimal money, String name) {
        this.money=money;
        this.name=name;
    }

    AmountOfMoney() {
        this.money=null;
    }

    /** ========================= METODY ============================= */

    /** ------------------------- Nazwa ------------------------------ */

    public String getName() {
        return this.name;
    }

    private void setName(String name) throws AmountOfMoneyException {
        if (name == null || name.equals("")){
            throw new AmountOfMoneyException("Musisz podac nazwe zlozona ze znakow!");}
        else
            this.name = name;
    }

    /** ----------------------- Pieniądze ---------------------------- */

    public BigDecimal getMoney(){
        return this.money;
    }

    public void setMoney(BigDecimal money){
        this.money=money;
    }

    /** ----------------------- Transakcja --------------------------- */

    private boolean pay(){
        System.out.println("Ile gotowki wplacono?");
        try {
            BigDecimal toPay=EnterDataInterface.enterBigDecimal();
            if (toPay.compareTo(new BigDecimal(0)) <= 0) {
                System.out.println("Nie mozna wplacic zero lub mniej niz zero gotowki!");
                return false;
            } else {
                this.money=this.money.add(toPay);
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Musisz podac liczbe!");
            return false;
        }
    }

    private boolean withdraw(){
        System.out.println("Ile gotowki wyplacono?");
        try {
            BigDecimal toWithdraw=EnterDataInterface.enterBigDecimal();
            if (toWithdraw.compareTo(new BigDecimal(0)) <= 0) {
                System.out.println("Nie mozna wyplacic zero lub mniej niz zero gotowki!");
                return false;
            } else {
                this.money=this.money.subtract(toWithdraw);
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Musisz podac liczbe!");
            return false;
        }
    }

    public void transaction() {
        Scanner scan = new Scanner(System.in);
        boolean toContinue;
        do {
            System.out.println("1.Wplata czy 2.wyplata gotowki?[1/2]");
            try {
                switch (Integer.parseInt(scan.nextLine())) {
                    case 1:
                        do {
                            toContinue = !pay();
                        } while (toContinue);
                        break;
                    case 2:
                        do {
                            toContinue = !withdraw();
                        } while (toContinue);
                        break;
                    default:
                        System.out.println("Brak takiej opcji!");
                        break;
                }
                toContinue = false;
            } catch (NumberFormatException e) {
                System.out.println("Podaj cyfre!");
                toContinue = true;
            }
        } while (toContinue);
    }

    /** -------------------- Wczytywanie hajsu ------------------------ */

    public void enterMoney() {
        Scanner scaner = new Scanner(System.in);
        boolean toContinue;
        do {
            try {
                System.out.println("Podaj nazwe obiektu:");
                setName(scaner.nextLine());
                toContinue = false;
            } catch (AmountOfMoneyException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        }while (toContinue);
        System.out.println("Podaj ilosc pieniedzy: ");
        setMoney(EnterDataInterface.enterBigDecimal());
    }

    /** ---------------------- Odczyt hajsu -------------------------- */

    @Override
    public String toString() {
        return this.getMoney().toString();
    }
}