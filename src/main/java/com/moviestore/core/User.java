package com.moviestore.core;

import java.io.Serializable;
import java.util.Objects;

/**
 * User class representing a user in the system
 * Encapsulates user data and behavior
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String userId;
    private String username;
    private String password;
    private String email;
    private double walletBalance;
    private String registrationDate;
    
    // Constructor
    public User(String userId, String username, String password, String email, double walletBalance) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.walletBalance = walletBalance;
        this.registrationDate = java.time.LocalDate.now().toString();
    }
    
    // Getters and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public double getWalletBalance() { return walletBalance; }
    public void setWalletBalance(double walletBalance) { this.walletBalance = walletBalance; }
    
    public void addToWallet(double amount) {
        this.walletBalance += amount;
    }
    
    public boolean deductFromWallet(double amount) {
        if (this.walletBalance >= amount) {
            this.walletBalance -= amount;
            return true;
        }
        return false;
    }
    
    public String getRegistrationDate() { return registrationDate; }
    
    @Override
    public String toString() {
        return username + " (" + email + ")";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
