package com.moviestore.ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import com.moviestore.core.DataManager;
import com.moviestore.core.User;
import java.util.UUID;

/**
 * Registration view for new users
 */
public class RegisterView {
    private VBox view;
    private BorderPane parent;
    
    public RegisterView(BorderPane parent) {
        this.parent = parent;
        this.view = createRegisterView();
    }
    
    private VBox createRegisterView() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(40));
        root.setStyle("-fx-font-size: 14;");
        root.setAlignment(Pos.TOP_CENTER);
        
        // Title
        Label titleLabel = new Label("Create Account");
        titleLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");
        
        // Username field
        HBox usernameBox = new HBox(10);
        Label usernameLabel = new Label("Username:");
        usernameLabel.setPrefWidth(100);
        TextField usernameField = new TextField();
        usernameBox.getChildren().addAll(usernameLabel, usernameField);
        
        // Email field
        HBox emailBox = new HBox(10);
        Label emailLabel = new Label("Email:");
        emailLabel.setPrefWidth(100);
        TextField emailField = new TextField();
        emailBox.getChildren().addAll(emailLabel, emailField);
        
        // Password field
        HBox passwordBox = new HBox(10);
        Label passwordLabel = new Label("Password:");
        passwordLabel.setPrefWidth(100);
        PasswordField passwordField = new PasswordField();
        passwordBox.getChildren().addAll(passwordLabel, passwordField);
        
        // Confirm password field
        HBox confirmBox = new HBox(10);
        Label confirmLabel = new Label("Confirm:");
        confirmLabel.setPrefWidth(100);
        PasswordField confirmField = new PasswordField();
        confirmBox.getChildren().addAll(confirmLabel, confirmField);
        
        // Buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        
        Button registerButton = new Button("Register");
        registerButton.setPrefWidth(100);
        registerButton.setOnAction(e -> {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String confirm = confirmField.getText();
            handleRegister(username, email, password, confirm);
        });
        
        Button backButton = new Button("Back");
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> parent.setCenter(new LoginView(parent).getView()));
        
        buttonBox.getChildren().addAll(registerButton, backButton);
        
        root.getChildren().addAll(titleLabel, new Separator(), 
                                 usernameBox, emailBox, passwordBox, confirmBox, 
                                 buttonBox);
        
        return root;
    }
    
    private void handleRegister(String username, String email, String password, String confirm) {
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showAlert("Validation Error", "All fields are required");
            return;
        }
        
        if (!password.equals(confirm)) {
            showAlert("Validation Error", "Passwords do not match");
            return;
        }
        
        DataManager dm = DataManager.getInstance();
        if (dm.getUserByUsername(username) != null) {
            showAlert("Registration Failed", "Username already exists");
            return;
        }
        
        User newUser = new User(UUID.randomUUID().toString(), username, password, email, 0.0);
        dm.addUser(newUser);
        
        showInfo("Success", "Account created successfully! Please login.");
        parent.setCenter(new LoginView(parent).getView());
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public VBox getView() {
        return view;
    }
}
