package reto2desktopclient.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Matteo Fernández
 */
public class ArtistManagementController {

    @FXML
    private Stage stage;
    @FXML
    private TableView tableArtists;
    @FXML
    private Button btnDisableArtist;
    @FXML
    private Button btnEnableArtist;
    @FXML
    private Button btnNewArtist;
    @FXML
    private Button btnAddArtist;
    @FXML
    private MenuItem menuItemDisableArtist;
    @FXML
    private MenuItem menuItemEnableArtist;
    @FXML
    private MenuItem menuItemNewArtist;
    @FXML
    private TextField txtUserNameArtist;
    @FXML
    private TextField txtEmailArtist;
    @FXML
    private TextField txtFullNameArtist;
    @FXML
    private Button btnSeeEvents;
    @FXML
    private Button btnBack;

    public void handleButtonSignUp(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/logIn.fxml"));
            Parent root = (Parent) loader.load();
            LogInController controller = (loader.getController());
            controller.setStage(stage);
            controller.initStage(root);
        } catch (IOException e) {
            //traza al salir una excepción
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, "Se ha abierto la ventana", e);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Could not change to Sign Up window.", ButtonType.OK);
            alert.showAndWait();
        }

    }

}
