package com.moviestore.core;

import java.io.Serializable;
import java.util.Objects;

/**
 * Movie class representing a movie in the catalog
 * Follows OOP principles with encapsulation
 */
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String movieId;
    private String title;
    private String genre;
    private String director;
    private double price;
    private int releaseYear;
    private String description;
    private int stock;
    
    // Constructor
    public Movie(String movieId, String title, String genre, String director, 
                 double price, int releaseYear, String description, int stock) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.price = price;
        this.releaseYear = releaseYear;
        this.description = description;
        this.stock = stock;
    }
    
    // Getters and Setters
    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    
    @Override
    public String toString() {
        return String.format("%s - %s (%d) - $%.2f", title, genre, releaseYear, price);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieId, movie.movieId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(movieId);
    }
}
