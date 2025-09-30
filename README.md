# Kavin_Malar_EI_Project
### EXP_1


# Robot Controller – Command Design Pattern

## Project Description

This project demonstrates a **Robot Controller** implemented using the **Command Design Pattern**. The program provides a command-line interface (CLI) where users can:

* Move the robot forward or backward.
* Turn the robot left or right.
* Pick up or place an object.
* Undo the last executed command.
* Exit the application.

The Command pattern ensures that each action is encapsulated as a separate command object, decoupling the **invoker** from the **receiver**, while providing undo functionality and maintainable, extensible code.

## Purpose / Use Case

The Robot Controller is useful in scenarios like:

* Simulating robot movements and actions in a controlled environment.
* Teaching or demonstrating the Command Design Pattern in CLI-based applications.
* Supporting undoable actions and command history tracking.
* Providing robust logging, input validation, and exception handling for safe user interactions.
* Creating an extensible system where new robot commands can be added easily.

## Design Pattern

The **Command pattern** is used to encapsulate robot actions:

* **Command (Interface)**: Declares `execute()` and `undo()` methods.
* **Concrete Commands**: `MoveForwardCommand`, `MoveBackwardCommand`, `TurnLeftCommand`, `TurnRightCommand`, `PickPlaceCommand`.
* **Receiver (Robot)**: Performs the actual actions, maintains state (`x`, `y`, direction).
* **Invoker (RobotControllerInvoker)**: Executes commands and maintains a history for undo functionality.
* **Utils**: Provides logging (`LoggerUtil`) and input validation (`InputValidator`) for robust interactions.
* **Main**: CLI interface for interacting with the user.

## Sample Run

```
[2025-09-29T20:15:00] INFO: Robot Controller Started

=== Robot Controller Menu ===
1. Move Forward
2. Move Backward
3. Turn Left
4. Turn Right
5. Pick/Place Object
6. Undo Last Command
7. Exit
Enter choice: 1
[2025-09-29T20:15:05] INFO: Robot moved forward to position: (0,1) facing NORTH

=== Robot Controller Menu ===
1. Move Forward
2. Move Backward
3. Turn Left
4. Turn Right
5. Pick/Place Object
6. Undo Last Command
7. Exit
Enter choice: 7
[2025-09-29T20:15:20] INFO: Exiting Robot Controller
```


# Traffic Signal Monitoring System – Observer Design Pattern

## Project Description

This project demonstrates a **Traffic Signal Monitoring System** implemented using the **Observer Design Pattern**. The program provides a command-line interface (CLI) where users can:

* Change the traffic signal state (`RED`, `YELLOW`, `GREEN`).
* Dynamically attach or detach observers such as Traffic Police, Pedestrians, and Vehicles.
* Notify all registered observers automatically whenever the signal changes.
* Exit the application gracefully.

The Observer pattern ensures that when the **Traffic Signal (Subject)** changes, all dependent **Observers** (e.g., Vehicles, Pedestrians) are updated automatically, without the subject knowing their exact implementation details.

---

## Purpose / Use Case

The Traffic Signal Monitoring System is useful in scenarios like:

* Simulating real-world traffic signal behavior for vehicles and pedestrians.
* Demonstrating how multiple stakeholders (police, pedestrians, vehicles) respond differently to the same event.
* Teaching or illustrating the Observer Design Pattern in a CLI-based program.
* Supporting extensibility by allowing new observers (e.g., Emergency Services) to be added easily without modifying the signal logic.
* Providing robust input validation, exception handling, and logging for safe long-running operation.

## Design Pattern

The **Observer Pattern** is used to decouple the traffic signal (subject) from its dependents:

* **Subject (TrafficSignal)**: Maintains the current signal state and a set of observers. Notifies observers on every state change.
* **Observer (Interface)**: Declares the `update(TrafficSignalState state)` method.
* **Concrete Observers**:

  * `TrafficPoliceObserver` – Logs all signal changes for monitoring.
  * `VehicleObserver` – Responds by moving on GREEN, stopping on RED, and preparing on YELLOW.
  * `PedestrianObserver` – Responds by crossing on RED and waiting otherwise.
* **Utils**:

  * `LoggerUtil` – Centralized logging system.
  * `InputValidator` – Validates menu inputs.
