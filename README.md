# Java Interest Engine 🚀

A professional-grade financial calculation engine built with **Java 17** and **Maven**.

## 🧠 Why this project stands out
Unlike basic "calculator" scripts, this project is built using professional software engineering principles:

1.  **Separation of Concerns (MVC)**: The calculation logic is completely decoupled from the GUI. This allows the math service to be reused in any environment (Web, CLI, or Mobile).
2.  **Unit Testing (TDD)**: Comprehensive test suite using **JUnit 5** to ensure mathematical accuracy and handle edge cases (negative values, zero interest).
3.  **Modern Build System**: Managed by **Maven**, making it easy to build, test, and package the application across any environment.
4.  **Robust Error Handling**: Implements defensive programming to prevent crashes from invalid user inputs.

## 🛠 Tech Stack
*   **Language:** Java 17
*   **Build Tool:** Maven
*   **Testing:** JUnit 5
*   **GUI:** Swing (Refactored for View-Service pattern)

## 🏗 Project Structure
```
src/
 ├── main/java/com/brian/interest/
 │    ├── service/        <-- Pure logic (Service Layer)
 │    └── gui/            <-- UI components (View Layer)
 └── test/java/com/brian/interest/service/  <-- Unit Tests
```

## 🚀 How to Run

### Prerequisities
*   JDK 17 or higher
*   Maven

### Build & Test
```bash
mvn clean test
```

### Run Application
```bash
mvn compile exec:java -Dexec.mainClass="com.brian.interest.gui.MainFrame"
```

---
*Created by Brian Munashe Mbawa as part of a technical portfolio upgrade.*
