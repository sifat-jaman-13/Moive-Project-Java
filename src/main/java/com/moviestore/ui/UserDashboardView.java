package com.moviestore.ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import com.moviestore.core.*;

/**
 * User dashboard showing available movies
 */
public class UserDashboardView {
    private VBox view;
    private BorderPane parent;
    private User currentUser;
    private DataManager dm;
    
    public UserDashboardView(BorderPane parent, User user) {
        this.parent = parent;
        this.currentUser = user;
        this.dm = DataManager.getInstance();
        this.view = createDashboardView();
    }
    
    private VBox createDashboardView() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        
        // Header
        HBox header = new HBox(20);
        header.setAlignment(Pos.CENTER_LEFT);
        Label titleLabel = new Label("Movie Store - Welcome " + currentUser.getUsername());
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        
        Label walletLabel = new Label("Wallet: $" + String.format("%.2f", currentUser.getWalletBalance()));
        walletLabel.setStyle("-fx-font-size: 14;");
        
        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> parent.setCenter(new LoginView(parent).getView()));
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        header.getChildren().addAll(titleLabel, spacer, walletLabel, logoutButton);
        
        // Movies ListView
        ListView<Movie> moviesListView = new ListView<>();
        moviesListView.setPrefHeight(400);
        
        for (Movie movie : dm.getAllMovies()) {
            moviesListView.getItems().add(movie);
        }
        
        // Movie details
        VBox detailsBox = new VBox(10);
        Label detailsLabel = new Label("Select a movie to view details");
        detailsBox.getChildren().add(detailsLabel);
        
        moviesListView.setOnMouseClicked(e -> {
            Movie selected = moviesListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                detailsLabel.setText(
                    "Title: " + selected.getTitle() + "\n" +
                    "Director: " + selected.getDirector() + "\n" +
                    "Genre: " + selected.getGenre() + "\n" +
                    "Year: " + selected.getReleaseYear() + "\n" +
                    "Price: $" + String.format("%.2f", selected.getPrice()) + "\n" +
                    "Description: " + selected.getDescription()
                );
            }
        });
        
        // Buttons
        HBox actionBox = new HBox(10);
        actionBox.setAlignment(Pos.CENTER);
        
        Button addToCartButton = new Button("Add to Cart");
        addToCartButton.setOnAction(e -> {
            Movie selected = moviesListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                dm.addToCart(currentUser.getUserId(), selected);
                showInfo("Added", selected.getTitle() + " added to cart");
            }
        });
        
        Button viewCartButton = new Button("View Cart");
        viewCartButton.setOnAction(e -> {
            parent.setCenter(new CartView(parent, currentUser).getView());
        });
        
        Button viewLibraryButton = new Button("My Library");
        viewLibraryButton.setOnAction(e -> {
            parent.setCenter(new LibraryView(parent, currentUser).getView());
        });
        
        actionBox.getChildren().addAll(addToCartButton, viewCartButton, viewLibraryButton);
        
        root.getChildren().addAll(header, new Separator(), moviesListView, detailsBox, actionBox);
        
        return root;
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
