#!/bin/bash
# Attempt to run Kotlin tests

# Ensure the script is executable
chmod +x run_tests.sh

# Set up Kotlin compilation
kotlinc -cp src/main/kotlin:src/test/kotlin:$(find /usr/share/gradle/lib -name "*.jar" | tr '\n' ':') \
    src/main/kotlin/com/todoapp/model/Todo.kt \
    src/test/kotlin/com/todoapp/model/TodoTest.kt \
    -d test_classes

# Run tests
java -cp test_classes:$(find /usr/share/gradle/lib -name "*.jar" | tr '\n' ':') \
    org.junit.platform.console.ConsoleLauncher \
    --select-package com.todoapp.model