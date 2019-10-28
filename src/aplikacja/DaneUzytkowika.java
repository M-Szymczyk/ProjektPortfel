package aplikacja;

import java.util.Scanner;
/**
 *Klasa DaneUzytkownika przechowuje dane uzytkownika tj.
 * imie, nazwisko, pesel, nr dowodu osobistego, miasto zamieszkania, ulice zamieszkania, nr ulicy, nr mieszkania,
 * kod pocztowy, Poczte
 */

// wyjatek na blednie wklepane dane przez uzytkownika
class DaneUzytkownikaException extends Exception{

    //private static final long seialVersionUID =1L;

    DaneUzytkownikaException(String message) {
        super(message);
    }
}

public class DaneUzytkowika implements DaneUzytkownikaInterface {
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

    // ================== IMIE ======================
    private String getName() {
        return name;
    }

    private void setName(String name) throws DaneUzytkownikaException {
        if (name == null || name.equals("")) {
            throw new DaneUzytkownikaException("Musisz podac imie!");
        } else
            this.name = name;
    }
    // ================ NAZWISKO ====================
    private String getSurname() {
        return surname;
    }

    private void setSurname(String surname) throws DaneUzytkownikaException {
        if (surname == null || surname.equals(""))
            throw new DaneUzytkownikaException("Musisz podac nazwisko!");
        else
            this.surname = surname;
    }
    // ================== PESEL =====================
    private String getPesel() {
        return pesel;
    }

    private void setPesel(String pesel) throws DaneUzytkownikaException {
        if (pesel == null || pesel.equals(""))
            throw new DaneUzytkownikaException("Musisz podac PESEL!");
        else
            this.pesel = pesel;
    }
   // ================ NR DOWODU ===================
    private String getId_no() {
        return id_no;
    }

    private void setId_no(String id_no) throws DaneUzytkownikaException {
        if (id_no == null || id_no.equals(""))
            throw new DaneUzytkownikaException("Musisz podac numer dowodu!");
        else
            this.id_no = id_no;
    }
    // ================== MIASTO ====================
    private String getResidential_city() {
        return residential_city;
    }

    private void setResidential_city(String residential_city) throws DaneUzytkownikaException {
        if (residential_city == null || residential_city.equals(""))
            throw new DaneUzytkownikaException("Musisz podac miasto zamieszkania!");
        else
            this.residential_city = residential_city;
    }

    // ================== ULICA =====================
    private String getResidentail_street() {
        return residentail_street;
    }

    private void setResidentail_street(String residentail_street) throws DaneUzytkownikaException {
        if (residentail_street == null || residentail_street.equals(""))
            throw new DaneUzytkownikaException("Musisz podac ulice zamieszkania!");
        else
            this.residentail_street = residentail_street;
    }

    //================== NR DOMU ====================
    private int getHouse_no() {
        return house_no;
    }

    private void setHouse_no(int house_no)throws DaneUzytkownikaException {
        if (house_no <= 0)
            throw new DaneUzytkownikaException("Nr domu nie moze byc mniejszy niz zero!");
        else
            this.house_no = house_no;
    }

    private void setHouse_no(String house_no) throws DaneUzytkownikaException {
        if (house_no == null || house_no.equals(""))
            throw new DaneUzytkownikaException("Musisz podac nr domu!");
        else {
            try {
                setHouse_no(Integer.parseInt(house_no));
            } catch (NumberFormatException e) {
                throw new DaneUzytkownikaException("Numer domu musi byc liczba!");
            }
        }
    }

    // ============== NR MIESZKANIA =================
    private int getFlat_no() {
        return flat_no;
    }

    private void setFlat_no(int flat_no)throws DaneUzytkownikaException {
        if (flat_no <= 0)
            throw new DaneUzytkownikaException("Nr mieszkania musi byc wiekszy niz zero!");
        else
            this.flat_no = flat_no;
    }

