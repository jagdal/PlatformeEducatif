package com.exemple.platformeeducatif;

public class User {
    private String username;
    private String password;

    // Constructeur
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters et setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
