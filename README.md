# Cucumber Selenium Automation

[![UI Automation Tests](https://github.com/TetianaDoc/selenium-automation-cucumber.io/actions/workflows/ci.yml/badge.svg)](https://github.com/TetianaDoc/selenium-automation-cucumber.io/actions/workflows/ci.yml)

A UI test automation framework built with **Java 17**, **Selenium WebDriver 4**, **Cucumber 7 (BDD)**, **JUnit 4**, and **AssertJ** following the **Page Object** and **Action** design patterns.

---

## Tech Stack

| Tool / Library | Version | Purpose |
| :--- | :--- | :--- |
| **Java** | 17+ | Programming language |
| **Maven** | 3.8+ | Build & dependency management |
| **Selenium Java** | 4.25.0 | Browser automation & built-in Selenium Manager |
| **Cucumber (Java & JUnit)** | 7.18.1 | BDD test specification & execution |
| **AssertJ Core** | 3.26.3 | Fluent test assertions |

---

## Project Structure

```text
cucumber-selenium-automation
├── pom.xml
├── README.md
└── src
    ├── main/java/com/junit
    │   ├── actions
    │   │   ├── BaseAction.java       # Shared WebDriver / WebDriverWait helpers
    │   │   ├── DocsAction.java       # Actions on the Cucumber documentation pages
    │   │   └── HomeAction.java       # Actions on the Cucumber home page & navigation
    │   ├── driver
    │   │   └── DriverManager.java    # ChromeDriver initialization & lifecycle management
    │   └── pages
    │       ├── BasePage.java         # PageFactory initialization base class
    │       ├── DocsPage.java         # Locators for documentation pages
    │       └── HomePage.java         # Locators & elements for the home page
    └── test
        ├── java/com/junit
        │   ├── hooks
        │   │   ├── DriverHooks.java      # Quits WebDriver after each scenario
        │   │   └── ScreenshotHook.java   # Attaches PNG screenshot after each scenario
        │   ├── runner
        │   │   └── TestRunner.java       # Cucumber JUnit test runner
        │   └── steps
        │       └── MenuSteps.java        # Step definitions for navigation scenarios
        └── resources/com/junit/features
            └── MenuSections.feature      # Gherkin feature specifications
```

---

## Prerequisites

- **JDK 17** or newer installed (`java -version`)
- **Apache Maven 3.8+** installed (`mvn -version`)
- **Google Chrome** installed (ChromeDriver is automatically resolved by Selenium Manager)

---

## Running Tests

### Run all `@smoke` tests (headed browser)
```bash
mvn clean test
```

### Run tests in headless mode
```bash
mvn clean test -Dheadless=true
```

### Run tests with custom Cucumber tags
```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

---

## Test Reports

After test execution, an HTML Cucumber report (including attached scenario screenshots) is generated at:
```text
target/cucumber-reports/cucumber.html
```
