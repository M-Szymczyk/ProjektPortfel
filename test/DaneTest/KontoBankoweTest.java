package DaneTest;

import aplikacja.dane.DaneUzytkowika;
import org.junit.Test;
import aplikacja.dane.KontoBankowe;
public class KontoBankoweTest {
    @Test
    public void wczytajTest(){
        DaneUzytkowika uzytkownik2 = new DaneUzytkowika("imie", "nazwisko", "99042501019", "mbc124", "Wroclaw", "ino", 5, 45, 25, "Wro");
        KontoBankowe konto1=new KontoBankowe();
        konto1.wczytaj();
        //Assert.assertEquals();
    }

}
