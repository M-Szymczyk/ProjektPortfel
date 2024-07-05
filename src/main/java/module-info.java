module MoneyManagerConsoleAPP {
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires static lombok;
    requires org.apache.commons.lang3;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    exports application.ui.window;
}