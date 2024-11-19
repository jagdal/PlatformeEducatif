package com.exemple.platformeeducatif.Quiz;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import java.util.List;

public class QuizController {
    @FXML
    private Label questionLabel;
    @FXML
    private ToggleGroup optionsGroup;
    @FXML
    private RadioButton option1, option2, option3, option4;

    private List<Question> questions;
    private int currentQuestionIndex = 0;

    private QuizService quizService = new QuizService();

    @FXML
    public void initialize() {
        questions = quizService.fetchQuestions();
        loadQuestion();
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question question = questions.get(currentQuestionIndex);
            questionLabel.setText(question.getQuestionText());
            option1.setText(question.getOptions()[0]);
            option2.setText(question.getOptions()[1]);
            option3.setText(question.getOptions()[2]);
            option4.setText(question.getOptions()[3]);
        } else {
            showAlert("Fin du quiz", "Vous avez terminé toutes les questions !");
        }
    }

    @FXML
    private void handleSubmitAction() {
        RadioButton selected = (RadioButton) optionsGroup.getSelectedToggle();
        if (selected != null) {
            int selectedOption = Integer.parseInt(selected.getId().substring(6)) - 1; // extrait l'index
            Question currentQuestion = questions.get(currentQuestionIndex);

            if (selectedOption == currentQuestion.getCorrectOption()) {
                showAlert("Bonne réponse", "Félicitations !");
            } else {
                showAlert("Mauvaise réponse", "Essayez encore !");
            }

            currentQuestionIndex++;
            loadQuestion();
        } else {
            showAlert("Erreur", "Veuillez sélectionner une réponse !");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
