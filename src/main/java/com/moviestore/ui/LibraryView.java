package com.moviestore.ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import com.moviestore.core.*;
import java.util.List;

/**
 * User's movie library view
 */
public class LibraryView {
    private VBox view;
    private BorderPane parent;
    private User currentUser;
    private DataManager dm;
    
    public LibraryView(BorderPane parent, User user) {
        this.parent = parent;
        this.currentUser = user;
        this.dm = DataManager.getInstance();
        this.view = createLibraryView();
    }
    
    private VBox createLibraryView() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        
        // Header
        HBox header = new HBox(20);
        header.setAlignment(Pos.CENTER_LEFT);
        Label titleLabel = new Label("My Library");
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> parent.setCenter(new UserDashboardView(parent, currentUser).getView()));
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        header.getChildren().addAll(titleLabel, spacer, backButton);
        
        // Library items
        List<Movie> libraryItems = dm.getUserLibrary(currentUser.getUserId());
        ListView<Movie> libraryListView = new ListView<>();
        libraryListView.setPrefHeight(400);
        
        for (Movie movie : libraryItems) {
            libraryListView.getItems().add(movie);
        }
        
        if (libraryItems.isEmpty()) {
            Label emptyLabel = new Label("Your library is empty. Start by purchasing movies!");
            root.getChildren().addAll(header, new Separator(), emptyLabel);
        } else {
            root.getChildren().addAll(header, new Separator(), libraryListView);
        }
        
        return root;
    }
    
    public VBox getView() {
        return view;
    }
}
