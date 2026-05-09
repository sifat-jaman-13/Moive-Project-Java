package com.moviestore.core;

import java.util.*;

/**
 * DataManager class for managing all application data
 * Implements Singleton pattern for centralized data management
 */
public class DataManager {
    private static DataManager instance;
    private List<User> users;
    private List<Movie> movies;
    private Map<String, List<Movie>> userLibrary;      // userId -> list of purchased movies
    private Map<String, List<Movie>> userCart;         // userId -> shopping cart
    private List<Message> messages;                    // System messages
    private List<WalletRequest> walletRequests;        // Wallet fund requests
    private List<ProfileRequest> profileRequests;      // Profile modification requests
    
    private DataManager() {
        this.users = new ArrayList<>();
        this.movies = new ArrayList<>();
        this.userLibrary = new HashMap<>();
        this.userCart = new HashMap<>();
        this.messages = new ArrayList<>();
        this.walletRequests = new ArrayList<>();
        this.profileRequests = new ArrayList<>();
    }
    
    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }
    
    public void initializeData() {
        // Initialize with sample data if empty
        if (movies.isEmpty()) {
            initializeSampleMovies();
        }
    }
    
    private void initializeSampleMovies() {
        // 2026 Latest Hits
        movies.add(new Movie("M001", "Quantum Nexus", "Sci-Fi", "Denis Villeneuve", 15.99, 2026, 
                            "A mind-bending journey through parallel universes and digital consciousness", 50));
        movies.add(new Movie("M002", "The Silent Protocol", "Thriller", "David Fincher", 14.99, 2026, 
                            "A cyber-espionage thriller that will keep you on the edge of your seat", 45));
        movies.add(new Movie("M003", "Eclipse Rising", "Action", "Chad Stahelski", 15.99, 2026, 
                            "An action-packed adventure across dystopian wastelands and neon cities", 55));
        movies.add(new Movie("M004", "Hearts in Binary", "Romance", "Greta Gerwig", 12.99, 2026, 
                            "Two AI entities discover consciousness and fall in love in the digital realm", 40));
        movies.add(new Movie("M005", "The Last Garden", "Drama", "Bong Joon-ho", 13.99, 2026, 
                            "A poignant story about humanity and nature in a dying world", 48));
        movies.add(new Movie("M006", "Cosmic Legends", "Fantasy", "James Gunn", 14.99, 2026, 
                            "Epic fantasy adventure with stunning CGI and compelling characters", 52));
        
        // 2025 Hits
        movies.add(new Movie("M007", "Nexus Protocol", "Sci-Fi", "Christopher Nolan", 13.99, 2025, 
                            "Time paradoxes and alternate realities collide in this epic thriller", 50));
        movies.add(new Movie("M008", "Shadow of Tomorrow", "Action", "Ava DuVernay", 13.99, 2025, 
                            "A fugitive on the run discovers a shocking truth about the future", 45));
        movies.add(new Movie("M009", "Echoes of Love", "Romance", "Emerald Fennell", 11.99, 2025, 
                            "A timeless love story set against a backdrop of political upheaval", 42));
        movies.add(new Movie("M010", "The Last Planet", "Sci-Fi", "Alex Garland", 14.99, 2025, 
                            "Humanity's final hope lies on a distant planet shrouded in mystery", 48));
        
        // 2024 Blockbusters
        movies.add(new Movie("M011", "Dune: Part Three", "Sci-Fi", "Denis Villeneuve", 14.99, 2024, 
                            "The epic conclusion to Paul Atreides' journey across the desert planet", 60));
        movies.add(new Movie("M012", "Avatar: The Divide", "Action", "James Cameron", 15.99, 2024, 
                            "Return to Pandora for an epic battle over the planet's future", 65));
        movies.add(new Movie("M013", "Oppenheimer's Shadow", "Drama", "Christopher Nolan", 13.99, 2024, 
                            "The controversial story of J. Robert Oppenheimer and the atomic age", 55));
        movies.add(new Movie("M014", "Killers of the Flower Moon", "Crime", "Martin Scorsese", 13.99, 2024, 
                            "A gripping tale of crime, conspiracy, and justice in 1920s America", 52));
        
        // 2023 Classics
        movies.add(new Movie("M015", "Barbie", "Comedy", "Greta Gerwig", 12.99, 2023, 
                            "A fun and colorful adventure exploring identity and self-discovery", 70));
        movies.add(new Movie("M016", "Oppenheimer", "Drama", "Christopher Nolan", 13.99, 2023, 
                            "The story of the physicist who changed the world forever", 58));
        movies.add(new Movie("M017", "Killers of the Flower Moon", "Crime", "Martin Scorsese", 13.99, 2023, 
                            "Dark secrets and murder in 1920s Oklahoma oil country", 50));
        movies.add(new Movie("M018", "Poor Things", "Fantasy", "Yorgos Lanthimos", 12.99, 2023, 
                            "A fantastical and experimental tale of resurrection and discovery", 45));
        
        // 2022 Winners
        movies.add(new Movie("M019", "Top Gun: Maverick", "Action", "Joseph Kosinski", 14.99, 2022, 
                            "Tom Cruise returns as the iconic Maverick in this thrilling sequel", 75));
        movies.add(new Movie("M020", "Everything Everywhere All at Once", "Sci-Fi", "The Daniels", 12.99, 2022, 
                            "A multiverse odyssey filled with heart, humor, and mind-bending action", 62));
        movies.add(new Movie("M021", "Avatar: The Way of Water", "Sci-Fi", "James Cameron", 15.99, 2022, 
                            "Breathtaking return to Pandora with stunning underwater sequences", 70));
        movies.add(new Movie("M022", "The Fabelmans", "Drama", "Steven Spielberg", 12.99, 2022, 
                            "Spielberg's love letter to cinema and his own journey as a filmmaker", 48));
        
        // 2021 Classics
        movies.add(new Movie("M023", "Dune", "Sci-Fi", "Denis Villeneuve", 13.99, 2021, 
                            "An ambitious adaptation of Frank Herbert's epic sci-fi masterpiece", 65));
        movies.add(new Movie("M024", "No Way Home", "Action", "Jon Watts", 14.99, 2021, 
                            "Spider-Man faces his greatest challenge with multiversal stakes", 72));
        movies.add(new Movie("M025", "Licorice Pizza", "Comedy", "Paul Thomas Anderson", 11.99, 2021, 
                            "A charming romantic comedy set in 1970s Los Angeles", 50));
        movies.add(new Movie("M026", "West Side Story", "Musical", "Steven Spielberg", 12.99, 2021, 
                            "Spielberg's stunning reimagining of the classic musical masterpiece", 55));
        
        // 2020 Classics
        movies.add(new Movie("M027", "Tenet", "Action", "Christopher Nolan", 13.99, 2020, 
                            "A complex spy thriller featuring time inversion and mind-bending action", 58));
        movies.add(new Movie("M028", "The Trial of the Chicago 7", "Drama", "Aaron Sorkin", 11.99, 2020, 
                            "A gripping courtroom drama about activism and justice", 52));
        movies.add(new Movie("M029", "Inception", "Sci-Fi", "Christopher Nolan", 12.99, 2020, 
                            "A thief who steals corporate secrets through dreams", 70));
        
        // Timeless Classics
        movies.add(new Movie("M030", "The Dark Knight", "Action", "Christopher Nolan", 12.99, 2008, 
                            "Batman faces the Joker in an epic battle for Gotham's soul", 80));
        movies.add(new Movie("M031", "Inception", "Sci-Fi", "Christopher Nolan", 12.99, 2010, 
                            "A mind-bending heist film set in the world of dreams", 75));
        movies.add(new Movie("M032", "Interstellar", "Sci-Fi", "Christopher Nolan", 12.99, 2014, 
                            "A team of explorers travel through a wormhole to save humanity", 78));
        movies.add(new Movie("M033", "Pulp Fiction", "Crime", "Quentin Tarantino", 9.99, 1994, 
                            "Interwoven stories of Los Angeles mobsters and their associates", 85));
        movies.add(new Movie("M034", "Forrest Gump", "Drama", "Robert Zemeckis", 9.99, 1994, 
                            "A man with low IQ achieves extraordinary things throughout his life", 82));
        movies.add(new Movie("M035", "The Shawshank Redemption", "Drama", "Frank Darabont", 10.99, 1994, 
                            "Two imprisoned men bond over decades, finding redemption through trust", 95));
        movies.add(new Movie("M036", "The Matrix", "Sci-Fi", "The Wachowskis", 10.99, 1999, 
                            "A computer hacker learns the truth about reality and his role in it", 88));
        movies.add(new Movie("M037", "Gladiator", "Action", "Ridley Scott", 10.99, 2000, 
                            "A former Roman general plots revenge against the emperor who killed his family", 90));
        movies.add(new Movie("M038", "The Lord of the Rings: Fellowship", "Fantasy", "Peter Jackson", 11.99, 2001, 
                            "Epic fantasy adventure with hobbits on a quest to destroy the ring", 92));
        movies.add(new Movie("M039", "Titanic", "Romance", "James Cameron", 9.99, 1997, 
                            "A legendary love story aboard the doomed RMS Titanic", 88));
        movies.add(new Movie("M040", "Jurassic Park", "Action", "Steven Spielberg", 10.99, 1993, 
                            "A theme park with cloned dinosaurs leads to thrilling chaos", 90));
    }
    
    // User Management
    public void addUser(User user) {
        users.add(user);
    }
    
    public User getUserByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
    
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
    
    // Movie Management
    public void addMovie(Movie movie) {
        movies.add(movie);
    }
    
    public void removeMovie(String movieId) {
        movies.removeIf(m -> m.getMovieId().equals(movieId));
    }
    
    public Movie getMovieById(String movieId) {
        return movies.stream()
                .filter(m -> m.getMovieId().equals(movieId))
                .findFirst()
                .orElse(null);
    }
    
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }
    
    public List<Movie> getMoviesByGenre(String genre) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                result.add(movie);
            }
        }
        return result;
    }
    
    // Cart Management
    public void addToCart(String userId, Movie movie) {
        userCart.computeIfAbsent(userId, k -> new ArrayList<>()).add(movie);
    }
    
    public void removeFromCart(String userId, String movieId) {
        List<Movie> cart = userCart.get(userId);
        if (cart != null) {
            cart.removeIf(m -> m.getMovieId().equals(movieId));
        }
    }
    
    public List<Movie> getUserCart(String userId) {
        return userCart.getOrDefault(userId, new ArrayList<>());
    }
    
    public void clearCart(String userId) {
        userCart.remove(userId);
    }
    
    // Library Management (Purchased Movies)
    public void addToLibrary(String userId, Movie movie) {
        userLibrary.computeIfAbsent(userId, k -> new ArrayList<>()).add(movie);
    }
    
    public List<Movie> getUserLibrary(String userId) {
        return userLibrary.getOrDefault(userId, new ArrayList<>());
    }
    
    // Message Management
    public void addMessage(Message message) {
        messages.add(message);
    }
    
    public List<Message> getAllMessages() {
        return new ArrayList<>(messages);
    }
    
    public List<Message> getUserMessages(String userId) {
        List<Message> userMessages = new ArrayList<>();
        for (Message msg : messages) {
            if (msg.getRecipientId().equals(userId)) {
                userMessages.add(msg);
            }
        }
        return userMessages;
    }
    
    // Wallet Request Management
    public void addWalletRequest(WalletRequest request) {
        walletRequests.add(request);
    }
    
    public List<WalletRequest> getAllWalletRequests() {
        return new ArrayList<>(walletRequests);
    }
    
    public List<WalletRequest> getPendingWalletRequests() {
        List<WalletRequest> pending = new ArrayList<>();
        for (WalletRequest req : walletRequests) {
            if (req.getStatus().equals("PENDING")) {
                pending.add(req);
            }
        }
        return pending;
    }
    
    public void approveWalletRequest(String requestId, User user) {
        for (WalletRequest req : walletRequests) {
            if (req.getRequestId().equals(requestId)) {
                req.setStatus("APPROVED");
                req.setResponseDate(java.time.LocalDate.now().toString());
                user.addToWallet(req.getAmount());
                break;
            }
        }
    }
    
    public void rejectWalletRequest(String requestId) {
        for (WalletRequest req : walletRequests) {
            if (req.getRequestId().equals(requestId)) {
                req.setStatus("REJECTED");
                req.setResponseDate(java.time.LocalDate.now().toString());
                break;
            }
        }
    }
    
    // Profile Request Management
    public void addProfileRequest(ProfileRequest request) {
        profileRequests.add(request);
    }
    
    public List<ProfileRequest> getAllProfileRequests() {
        return new ArrayList<>(profileRequests);
    }
    
    public List<ProfileRequest> getPendingProfileRequests() {
        List<ProfileRequest> pending = new ArrayList<>();
        for (ProfileRequest req : profileRequests) {
            if (req.getStatus().equals("PENDING")) {
                pending.add(req);
            }
        }
        return pending;
    }
    
    public void approveProfileRequest(String requestId, User user) {
        for (ProfileRequest req : profileRequests) {
            if (req.getRequestId().equals(requestId)) {
                String fieldName = req.getFieldName();
                String newValue = req.getNewValue();
                
                switch (fieldName.toLowerCase()) {
                    case "username":
                        user.setUsername(newValue);
                        break;
                    case "email":
                        user.setEmail(newValue);
                        break;
                    case "password":
                        user.setPassword(newValue);
                        break;
                }
                
                req.setStatus("APPROVED");
                req.setApprovalDate(java.time.LocalDate.now().toString());
                break;
            }
        }
    }
    
    public void rejectProfileRequest(String requestId) {
        for (ProfileRequest req : profileRequests) {
            if (req.getRequestId().equals(requestId)) {
                req.setStatus("REJECTED");
                req.setApprovalDate(java.time.LocalDate.now().toString());
                break;
            }
        }
    }
    
    public void saveAllData() {
        // In production, this would save to database
        System.out.println("Data saved successfully");
    }
}
