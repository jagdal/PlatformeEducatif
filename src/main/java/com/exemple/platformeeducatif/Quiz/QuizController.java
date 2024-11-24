package com.exemple.platformeeducatif.Quiz;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class QuizController {
    @FXML
    private Label questionLabel;
    @FXML
    private ToggleGroup optionsGroup;
    @FXML
    private RadioButton option1, option2, option3, option4;
    @FXML
    private Label questionNumber;
    @FXML
    private Label correctAnswer;

    int numCorrect = 0;

    private List<Question> questions;
    private int currentQuestionIndex = 0;

    private QuizService quizService = new QuizService();

    @FXML
    public void initialize() {
        questions = quizService.fetchQuestions();
        loadQuestion();
        if (questionNumber == null) {
            System.out.println("Error: questionNumber is null! Check the FXML fx:id.");
        } else {
            System.out.println("questionNumber is linked successfully.");
        }
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

            correctAnswer.setText("Tu Valide " + numCorrect + " Questions correct");
        }
    }

    // incremente number Question

    int numCount = 1;
    @FXML
    private Slider slider;
    @FXML
    private void handleSubmitAction() {

        RadioButton selected = (RadioButton) optionsGroup.getSelectedToggle();
        if (selected != null) {
            int selectedOption = Integer.parseInt(selected.getId().substring(6)) - 1; // extrait l'index
            Question currentQuestion = questions.get(currentQuestionIndex);

            if (selectedOption == currentQuestion.getCorrectOption()) {
                showAlert("Bonne réponse", "Félicitations !");
                numCorrect++;
                slider.setValue(numCorrect);
            } else {
                showAlert("Mauvaise réponse", "Essayez encore !");
            }


            currentQuestionIndex++;
            loadQuestion();
            if(currentQuestionIndex < questions.size()) {
                numCount++;
                questionNumber.setText("Question " + numCount);
            }




        } else {
            showAlert("Erreur", "Veuillez sélectionner une réponse !");
        }
    }
    // this code for previous button
    @FXML
    private void handlePreviousAction() {
        if (currentQuestionIndex > 0) {
            numCount--;
            questionNumber.setText("Question " + numCount);
            currentQuestionIndex--; // Move to the previous question
            loadQuestion(); // Load the previous question
        } else {
            showAlert("Erreur", "Vous êtes déjà à la première question !");
        }
    }


    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
