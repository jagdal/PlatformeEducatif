package com.exemple.platformeeducatif;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public boolean signUp(String name, String username, String email, String password) {
        String query = "INSERT INTO user (name, username, email, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Définir les paramètres dans la requête SQL
            stmt.setString(1, name);
            stmt.setString(2, username);
            stmt.setString(3, email);
            stmt.setString(4, password);

            // Exécuter la requête d'insertion
            int rowsInserted = stmt.executeUpdate();

            // Retourner true si l'insertion a réussi (si des lignes ont été insérées)
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retourner false en cas d'exception ou d'erreur
        }
    }
    public boolean login(String username, String password) {

        //methode de login
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Retourne true si un utilisateur est trouvé
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}

