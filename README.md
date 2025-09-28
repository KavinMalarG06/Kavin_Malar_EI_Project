# Kavin_Malar_EI_Project
### EXP_1
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

## Example Interaction

```
=== Dynamic Document Converter ===
Enter Document Title: Meeting Notes
Enter Document Content (end with a single line 'END'):
Discussed project deadlines.
Next steps: design review.
END
Choose Format [pdf/docx/odt]: pdf

[PDF Export]
Title : Meeting Notes
Content:
Discussed project deadlines.
Next steps: design review.

Document successfully exported in PDF format.
```