* **Exceptions**: Custom exceptions for invalid input and observer handling.
* **Main**: CLI for interacting with the user to change signals and manage the system.

## Sample Run

```
[2025-09-30T15:05:00] INFO: Starting Traffic Signal Monitoring System...

=== Traffic Signal Menu ===
1. Change Signal to RED
2. Change Signal to YELLOW
3. Change Signal to GREEN
4. Exit
Enter choice: 1
[2025-09-30T15:05:10] INFO: Signal changed to: RED
[2025-09-30T15:05:10] INFO: Traffic Police notified: Signal is RED
[2025-09-30T15:05:10] INFO: Vehicles: Stop immediately!
[2025-09-30T15:05:10] INFO: Pedestrians: Safe to cross now!

=== Traffic Signal Menu ===
1. Change Signal to RED
2. Change Signal to YELLOW
3. Change Signal to GREEN
4. Exit
Enter choice: 4
[2025-09-30T15:05:15] INFO: Shutting down Traffic Signal Monitoring System.
```


# Authentication / Session Manager – Singleton Design Pattern

## Project Description

This project demonstrates an **Authentication / Session Manager** implemented using the **Singleton Design Pattern**. The program provides a command-line interface (CLI) where users can:

* Register new accounts with a username and password.
* Login to the system with valid credentials.
* Logout from an active session.
* Check the current active session at any time.

The **Singleton pattern** ensures that there is **only one instance** of the Authentication Manager controlling all user sessions throughout the application’s lifecycle.

## Purpose / Use Case

The Authentication / Session Manager is useful in scenarios like:

* Controlling user session creation and access in CLI-based or server-side applications.
* Ensuring a single point of truth for session handling in applications requiring consistent state management.
* Providing a centralized manager for login/logout functionality without risking multiple conflicting instances.
* Logging user actions and handling exceptions in a robust, maintainable manner.

## Design Pattern

The **Singleton pattern** is used to guarantee that only **one AuthenticationManager instance** exists:

* **Singleton (AuthenticationManager):** Manages registration, login, logout, and session tracking.
* **User:** Represents a registered user with username and password.
* **Session:** Represents an active user session including login timestamp.
* **Utils:** Provides logging, input handling, and defensive programming helpers.
* **Main:** CLI interface for interacting with users.

## Sample Run

```
[2025-09-29T19:33:02] INFO: Authentication Manager started.

=== Authentication Menu ===
1. Register
2. Login
3. Logout
4. Check Active Session
5. Exit
Enter choice: 1
Enter username: Alice
Enter password: Pass123
[2025-09-29T19:33:10] INFO: User registered: Alice
User registered successfully!

=== Authentication Menu ===
1. Register
2. Login
3. Logout
4. Check Active Session
5. Exit
Enter choice: 2
Enter username: Alice
Enter password: Pass123
[2025-09-29T19:33:21] INFO: User logged in: Alice
Login successful!

=== Authentication Menu ===
1. Register
2. Login
3. Logout
4. Check Active Session
5. Exit
Enter choice: 4
Active session for: Alice since 2025-09-29T19:33:21.830

=== Authentication Menu ===
1. Register
2. Login
3. Logout
4. Check Active Session
5. Exit
Enter choice: 5
[2025-09-29T19:34:00] INFO: Exiting Authentication Manager.
```


# Advanced Vehicle Factory - Factory Design Pattern

## **Project Overview**

The **Advanced Vehicle Factory** is a Java-based command-line application that demonstrates the **Factory Design Pattern** in a real-world scenario. This application allows users to dynamically create different types of vehicles (Car, Bike, Truck) with specific attributes such as brand, maximum speed, and fuel type. The program is robust, long-running, and validates input types to prevent errors during runtime.

## **Design Pattern**

The **Factory Design Pattern** is a **creational pattern** that provides an interface for creating objects without specifying the exact class of object that will be created. It allows the program to **decouple object creation from usage**, making it easier to extend and maintain.

* **`AdvancedVehicleFactory`** class acts as the **factory**.
* It has a method `createVehicle(category, type, brand, maxSpeed, fuelType)` that returns a `Vehicle` object based on the input parameters.
* **Concrete Vehicle classes** (`Car`, `Bike`, `Truck`) extend the abstract `Vehicle` class.
* The client code (`MenuHandler`) interacts only with the **Vehicle interface**, not the concrete classes.

