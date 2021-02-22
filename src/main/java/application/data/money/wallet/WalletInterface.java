package application.data.money.wallet;

interface WalletInterface {
    /**
     * prawdo podobnie bd wyorzystane do
     * wczytywanie danych do portfela
     */
    void enterDataWallet();

    /**
     * odczyt danych portfela
     */
    String toString();
}
