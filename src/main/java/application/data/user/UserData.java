package application.data.user;

import application.services.EnterDataInterface;

public class UserData implements EnterDataInterface {
    private String name;
    private String surname;
    private String pesel;
    private String id_no;               // nr dowodu
    private String residential_city;    // miasto zamieszkania
    private String residentail_street;
    private int house_no;
    private int flat_no;
    private int postcode;
    private String post;

    public UserData() {
        this.name = null;
        this.surname = null;
        this.pesel = null;
        this.id_no = null;
        this.residential_city = null;
        this.residentail_street = null;
        this.house_no = 0;
        this.flat_no = 0;
        this.postcode = 0;
        this.post = null;
    }

    public UserData(String name, String surname, String pesel, String id_no, String residential_city, String residentail_street, int house_no, int flat_no, int postcode, String post) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.id_no = id_no;
        this.residential_city = residential_city;
        this.residentail_street = residentail_street;
        this.house_no = house_no;
        this.flat_no = flat_no;
        this.postcode = postcode;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UserDataException {
        if (name == null || name.equals("")) {
            throw new UserDataException("Musisz podac imie!");
        } else
            this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws UserDataException {
        if (surname == null || surname.equals(""))
            throw new UserDataException("Musisz podac nazwisko!");
        else
            this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) throws UserDataException {
        if (pesel == null || pesel.equals(""))
            throw new UserDataException("Musisz podac PESEL!");
        else
            this.pesel = pesel;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) throws UserDataException {
        if (id_no == null || id_no.equals(""))
            throw new UserDataException("Musisz podac numer dowodu!");
        else
            this.id_no = id_no;
    }

    public String getResidential_city() {
        return residential_city;
    }

    public void setResidential_city(String residential_city) throws UserDataException {
        if (residential_city == null || residential_city.equals(""))
            throw new UserDataException("Musisz podac miasto zamieszkania!");
        else
            this.residential_city = residential_city;
    }

    public String getResidentail_street() {
        return residentail_street;
    }

    public void setResidentail_street(String residentail_street) throws UserDataException {
        if (residentail_street == null || residentail_street.equals(""))
            throw new UserDataException("Musisz podac ulice zamieszkania!");
        else
            this.residentail_street = residentail_street;
    }

    public int getHouse_no() {
        return house_no;
    }

    public void setHouse_no(int house_no)throws UserDataException {
        if (house_no <= 0)
            throw new UserDataException("Nr domu nie moze byc mniejszy niz zero!");
        else
            this.house_no = house_no;
    }

    public int getFlat_no() {
        return flat_no;
    }

    public void setFlat_no(int flat_no)throws UserDataException {
        if (flat_no <= 0)
            throw new UserDataException("Nr mieszkania musi byc wiekszy niz zero!");
        else
            this.flat_no = flat_no;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) throws UserDataException{
        if (postcode <= 0)
            throw new UserDataException("Kod pocztowy musi byc wiekszy niz zero!");
        else
            this.postcode = postcode;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) throws UserDataException {
        if (post == null || post.equals(""))
            throw new UserDataException("Musisz podac poczte!");
        else
            this.post = post;
    }

    @Override
    public String toString() {
        return "\n1.Imie: " + getName() +
                "\n2.Nazwisko: " + getSurname() +
                "\n3.PESEL: " + getPesel() +
                "\n4.Numer dowodu osobistego: " + getId_no() +
                "\n5.Miasto zamieszkania: " + getResidential_city() +
                "\n6.Ulica zamieszkania: " + getResidentail_street() +
                "\n7.Numer domu: " + getHouse_no() +
                "\n8.Numer mieszkania: " + getFlat_no() +
                "\n9.Kod pocztowy: " + getPostcode() +
                "\n10.Poczta: " + getPost();
    }
}