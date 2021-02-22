package application.data.money.amount;

interface AmountOfMoneyInterface {
    /**
     * Do wczytawania poczatkowego stanu gotowki
     */
    void enterMoney();

    /**
     * Do zwracania stanu gotowki
     */
    String toString();

    /**
     * Do listowania kont i portfeli
     *
     * @return zwraca nazwe obiektu
     */
    String getName();
}
