import java.util.Scanner;
import exporters.*;
import documents.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Dynamic Document Converter ===");

        // 1. Get Document Title and Content
        System.out.print("Enter Document Title: ");
        String title = sc.nextLine();

        System.out.println("Enter Document Content (end with a single line 'END'):");
        StringBuilder contentBuilder = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.trim().equalsIgnoreCase("END")) break;
            contentBuilder.append(line).append("\n");
        }
        String content = contentBuilder.toString();

        // 2. Choose Export Format
        System.out.print("Choose Format [pdf/docx/odt]: ");
        String format = sc.nextLine().trim().toLowerCase();

        FormatExporter exporter;
        switch (format) {
            case "pdf":  exporter = new PdfExporter(); break;
            case "docx": exporter = new DocxExporter(); break;
            case "odt":  exporter = new OdtExporter(); break;
            default:
                System.out.println("Unknown format: " + format);
                sc.close();
                return;
        }

        // 3. Create Document Object and Export
        Document document = new GenericDocument(exporter, title, content);
        document.export();

        sc.close();
        System.out.println("\nDocument successfully exported in " + format.toUpperCase() + " format.");
    }
}
