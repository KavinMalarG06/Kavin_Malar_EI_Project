# Kavin_Malar_EI_Project
### EXP_1

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

## Example Run

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

## Example Run

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
