package aplikacja;

import java.util.Scanner;

public class KontoBankowe extends IloscPieniedzy {
    private int nr_konta_bankowego;
    private String nazwa_konta;
    private DaneUzytkowika wlasciciel;

    public KontoBankowe(int ilosc_zl, int ilosc_gr, int nr_konta_bankowego, String nazwa_konta, DaneUzytkowika wlasciciel) {
        super(ilosc_zl, ilosc_gr);
        this.nr_konta_bankowego = nr_konta_bankowego;
        this.nazwa_konta = nazwa_konta;
        this.wlasciciel = wlasciciel;
    }

    void wczytaj(DaneUzytkowika uzytkownik) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe konta: ");
        setNazwa_konta(scanner.nextLine());
        System.out.println("Podaj nr_konta: ");
        setNr_konta_bankowego(scanner.nextInt());
        super.wczytaj();

        System.out.println("Czy chcesz aby aktualny uzytkownik stal sie wlascicielem tego konta?(T/N): ");
        if (scanner.nextLine().equals("T"))
            wlasciciel = uzytkownik;
        else {
            System.out.println("Czy chcesz dodac dane wlasciciela tego konta? (T/N): ");
            if (scanner.nextLine().equals("T")) {
                wlasciciel = new DaneUzytkowika();
                wlasciciel.wczytaj();
            }
            else System.out.println("Podpowiedz: Dane mozesz wpisac w kazdej chwili wybierajac opcje w menu startowym.");
        }

    }

    public KontoBankowe() {
        this.nr_konta_bankowego = 0;
        this.nazwa_konta = null;
        this.wlasciciel=null;
    }

    private void setNr_konta_bankowego(int nr_konta_bankowego) {
        this.nr_konta_bankowego = nr_konta_bankowego;
    }


    private void setNazwa_konta(String nazwa_konta) {
        this.nazwa_konta = nazwa_konta;
    }

    private String getNazwa_konta() {
        return nazwa_konta;
    }
    private int getNr_konta_bankowego() {
        return nr_konta_bankowego;
    }

    private DaneUzytkowika getWlasciciel() {
        return this.wlasciciel;
    }

    public String toString(){
        return "Stan "+ getNazwa_konta() +"o numerze"+  getNr_konta_bankowego()+"ktorego wlascicielam jest: "+
                getWlasciciel()+"\nwynosi: "+ super.toString();
    }

}
