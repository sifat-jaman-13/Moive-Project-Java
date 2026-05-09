ScarZero Movie Store (Java) - Windows Setup Guide
==================================================

This guide will help you run the ScarZero Movie Store Java application on Windows.

Prerequisites
=============
- Java 17 or higher
- Maven 3.6 or higher
- Git (optional, for cloning)

Installation Steps
==================

1. Install Java 17+ (if not already installed)
   - Download from: https://jdk.java.net/21/
   - Or use: https://adoptium.net/
   - Follow the installation wizard
   - Add Java to PATH (usually automatic)

2. Install Maven (if not already installed)
   - Download from: https://maven.apache.org/download.cgi
   - Extract to a folder (e.g., C:\tools\maven)
   - Add Maven bin folder to PATH
   - Or download using a package manager:
     * Chocolatey: choco install maven
     * Scoop: scoop install maven

3. Verify Installation
   Open Command Prompt and run:
   ```
   java -version
   mvn -version
   ```

Building and Running
====================

Option 1: Using Maven to Run (Recommended)
   1. Open Command Prompt
   2. Navigate to project directory:
      cd path\to\Movie Store With Java
   
   3. Build and run:
      mvn clean javafx:run

Option 2: Build JAR and Run
   1. Open Command Prompt
   2. Navigate to project directory:
      cd path\to\Movie Store With Java
   
   3. Build the JAR:
      mvn clean package
   
   4. Run the JAR:
      java -jar target\MovieStore.jar

Project Structure
=================
src/main/java/com/moviestore/
├── MovieStoreApp.java           - Main application class
├── auth/                        - Authentication modules
├── core/                        - Core classes (Movie, User, DataManager)
├── ui/                          - JavaFX UI components
│   ├── LoginView.java
│   ├── RegisterView.java
│   ├── AdminLoginView.java
│   ├── UserDashboardView.java
│   ├── CartView.java
│   ├── LibraryView.java
│   └── AdminDashboardView.java
└── resources/                   - Configuration files

Default Credentials
===================
Admin Login:
  Username: admin
  Password: admin123

Troubleshooting
===============

1. "Java not found"
   - Ensure Java is installed and added to PATH
   - Restart Command Prompt after installation
   - Run: java -version to verify

2. "Maven not found"
   - Ensure Maven is installed and added to PATH
   - Restart Command Prompt after installation
   - Run: mvn -version to verify

3. Build fails with "Invalid source release"
   - Ensure you have Java 17 or higher installed
   - Check Maven's settings.xml for Java version configuration

4. GUI doesn't start
   - Make sure you're not running in headless mode
   - Try running with: mvn javafx:run

5. OutOfMemoryError
   - Increase heap size:
     java -Xmx1024m -jar target\MovieStore.jar

Quick Reference
===============

Build only:
  mvn clean compile

Build with tests:
  mvn clean test

Create executable JAR:
  mvn clean package

Run the application:
  mvn javafx:run

Clean build artifacts:
  mvn clean

Additional Resources
====================
- Maven Documentation: https://maven.apache.org/
- JavaFX Documentation: https://openjfx.io/
- Java Documentation: https://docs.oracle.com/en/java/

For more information, see README.md
