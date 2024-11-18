package com.exemple.platformeeducatif;

import com.exemple.platformeeducatif.BaseDeDonnes.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUp {
    @FXML
    private TextField username;
    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    @FXML
    private Label error;
    @FXML

    private void handleSignup() {
        String namee = name.getText();
        String usernamee = username.getText();
        String emaile = email.getText();
        String passworde = password.getText();

        if (namee.isEmpty() || usernamee.isEmpty() || emaile.isEmpty() || passworde.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Champs vides", "Veuillez remplir tous les champs !");
            return;
        }

        // Passer l'objet User à la méthode signUp
        UserDAO userDAO = new UserDAO();
        if (userDAO.signUp(namee, usernamee, emaile, passworde)) {
            showAlert(Alert.AlertType.INFORMATION, "Inscription réussie", "Bienvenue " + name + " !");
        } else {
            showAlert(Alert.AlertType.ERROR, "Échec de l'inscription", "Impossible de créer un compte. Essayez un autre nom d'utilisateur ou email.");
        }

    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    /*
    public void signUpButton(ActionEvent event) {
        error.setText("your email or password is incorect , pleas try again");
    }
    */

    public void swithToLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Login!");
        stage.setScene(scene);
        stage.show();
    }


}
