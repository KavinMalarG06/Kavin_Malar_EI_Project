
package exporters;

import java.io.IOException;
import utils.LoggerUtil;

public class PdfExporter implements FormatExporter {
    @Override
    public void export(String title, String content) throws IOException {
        try {
            LoggerUtil.logInfo("Exporting document as PDF...");
            System.out.println("\n[PDF Export]");
            System.out.println("Title : " + title);
            System.out.println("Content:\n" + content);
        } catch (Exception e) {
            throw new IOException("PDF export failed", e);
        }
    }
}
