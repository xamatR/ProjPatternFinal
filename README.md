﻿# Restaurant Design Patterns Project

This project demonstrates the integration of various GoF (Gang of Four) design patterns plus one extra pattern (Command) within the domain of a restaurant. The application covers order creation and management, dish preparation and customization, payment processing, notifications, and complaint handling, all using well-known and tested design patterns.

## Implemented Design Patterns

- **Singleton:** Ensures that only one instance of `RestaurantManager` is created.
- **Abstract Factory:** Creates orders for different types (Dine-In and Take-Away).
- **Factory Method:** Creates dishes (e.g., Pizza, Burger) in a flexible way.
- **Decorator:** Allows dynamic dish customization (e.g., adding extra cheese).
- **State:** Manages the order states (New, Preparing, Ready, Served, Cancelled) and their transitions.
- **Observer:** Notifies waiters when an order's state changes.
- **Strategy:** Encapsulates different payment algorithms (cash or credit card).
- **Template Method:** Defines a skeleton for the dish preparation algorithm, allowing variations.
- **Chain of Responsibility:** Processes customer complaints in a hierarchical manner.
- **Command (Extra):** Encapsulates order actions (placing or canceling) as command objects to be executed later.

## Prerequisites

- **Java 17** (or higher) must be installed on your machine.
- **JUnit 3.8.1** for running unit tests.
- (Optional) **Maven** or **Gradle** for project and dependency management.

## Project Structure

Each class is separated into its own file to facilitate maintenance and future enhancements. The main files include:

- `RestaurantManager.java` (Singleton)
- `Order.java`, `DineInOrder.java`, `TakeAwayOrder.java` (Abstract Factory)
- `DishCreator.java`, `PizzaCreator.java`, `BurgerCreator.java` (Factory Method)
- `DishDecorator.java`, `ExtraCheeseDecorator.java` (Decorator)
- `OrderState.java`, `NewOrderState.java`, `PreparingOrderState.java`, `ReadyOrderState.java`, `ServedOrderState.java`, `CancelledOrderState.java` (State)
- `OrderObserver.java`, `Waiter.java` (Observer)
- `PaymentStrategy.java`, `CashPayment.java`, `CreditCardPayment.java` (Strategy)
- `DishPreparationTemplate.java`, `PastaPreparation.java` (Template Method)
- `ComplaintHandler.java`, `ChefComplaintHandler.java`, `ManagerComplaintHandler.java` (Chain of Responsibility)
- `OrderCommand.java`, `PlaceOrderCommand.java`, `CancelOrderCommand.java`, `OrderInvoker.java` (Command)
- 
## How to Run the Project

### 1. Running Without Maven/Gradle

If you are not using Maven or Gradle, you can compile and run the files directly with `javac` and `java`:

```bash
# Compile all Java files (assuming they are in the same directory)
javac *.java

# Run the main class
java Main
```

# Running with Maven
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="Main"
```
#3. Running Unit Tests
The project includes unit tests written in JUnit 5 that cover state transitions as well as other design pattern functionalities.

Without Maven/Gradle:
Compile and run the tests using your preferred testing framework setup (ensuring the classpath is correctly set).

With Maven:

```bash
mvn test
```
With Gradle:

```bash
gradle test
```

# Class Diagram
![Class Diagram](Diagrama.jpg)


