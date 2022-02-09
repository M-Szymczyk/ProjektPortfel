package application.data.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserDataTest {
    @Test
    public void buildEmptyUser() {
        // given
        UserData userData = UserData.builder().build();

        // when

        // then
        Assertions.assertNull(userData.getName());
        Assertions.assertNull(userData.getSurname());
        Assertions.assertNull(userData.getPesel());
        Assertions.assertNull(userData.getIdNo());
        Assertions.assertNull(userData.getResidentialCity());
        Assertions.assertNull(userData.getResidentialStreet());
        Assertions.assertNull(userData.getHouseNo());
        Assertions.assertNull(userData.getFlatNo());
        Assertions.assertNull(userData.getPostCode());
        Assertions.assertNull(userData.getPost());
    }

    @Test
    public void buildUserWithFilledData() {
        // given
        String name = "name";
        String surname = "surname";
        String pesel = "pesel";
        String idNo = "idNo";
        String residentialCity = "residentialCity";
        String residentialStreet = "residentialStreet";
        String houseNo = "houseNo";
        String flatNo = "flatNo";
        String postCode = "postCode";
        String post = "post";
        UserData userData = UserData.builder()
                .withSurname(surname)
                .withName(name)
                .withPesel(pesel)
                .withIdNo(idNo)
                .withResidentialCity(residentialCity)
                .withResidentialStreet(residentialStreet)
                .withHouseNo(houseNo)
                .withFlatNo(flatNo)
                .withPostCode(postCode)
                .withPost(post)
                .build();

        // when

        // then
        Assertions.assertEquals(name, userData.getName());
        Assertions.assertEquals(surname, userData.getSurname());
        Assertions.assertEquals(pesel, userData.getPesel());
        Assertions.assertEquals(idNo, userData.getIdNo());
        Assertions.assertEquals(residentialCity, userData.getResidentialCity());
        Assertions.assertEquals(residentialStreet, userData.getResidentialStreet());
        Assertions.assertEquals(houseNo, userData.getHouseNo());
        Assertions.assertEquals(flatNo, userData.getFlatNo());
        Assertions.assertEquals(postCode, userData.getPostCode());
        Assertions.assertEquals(post, userData.getPost());
    }
}
