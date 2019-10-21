package aplikacja;

import java.util.ArrayList;
import java.util.Scanner;

class SilnikAplikacji {
    private static final String MENU=
            "\nMENU"+
                    "\n1.Dodaj transakcje" +
                    "\n2.Tworzenie nowego konta" +
                    "\n3.Tworzenie nowego portfela" +
                    "\n4.Wyswietlenie stanu konta" +
                    "\n5.Wyswietlenie stanu portfela" +
                    "\n6.Koniec programu" +
                    "\nWybierz opcje: ";

    public static void main(String[] args) {
        SilnikAplikacji silnik=new SilnikAplikacji();  // w sumie "xD" - najkrotszy main jakiego widzialem :P
        silnik.praca();
    }

    private void praca() {
        // tworzymy tablice-liste kont bankowych gdzie bedziemy przechowywac dane kont
        ArrayList<KontoBankowe> konta_bankowe = new ArrayList<>();

        // analogicznie portfele
        ArrayList<Portfel>portfele=new ArrayList<>();

        // przywitanie
        System.out.println("Witaj w programie \"MoneyManager\" !");
        System.out.println("Kobieta jak kobieta, twór ma różne rządze, zerknij tutaj bo może podpierdala Ci pieniądze...");

        // przechodzimy do wlasciwej czesci programu
        boolean warunek_dzialania_programu=true;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println(MENU);
            switch (Integer.parseInt(scan.nextLine())) {
                case 1:
                    // opcja dodawania transakcji
                case 2:
                    //2.Tworzenie nowego konta"
                    konta_bankowe.add(new KontoBankowe());
                    konta_bankowe.get(konta_bankowe.size() - 1).wczytaj();
                    break;
                case 3:
                    //3.Tworzenie nowego portfela
                    portfele.add(new Portfel());
                    portfele.get(portfele.size() - 1).wczytaj();
                    break;
                case 4:
                    //4.Wyswietlenie stanu konta
                    if (konta_bankowe.size() == 0)
                        System.out.println("Nie dodano zadnych kont!");
                    else
                        for (KontoBankowe konto_bankowe : konta_bankowe)
                            System.out.println(konto_bankowe.toString());

                    break;
                case 5:
                    //5.Wyswietlenie stanu portfela
                    if (portfele.size() == 0)
                        System.out.println("Nie dodano zadnych portfeli!");
                    else
                        for (Portfel portfel : portfele)
                            System.out.println(portfel.toString());
                    break;
                case 6:
                    warunek_dzialania_programu = false;
                    break;
            }
        }while (warunek_dzialania_programu);
        System.out.println("Koniec");
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

