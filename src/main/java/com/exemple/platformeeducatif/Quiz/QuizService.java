package com.exemple.platformeeducatif.Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Créer une méthode pour charger les questions depuis la BD

public class QuizService {
    public List<Question> fetchQuestions() {
        List<Question> questions = new ArrayList<>();

        String query = "SELECT * FROM Quiz";
        try (Connection conn = DatabaseUtil.connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String questionText = rs.getString("question");
                String[] options = {
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4")
                };
                int correctOption = rs.getInt("correctOption");

                questions.add(new Question(questionText, options, correctOption));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
}
