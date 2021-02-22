package application.data;

import application.data.user.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

public class UserDataTest {
    private UserData user1,user2;

    @BeforeEach
    public void setUp() {
       user1 = new UserData();
       user2 = new UserData("imie", "nazwisko", "99042501019", "mbc124", "Wroclaw", "ino", 5, 45, 25, "Wro");
    }

    @Test
    public void setUserName() {
        try{
            // given
            user1 = new UserData();

            // when
            Method method = UserData.class.getDeclaredMethod("setName", String.class);
            method.setAccessible(true);

            // then
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1));
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, ""));
            Assertions.assertDoesNotThrow(() -> method.invoke(user1, "Kajtus"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setUserSurname() {
        try{
            // given
            user1 = new UserData();

            // when
            Method method = UserData.class.getDeclaredMethod("setSurname", String.class);
            method.setAccessible(true);

            // then
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1));
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, ""));
            Assertions.assertDoesNotThrow(() -> method.invoke(user1, "Wiciu"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setUserPesel() {
        try{
            // given
            user1 = new UserData();

            // when
            Method method = UserData.class.getDeclaredMethod("setPesel", String.class);
            method.setAccessible(true);

            // then
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1));
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, ""));
            Assertions.assertDoesNotThrow(() -> method.invoke(user1, "9907xxxxxxx"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setUserIdNo() {
        try{
            // given
            user1 = new UserData();

            // when
            Method method = UserData.class.getDeclaredMethod("setId_no", String.class);
            method.setAccessible(true);

            // then
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1));
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, ""));
            Assertions.assertDoesNotThrow(() -> method.invoke(user1, "CAMxxxx"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setUserCity() {
        try{
            // given
            user1 = new UserData();

            // when
            Method method = UserData.class.getDeclaredMethod("setResidential_city", String.class);
            method.setAccessible(true);

            // then
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1));
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, ""));
            Assertions.assertDoesNotThrow(() -> method.invoke(user1, "Tuchola"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setUserStreet() {
        try{
            // given
            user1 = new UserData();

            // when
            Method method = UserData.class.getDeclaredMethod("setResidentail_street", String.class);
            method.setAccessible(true);

            // then
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1));
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, ""));
            Assertions.assertDoesNotThrow(() -> method.invoke(user1, "MickiewiczaChyba"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setUserHouseNo() {
        try{
            // given
            user1 = new UserData();

            // when
            Method method = UserData.class.getDeclaredMethod("setHouse_no", int.class);
            method.setAccessible(true);

            // then
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, -1));
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, 0));
            Assertions.assertDoesNotThrow(() -> method.invoke(user1, 69));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setUserFlatNo() {
        try{
            // given
            user1 = new UserData();

            // when
            Method method = UserData.class.getDeclaredMethod("setFlat_no", int.class);
            method.setAccessible(true);

            // then
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, -1));
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, 0));
            Assertions.assertDoesNotThrow(() -> method.invoke(user1, 69));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setUserPostCode() {
        try{
            // given
            user1 = new UserData();

            // when
            Method method = UserData.class.getDeclaredMethod("setPostcode", int.class);
            method.setAccessible(true);

            // then
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, -1));
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, 0));
            Assertions.assertDoesNotThrow(() -> method.invoke(user1, 89400));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setUserPost() {
        try{
            // given
            user1 = new UserData();

            // when
            Method method = UserData.class.getDeclaredMethod("setPost", String.class);
            method.setAccessible(true);

            // then
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1));
            Assertions.assertThrows(Exception.class, () -> method.invoke(user1, ""));
            Assertions.assertDoesNotThrow(() -> method.invoke(user1, "Tuchola"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
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
