# Todo App - Kotlin Test Suite

## Testing Approach

This project uses a custom test runner script (`test_runner.kts`) to validate the Todo model's functionality.

### Test Coverage

The test script covers the following scenarios:
- Creating a todo with minimal data
- Creating a todo with all optional properties
- Toggling todo completion status
- Validating title constraints
  - Non-empty title
  - Maximum title length (100 characters)
- Validating description constraints
  - Optional description
  - Maximum description length (500 characters)
- Validating due date constraints
  - Due date must be in the future

### Running Tests

To run tests, execute the `test_runner.kts` script:

```bash
kotlinc -script test_runner.kts
```

### Note

This approach provides a lightweight, script-based testing mechanism that can be easily integrated into CI/CD pipelines.