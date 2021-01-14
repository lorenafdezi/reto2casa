package reto2desktopclient.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

/**
 *
 * @author Matteo Fernández
 */
public class ArtistManagementController {

    private static final Logger LOGGER = Logger.getLogger(LogInController.class.getName());
    ObservableList<String> choiceBoxList = FXCollections.observableArrayList("RAP", "EMD");
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
    private ChoiceBox choiceBox;
    @FXML
    private Button btnSeeEvents;
    boolean errorEmailLenght = false;
    boolean errorEmailPattern = false;
    boolean errorTxtUserNameArtist = false;

    @FXML
    /**
     * Abre la ventana de Log In cuando pulsas el botón back
     *
     * @param event
     */
    public void handleButtonBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/viewLogIn.fxml"));
            Parent root = (Parent) loader.load();
            LogInController controller = (loader.getController());
            controller.setStage(stage);
            controller.initStage(root);
        } catch (IOException e) {
            //traza al salir una excepción
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, "Se ha abierto la ventana", e);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Could not change to Log In window.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    /**
     * Abre la ventana de Event cuando pulsas el botón See event
     *
     * @param event
     */
    public void handleButtonSeeEvents(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/events.fxml"));
            Parent root = (Parent) loader.load();
            LogInController controller = (loader.getController());
            controller.setStage(stage);
            controller.initStage(root);
        } catch (IOException e) {
            //traza al salir una excepción
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, "Se ha abierto la ventana", e);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Could not change to Events.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    void initStage(Parent root
    ) {
        Scene scene = new Scene(root);
        Logger.getLogger(LogInController.class.getName()).log(Level.INFO, "Initializing stage...");
        stage.setScene(scene);
        stage.setTitle("Artist Management");
        stage.setResizable(false);
        txtFullNameArtist.requestFocus();
        btnDisableArtist.setDisable(true);
        txtEmailArtist.textProperty().addListener(this::handletxtEmailArtist);
        txtFullNameArtist.textProperty().addListener(this::handleTextFullNameArtist);
        txtUserNameArtist.textProperty().addListener(this::handletxtUserNameArtist);
        btnEnableArtist.setDisable(true);
        btnNewArtist.setDisable(true);
        menuItemDisableArtist.setDisable(true);
        menuItemEnableArtist.setDisable(true);
        menuItemNewArtist.setDisable(true);
        btnAddArtist.setTooltip(new Tooltip("Click to send credentials."));
        stage.show();
    }

    private void handleTextFullNameArtist(Observable obs) {
        Integer txtFullNameLength = txtFullNameArtist.getText().trim().length();
        Pattern patternFullName = Pattern.compile("^([A-Za-z]+[ ]?)+$");
        Matcher matcherFullName = patternFullName.matcher(txtFullNameArtist.getText());
        //If there is any error...
        if (txtFullNameLength == 0 || txtFullNameLength > 255 || !matcherFullName.matches()) {
            if (!matcherFullName.matches()) {
                btnAddArtist.setVisible(false);
                Alert alert = new Alert(Alert.AlertType.ERROR, "Must only contain letters", ButtonType.OK);
                alert.showAndWait();
            }
            //Sets the alert message when the fiel is empty.
            if (txtFullNameLength == 0) {
                btnAddArtist.setVisible(false);
                Alert alert = new Alert(Alert.AlertType.ERROR, "Field must not be empty", ButtonType.OK);
                alert.showAndWait();
            } //Sets the alert message when the field is longer than 255 characters.
            else if (txtFullNameLength > 255) {
                btnAddArtist.setVisible(false);
                Alert alert = new Alert(Alert.AlertType.ERROR, "Must be less than 255 characters", ButtonType.OK);
                alert.showAndWait();
            }
        } else {
            btnAddArtist.setVisible(true);
        }
    }

    //for the txt Username
    private void handletxtUserNameArtist(Observable obs) {
        Integer usLenght = txtUserNameArtist.getText().trim().length();
        //if username =0 or <255= error
        if (usLenght == 0 || usLenght > 255) {
            errorTxtUserNameArtist = true;
        } else {
            errorTxtUserNameArtist = false;
        }
    }

    //for the txt Email
    public void handletxtEmailArtist(Observable obs) {
        Integer txtEmailLength = txtEmailArtist.getText().trim().length();
        Pattern patternEmail = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@"
                + "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcherEmail = patternEmail.matcher(txtEmailArtist.getText());

        if (txtEmailLength == 0 || txtEmailLength > 255) {
            errorEmailLenght = true;
        } else if (!matcherEmail.matches()) {
            errorEmailPattern = true;
        } else {
            errorEmailLenght = false;
            errorEmailPattern = false;
        }

    }
}

