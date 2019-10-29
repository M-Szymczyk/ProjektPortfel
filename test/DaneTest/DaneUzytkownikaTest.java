package DaneTest;

import aplikacja.dane.DaneUzytkowika;
import org.junit.Test;
import org.junit.Assert;

public class DaneUzytkownikaTest {
    //DaneUzytkowika uzytkowik1,uzytkownik2=new DaneUzytkowika("imie","nazwisko","99042501019","mbc124","Wroclaw","ino",5,45,25,"Wro");

    @Test
    public void Test_Wczytaj() {
        DaneUzytkowika uzytkowik1 = new DaneUzytkowika(), uzytkownik2 = new DaneUzytkowika("imie", "nazwisko", "99042501019", "mbc124", "Wroclaw", "ino", 5, 45, 25, "Wro");
        
        uzytkowik1.wczytaj();
        Assert.assertEquals(uzytkowik1,uzytkownik2);
    }

    @Test
    public void Test_toString() {
        DaneUzytkowika uzytkownik2 = new DaneUzytkowika("imie", "nazwisko", "99042501019", "mbc124", "Wroclaw", "ino", 5, 45, 25, "Wro");
        Assert.assertEquals("\n1.Imie: " + "imie" +
                "\n2.Nazwisko: " + "nazwisko" +
                "\n3.PESEL: " + "99042501019" +
                "\n4.Numer dowodu osobistego: " + "mbc124" +
                "\n5.Miasto zamieszkania: " + "Wroclaw" +
                "\n6.Ulica zamieszkania: " + "ino" +
                "\n7.Numer domu: " + 5 +
                "\n8.Numer mieszkania: " + 45 +
                "\n9.Kod pocztowy: " + 25 +
                "\n10.Poczta: " + "Wro", uzytkownik2.toString());
    }
}
