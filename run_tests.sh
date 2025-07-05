#!/bin/bash
set -e

echo "Running Kotlin tests for Todo App"

# Simulate Gradle test command
./gradlew test

echo "Tests completed successfully!"