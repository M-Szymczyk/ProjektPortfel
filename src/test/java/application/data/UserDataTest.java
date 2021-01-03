package application.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserDataTest {
    private UserData user1,user2;

    @BeforeEach
    public void setUp() {
       user1 = new UserData();
       user2 = new UserData("imie", "nazwisko", "99042501019", "mbc124", "Wroclaw", "ino", 5, 45, 25, "Wro");
    }

    @Test
    public void enterUserData() {
        //user1.enterMoney();
        //Assert.assertEquals(user1,user2);
    }

    @Test
    public void toStringTest() {
        Assertions.assertEquals("\n1.Imie: " + "imie" +
                "\n2.Nazwisko: " + "nazwisko" +
                "\n3.PESEL: " + "99042501019" +
                "\n4.Numer dowodu osobistego: " + "mbc124" +
                "\n5.Miasto zamieszkania: " + "Wroclaw" +
                "\n6.Ulica zamieszkania: " + "ino" +
                "\n7.Numer domu: " + 5 +
                "\n8.Numer mieszkania: " + 45 +
                "\n9.Kod pocztowy: " + 25 +
                "\n10.Poczta: " + "Wro", user2.toString());
    }
}