## **Sample Run**

```
=== Vehicle Factory Menu ===
1. Create Passenger Vehicle
2. Create Commercial Vehicle
3. Exit
Enter choice: 1
Enter vehicle type (Car, Bike, Truck): Car
Enter brand: Honda
Enter max speed (km/h): 180
Enter fuel type (Petrol/Diesel/Electric): Petrol

Vehicle created successfully: Car [PASSENGER]
Vehicle: Honda, Max Speed: 180 km/h, Fuel: Petrol
Driving a car at 180 km/h.
Honda is refueling with Petrol
```


# Document Converter – Bridge Design Pattern

## Project Description

This project demonstrates a **Document Converter** that can export text documents into multiple formats: **PDF, DOCX, and ODT**. Users can create a document with any title and content dynamically via the **command-line interface**, then choose the desired export format.

## Purpose / Use Case

The converter is useful for scenarios like:

* Generating **business reports** for clients in PDF, internal DOCX copies, or open-source ODT format.
* Exporting **letters, notes, or assignments** in multiple formats without rewriting the document logic.
* Integrating with apps or services that need **flexible, format-independent document output**.

## Design Pattern

The **Bridge pattern** is used to **decouple abstraction (document types) from implementation (export formats)**:

* **Abstraction:** `Document` (holds title and content)
* **Refined Abstraction:** `GenericDocument` (dynamically created document)
* **Implementor:** `FormatExporter` interface (defines export behavior)
* **Concrete Implementors:** `PdfExporter`, `DocxExporter`, `OdtExporter`

## Sample Run

```
[INFO] 2025-09-28 19:15:30 - === Dynamic Document Converter Started ===
Enter Document Title: Meeting Notes
Enter Document Content (end with 'END'):
Discuss project deadlines.
Next step: design review.
END
Choose Format pdf/docx/odt: pdf
[INFO] 2025-09-28 19:15:35 - Exporting document as PDF...

Do you want to create another document? yes/no: no
[INFO] 2025-09-28 19:15:55 - === Document Converter Exited ===
```


# Weather Simulation – Flyweight Design Pattern

## Project Description

This project demonstrates a **Weather Simulation** where clouds of different types (`Cumulus`, `Cirrus`, `Stratus`) are created and rendered dynamically on the screen. Instead of creating a new object for each cloud instance, the program shares intrinsic state (cloud type, texture) using the **Flyweight Design Pattern**, while extrinsic state (position on screen) is passed at runtime.

Users interact with the simulation via a **command-line interface**. They can choose which type of cloud to render, and the system places it at random coordinates. The program also includes a **retry mechanism** for transient errors, **logging** for observability, and **exception handling** for robustness.

## Purpose / Use Case

The simulation is useful for scenarios like:

* **Weather applications**: Efficiently rendering large numbers of clouds without memory overhead.
* **Games and simulations**: Representing thousands of visual objects (like trees, particles, or clouds) by reusing shared data.
* **Graphics engines**: Demonstrating how intrinsic and extrinsic state can reduce system load.

## Design Pattern

The **Flyweight pattern** is used to share objects that have common intrinsic properties, while extrinsic state is supplied at runtime:

* **Flyweight (Interface):** `Cloud` (defines `render`)
* **Concrete Flyweight:** `ConcreteCloud` (stores intrinsic state like cloud type and texture)
* **Flyweight Factory:** `CloudFactory` (returns shared cloud objects)
* **Client:** `CloudSimulator` (requests clouds and assigns random positions)
* **Extrinsic State:** Coordinates `(x, y)` supplied at runtime

## Sample Run

```
=== Weather Simulation Menu ===
1. Add Cumulus Cloud
2. Add Cirrus Cloud
3. Add Stratus Cloud
4. Exit
Enter your choice: 1
[INFO] Rendering cloud of type CUMULUS with texture FluffyTexture at coordinates (423, 175)

=== Weather Simulation Menu ===
1. Add Cumulus Cloud
2. Add Cirrus Cloud
3. Add Stratus Cloud
4. Exit
Enter your choice: 4
[INFO] Exiting simulation.
```
