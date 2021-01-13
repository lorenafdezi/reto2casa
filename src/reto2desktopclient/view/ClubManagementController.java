/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto2desktopclient.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javax.swing.text.TableView;

/**
 *
 * @author Ander
 */
public class ClubManagementController {

    @FXML
    private Stage stage;
    @FXML
    private TableView clubTable;
    @FXML
    private TableColumn tableId;
    @FXML
    private TableColumn tableLogin;
    @FXML
    private TableColumn tableEmail;
    @FXML
    private TableColumn tableName;
    @FXML
    private TableColumn tableLastAccess;
    @FXML
    private TableColumn tableLocation;
    @FXML
    private TableColumn tablePhoneNumber;
    @FXML
    private TableColumn tableStatus;
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblId;
    @FXML
    private TextField txtId;
    @FXML
    private Label lblLogin;
    @FXML
    private TextField txtLogin;
    @FXML
    private Label lblEmail;
    @FXML
    private TextField txtEmail;
    @FXML
    private Label lblName;
    @FXML
    private TextField txtName;
    @FXML
    private Label lblLocation;
    @FXML
    private TextField txtLocation;
    @FXML
    private Label lblPhoneNumber;
    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtStatus;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnSeeEvents;

    boolean errorLoginLenght = false;
    boolean errorEmailLenght = false;
    boolean errorEmailPattern = false;
    boolean errorNameLenght = false;
    boolean errorNamePattern = false;
    boolean errorLocationLenght = false;
    boolean errorPhoneNumberLenght = false;
    boolean errorPhoneNumberPattern = false;
    boolean errorStatus = false;

    public void initStage(Parent root) {
        Scene scene = new Scene(root);
        Logger.getLogger(LogInController.class.getName()).log(Level.INFO, "Initializing stage...");
        stage.setScene(scene);
        stage.setTitle("Club Profile");
        stage.setResizable(false);
        txtId.requestFocus();
        txtLogin.textProperty().addListener(this::handleTextLogin);
        txtEmail.textProperty().addListener(this::handleTextEmail);
        txtName.textProperty().addListener(this::handleTextName);
        txtLocation.textProperty().addListener(this::handleTextLocation);
        txtPhoneNumber.textProperty().addListener(this::handleTextPhoneNumber);
        txtStatus.textProperty().addListener(this::handleTextStatus);
        btnAdd.setDisable(true);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        btnSeeEvents.setDisable(true);
        btnAdd.setTooltip(
                new Tooltip("Insert data to add club"));
        btnDelete.setTooltip(
                new Tooltip("Select club to disable"));
        btnUpdate.setTooltip(
                new Tooltip("Select club to update"));
        Logger.getLogger(LogInController.class.getName()).log(Level.INFO, "Showing stage...");
        stage.show();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    private void handleTextLogin(Observable obs) {
        Integer usLenght = txtLogin.getText().trim().length();
        //if username =0 or <255= error
        if (usLenght == 0 || usLenght > 255) {
            errorLoginLenght = true;
        } else {
            errorLoginLenght = false;
        }
        testInputErrors();
    }

    private void handleTextEmail(Observable obs) {
        Integer txtEmailLength = txtEmail.getText().trim().length();
        Pattern patternEmail = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@"
                + "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcherEmail = patternEmail.matcher(txtEmail.getText());

        if (txtEmailLength == 0 || txtEmailLength > 255) {
            errorEmailLenght = true;
        } else if (!matcherEmail.matches()) {
            errorEmailPattern = true;
        } else {
            errorEmailLenght = false;
            errorEmailPattern = false;
        }
        //Tests if there is any input error and disables btnAdd and btnUpdaet if so.
        testInputErrors();
    }

    private void handleTextName(Observable obs) {
        Integer txtNameLength = txtName.getText().trim().length();
        Pattern patternName = Pattern.compile("^([A-Za-z]+[ ]?)+$");
        Matcher matcherName = patternName.matcher(txtName.getText());

        if (txtNameLength == 0 || txtNameLength > 255) {
            errorNameLenght = true;
        } else if (!matcherName.matches()) {
            errorNamePattern = true;
        } else {
            errorNameLenght = false;
            errorNamePattern = false;
        }
        //Tests if there is any input error and disables btnAdd and btnUpdaet if so.ç
        testInputErrors();
    }

    private void handleTextLocation(Observable obs) {
        Integer txtLocationLength = txtName.getText().trim().length();
        if (txtLocationLength == 0 || txtLocationLength > 255) {
            errorLocationLenght = true;
        } else {
            errorLocationLenght = false;
        }
    }

    private void handleTextPhoneNumber(Observable obs) {
        Integer txtPhoneNumberLenght = txtName.getText().trim().length();
        Pattern patternPhoneNumber = Pattern.compile("/\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})/");
        Matcher matcherPhoneNumber = patternPhoneNumber.matcher(txtPhoneNumber.getText());
        if (txtPhoneNumberLenght == 0 || txtPhoneNumberLenght > 255) {
            errorPhoneNumberLenght = true;
        } else if (!matcherPhoneNumber.matches()) {
            errorPhoneNumberPattern = true;
        } else {
            errorPhoneNumberLenght = false;
            errorPhoneNumberPattern = false;
        }
    }

    private void handleTextStatus(Observable obs) {
        String status = txtStatus.getText();
        if (status.equals("Enabled") || status.equals("enabled") || status.equals("Disabled")
                || status.equals("disabled")) {
            errorStatus = false;
        } else {
            errorStatus = true;
        }
    }

    private void testInputErrors() {/*
        if (errorLoginLenght || errorUsername) {
            btnAdd.setDisable(true);
            btnUpdate.setDisable(true);
        } else {
            btnAdd.setDisable(false);
            btnUpdate.setDisable(false);
        }*/
    }

}
