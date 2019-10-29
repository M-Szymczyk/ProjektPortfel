package DaneTest;
import aplikacja.dane.IloscPieniedzy;
import aplikacja.dane.KontoBankowe;
import org.junit.Test;

public class IloscPieniedzyTest {
    @Test
    public void wczytajHajsTest(){
       KontoBankowe konto=new KontoBankowe();
       konto.wczytajHajs();

    }
}
