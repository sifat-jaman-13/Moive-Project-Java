package com.moviestore.core;

import java.io.Serializable;
import java.util.Objects;

/**
 * Message class for system messages and user communication
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String messageId;
    private String senderId;
    private String recipientId;
    private String subject;
    private String content;
    private String timestamp;
    private boolean read;
    private String type; // SYSTEM, USER, ADMIN
    
    public Message(String messageId, String senderId, String recipientId, 
                   String subject, String content, String type) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.subject = subject;
        this.content = content;
        this.timestamp = java.time.LocalDateTime.now().toString();
        this.read = false;
        this.type = type;
    }
    
    // Getters and Setters
    public String getMessageId() { return messageId; }
    public String getSenderId() { return senderId; }
    public String getRecipientId() { return recipientId; }
    public String getSubject() { return subject; }
    public String getContent() { return content; }
    public String getTimestamp() { return timestamp; }
    public boolean isRead() { return read; }
    public void setRead(boolean read) { this.read = read; }
    public String getType() { return type; }
    
    @Override
    public String toString() {
        return String.format("%s - %s (Unread: %s)", subject, 
                           java.time.LocalDateTime.parse(timestamp).toLocalDate(), 
                           !read);
    }
}
