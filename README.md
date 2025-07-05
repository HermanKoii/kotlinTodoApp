# Kotlin Todo App

## Project Overview
A simple Todo application built with Kotlin, demonstrating Android development best practices.

## Testing Strategy
The project includes multiple layers of testing:

### Unit Tests
- Located in `app/src/test`
- Test ViewModel logic and data transformations
- Use Mockito for mocking dependencies
- Utilize Kotlin Coroutines test utilities

### Instrumentation Tests
- Located in `app/src/androidTest`
- Test UI components and interactions
- Use Espresso for UI testing
- Verify activity behaviors and user flows

### Test Coverage
- ViewModel unit tests
- Activity UI tests
- Input validation tests
- Basic functionality verification

## Running Tests
### Unit Tests
```bash
./gradlew test
```

### Instrumentation Tests
```bash
./gradlew connectedAndroidTest
```

## Dependencies
- Android Jetpack
- Kotlin Coroutines
- Room Database
- JUnit
- Mockito
- Espresso