package application.services;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public interface EnterDataInterface {

    /**
     * Metoda enter int zczytuje stringa i rzutuje go na int
     * @return zwraca liczbe int
     */
    static int enterInt() {
        boolean isError;
        int enteredInt = 0;
        do{
            isError = false;
            try{
                enteredInt = new Scanner(System.in).nextInt();
            } catch(InputMismatchException e){
                System.err.println("Musisz podac liczbe!");
                isError = true;
            }
        }while(isError);
        return enteredInt;
    }

    /**
     * Metoda enter BigDecimal zczytuje stringa i rzutuje go na BigDecimal
     * @return zwraca liczbe BigDecimal
     */
    static BigDecimal enterBigDecimal() {
        boolean isError;
        BigDecimal enteredBigDecimal = new BigDecimal(0);
        do{
            isError = false;
            try{
                enteredBigDecimal = new Scanner(System.in).nextBigDecimal();
            } catch(InputMismatchException e){
                System.err.println("Musisz podac liczbe!");
                isError = true;
            }
        }while(isError);
        return enteredBigDecimal;
    }
}
