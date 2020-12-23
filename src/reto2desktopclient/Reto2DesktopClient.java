/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto2desktopclient;

import entity.*;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import reto2desktopclient.client.*;

/**
 *
 * @author Martin Angulo <martin.angulo at tartanga.eus>
 */
public class Reto2DesktopClient extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //REST CLIENTS
        UserManager userManager = UserManagerFactory.getUserManager();
        User user = userManager.find(Club.class, "1");
        System.out.println(user.toString());
        
        ClubManager clubManager = ClubManagerFactory.getClubManager();
        Club club = clubManager.find(Club.class, "1");
        System.out.println(club.toString());
        
        ArtistManager artistManager = ArtistManagerFactory.getArtistManager();
        Artist artist = artistManager.find(Artist.class, "8");
        System.out.println(artist.toString());
        System.out.println(artist.getFullName());
        
        List<Club> clubs = new ArrayList<>();
        clubs = (List<Club>)clubManager.getAllClubs(List.class);
        
        for(int i = 0; i < clubs.size(); ++i) {
            System.out.println(clubs.get(i).toString());
        }
        //REST CLIENTS
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World");
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
