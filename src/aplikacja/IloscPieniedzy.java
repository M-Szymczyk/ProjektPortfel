package aplikacja;

import java.util.Scanner;

public abstract class IloscPieniedzy implements IloscPieniedzyInterface {
    private int ilosc_zl;
    private int ilosc_gr;
    private double bardzo_mala_wartosc;



    public void wczytaj(){
        Scanner scane =new Scanner(System.in);
        System.out.println("Podaj ilosc zl: ");
        setIlosc_zl(Integer.parseInt(scane.nextLine()));
        System.out.println("Podaj ilosc gr: ");
        int tmp=Integer.parseInt(scane.nextLine());
        setIlosc_gr(tmp%100);
        if(tmp>=100 || tmp <=-100) setIlosc_zl(this.ilosc_zl+tmp/100);
    }

    @Override
    public String toString(){
        return "Stan: "+getIlosc_zl()+"."+getIlosc_gr()+"  "+getBardzo_mala_wartosc();
    }

    private int getIlosc_zl() {
        return ilosc_zl;
    }

    private void setIlosc_zl(int ilosc_zl) {

        this.ilosc_zl = ilosc_zl;
    }

    private int getIlosc_gr() {
        return ilosc_gr;
    }

    private void setIlosc_gr(int ilosc_gr) {
        this.ilosc_gr = ilosc_gr;
    }

    IloscPieniedzy(int ilosc_zl) {
        this.ilosc_zl = ilosc_zl;
        this.ilosc_gr = 0;
        this.bardzo_mala_wartosc = 0;
    }
    IloscPieniedzy(int ilosc_zl, int ilosc_gr) {
        this.ilosc_zl = ilosc_zl;
        this.ilosc_gr = ilosc_gr;
        this.bardzo_mala_wartosc = 0;
    }
    IloscPieniedzy(int ilosc_zl, int ilosc_gr, double bardzo_mala_wartosc) {
        this.ilosc_zl = ilosc_zl;
        this.ilosc_gr = ilosc_gr;
        this.bardzo_mala_wartosc = bardzo_mala_wartosc;
    }
    IloscPieniedzy() {
        this.ilosc_zl = 0;
        this.ilosc_gr = 0;
        this.bardzo_mala_wartosc = 0;
    }


    private double getBardzo_mala_wartosc() {
        return bardzo_mala_wartosc;
    }
/*
    private void setBardzo_mala_wartosc(double bardzo_mala_wartosc) {
        this.bardzo_mala_wartosc = bardzo_mala_wartosc;
    }
*/

}
