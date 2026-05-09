#!/bin/bash

# ScarZero Movie Store - Linux Setup Script
# This script sets up the Java Maven project for Linux systems

echo "🐧 ScarZero Movie Store (Java) - Linux Setup"
echo "=============================================="

# Check if Java is installed
echo "📦 Checking Java installation..."
if ! command -v java &> /dev/null; then
    echo "❌ Java is not installed. Please install Java 17 or higher."
    echo "   Ubuntu/Debian: sudo apt-get install openjdk-17-jdk"
    echo "   Fedora: sudo dnf install java-17-openjdk-devel"
    exit 1
fi

java -version

# Check if Maven is installed
echo ""
echo "📦 Checking Maven installation..."
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven is not installed. Please install Maven 3.6 or higher."
    echo "   Ubuntu/Debian: sudo apt-get install maven"
    echo "   Fedora: sudo dnf install maven"
    exit 1
fi

mvn -version

# Build the project
echo ""
echo "🔨 Building project with Maven..."
mvn clean package

if [ $? -eq 0 ]; then
    echo ""
    echo "✨ Build successful!"
    echo ""
    echo "🚀 To run the application:"
    echo "   mvn javafx:run"
    echo ""
    echo "Or use the JAR file:"
    echo "   java -jar target/MovieStore.jar"
else
    echo "❌ Build failed"
    exit 1
fi
