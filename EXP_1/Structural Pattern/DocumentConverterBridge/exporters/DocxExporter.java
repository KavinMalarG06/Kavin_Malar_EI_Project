
package exporters;

import java.io.IOException;
import utils.LoggerUtil;

public class DocxExporter implements FormatExporter {
    @Override
    public void export(String title, String content) throws IOException {
        try {
            LoggerUtil.logInfo("Exporting document as DOCX...");
            System.out.println("\n[DOCX Export]");
            System.out.println("Title : " + title);
            System.out.println("Content:\n" + content);
        } catch (Exception e) {
            throw new IOException("DOCX export failed", e);
        }
    }
}
