package application.data.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class UserData {
    private String name;
    private String surname;
    private String pesel;
    private String idNo;               // nr dowodu
    private String residentialCity;    // miasto zamieszkania
    private String residentialStreet;
    private String houseNo;
    private String flatNo;
    private String postCode;
    private String post;

    @Override
    public String toString() {
        return "\n1.Imie: " + getName() +
                "\n2.Nazwisko: " + getSurname() +
                "\n3.PESEL: " + getPesel() +
                "\n4.Numer dowodu osobistego: " + this.getIdNo() +
                "\n5.Miasto zamieszkania: " + this.getResidentialCity() +
                "\n6.Ulica zamieszkania: " + this.getResidentialStreet() +
                "\n7.Numer domu: " + this.getHouseNo() +
                "\n8.Numer mieszkania: " + this.getFlatNo() +
                "\n9.Kod pocztowy: " + this.getPostCode() +
                "\n10.Poczta: " + getPost();
    }
}