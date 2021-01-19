/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto2desktopclient.view;

import java.time.LocalDate;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author 2dam
 */
public class TableModel {

    private SimpleStringProperty tblLogin;
    private SimpleStringProperty tbEmail;
    private SimpleStringProperty tblName;
    private SimpleFloatProperty tblLastaccess;
    private SimpleStringProperty tblMusic;
    private SimpleStringProperty tblStatus;

    TableModel(String tblLogin, String tbEmail, String tblName, ObservableList items, LocalDate value) {
        this.tblLogin = new SimpleStringProperty(tblLogin);
        this.tbEmail = new SimpleStringProperty(tbEmail);
        this.tblName = new SimpleStringProperty(tblName);
        this.tblLastaccess = new SimpleFloatProperty(tblLastaccess);
        this.tblMusic = new SimpleStringProperty(tblMusic);
        this.tblStatus = new SimpleStringProperty(tblStatus);

    }

    public SimpleStringProperty getTblLogin() {
        return tblLogin;
    }

    public void setTblLogin(SimpleStringProperty tblLogin) {
        this.tblLogin = tblLogin;
    }

    public SimpleStringProperty getTbEmail() {
        return tbEmail;
    }

    public void setTbEmail(SimpleStringProperty tbEmail) {
        this.tbEmail = tbEmail;
    }

    public SimpleStringProperty getTblName() {
        return tblName;
    }

    public void setTblName(SimpleStringProperty tblName) {
        this.tblName = tblName;
    }

    public SimpleFloatProperty getTblLastaccess() {
        return tblLastaccess;
    }

    public void setTblLastaccess(SimpleFloatProperty tblLastaccess) {
        this.tblLastaccess = tblLastaccess;
    }

    public SimpleStringProperty getTblMusic() {
        return tblMusic;
    }

    public void setTblMusic(SimpleStringProperty tblMusic) {
        this.tblMusic = tblMusic;
    }

    public SimpleStringProperty getTblStatus() {
        return tblStatus;
    }

    public void setTblStatus(SimpleStringProperty tblStatus) {
        this.tblStatus = tblStatus;
    }

}
