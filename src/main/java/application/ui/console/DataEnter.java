package application.ui.console;

import application.services.DataValidator;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataEnter {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Metoda enter int zczytuje stringa i rzutuje go na int
     * @return zwraca liczbe int
     */
    public static int enterInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch(InputMismatchException e){
                System.err.println("Musisz podac liczbe!");
            }
        }
    }

    /**
     * Metoda enter BigDecimal zczytuje stringa, rzutuje go na BigDecimal i waliduje
     * @return zwraca liczbe BigDecimal
     */
    public static BigDecimal enterBigDecimal() {
        while (true) {
            try {
                return DataValidator.check(scanner.nextBigDecimal());
            } catch (InputMismatchException e){
                System.err.println("Musisz podac liczbe!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Metoda enter String zczytuje stringa z konsoli, waliduje go i sprawdza
     * @return zwraca String
     */
    public static String enterString() {
        while (true) {
            try {
                return DataValidator.check(scanner.nextLine());
            } catch (InputMismatchException e){
                System.err.println("Musisz podac słowo!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
