package com.exemple.platformeeducatif;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignUp {
    @FXML
    private Label username;
    @FXML
    private Label name;
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    @FXML
    private Label error;

    public void signUpButton(ActionEvent event) {
        error.setText("your email or password is incorect , pleas try again");
    }

}
