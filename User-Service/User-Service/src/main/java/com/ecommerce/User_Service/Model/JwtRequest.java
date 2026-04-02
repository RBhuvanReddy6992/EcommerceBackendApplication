package com.ecommerce.User_Service.Model;



import java.io.Serializable;

// DTO for login request
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;   // or email
    private String password;

    // Default constructor
    public JwtRequest() {
    }

    // Constructor with fields
    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters & Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}