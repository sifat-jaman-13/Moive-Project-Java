package com.moviestore;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import com.moviestore.ui.LoginView;
import com.moviestore.core.DataManager;

/**
 * Main entry point for the Movie Store Application
 * Demonstrates JavaFX application lifecycle and scene management
 */
public class MovieStoreApp extends Application {
    
    private static Stage primaryStage;
    private static BorderPane root;
    
    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        
        // Initialize data manager
        DataManager.getInstance().initializeData();
        
        // Setup main window
        root = new BorderPane();
        Scene scene = new Scene(root, 1000, 700);
        
        stage.setTitle("ScarZero Movie Store");
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> handleExit());
        
        // Show login view
        showLoginView();
        
        stage.show();
    }
    
    public static void showLoginView() {
        if (root != null) {
            root.setCenter(new LoginView(root).getView());
        }
    }
    
    private void handleExit() {
        DataManager.getInstance().saveAllData();
        System.exit(0);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
