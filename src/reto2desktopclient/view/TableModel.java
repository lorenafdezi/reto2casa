/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto2desktopclient.view;

import java.time.LocalDate;
import javafx.scene.control.ChoiceBox;

/**
 *
 * @author 2dam
 */
public class TableModel {

    private String tblLogin;
    private String tbEmail;
    private String tblName;
    private LocalDate tblLastaccess;
    private String tblMusic;
    private String tblStatus;

    TableModel(String tblLogin, String tbEmail, String tblName, LocalDate tblLastaccess, String tblMusic, String tblStatus) {
        this.tblLogin = tblLogin;
        this.tbEmail = tbEmail;
        this.tblName = tblName;
        this.tblLastaccess = tblLastaccess;
        this.tblMusic = tblMusic;
        this.tblStatus = tblStatus;

    }

    public String getTblLogin() {
        return tblLogin;
    }

    public void setTblLogin(String tblLogin) {
        this.tblLogin = tblLogin;
    }

    public String getTbEmail() {
        return tbEmail;
    }

    public void setTbEmail(String tbEmail) {
        this.tbEmail = tbEmail;
    }

    public String getTblName() {
        return tblName;
    }

    public void setTblName(String tblName) {
        this.tblName = tblName;
    }

    public LocalDate getTblLastaccess() {
        return tblLastaccess;
    }

    public void setTblLastaccess(LocalDate tblLastaccess) {
        this.tblLastaccess = tblLastaccess;
    }

    public String getTblMusic() {
        return tblMusic;
    }

    public void setTblMusic(String tblMusic) {
        this.tblMusic = tblMusic;
    }

    public String getTblStatus() {
        return tblStatus;
    }

    public void setTblStatus(String tblStatus) {
        this.tblStatus = tblStatus;
    }

}
