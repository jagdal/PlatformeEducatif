package com.exemple.platformeeducatif;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.management.remote.JMXConnectorFactory.connect;

public class UserDAO {
    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/login"; // Remplacez avec votre URL de base de données
        String user = "root"; // Nom d'utilisateur de la base de données
        String password = ""; // Mot de passe de la base de données
        return DriverManager.getConnection(url, user, password);
    }
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


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT username, name, email FROM user"; // Requête sans le mot de passe

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String username = rs.getString("username");
                String name = rs.getString("name");
                String email = rs.getString("email");

                users.add(new User(username, name, email));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }


}

