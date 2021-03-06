package application.data;

import java.util.Scanner;

interface UserDataInterface {

    /**
     * Metoda enterMoney wczytuje data uzytkownika
     */

    void enterUserData();

    /**
     * Metoda to String zwraca data uzytkownknika w formie gotowej do wyswietlenia
     */

    String toString();
}

// wyjatek na blednie wklepane data przez uzytkownika

class UserDataException extends Exception{
    //private static final long seialVersionUID =1L;
    UserDataException(String message) {
        super(message);
    }
}

/**
 *Klasa DaneUzytkownika przechowuje data uzytkownika tj.
 * imie, nazwisko, pesel, nr dowodu osobistego, miasto zamieszkania, ulice zamieszkania, nr ulicy, nr mieszkania,
 * kod pocztowy, Poczte
 */

public class UserData implements UserDataInterface, EnterDataInterface {
    private String name;
    private String surname;
    private String pesel;
    private String id_no;//nr_dowodu
    private String residential_city;//miasto_zam
    private String residentail_street;
    private int house_no;
    private int flat_no;
    private int postcode;
    private String post;

    /** =================== KONSTRUKTORY ======================= */

    // konstruktor na nulle i zera
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
        post = null;
    }

    // konstruktor na wszystko
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

    /** ====================== METODY ========================== */

    /** ----------------------- Imie --------------------------- */

    private String getName() {
        return name;
    }

    private void setName(String name) throws UserDataException {
        if (name == null || name.equals("")) {
            throw new UserDataException("Musisz podac imie!");
        } else
            this.name = name;
    }
    /** --------------------- Nazwisko ------------------------- */

    private String getSurname() {
        return surname;
    }

    private void setSurname(String surname) throws UserDataException {
        if (surname == null || surname.equals(""))
            throw new UserDataException("Musisz podac nazwisko!");
        else
            this.surname = surname;
    }

    /** ---------------------- Pesel --------------------------- */

    private String getPesel() {
        return pesel;
    }

    private void setPesel(String pesel) throws UserDataException {
        if (pesel == null || pesel.equals(""))
            throw new UserDataException("Musisz podac PESEL!");
        else
            this.pesel = pesel;
    }

    /** -------------------- nr dowodu ------------------------- */

    private String getId_no() {
        return id_no;
    }

    private void setId_no(String id_no) throws UserDataException {
        if (id_no == null || id_no.equals(""))
            throw new UserDataException("Musisz podac numer dowodu!");
        else
            this.id_no = id_no;
    }

    /** --------------- miasto zamieszkania -------------------- */

    private String getResidential_city() {
        return residential_city;
    }

    private void setResidential_city(String residential_city) throws UserDataException {
        if (residential_city == null || residential_city.equals(""))
            throw new UserDataException("Musisz podac miasto zamieszkania!");
        else
            this.residential_city = residential_city;
    }

    /** ---------------------- ulica --------------------------- */

    private String getResidentail_street() {
        return residentail_street;
    }

    private void setResidentail_street(String residentail_street) throws UserDataException {
        if (residentail_street == null || residentail_street.equals(""))
            throw new UserDataException("Musisz podac ulice zamieszkania!");
        else
            this.residentail_street = residentail_street;
    }

    /** --------------------- nr domu -------------------------- */

    private int getHouse_no() {
        return house_no;
    }

    private void setHouse_no(int house_no)throws UserDataException {
        if (house_no <= 0)
            throw new UserDataException("Nr domu nie moze byc mniejszy niz zero!");
        else
            this.house_no = house_no;
    }

    /** ------------------ nr mieszkania ----------------------- */

    private int getFlat_no() {
        return flat_no;
    }

    private void setFlat_no(int flat_no)throws UserDataException {
        if (flat_no <= 0)
            throw new UserDataException("Nr mieszkania musi byc wiekszy niz zero!");
        else
            this.flat_no = flat_no;
    }

    /** ------------------ kod pocztowy ------------------------ */

    private int getPostcode() {
        return postcode;
    }

    private void setPostcode(int postcode) throws UserDataException{
        if (postcode <= 0)
            throw new UserDataException("Kod pocztowy musi byc wiekszy niz zero!");
        else
            this.postcode = postcode;
    }

    /** --------------------- poczta --------------------------- */

    private String getPost() {
        return post;
    }

    private void setPost(String post) throws UserDataException {
        if (post == null || post.equals(""))
            throw new UserDataException("Musisz podac poczte!");
        else
            this.post = post;
    }

    /** --------------- wczytywanie danych --------------------- */

    public void enterUserData() {
        Scanner scanner = new Scanner(System.in);
        boolean toContinue;
        do {
            try {
                System.out.println("Podaj imie: ");
                setName(scanner.nextLine());
                toContinue = false;
            } catch (UserDataException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        } while (toContinue);
        do {
            try {
                System.out.println("Podaj nazwisko: ");
                setSurname(scanner.nextLine());
                toContinue = false;
            } catch (UserDataException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        } while (toContinue);
        do {
            try {
                System.out.println("Podaj Pesel: ");
                setPesel(scanner.nextLine());
                toContinue = false;
            } catch (UserDataException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        } while (toContinue);
        do {
            try {
                System.out.println("Podaj numer dowodu osobistego: ");
                setId_no(scanner.nextLine());
                toContinue = false;
            } catch (UserDataException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        } while (toContinue);
        do {
            try {
                System.out.println("Podaj miasto zamieszkania: ");
                setResidential_city(scanner.nextLine());
                toContinue = false;
            } catch (UserDataException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        } while (toContinue);
        do {
            try {
                System.out.println("Podaj ulice: ");
                setResidentail_street(scanner.next());
                toContinue = false;
            } catch (UserDataException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        } while (toContinue);
        do {
            try {
                System.out.println("Podaj nr domu:");
                setHouse_no(EnterDataInterface.enterInt());
                toContinue = false;
            } catch (UserDataException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        } while (toContinue);
        do {
            try {
                System.out.println("Podaj nr_mieszkania: ");
                setFlat_no(EnterDataInterface.enterInt());
                toContinue = false;
            } catch (UserDataException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        } while (toContinue);
        do {
            try {
                System.out.println("Podaj kod pocztowy: ");
                setPostcode(EnterDataInterface.enterInt());
                toContinue = false;
            } catch (UserDataException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        } while (toContinue);
        do {
            try {
                System.out.println("Podaj Poczte: ");
                setPost(scanner.nextLine());
                toContinue = false;
            } catch (UserDataException e) {
                System.out.println(e.getMessage());
                toContinue = true;
            }
        } while (toContinue);
    }

    /** ------------------ zwrot danych ------------------------ */

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