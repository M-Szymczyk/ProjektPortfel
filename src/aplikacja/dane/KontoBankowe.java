package aplikacja.dane;

import java.util.Scanner;

interface KontoBankoweInterface {
    /**
     * Do wczytywania pol klasy
     */
    void wczytaj();

    /**
     * Zwraca wszystkie dane konta
     */
    String toString();
}

class KontoBankoweException extends Exception{

    KontoBankoweException(String message) {
        super(message);
    }
}

public class KontoBankowe extends IloscPieniedzy implements KontoBankoweInterface {
    // bede tworzyc transakcje i dodawac tutaj liste transakcji. pomysle nad ich limitem
    private int nr_konta_bankowego;
    private DaneUzytkowika wlasciciel;

    // ==================== NR_KONTA ================================

    private void setNr_konta_bankowego(int nr_konta_bankowego) throws KontoBankoweException {
        if (nr_konta_bankowego < 0) {
            throw new KontoBankoweException("Numer konta bankowego nie moze byc mniejszy niz zero!");
        } else
            this.nr_konta_bankowego = nr_konta_bankowego;
    }

    private int getNr_konta_bankowego() {
        return nr_konta_bankowego;
    }

    //===================== Wlasciciel ============================
    private DaneUzytkowika getWlasciciel() {
        return this.wlasciciel;
    }

    // konstruktory
    public KontoBankowe() {
        this.nr_konta_bankowego = 0;
        this.wlasciciel = null;
    }

    public KontoBankowe(int ilosc_zl, int ilosc_gr, String nazwa, int nr_konta_bankowego, DaneUzytkowika wlasciciel) {
        super(ilosc_zl, ilosc_gr,nazwa);
        this.nr_konta_bankowego = nr_konta_bankowego;
        this.wlasciciel = wlasciciel;
    }

    // wczytywanie danych konta, hajsu + opcjonalnie wlasciciela
    @Override
    public void wczytaj() {
        super.wczytaj();//wywoluje metode wczytaj klasy IloscPieniedzy
        Scanner scanner = new Scanner(System.in);
        boolean war_poprawnosci;
        do {
            try {
                System.out.println("Podaj nr_konta: ");
                setNr_konta_bankowego(WczytywanieDanychInterface.enterInt());
                war_poprawnosci = false;
            } catch (KontoBankoweException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);

        // daje mozliwosc dodania wlasciciela w kazdej chwili, niekoniecznie teraz, a no i poki co to nie bawimy sie
        // w tworzenie uzytkownikow i ich list ...
        System.out.println("Czy chcesz dodac dane wlasciciela tego konta? (T/N): ");
        if (scanner.nextLine().toUpperCase().equals("T")) {
            wlasciciel = new DaneUzytkowika();
            wlasciciel.wczytaj();
        } else System.out.println("Podpowiedz: Dane mozesz wpisac w kazdej chwili wybierajac opcje w menu startowym.");
        //FIXME nie przechytujemy wszystkich odp uzytkownika
    }

    @Override
    public String toString() {
        return "Stan " + getNazwa() + "o numerze" + getNr_konta_bankowego() + "ktorego wlascicielam jest: " +
                getWlasciciel() + "\nwynosi: " + super.toString();
    }
}
