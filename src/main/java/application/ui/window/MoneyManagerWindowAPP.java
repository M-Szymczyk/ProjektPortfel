package application.ui.window;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MoneyManagerWindowAPP extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MoneyManagerWindowAPP.class.getResource("MainWindow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            //todo           Logger.getLogger(ServerConfigChooser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
