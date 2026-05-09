package com.moviestore.ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import com.moviestore.core.DataManager;
import com.moviestore.core.User;

/**
 * Login view for user authentication
 */
public class LoginView {
    private VBox view;
    private BorderPane parent;
    
    public LoginView(BorderPane parent) {
        this.parent = parent;
        this.view = createLoginView();
    }
    
    private VBox createLoginView() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(40));
        root.setStyle("-fx-font-size: 14;");
        root.setAlignment(Pos.CENTER);
        
        // Title
        Label titleLabel = new Label("ScarZero Movie Store");
        titleLabel.setStyle("-fx-font-size: 28; -fx-font-weight: bold;");
        
        Label subtitleLabel = new Label("Welcome Back");
        subtitleLabel.setStyle("-fx-font-size: 16;");
        
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
        
        // Buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        
        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(100);
        loginButton.setStyle("-fx-font-size: 14;");
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            handleLogin(username, password);
        });
        
        Button registerButton = new Button("Register");
        registerButton.setPrefWidth(100);
        registerButton.setStyle("-fx-font-size: 14;");
        registerButton.setOnAction(e -> showRegisterView());
        
        Button adminButton = new Button("Admin Login");
        adminButton.setPrefWidth(100);
        adminButton.setStyle("-fx-font-size: 14;");
        adminButton.setOnAction(e -> showAdminLoginView());
        
        buttonBox.getChildren().addAll(loginButton, registerButton, adminButton);
        
        // Status label
        Label statusLabel = new Label();
        statusLabel.setStyle("-fx-text-fill: red;");
        
        root.getChildren().addAll(titleLabel, subtitleLabel, 
                                 new Separator(), 
                                 usernameBox, passwordBox, 
                                 statusLabel, buttonBox);
        
        return root;
    }
    
    private void handleLogin(String username, String password) {
        DataManager dm = DataManager.getInstance();
        User user = dm.getUserByUsername(username);
        
        if (user != null && user.getPassword().equals(password)) {
            // Login successful
            parent.setCenter(new UserDashboardView(parent, user).getView());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("Username or password is incorrect");
            alert.showAndWait();
        }
    }
    
    private void showRegisterView() {
        parent.setCenter(new RegisterView(parent).getView());
    }
    
    private void showAdminLoginView() {
        parent.setCenter(new AdminLoginView(parent).getView());
    }
    
    public VBox getView() {
        return view;
    }
}
