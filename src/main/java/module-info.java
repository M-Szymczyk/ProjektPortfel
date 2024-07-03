module MoneyManagerConsoleAPP {
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires javafx.graphics;
    requires static lombok;
    requires org.apache.commons.lang3;

    exports application.ui.window;
}