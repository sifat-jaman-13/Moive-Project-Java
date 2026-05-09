package com.moviestore.ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import com.moviestore.core.DataManager;

/**
 * Admin login view with attempt limiting
 */
public class AdminLoginView {
    private VBox view;
    private BorderPane parent;
    private int attempts = 0;
    private final int MAX_ATTEMPTS = 5;
    
    // Admin credentials
    private final String ADMIN_USERNAME = "Sifat";
    private final String ADMIN_PASSWORD = "sifat";
    
    public AdminLoginView(BorderPane parent) {
        this.parent = parent;
        this.view = createAdminLoginView();
    }
    
    private VBox createAdminLoginView() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(40));
        root.setStyle("-fx-font-size: 14;");
        root.setAlignment(Pos.CENTER);
        
        // Title
        Label titleLabel = new Label("Admin Console");
        titleLabel.setStyle("-fx-font-size: 28; -fx-font-weight: bold;");
        
        // Username field
        HBox usernameBox = new HBox(10);
        Label usernameLabel = new Label("Username:");
        usernameLabel.setPrefWidth(100);
        TextField usernameField = new TextField();
        usernameBox.getChildren().addAll(usernameLabel, usernameField);
        
        // Password field
        HBox passwordBox = new HBox(10);
        Label passwordLabel = new Label("Password:");
        passwordLabel.setPrefWidth(100);
        PasswordField passwordField = new PasswordField();
        passwordBox.getChildren().addAll(passwordLabel, passwordField);
        
        // Status label
        Label statusLabel = new Label();
        statusLabel.setStyle("-fx-text-fill: red;");
        
        // Buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        
        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(100);
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            handleAdminLogin(username, password, statusLabel);
        });
        
        Button backButton = new Button("Back");
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> parent.setCenter(new LoginView(parent).getView()));
        
        buttonBox.getChildren().addAll(loginButton, backButton);
        
        root.getChildren().addAll(titleLabel, new Separator(), 
                                 usernameBox, passwordBox, 
                                 statusLabel, buttonBox);
        
        return root;
    }
    
    private void handleAdminLogin(String username, String password, Label statusLabel) {
        if (attempts >= MAX_ATTEMPTS) {
            statusLabel.setText("Too many failed attempts. Please try again later.");
            return;
        }
        
        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            parent.setCenter(new AdminDashboardView(parent).getView());
        } else {
            attempts++;
            statusLabel.setText("Invalid credentials. Attempts: " + attempts + "/" + MAX_ATTEMPTS);
        }
    }
    
    public VBox getView() {
        return view;
    }
}
