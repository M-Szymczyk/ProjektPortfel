package application.ui.window;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {
    public MenuItem MI_CreateAccount;

    public void OnActionMI_CreateAccount() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddAccount.fxml"));
        try {
            Scene scene = new Scene( loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
//todo            Logger.getLogger(ServerConfigChooser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
