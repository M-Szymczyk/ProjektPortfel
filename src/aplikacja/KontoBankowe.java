package aplikacja;

import java.util.Scanner;

public class KontoBankowe extends IloscPieniedzy {
    // bede tworzyc transakcje i dodawac tutaj liste transakcji. pomysle nad ich limitem
    private int nr_konta_bankowego;
    private String nazwa_konta;
    private DaneUzytkowika wlasciciel;


    // konstruktory
    public KontoBankowe() {
        this.nr_konta_bankowego = 0;
        this.nazwa_konta = null;
        this.wlasciciel=null;
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
        System.out.println("Podaj nazwe konta: ");
        setNazwa_konta(scanner.nextLine());
        System.out.println("Podaj nr_konta: ");
        setNr_konta_bankowego(Integer.parseInt(scanner.nextLine()));
        wczytajHajs();

        // daje mozliwosc dodania wlasciciela w kazdej chwili, niekoniecznie teraz, a no i poki co to nie bawimy sie
        // w tworzenie uzytkownikow i ich list ...
        System.out.println("Czy chcesz dodac dane wlasciciela tego konta? (T/N): ");
        if (scanner.nextLine().equals("T")) {
            wlasciciel = new DaneUzytkowika();
            wlasciciel.wczytaj();
        }
        else System.out.println("Podpowiedz: Dane mozesz wpisac w kazdej chwili wybierajac opcje w menu startowym.");
    }


    // zapis danych
    private void setNr_konta_bankowego(int nr_konta_bankowego) {
        this.nr_konta_bankowego = nr_konta_bankowego;
    }
    private void setNazwa_konta(String nazwa_konta) {
        this.nazwa_konta = nazwa_konta;
    }

    // odczyt danych
    private String getNazwa_konta() {
        return nazwa_konta;
    }
    private int getNr_konta_bankowego() {
        return nr_konta_bankowego;
    }
    private DaneUzytkowika getWlasciciel() {
        return this.wlasciciel;
    }

    // nie jestem pewny ale tutaj nie potrzeba przypadkiem @override ? tak samo jest w klasie Portfel
    // chyba ze to wynika z braku interfejsu (slabo sie na nich znam)
    public String toString(){
        return "Stan "+ getNazwa_konta() +"o numerze"+  getNr_konta_bankowego()+"ktorego wlascicielam jest: "+
                getWlasciciel()+"\nwynosi: "+ super.toString();
    }

}
