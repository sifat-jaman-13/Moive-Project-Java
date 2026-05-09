package com.moviestore.core;

import java.io.Serializable;
import java.util.Objects;

/**
 * ProfileRequest class for handling user profile modification requests
 */
public class ProfileRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String requestId;
    private String userId;
    private String fieldName; // username, email, password
    private String newValue;
    private String status; // PENDING, APPROVED, REJECTED
    private String requestDate;
    private String approvalDate;
    private String adminNotes;
    
    public ProfileRequest(String requestId, String userId, String fieldName, String newValue) {
        this.requestId = requestId;
        this.userId = userId;
        this.fieldName = fieldName;
        this.newValue = newValue;
        this.status = "PENDING";
        this.requestDate = java.time.LocalDate.now().toString();
        this.adminNotes = "";
    }
    
    // Getters and Setters
    public String getRequestId() { return requestId; }
    public String getUserId() { return userId; }
    public String getFieldName() { return fieldName; }
    public String getNewValue() { return newValue; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRequestDate() { return requestDate; }
    public String getApprovalDate() { return approvalDate; }
    public void setApprovalDate(String approvalDate) { this.approvalDate = approvalDate; }
    public String getAdminNotes() { return adminNotes; }
    public void setAdminNotes(String notes) { this.adminNotes = notes; }
    
    @Override
    public String toString() {
        return String.format("Profile Request #%s - %s: %s → %s - Status: %s", 
                           requestId, fieldName, userId, newValue, status);
    }
}