    private void setFlat_no(String flat_no) throws DaneUzytkownikaException {
        if (flat_no == null || flat_no.equals(""))
            throw new DaneUzytkownikaException("Musisz podac nr mieszkania!");
        else {
            try {
                setFlat_no(Integer.parseInt(flat_no));
            } catch (NumberFormatException e) {
                throw new DaneUzytkownikaException("Nr mieszkania musi byc liczba!");
            }
        }
    }

    // =============== KOD POCZTOWY==================
    private int getPostcode() {
        return postcode;
    }

    private void setPostcode(int postcode) throws DaneUzytkownikaException{
        if (postcode <= 0)
            throw new DaneUzytkownikaException("Kod pocztowy musi byc wiekszy niz zero!");
        else
            this.postcode = postcode;
    }

    private void setPostcode(String postcode) throws DaneUzytkownikaException {
        if (postcode == null || postcode.equals(""))
            throw new DaneUzytkownikaException("Musisz podac kod pocztowy!");
        else {
            try {
                setPostcode(Integer.parseInt(postcode));
            } catch (NumberFormatException e) {
                throw new DaneUzytkownikaException("Kod pocztowy musi byc liczba!");
            }
        }
    }

    // =================== POCZTA ===================
    private String getPost() {
        return post;
    }

    private void setPost(String post) throws DaneUzytkownikaException {
        if (post == null || post.equals(""))
            throw new DaneUzytkownikaException("Musisz podac poczte!");
        else
            this.post = post;
    }

    // konstruktor na nulle i zera
    public DaneUzytkowika() {
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
    public DaneUzytkowika(String name, String surname, String pesel, String id_no, String residential_city, String residentail_street, int house_no, int flat_no, int postcode, String post) {
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

    // wczytywanie wszystkich danych
    public void wczytaj() {
        Scanner scanner = new Scanner(System.in);
        boolean war_poprawnosci;
        do {
            try {
                System.out.println("Podaj imie: ");
                setName(scanner.nextLine());
                war_poprawnosci = false;
            } catch (DaneUzytkownikaException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
        do {
            try {
                System.out.println("Podaj nazwisko: ");
                setSurname(scanner.nextLine());
                war_poprawnosci = false;
            } catch (DaneUzytkownikaException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
        do {
            try {
                System.out.println("Podaj Pesel: ");
                setPesel(scanner.nextLine());
                war_poprawnosci = false;
            } catch (DaneUzytkownikaException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
        do {
            try {
                System.out.println("Podaj numer dowodu osobistego: ");
                setId_no(scanner.nextLine());
                war_poprawnosci = false;
            } catch (DaneUzytkownikaException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
        do {
            try {
                System.out.println("Podaj miasto zamieszkania: ");
                setResidential_city(scanner.nextLine());
                war_poprawnosci = false;
            } catch (DaneUzytkownikaException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
        do {
            try {
                System.out.println("Podaj ulice: ");
                setResidentail_street(scanner.next());
                war_poprawnosci = false;
            } catch (DaneUzytkownikaException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
        do {
            try {
                System.out.println("Podaj nr domu:");
                setHouse_no(scanner.nextLine());
                war_poprawnosci = false;
            } catch (DaneUzytkownikaException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
        do {
            try {
                System.out.println("Podaj nr_mieszkania: ");
                setFlat_no(scanner.nextLine());
                war_poprawnosci = false;
            } catch (DaneUzytkownikaException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
        do {
            try {
                System.out.println("Podaj kod pocztowy: ");
                setPostcode(scanner.nextLine());
                war_poprawnosci = false;
            } catch (DaneUzytkownikaException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
        do {
            try {
                System.out.println("Podaj Poczte: ");
                setPost(scanner.nextLine());
                war_poprawnosci = false;
            } catch (DaneUzytkownikaException e) {
                System.out.println(e.getMessage());
                war_poprawnosci = true;
            }
        } while (war_poprawnosci);
    }

    // odczyt danych
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