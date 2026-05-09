package com.moviestore.ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import com.moviestore.core.*;
import java.util.UUID;

/**
 * Admin dashboard for managing movies and users
 */
public class AdminDashboardView {
    private VBox view;
    private BorderPane parent;
    private DataManager dm;
    
    public AdminDashboardView(BorderPane parent) {
        this.parent = parent;
        this.dm = DataManager.getInstance();
        this.view = createAdminDashboardView();
    }
    
    private VBox createAdminDashboardView() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        
        // Header
        HBox header = new HBox(20);
        header.setAlignment(Pos.CENTER_LEFT);
        Label titleLabel = new Label("Admin Console");
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> parent.setCenter(new LoginView(parent).getView()));
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        header.getChildren().addAll(titleLabel, spacer, logoutButton);
        
        // Tab panel
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        // Movies tab
        Tab moviesTab = createMoviesTab();
        
        // Users tab
        Tab usersTab = createUsersTab();
        
        tabPane.getTabs().addAll(moviesTab, usersTab);
        
        root.getChildren().addAll(header, new Separator(), tabPane);
        
        return root;
    }
    
    private Tab createMoviesTab() {
        Tab tab = new Tab("Manage Movies");
        
        VBox content = new VBox(10);
        content.setPadding(new Insets(15));
        
        // Movies list
        ListView<Movie> moviesList = new ListView<>();
        moviesList.setPrefHeight(300);
        
        for (Movie movie : dm.getAllMovies()) {
            moviesList.getItems().add(movie);
        }
        
        // Add movie form
        VBox addForm = new VBox(10);
        addForm.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1; -fx-padding: 10;");
        
        Label formTitle = new Label("Add New Movie");
        formTitle.setStyle("-fx-font-weight: bold;");
        
        TextField titleField = new TextField();
        titleField.setPromptText("Title");
        
        TextField genreField = new TextField();
        genreField.setPromptText("Genre");
        
        TextField directorField = new TextField();
        directorField.setPromptText("Director");
        
        TextField priceField = new TextField();
        priceField.setPromptText("Price");
        
        TextField yearField = new TextField();
        yearField.setPromptText("Release Year");
        
        Button addButton = new Button("Add Movie");
        addButton.setOnAction(e -> {
            try {
                String title = titleField.getText();
                String genre = genreField.getText();
                String director = directorField.getText();
                double price = Double.parseDouble(priceField.getText());
                int year = Integer.parseInt(yearField.getText());
                
                Movie movie = new Movie(UUID.randomUUID().toString(), title, genre, director, 
                                      price, year, "Sample description", 50);
                dm.addMovie(movie);
                moviesList.getItems().add(movie);
                
                titleField.clear();
                genreField.clear();
                directorField.clear();
                priceField.clear();
                yearField.clear();
                
                showInfo("Success", "Movie added successfully");
            } catch (Exception ex) {
                showAlert("Error", "Please fill all fields with valid data");
            }
        });
        
        addForm.getChildren().addAll(formTitle, titleField, genreField, directorField, priceField, yearField, addButton);
        
        content.getChildren().addAll(
            new Label("Current Movies:"),
            moviesList,
            new Separator(),
            addForm
        );
        
        ScrollPane scrollPane = new ScrollPane(content);
        tab.setContent(scrollPane);
        return tab;
    }
    
    private Tab createUsersTab() {
        Tab tab = new Tab("Manage Users");
        
        VBox content = new VBox(10);
        content.setPadding(new Insets(15));
        
        // Users list
        ListView<User> usersList = new ListView<>();
        usersList.setPrefHeight(300);
        
        for (User user : dm.getAllUsers()) {
            usersList.getItems().add(user);
        }
        
        Label userCountLabel = new Label("Total Users: " + dm.getAllUsers().size());
        userCountLabel.setStyle("-fx-font-size: 14;");
        
        content.getChildren().addAll(
            new Label("Registered Users:"),
            userCountLabel,
            usersList
        );
        
        ScrollPane scrollPane = new ScrollPane(content);
        tab.setContent(scrollPane);
        return tab;
    }
    
    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public VBox getView() {
        return view;
    }
}
