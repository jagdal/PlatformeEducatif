package com.exemple.platformeeducatif.Admin;


import com.exemple.platformeeducatif.Causes.Cause;
import com.exemple.platformeeducatif.Causes.CauseManager;
import com.exemple.platformeeducatif.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AdminController {

    @FXML
    private VBox formContainer;

    @FXML
    private Button addButton;

    private File selectedImageFile;


    @FXML
    private VBox formSolution;

    @FXML
    public void showAddCauseForm() {
        // Clear any existing form
        formContainer.getChildren().clear();

        // Create form components
        ImageView imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        Button chooseImageButton = new Button("Choose Image");
        chooseImageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose Image");
            selectedImageFile = fileChooser.showOpenDialog(null);
            if (selectedImageFile != null) {
                Image image = new Image(selectedImageFile.toURI().toString());
                imageView.setImage(image);
            }
        });

        TextField titleField = new TextField();
        titleField.setPromptText("Enter Title");

        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Enter Description");

        Button saveButton = new Button("Save Cause");
        saveButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        saveButton.setOnAction(e -> {
            String title = titleField.getText();
            String description = descriptionField.getText();

            if (title.isEmpty() || description.isEmpty() || selectedImageFile == null) {
                System.out.println("All fields are required!");
                return;
            }

            // Save cause to CauseManager
            Cause cause = new Cause(title, description, selectedImageFile.toURI().toString());
            CauseManager.getInstance().addCause(cause);

            System.out.println("Cause added successfully!");

            // Clear form after saving
            titleField.clear();
            descriptionField.clear();
            imageView.setImage(null);
            selectedImageFile = null;
        });

        // Add components to form container
        formContainer.getChildren().addAll(imageView, chooseImageButton, titleField, descriptionField, saveButton);
    }
    @FXML
    public void showAddSolutionForm() {
        // Clear any existing form
        formSolution.getChildren().clear();

        // Create form components
        ImageView imageView = new ImageView();
        imageView.setFitWidth(120);
        imageView.setFitHeight(120);

        Button chooseImageButton = new Button("Choose Image");
        chooseImageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose Image");
            selectedImageFile = fileChooser.showOpenDialog(null);
            if (selectedImageFile != null) {
                Image image = new Image(selectedImageFile.toURI().toString());
                imageView.setImage(image);
            }
        });

        TextField titleField = new TextField();
        titleField.setPromptText("Enter Title of Solution");

        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Enter Description of Solution");

        Button saveButton = new Button("Save Solution");
        saveButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        saveButton.setOnAction(e -> {
            String title = titleField.getText();
            String description = descriptionField.getText();

            if (title.isEmpty() || description.isEmpty() || selectedImageFile == null) {
                System.out.println("All fields are required!");
                return;
            }

            // Save cause to CauseManager
            Cause cause = new Cause(title, description, selectedImageFile.toURI().toString());
            CauseManager.getInstance().addCause(cause);

            System.out.println("Solution added successfully!");

            // Clear form after saving
            titleField.clear();
            descriptionField.clear();
            imageView.setImage(null);
            selectedImageFile = null;


        });

        // Add components to form container
        formSolution.getChildren().addAll(imageView, chooseImageButton, titleField, descriptionField, saveButton);
    }
    public void switchToCause(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cause.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Causes!");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMembres(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("member.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Causes!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void handleLogout(javafx.event.ActionEvent event) {
        // Logic for logging out the user
        System.out.println("Logout successful!");

        // Optionally, close the current window
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

