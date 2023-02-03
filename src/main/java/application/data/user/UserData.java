package application.data.user;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@EqualsAndHashCode
@Getter
@Jacksonized
@Builder(setterPrefix = "with", toBuilder = true)
public class UserData {
    private final String name, surname, pesel, idNo, residentialCity, residentialStreet, houseNo, flatNo, postCode, post;

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