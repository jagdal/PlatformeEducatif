package com.exemple.platformeeducatif.Causes;

import com.exemple.platformeeducatif.HelloApplication;
import com.exemple.platformeeducatif.HelloController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowCause extends HelloController {

    @FXML
    private TilePane causeList;

    @FXML
    public void initialize() {
        loadCauses();
    }

    private void loadCauses() {
        for (Cause cause : CauseManager.getInstance().getCauses()) {
            HBox card = createCard(cause.getTitle(), cause.getDescription(), new Image(cause.getImagePath()));
            causeList.getChildren().add(card);
            causeList.setHgap(20); // Horizontal gap
            causeList.setVgap(20);
        }
    }

    private HBox createCard(String title, String description, Image image) {
        HBox card = new HBox(10);
        card.setStyle("-fx-background-color: #D6F3E2; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 15px; -fx-alignment: center;");
        card.setSpacing(20);
        card.setPrefSize(300, 300);
        card.setMaxSize(300, 300); // Ensures the card doesn't grow larger than this size
        TilePane tilePane = new TilePane();
        // Set horizontal and vertical gaps
        tilePane.setHgap(10); // Horizontal spacing
        tilePane.setVgap(10); // Vertical spacing

        ImageView cardImageView = new ImageView(image);
        cardImageView.setFitWidth(120);
        cardImageView.setFitHeight(120);

        VBox textSection = new VBox(5);

        Text titleText = new Text(title);
        titleText.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Text descriptionText = new Text(description);
        descriptionText.setStyle("-fx-font-size: 14px;");



        textSection.getChildren().addAll(titleText, descriptionText);
        card.getChildren().addAll(cardImageView, textSection);

        return card;
    }
    public void switchToAdmin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Admins!");
        stage.setScene(scene);
        stage.show();
    }

}
