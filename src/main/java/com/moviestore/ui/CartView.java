package com.moviestore.ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import com.moviestore.core.*;
import java.util.List;

/**
 * Shopping cart view for users
 */
public class CartView {
    private VBox view;
    private BorderPane parent;
    private User currentUser;
    private DataManager dm;
    
    public CartView(BorderPane parent, User user) {
        this.parent = parent;
        this.currentUser = user;
        this.dm = DataManager.getInstance();
        this.view = createCartView();
    }
    
    private VBox createCartView() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        
        // Header
        HBox header = new HBox(20);
        header.setAlignment(Pos.CENTER_LEFT);
        Label titleLabel = new Label("Shopping Cart");
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> parent.setCenter(new UserDashboardView(parent, currentUser).getView()));
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        header.getChildren().addAll(titleLabel, spacer, backButton);
        
        // Cart items
        List<Movie> cartItems = dm.getUserCart(currentUser.getUserId());
        ListView<Movie> cartListView = new ListView<>();
        cartListView.setPrefHeight(300);
        
        for (Movie movie : cartItems) {
            cartListView.getItems().add(movie);
        }
        
        // Total
        double total = cartItems.stream().mapToDouble(Movie::getPrice).sum();
        Label totalLabel = new Label("Total: $" + String.format("%.2f", total));
        totalLabel.setStyle("-fx-font-size: 14; -fx-font-weight: bold;");
        
        // Buttons
        HBox actionBox = new HBox(10);
        actionBox.setAlignment(Pos.CENTER);
        
        Button removeButton = new Button("Remove Selected");
        removeButton.setOnAction(e -> {
            Movie selected = cartListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                dm.removeFromCart(currentUser.getUserId(), selected.getMovieId());
                cartListView.getItems().remove(selected);
            }
        });
        
        Button checkoutButton = new Button("Checkout");
        checkoutButton.setOnAction(e -> {
            if (currentUser.deductFromWallet(total)) {
                for (Movie movie : cartItems) {
                    dm.addToLibrary(currentUser.getUserId(), movie);
                }
                dm.clearCart(currentUser.getUserId());
                showInfo("Success", "Purchase completed! Movies added to your library.");
                parent.setCenter(new UserDashboardView(parent, currentUser).getView());
            } else {
                showAlert("Insufficient Funds", "Your wallet balance is insufficient.");
            }
        });
        
        actionBox.getChildren().addAll(removeButton, checkoutButton);
        
        root.getChildren().addAll(header, new Separator(), cartListView, totalLabel, actionBox);
        
        return root;
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
