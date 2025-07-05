#!/bin/bash
# Attempt to run Kotlin tests

# Ensure Gradle wrapper is executable
chmod +x ./gradlew

# Run tests
./gradlew test