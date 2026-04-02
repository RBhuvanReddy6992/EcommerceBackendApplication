package com.ecommerce.User_Service.Model;



import java.io.Serializable;

// DTO for login response (returns JWT token)
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;

    // Default constructor
    public JwtResponse() {
    }

    // Constructor with token
    public JwtResponse(String token) {
        this.token = token;
    }

    // Getter & Setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
