package com.exemple.platformeeducatif;
/*
public class User {
    private String username;
    private String password;
    private String name , email ;
    // Constructeur
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String namee, String usernamee, String emaile, String passworde) {
        this.name = namee;
        this.username = usernamee;
        this.email = emaile;
        this.password = passworde;

    }

    // Getters et setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
*/
public class User {
    private String name;
    private String username;
    private String email;
    private String password;

    // Constructeur
    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters et setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
