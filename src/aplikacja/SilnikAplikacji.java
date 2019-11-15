package aplikacja;

import aplikacja.dane.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SilnikAplikacji implements WczytywanieDanychInterface {
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
        //SilnikAplikacji silnik=new SilnikAplikacji();  // w sumie "xD" - najkrotszy main jakiego widzialem :P
        //silnik.praca();
        new SilnikAplikacji().praca();//Prosze jeszcze krótszy main XD
    }

    private void praca() {
        // tworzymy tablice-liste kont bankowych gdzie bedziemy przechowywac dane kont
        ArrayList<IloscPieniedzy> konta_bankowe = new ArrayList<>();

        // analogicznie portfele
        ArrayList<IloscPieniedzy> portfele = new ArrayList<>();

        // przywitanie
        System.out.println("Witaj w programie \"MoneyManager\" !");
        System.out.println("Kobieta jak kobieta, twór ma różne rządze, zerknij tutaj bo może podpierdala Ci pieniądze...");

        // przechodzimy do wlasciwej czesci programu
        boolean warunek_dzialania_programu = true;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println(MENU);
            switch (WczytywanieDanychInterface.enterInt()) {
                case 1:
                    // opcja dodawania transakcji
                    //listuje wszystkie konta i portfele
                    System.out.println("Transakcja w portfelu,czy na koncie?[P/K]");
                    String odp_uzytkownika=scan.nextLine().toUpperCase();
                    if (odp_uzytkownika.equals("K")) {
                        if (konta_bankowe.size() == 0) {
                            System.out.println("Nie masz zadnych kont!");
                        } else {
                            listowanie(konta_bankowe);
                            System.out.println("W ktorym koncie dodajemy transkacje: ");
                            konta_bankowe.get(WczytywanieDanychInterface.enterInt() - 1).transakcja();
                        }
                    } else if (odp_uzytkownika.equals("P")) {
                        if (portfele.size() == 0) {
                            System.out.println("Nie masz zadnych portfeli!");
                        } else {
                            listowanie(portfele);
                            System.out.println("W ktorym portfelu dodajemy transkacje: ");
                            portfele.get(WczytywanieDanychInterface.enterInt() - 1).transakcja();
                        }
                    } else {
                        System.out.println("Nie ma takiej opcji!");
                    }
                    //TODO trzeba przetestowac
                    break;
                case 2:
                    //2.Tworzenie nowego konta"
                    konta_bankowe.add(new BankAccount());
                    konta_bankowe.get(konta_bankowe.size() - 1).wczytaj();//to dziala dziwnie xd
                    break;
                case 3:
                    //3.Tworzenie nowego portfela
                    portfele.add(new Portfel());
                    portfele.get(portfele.size() - 1).wczytaj();// i to tez
                    break;
                case 4:
                    //4.Wyswietlenie stanu konta
                    if (konta_bankowe.size() == 0)
                        System.out.println("Nie dodano zadnych kont!");
                    else {
                        listowanie(konta_bankowe);
                        System.out.println("Ktore konto wyswietlic: ");
                        System.out.println(konta_bankowe.get(WczytywanieDanychInterface.enterInt() - 1).toString());
                    }
                    break;
                case 5:
                    //5.Wyswietlenie stanu portfela
                    if (portfele.size() == 0)
                        System.out.println("Nie dodano zadnych portfeli!");
                    else {
                        listowanie(portfele);
                        System.out.println("Ktore konto wyswietlic: ");
                        System.out.println(portfele.get(WczytywanieDanychInterface.enterInt() - 1).toString());
                    }
                    break;
                case 6:
                    warunek_dzialania_programu = false;
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
                    break;
            }
        } while (warunek_dzialania_programu);
        System.out.println("Koniec");
    }

    /**
     * metoda listowanie listuje elementy arraylisty
     *
     * @param obj listowana arraylista
     */
    private void listowanie(ArrayList<IloscPieniedzy> obj) {
        if (obj.size() == 0) {
            System.out.println("Nie masz zadnych kont!");
        } else
            for (int i = 0; i < obj.size(); i++) {
                IloscPieniedzy konta = obj.get(i);
                System.out.println(i + 1 + "." + konta.getNazwa());
            }
    }
}
/*
wlaczasz apke i na start:
pytanie - czy chcesz dodac transakcje? (tak, nie)
tak - przechodzisz do dodawania transakcji, nie - przechodzisz do glownego menu na ktorym wyswietla
stan najwazniejszego konta (np portfela) lub po prostu liste kont

przydalby sie jakis alarm od słabego stanu konta, tzn np w ciągu tygodnia załóżmy twój stan konta 'x' spadł o 90%
i wtedy jakies powiadomienie ze niski stan konta 'x'

mozliwosc ustawienia stalych dochodow i wydatkow (np doladowanie, netflix itp)

(opcjonalnie) jak wylaczasz apke to wyskakuje okienko z obrotami jakie zrobiles (o ile zrobiles) przykladowo:
wydales dzis: 50 zł, otrzymales dzis: 150zł. i tak za kazdym razem jak wylaczasz apke i dokonales jakis zmian
(czyli wpisales transakcje). mysle jednak ze to powinno byc opcjonalnie w ustawieniach i ewentualnie alternatywa
że nie po kazdym wylaczeniu apki tylko np na koniec dnia dopiero

jak konczy sie dzien to jezeli nie bylo zadnej transakcji to przypomnienie o tym ze nie wykonales zadnej transakcji

wiecej nie potrafie sobie przypomniec, to juz na biezaco. to sa takie rzeczy dodatkowe w sumie bo po za tym to trzeba
sama apke zrobic, te konta, transakcje, bilanse itp a ja tego jeszcze nie potrafie xD
*/

