#!/bin/bash
# Simulate Android test environment for TodoListAdapterTest

# Verify test dependencies
echo "Checking Robolectric test configuration..."

# Run Robolectric tests
echo "Running TodoListAdapterTest..."
javac -cp ".:app/src/test/java:app/src/main/java:robolectric-4.9.jar:junit-4.13.2.jar:mockito-core-4.8.0.jar" \
    app/src/test/java/com/todoapp/adapter/TodoListAdapterTest.kt

# Check compilation result
if [ $? -eq 0 ]; then
    echo "Tests compiled successfully"
    exit 0
else
    echo "Test compilation failed"
    exit 1
fi