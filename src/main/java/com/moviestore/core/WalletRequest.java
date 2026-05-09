package com.moviestore.core;

import java.io.Serializable;
import java.util.Objects;

/**
 * WalletRequest class for handling wallet fund requests
 * Allows users to request wallet top-ups
 */
public class WalletRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String requestId;
    private String userId;
    private double amount;
    private String status; // PENDING, APPROVED, REJECTED
    private String requestDate;
    private String responseDate;
    private String adminNotes;
    
    public WalletRequest(String requestId, String userId, double amount) {
        this.requestId = requestId;
        this.userId = userId;
        this.amount = amount;
        this.status = "PENDING";
        this.requestDate = java.time.LocalDate.now().toString();
        this.adminNotes = "";
    }
    
    // Getters and Setters
    public String getRequestId() { return requestId; }
    public String getUserId() { return userId; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRequestDate() { return requestDate; }
    public String getResponseDate() { return responseDate; }
    public void setResponseDate(String responseDate) { this.responseDate = responseDate; }
    public String getAdminNotes() { return adminNotes; }
    public void setAdminNotes(String notes) { this.adminNotes = notes; }
    
    @Override
    public String toString() {
        return String.format("Request #%s - User: %s - Amount: $%.2f - Status: %s", 
                           requestId, userId, amount, status);
    }
}
