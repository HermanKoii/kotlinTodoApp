#!/bin/bash
set -e

# Ensure Gradle wrapper exists and is executable
if [ ! -f ./gradlew ]; then
    echo "Gradle wrapper not found. Creating one..."
    gradle wrapper
fi

# Make Gradle wrapper executable
chmod +x ./gradlew

# Run tests with Gradle
./gradlew test