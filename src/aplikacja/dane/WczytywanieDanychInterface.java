package aplikacja.dane;

import java.util.Scanner;

public interface WczytywanieDanychInterface {
    /**
     * Metoda enter int zczytuje stringa i rzutuje go na int
     * @return zwraca liczbe int
     */
    static int enterInt() {
        boolean isError;
        int i = 0;
        do{
            isError = false;
            try{
                i = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch(NumberFormatException e){
                System.err.println("Musisz podac liczbe!");
                isError = true;
            }
        }while(isError);
        return i;
    }
}
