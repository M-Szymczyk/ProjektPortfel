package DaneTest;
import aplikacja.dane.KontoBankowe;
import org.junit.Test;

public class AmountOfMoneyTest {
    @Test
    public void wczytajHajsTest(){
       KontoBankowe konto=new KontoBankowe();
       konto.wczytaj();

    }
}
