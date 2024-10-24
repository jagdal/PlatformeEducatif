 package com.exemple.platformeeducatif;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

 public class HelloController {

     @FXML
     private Button courseOne;
     @FXML
     private Label welcomeText;
     @FXML
     private ProgressIndicator progress;
     @FXML
     private TextField textfield;
     @FXML
     private ImageView imageSearch;
     @FXML
     private Button button;


     //switch to part couse in page d'acceuil
     public void viewCouseOne(ActionEvent event) throws IOException {
         // Load the second scene FXML file
         FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("course1.fxml"));
         Scene scene = new Scene(fxmlLoader.load());
         Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
         stage.setScene(scene);
         stage.show();
     }

     //switch back to page d'acceuil
     public void backOfficielPage(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
         Scene scene = new Scene(fxmlLoader.load());
         Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
         stage.setScene(scene);
         stage.show();
     }

     //switch to signUp page
     public void siwtchToSignUp(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup.fxml"));
         Scene scene = new Scene(fxmlLoader.load());
         Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
         stage.setTitle("SignUp!");
         stage.setScene(scene);
         stage.show();
     }
     // switch label
     Label dashboard;


     //switch to settings page
     public void siwtchToSettings(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("settings.fxml"));
         Scene scene = new Scene(fxmlLoader.load());
         Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
         stage.setTitle("Settings");
         stage.setScene(scene);
         stage.show();
     }

 }

