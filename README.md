# 🎬 ScarZero Movie Store (Java Edition)

> A comprehensive movie store management system with separate user and admin interfaces built with Java and JavaFX.

## 🔗 Quick Links
[![Java](https://img.shields.io/badge/Java-Official%20Site-ED8B00?logo=java&logoColor=white)](https://www.java.com/)
[![JavaFX](https://img.shields.io/badge/JavaFX-Official%20Site-0078D4?logo=oracle&logoColor=white)](https://gluonhq.com/products/javafx/)
[![Maven](https://img.shields.io/badge/Maven-Official%20Site-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![NSU](https://img.shields.io/badge/NSU-North%20South%20University-1E90FF?logo=graduation-cap&logoColor=white)](https://www.northsouth.edu/)
[![GitHub](https://img.shields.io/badge/GitHub-Repository-333333?logo=github)](https://github.com/sifat-jaman-13/Moive-Project-Java)

[![Java Version](https://img.shields.io/badge/java-17%2B-orange)](https://www.oracle.com/java/technologies/downloads/)
[![Framework](https://img.shields.io/badge/framework-JavaFX%2021-blue)](https://gluonhq.com/products/javafx/)
[![Build Tool](https://img.shields.io/badge/build-Maven-red)](https://maven.apache.org/)
[![Platform](https://img.shields.io/badge/platform-windows%20%7C%20linux%20%7C%20macos-green)](#-quick-start)
[![License](https://img.shields.io/badge/license-proprietary-blue)](#-license)

---

## 📚 Project Information

**Author:** Sifat Jaman  
**Course:** CSE101 - Object-Oriented Programming Project  
**Institution:** North South University  
**Type:** Solo Project  
**Status:** ✅ Development Complete  
**Language:** Java 17+ with JavaFX 21

---

## 🎯 Project Overview

ScarZero Movie Store is a Java-based movie store management system following the same architecture as the Python Game Store. It demonstrates advanced OOP concepts with modern Java features and professional GUI development using JavaFX.

### ✨ Key Features

#### User Features
- 🔐 User Registration & Login
- 🎬 Browse Movie Catalog
- 🛒 Shopping Cart Management
- 💳 Wallet System
- 📚 Movie Library (Purchased Movies)
- 💬 Messaging System (Framework ready)
- 👤 User Profile Management

#### Admin Features
- 🔐 Secure Admin Login (with attempt limiting)
- 🎬 Add/Edit/Delete Movies
- 👥 Manage Users
- 📊 Movie Categories Management
- 💰 Handle Wallet Requests
- 💬 View Messages
- 📈 System Statistics

### Architecture Highlights
- ✅ **OOP Principles**: Encapsulation, Inheritance, Polymorphism
- ✅ **Design Patterns**: Singleton (DataManager), MVC (Views & Controllers)
- ✅ **Modern Java**: Java 17+ features, Lambdas, Streams
- ✅ **Professional GUI**: JavaFX with Scene Builder compatibility
- ✅ **Cross-Platform**: Runs on Windows, Linux, macOS
- ✅ **Maven Build**: Professional dependency management

---

## 📋 Requirements

### System Requirements
- **OS:** Windows 10+, Linux (Ubuntu 20.04+, Fedora 33+), macOS 10.13+
- **Java:** JDK 17 or higher
- **Maven:** 3.6 or higher
- **RAM:** 1 GB minimum
- **Disk Space:** 200 MB (with Maven cache)

### Check Your Installation
```bash
java -version      # Should show Java 17+
mvn -version       # Should show Maven 3.6+
```

---

## 🚀 Quick Start

### Windows Setup

#### Option 1: Using Maven (Recommended)
```bash
# Navigate to project directory
cd "path\to\Movie Store With Java"

# Build and run
mvn clean javafx:run
```

#### Option 2: Build JAR
```bash
# Build the project
mvn clean package

# Run the JAR
java -jar target\MovieStore.jar
```

#### Option 3: Using IDE
1. Open in IntelliJ IDEA or Eclipse
2. Mark `src\main\java` as Sources Root
3. Run `MovieStoreApp.java` main class

### Linux Setup

#### Option 1: Automated Setup (Recommended)
```bash
# Navigate to project directory
cd path/to/Movie\ Store\ With\ Java

# Make script executable
chmod +x setup_linux.sh

# Run setup
./setup_linux.sh
```

#### Option 2: Manual Setup
```bash
# Navigate to project directory
cd path/to/Movie\ Store\ With\ Java

# Build and run
mvn clean javafx:run
```

### macOS Setup
```bash
# Same as Linux
chmod +x setup_linux.sh
./setup_linux.sh

# Or directly:
mvn clean javafx:run
```

---

## 🎮 Running the Application

### Start the Application
```bash
mvn clean javafx:run
```

### Login Screen
You'll see the login view with three options:
1. **User Login** - Log in with existing account
2. **Register** - Create new user account
3. **Admin Login** - Access admin console

### Admin Credentials
```
Username: Sifat
Password: sifat
```

⚠️ **Note:** Admin login has 5-attempt limit for security.

### Default Test User
After registering, you can create your own account and start using the store.

---

## 📁 Project Structure

```
Movie Store With Java/
├── pom.xml                          # Maven configuration
├── src/
│   ├── main/
│   │   ├── java/com/moviestore/
│   │   │   ├── MovieStoreApp.java        # Main entry point
│   │   │   ├── core/
│   │   │   │   ├── Movie.java            # Movie model
│   │   │   │   ├── User.java             # User model
│   │   │   │   └── DataManager.java      # Data management (Singleton)
│   │   │   ├── auth/                     # Authentication modules
│   │   │   │   ├── LoginView.java
│   │   │   │   ├── RegisterView.java
│   │   │   │   └── AdminLoginView.java
│   │   │   └── ui/                       # JavaFX UI Views
│   │   │       ├── UserDashboardView.java
│   │   │       ├── CartView.java
│   │   │       ├── LibraryView.java
│   │   │       └── AdminDashboardView.java
│   │   └── resources/                    # Configuration files
│   └── test/java/                        # Unit tests
├── target/                              # Build output
├── README.md                            # This file
├── WINDOWS_SETUP.md                     # Windows setup guide
├── setup_linux.sh                       # Linux setup script
└── LICENSE                              # Proprietary license
```

---

## 🛠️ Maven Commands Reference

### Build Commands
```bash
# Clean compile
mvn clean compile

# Build with tests
mvn clean test

# Package into JAR
mvn clean package

# Skip tests during build
mvn clean package -DskipTests
```

### Run Commands
```bash
# Run with JavaFX plugin
mvn javafx:run

# Run JAR file
java -jar target/MovieStore.jar

# Run with custom heap size
java -Xmx1024m -jar target/MovieStore.jar
```

### Maven Options
```bash
# Verbose output
mvn clean javafx:run -X

# Offline mode
mvn clean javafx:run -o

# Skip tests
mvn clean javafx:run -DskipTests
```

---

## 🔐 Default Credentials

### Admin Panel
```
Username: admin
Password: admin123
```

### User Store
Create an account when you run the application for the first time.

---

## 🏗️ Project Architecture

### Design Patterns Used

1. **Singleton Pattern** (DataManager)
   - Centralized data management
   - Single instance across application

2. **MVC Pattern**
   - Views: JavaFX UI components
   - Controllers: Logic in View classes
   - Models: Movie, User classes

3. **Factory Pattern**
   - Creating Movie and User objects
   - Dynamic view instantiation

### Key Classes

#### Core Models
- `Movie.java` - Represents a movie with properties and methods
- `User.java` - Represents a user account with wallet management
- `DataManager.java` - Singleton managing all application data

#### UI Views
- `LoginView.java` - Authentication interface
- `RegisterView.java` - User registration form
- `UserDashboardView.java` - Main user interface
- `CartView.java` - Shopping cart management
- `LibraryView.java` - User's purchased movies
- `AdminDashboardView.java` - Admin management console
- `AdminLoginView.java` - Admin authentication

---

## 🐛 Troubleshooting

### Issue: Java not found
**Solution:**
```bash
# Install Java 17+
# Windows: Download from https://adoptium.net/
# Linux: sudo apt-get install openjdk-17-jdk
# macOS: brew install openjdk@17
```

### Issue: Maven not found
**Solution:**
```bash
# Install Maven
# Windows: choco install maven
# Linux: sudo apt-get install maven
# macOS: brew install maven
```

### Issue: "Invalid source release"
**Solution:**
- Ensure Java 17+ is installed
- Set JAVA_HOME environment variable
- Check Maven settings.xml

### Issue: GUI doesn't appear
**Solution:**
```bash
# Make sure X11 or Wayland is available (Linux)
# Try running with:
mvn javafx:run -X
```

### Issue: Build fails with dependency errors
**Solution:**
```bash
# Update Maven cache
mvn clean install

# Or skip tests:
mvn clean package -DskipTests
```

### Issue: Port already in use (if running server)
**Solution:**
```bash
# Kill process on port (if applicable)
# Windows: netstat -ano | findstr :8080
# Linux: lsof -i :8080
```

---

## 📊 Sample Data

The application comes pre-loaded with sample movies:

1. **Inception** (2010) - $12.99
   - Director: Christopher Nolan
   - Genre: Sci-Fi

2. **The Dark Knight** (2008) - $14.99
   - Director: Christopher Nolan
   - Genre: Action

3. **Interstellar** (2014) - $14.99
   - Director: Christopher Nolan
   - Genre: Sci-Fi

4. **Pulp Fiction** (1994) - $9.99
   - Director: Quentin Tarantino
   - Genre: Crime

5. **Forrest Gump** (1994) - $9.99
   - Director: Robert Zemeckis
   - Genre: Drama

---

## 🧪 Testing

### Unit Tests
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=MovieTest

# Skip tests during build
mvn package -DskipTests
```

### Manual Testing Checklist
- [ ] User registration works
- [ ] Login with valid credentials succeeds
- [ ] Admin login has attempt limit
- [ ] Add movies to cart
- [ ] Checkout deducts from wallet
- [ ] Movies appear in library after purchase
- [ ] Admin can add movies
- [ ] Admin can view users

---

## 📈 Performance Considerations

- **Startup Time:** ~3-5 seconds (first run may be slower)
- **Memory Usage:** ~200-300 MB heap
- **UI Responsiveness:** Smooth with sample data
- **Data Operations:** In-memory for demo (no database)

### Optimization Tips
```bash
# Reduce heap size for lower-end systems
java -Xmx512m -jar target/MovieStore.jar

# Use headless mode if no GUI needed
java -Djava.awt.headless=true ...
```

---

## 🎓 Learning Outcomes

This project demonstrates:

- ✅ **Advanced OOP**: Encapsulation, inheritance, polymorphism
- ✅ **Design Patterns**: Singleton, MVC, Factory
- ✅ **Java Streams**: Functional programming with Stream API
- ✅ **Lambda Expressions**: Modern Java syntax
- ✅ **JavaFX**: Modern GUI framework
- ✅ **Maven**: Professional build and dependency management
- ✅ **Software Architecture**: Modular, maintainable code
- ✅ **Exception Handling**: Robust error management
- ✅ **Collections Framework**: Efficient data structures

---

## 🔄 Comparison: Python vs Java Version

| Aspect | Python (Game Store) | Java (Movie Store) |
|--------|---------------------|------------------|
| GUI Framework | customtkinter | JavaFX |
| Build Tool | pip/uv | Maven |
| Data Persistence | Text files | In-memory (extensible) |
| Concurrency | asyncio ready | Thread-safe |
| Type System | Dynamic | Static (strong typing) |
| IDE Support | VS Code, PyCharm | IntelliJ IDEA, Eclipse |
| Performance | Interpreted | Compiled/JIT |
| Deploy | Virtual env | JAR/Docker |

---

## 📜 License

**⚠️ PROPRIETARY LICENSE - ALL RIGHTS RESERVED**

This project is the exclusive intellectual property of **Sifat Jaman**.

### Usage Terms:
- ✅ **Allowed:** View for educational purposes, fork for study
- ❌ **NOT Allowed:** Commercial use, modification, distribution without permission

**To request permission:** Contact Sifat Jaman via GitHub

See LICENSE file for complete terms.

---

## 🚀 Next Steps

1. **Run the Application**
   ```bash
   mvn clean javafx:run
   ```

2. **Create Admin Account**
   - Login with admin/admin123

3. **Add Movies**
   - Use Admin Console to add more movies

4. **Create User Account**
   - Register new account

5. **Buy Movies**
   - Browse, add to cart, checkout

6. **Explore Features**
   - View library, manage cart, update wallet

---

## 📞 Support & Contact

**Author:** Sifat Jaman  
**Institution:** North South University  
**Course:** CSE101 - Object-Oriented Programming  
**Project Type:** Solo Assignment

For questions or issues:
1. Check WINDOWS_SETUP.md for Windows-specific help
2. Check setup_linux.sh for Linux/macOS help
3. Review troubleshooting section above

---

## 🎉 Quick Commands

### Windows
```bash
# Setup
mvn clean javafx:run

# Build JAR
mvn clean package

# Run JAR
java -jar target\MovieStore.jar
```

### Linux/macOS
```bash
# Automated setup
chmod +x setup_linux.sh && ./setup_linux.sh

# Or manual
mvn clean javafx:run
```

---

## ✅ Verification Checklist

Before reporting issues, verify:
- [ ] Java 17+ installed: `java -version`
- [ ] Maven installed: `mvn -version`
- [ ] Project files present
- [ ] Running from project root directory
- [ ] No ports conflicting
- [ ] Sufficient disk space (~500 MB)

---

**Thank you for using ScarZero Movie Store (Java Edition)!** 🎬

*Last Updated: May 8, 2026*  
*Version: 1.0.0 - Development Complete*
