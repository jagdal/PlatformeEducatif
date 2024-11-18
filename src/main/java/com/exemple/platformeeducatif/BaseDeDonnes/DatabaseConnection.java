package com.exemple.platformeeducatif.BaseDeDonnes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/login"; // Remplacez par le nom de votre BD
    private static final String USER = "root"; // Nom d'utilisateur par défaut pour XAMPP
    private static final String PASSWORD = ""; // Laissez vide si vous n'avez pas de mot de passe

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
