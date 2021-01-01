package DataTest;

import application.data.UserData;
import application.data.BankAccount;
import org.junit.jupiter.api.Test;

public class KontoBankoweTest {
    @Test
    public void wczytajTest(){
        UserData user2 = new UserData("imie", "nazwisko", "99042501019", "mbc124", "Wroclaw", "ino", 5, 45, 25, "Wro");
        BankAccount account1=new BankAccount();
        //account1.enterDataBankAccount();
        //Assert.assertEquals();
    }

}
