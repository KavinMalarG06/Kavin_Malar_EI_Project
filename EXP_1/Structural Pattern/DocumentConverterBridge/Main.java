import exporters.*;
import documents.*;
import utils.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        LoggerUtil.logInfo("=== Dynamic Document Converter Started ===");

        boolean continueProgram = true;

        while (continueProgram) {
            try {
                String title = InputHandler.getNonEmptyString("Enter Document Title: ");
                String content = InputHandler.getMultiLineInput("Enter Document Content", "END");
                String format = InputHandler.getFormatChoice("Choose Format", new String[]{"pdf", "docx", "odt"});

                FormatExporter exporter;
                switch (format) {
                    case "pdf":  exporter = new PdfExporter(); break;
                    case "docx": exporter = new DocxExporter(); break;
                    case "odt":  exporter = new OdtExporter(); break;
                    default: throw new IllegalStateException("Unexpected format: " + format);
                }

                Document document = new GenericDocument(exporter, title, content);

                int retries = 3;
                for (int i = 0; i < retries; i++) {
                    try {
                        document.export();
                        LoggerUtil.logInfo("Document successfully exported in " + format.toUpperCase() + " format.");
                        break;
                    } catch (IOException e) {
                        LoggerUtil.logError("Export attempt " + (i+1) + " failed", e);
                        if (i == retries - 1) LoggerUtil.logInfo("All retries failed. Moving to next document.");
                        Thread.sleep(1000);
                    }
                }

                String continueChoice = InputHandler.getFormatChoice("Do you want to create another document?", new String[]{"yes", "no"});
                continueProgram = continueChoice.equalsIgnoreCase("yes");

            } catch (Exception e) {
                LoggerUtil.logError("Unexpected error occurred", e);
            }
        }

        LoggerUtil.logInfo("=== Document Converter Exited ===");
    }
}
