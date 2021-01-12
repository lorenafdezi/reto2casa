package reto2desktopclient.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Aitor Fidalgo
 */
public class AdminMainMenuController {
    
    private static final Logger LOGGER = Logger.getLogger(AdminMainMenuController.class.getName());
    
    @FXML
    private Stage stage;
    
    public void initStage(Parent root) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Admin Menu");
        stage.setResizable(false);
        stage.show();
        LOGGER.log(Level.INFO, "Successfully switched to Log In window.");
    }
    
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
