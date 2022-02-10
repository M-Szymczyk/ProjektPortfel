package application.ui.window;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MoneyManagerWindowAPP extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stackPane = new StackPane();

        primaryStage.setTitle("Money Manager");
        primaryStage.setScene(new Scene(stackPane, 500, 500));
        primaryStage.show();
    }
}
