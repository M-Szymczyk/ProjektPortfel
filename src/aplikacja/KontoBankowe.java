package aplikacja;

import java.util.Scanner;

interface KontoBankoweInterface{
    /**
     * Do wczytywania pol klasy
     */
    void wczytaj();

    /**
     * Wykorzystuje do szybkiego listowania kont
     * @return nazwe konta
     */
    String getNazwa_konta();

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
    private String nazwa_konta;
    private DaneUzytkowika wlasciciel;

    // konstruktory
    public KontoBankowe() {
        this.nr_konta_bankowego = 0;
        this.nazwa_konta = null;
        this.wlasciciel = null;
    }

    public KontoBankowe(int ilosc_zl, int ilosc_gr, int nr_konta_bankowego, String nazwa_konta, DaneUzytkowika wlasciciel) {
        super(ilosc_zl, ilosc_gr);
        this.nr_konta_bankowego = nr_konta_bankowego;
        this.nazwa_konta = nazwa_konta;
        this.wlasciciel = wlasciciel;
    }

    // wczytywanie danych konta, hajsu + opcjonalnie wlasciciela
    public void wczytaj() {
        Scanner scanner = new Scanner(System.in);
        boolean war_poprawnosci;
        do {
            try {
                System.out.println("Podaj nazwe konta: ");
                setNazwa_konta(scanner.nextLine());
                war_poprawnosci = false;
            } catch (KontoBankoweException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
        do {
            try {
                System.out.println("Podaj nr_konta: ");
                setNr_konta_bankowego(scanner.nextLine());
                war_poprawnosci = false;
            } catch (KontoBankoweException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
        wczytajHajs();

        // daje mozliwosc dodania wlasciciela w kazdej chwili, niekoniecznie teraz, a no i poki co to nie bawimy sie
        // w tworzenie uzytkownikow i ich list ...
        System.out.println("Czy chcesz dodac dane wlasciciela tego konta? (T/N): ");
        if (scanner.nextLine().toUpperCase().equals("T")) {
            wlasciciel = new DaneUzytkowika();
            wlasciciel.wczytaj();
        } else System.out.println("Podpowiedz: Dane mozesz wpisac w kazdej chwili wybierajac opcje w menu startowym.");
    }

    // ==================== NR_KONTA ================================
    private void setNr_konta_bankowego(String nr_konta) throws KontoBankoweException {
        if (nr_konta == null || nr_konta.equals("")) {
            throw new KontoBankoweException("Musisz podac nr konta!");
        } else {
            try {
                setNr_konta_bankowego(Integer.parseInt(nr_konta));
            } catch (NumberFormatException e) {
                throw new KontoBankoweException("Numer konta musi byc liczba!");
            }
        }
    }

    private void setNr_konta_bankowego(int nr_konta_bankowego) throws KontoBankoweException {
        if (nr_konta_bankowego < 0) {
            throw new KontoBankoweException("Numer konta bankowego nie moze byc mniejszy niz zero!");
        } else
            this.nr_konta_bankowego = nr_konta_bankowego;
    }

    private int getNr_konta_bankowego() {
        return nr_konta_bankowego;
    }

    //===================== NAZWA_KONTA ============================
    private void setNazwa_konta(String nazwa_konta) throws KontoBankoweException {
        if (nazwa_konta == null || nazwa_konta.equals("")) {
            throw new KontoBankoweException("Musisz podac nazwe konta!");
        } else
            this.nazwa_konta = nazwa_konta;
    }

    public String getNazwa_konta() {
        return nazwa_konta;
    }

    //===================== Wlasciciel ============================
    private DaneUzytkowika getWlasciciel() {
        return this.wlasciciel;
    }

    @Override
    public String toString() {
        return "Stan " + getNazwa_konta() + "o numerze" + getNr_konta_bankowego() + "ktorego wlascicielam jest: " +
                getWlasciciel() + "\nwynosi: " + super.toString();
    }
}
